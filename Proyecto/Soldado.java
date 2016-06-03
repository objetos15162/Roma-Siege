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
        super(niv, enemy, "soldadoinmovilD.gif", "soldadoinmovilI.gif", "soldadocorriendoD.gif", "soldadocorriendoI.gif", "soldadoataqueD.gif", "soldadoataqueI.gif");
        if(enemy)
        {
            setGifs("soldadoeinmovilD.gif", "soldadoeinmovilI.gif", "soldadoecorriendoD.gif", "soldadoecorriendoI.gif", "soldadoeataqueD.gif", "soldadoeataqueI.gif");
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
        if(!getAñadido())
        {
            añadeConts();
            setAñadido(true);
        }
        String key = actAutomatico();
        if(!getInAtk())
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
                        if( p.getX() - this.getX() <= -20 && timer.millisElapsed() >= 50)
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
                        if(p.getX() - this.getX() >= 10 && timer.millisElapsed() >= 50)
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

