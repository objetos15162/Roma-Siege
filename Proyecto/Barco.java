import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Barco here.
 * 
 * @author Daniel Wong 
 * @version 1.1
 */
public class Barco extends Personaje
{
    private int capacidad;
    private int vel; // Velocidad con la que el barco avanza
    private int contadorCiclos;
    
    /**
     * Constructor del barco generico. a partir del nivel que entra genera los estados base.
     */
    public Barco(int nivel, boolean esEnemigo)
    {
        super(nivel, esEnemigo, "barcoinmovilD.gif","barcoinmovilD.gif", "barcomovimientoD.gif", "barcomovimientoD.gif", "barcoataqueD.gif", "barcoataqueD.gif");
        capacidad = 5 + Greenfoot.getRandomNumber(4+nivel);
        vel = 0;
        contadorCiclos = 0;
        if(esEnemigo)
        {
            setGifs("barcoataqueI.gif","barcomovimientoI.gif", "barcoinmovilI.gif");
        }
    }
    
    /**
     * Con este constructor podremos crear un objeto barco leyendo sus datos desde un archivo.
     * @param archivo Es una cadena con el nombre del archivo donde se encuentra guardado.
     */
    public Barco(String archivo)
    {
        super(archivo);
    }
    
    /**
     * Act - do whatever the Barco wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(!getAñadido())
        {
            añadeConts();
            setAñadido(true);
        }
        
        if(!getisEnemy())
        {
            if(!getInAtk())
            {
                String key = Greenfoot.getKey();
                if(key != null)
                {
                    key.toLowerCase();
                    switch(key)
                    {
                        case "d":
                            if(vel < 10)
                            {
                                vel++;
                            }
                            break;
                        case "a":
                            if(vel > -10)
                            {
                                vel--;
                            }
                            break;
                        case "n":
                            setInAtk(true);
                            break;
                    }
                }
                
                if(contadorCiclos <= 5)
                {
                    contadorCiclos++;
                }
                else
                {
                    contadorCiclos=0;
                    mover(vel);
                }
            }
            else
            {
                completeAtk();
            }
        }
        else
        {
            actAutomatico();
        }
        mueveConts();
    }
    
    /**
     * Otorga automaticamente acciones a los barcos enemigos.
     */
    private void actAutomatico()
    {
        if(!getInAtk()) 
        {
            if(contadorCiclos<=75)
            {
                contadorCiclos++;
                mover(0);
            }
            else
            {
                List <Personaje> actores = getObjectsInRange(400, Personaje.class);
                for( Personaje p: actores)
                {
                    if(p != null && !p.getisEnemy())
                    {
                        if(p.getX() - this.getX() < -80 - (int)(this.getAtk()/2))
                        {
                            setInAtk(true);                       
                        }
                        else
                        {
                            mover(10);
                        }
                    }
                }
                contadorCiclos=0;
            }
        }
        else
        {
            completeAtk();
        }
    }
    
    /**
     * Este metodo es invocado justo cuando se esta en proceso un ataque;
     */
    private void completeAtk()
    {
        setInAtk(atacar(1));
        if(!getInAtk())
        {
            int dir;
            if(!getisEnemy())
            {
                dir = 1;
            }
            else
            {
                dir = -1;
            }
            Bala nueva = new Bala(dir, vel, (int)(getAtk()/3), (int)getAtk(), this);
            getWorld().addObject(nueva, this.getX()+dir*80, this.getY()-80);
            if(vel > 4)
            {
                vel-=3;
            }
            else
            {
                if(vel < 0 && vel > -10)
                {
                    vel -- ;
                }
            }
        }
    }
    
    
    /**
     * este metodo regresa la capacidad maxima de soldados que posee o puede poseer el usuario en juego... por el momento no es util.
     * @return capacidad- Num maximo de soldados que pueden subir al barco.
     */
    public int getCapacidad()
    {
        return capacidad;
    }
    
    /**
     * 
     * En este metodo se llama al toString de la superclase, ademas de agrefarle los atributos del heroe
     * al final. El orden de los datod quedaria en el siguiente:
     * Nombre, nivel, ataque, defensa, Vida Maxima, Aguante Maximo, Capacidad.
     * @override
     * @return caracteristicas Es la compilacion de cada atributo, separado por espacios, de la clase barco.
     */
     public String toString()
     {
         return super.toString() + " " + capacidad;
     }
}
