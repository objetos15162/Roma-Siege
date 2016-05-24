import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bala here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bala extends Actor
{
    /**
     * Act - do whatever the Bala wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean direction;
    public Bala(boolean dir)
    {
      direction = dir;
    }
    public void act() 
    {
        World mundo = getWorld();
      //  MundoCiudad c = (MundoCiudad)mundo;
       // int x=0;
      // ShipEnemy s =(ShipEnemy)getOneIntersectingObject(ShipEnemy.class);
      if(direction != false)
      {
        move(-5);
      }
      else{
          move(5);
        }
       // draw();
        if(this.getX()== (getWorld().getWidth()-1))
        {
            getWorld().removeObject(this);
        }
       /* else{
              if(s != null){
                  //s.destroy();
                  c.removeObject(this);
                  
                }
        }*/
       
    }    
    /*/**
     * Dibuja un circulo relleno de color negro
     */
    /*public void draw()
     {
         image.setColor(Color.BLACK);
         image.fillOval(x, y, x+height, y+width);
         
         setImage(image);
       
        } */
}
