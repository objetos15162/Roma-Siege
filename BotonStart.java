
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BotonStart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BotonStart extends Actor
{
    /**
     * Act - do whatever the BotonStart wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private String name;
    private Label l;
    public BotonStart (){
        name = " ";
        l = null;
    }
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this))
        {
            MyWorld w = new MyWorld();
            
            Greenfoot.setWorld(w);
        }
    }    
}
