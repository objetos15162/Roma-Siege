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
    private int vel;
    private int cont;
    
    /**
     * Constructor del barco generico. a partir del nivel que entra genera los estados base.
     */
    public Barco(int nivel, boolean esEnemigo)
    {
        super(nivel, esEnemigo, "Barco InmovilD.gif","Barco InmovilD.gif", "Barco MovimientoD.gif", "Barco MovimientoD.gif", "Barco AtaqueD.gif", "Barco AtaqueD.gif");
        capacidad = 5 + Greenfoot.getRandomNumber(4+nivel);
        vel = 0;
        cont = 0;
        if(esEnemigo)
        {
            setGifs("Barco AtaqueI.gif","Barco MovimientoI.gif", "Barco InmovilI.gif");
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
        if(!añadido)
        {
            añadeConts();
            añadido=true;
        }
        
        if(!getisEnemy())
        {
            if(!inAtk)
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
                            inAtk=true;
                            break;
                    }
                }
                
                if(cont <= 5)
                {
                    cont++;
                }
                else
                {
                    cont=0;
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
        if(!inAtk) 
        {
            if(cont<=75)
            {
                cont++;
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
                            inAtk=true;                       
                        }
                        else
                        {
                            mover(10);
                        }
                    }
                }
                cont=0;
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
        inAtk=atacar(1);
        if(!inAtk)
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
                vel-=5;
            }
            else
            {
                if(vel < 0 && vel > -10)
                {
                    vel -=2 ;
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
