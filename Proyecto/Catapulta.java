import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Catapulta here.
 * 
 * @author Daniel Wong
 * @version 0.1
 */
public class Catapulta extends Personaje
{
    private boolean shooting;
    private boolean sentido;
    public Catapulta(int niv,boolean enemy)
    {
<<<<<<< HEAD
        super(niv, false, "Catapulta InmovilD.gif", "Catapulta InmovilD.gif", "Catapulta MovimientoD.gif", "Catapulta MovimientoD.gif", "Catapulta AtaqueD.gif", "Catapulta AtaqueD.gif");
=======
        super(niv, "???", enemy);
        shooting = false;
        sentido = false;
>>>>>>> origin/master
    } 
    
    /**
     * Este metodo atacar es exclusivamente para la catapulta.
     */
    private void atacar()
    {
        getWorld().addObject(new Bala(sentido),this.getX(),this.getY());
    }
    public void act()
    {
          if(Greenfoot.isKeyDown("right"))
        {
            setImage("catapulta.png");
            sentido = false;
            
        }
         if(Greenfoot.isKeyDown("left"))
        {
            setImage("catapultaIzq.png");
            sentido = true;
        }
         if(Greenfoot.isKeyDown("z") && !shooting)
        {
            atacar();
         //   Greenfoot.playSound("cañon.mp3");
            shooting=true;
        }
       
       if(!Greenfoot.isKeyDown("z"))
       {
          shooting = false;
        }
    }
}
