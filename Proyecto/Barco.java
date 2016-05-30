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
    }
    
    /**
     * 
     */
    private void actAutomatico()
    {
        if(!inAtk) 
        {
            if(cont<=50)
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
                        if(p.getX() - this.getX() < -80)
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
     * este metodo regresa la capacidad maxima de soldados que posee
     */
    public int getCapacidad()
    {
        return capacidad;
    }
}
