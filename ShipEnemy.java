import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ShipEnemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShipEnemy extends ShipWar
{
    /**
     * Act - do whatever the ShipEnemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GifImage shipE;
    
   public ShipEnemy (){
    
     shipE = new GifImage("shipEnemy.gif");
    }
    
   public void act() 
    {
        // Add your action code here.
      World mundo = getWorld();
      MyWorld w = (MyWorld)mundo;
      Explosion e1 = new Explosion();
      
        setImage(shipE.getCurrentImage());
        move(-3);
        Ship s =(Ship)getOneIntersectingObject(Ship.class);
        
         if(this.getX()== 1)
        {
            w.removeObject(this);
        }
        else{
            if(s != null){
               s.destroy();
               this.destroy();
               w.addObject(e1,s.getPosX(),s.getPosY());
             
              
           }
        }
        
    }    
   
}
