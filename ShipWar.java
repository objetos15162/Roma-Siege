import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ShipWar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShipWar extends Actor
{
    /**
     * Act - do whatever the ShipWar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public ShipWar(){
        
    }
    public void act() 
    {
        // Add your action code here.
    }    
    public void destroy(){
        
        getWorld().removeObject(this);
      
        
    }
}
