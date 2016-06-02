import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Soldado here.
 * 
 * @author Daniel Wong
 * @version 0.1
 */
public class Soldado extends Personaje
{
    
    private SimpleTimer timer;
    
    public Soldado(int niv, boolean enemy)
    {
        super(niv, enemy, "Soldado InmovilD.gif", "Soldado InmovilI.gif", "Soldado CorriendoD.gif", "Soldado CorriendoI.gif", "Soldado AtaqueD.gif", "Soldado AtaqueI.gif");
        if(enemy)
        {
            setGifs("SoldadoE InmovilD.gif", "SoldadoE InmovilI.gif", "SoldadoE CorriendoD.gif", "SoldadoE CorriendoI.gif", "SoldadoE AtaqueD.gif", "SoldadoE AtaqueI.gif");
        }
        timer= new SimpleTimer();
        timer.mark();
    }
    
    /**
     * Act - do whatever the Soldado wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // se movera de manera automatica.
        if(!añadido)
        {
            añadeConts();
            añadido=true;
        }
        String key = actAutomatico();
        if(!inAtk)
        {
            if(key != null)
            {
                otorgaDireccion(key);
            }
            else
            {
                movEstandar();
            }
        }
        else
        {
            atacar();
        }
        mueveConts();
    }
    
    private String actAutomatico()
    {
        List <Personaje> actores = getObjectsInRange(500, Personaje.class);
        if(actores!=null)
        {
            for( Personaje p: actores)
            {
                if(p != null && p.getisEnemy() != this.getisEnemy() && !p.equals(this))
                {
                    if(p.getX() - this.getX() >= -20 && p.getX() - this.getX()<=0)
                    {
                        if(timer.millisElapsed()>=2000)
                        {
                            setDireccion(1);
                            timer.mark();
                            return "n"; 
                        }
                    }
                    else
                    {
                        if( p.getX() - this.getX() <= -20)
                        {
                            timer.mark();
                            return "a";
                        }
                    }
                    
                    if( p.getX() - this.getX()<= 20 && p.getX() - this.getX()>= 0)
                    {
                        if(timer.millisElapsed()>=2000)
                        {
                            timer.mark();
                            setDireccion(-1);
                            return "n";
                        }
                    }
                    else
                    {
                        if(p.getX() - this.getX() >= 10)
                        {
                            timer.mark();
                            return "d";
                        }
                    }
                }
            }
        }
        return null;
    }
}

