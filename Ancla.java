import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ancla here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ancla extends Actor
{
    private GifImage ancla;
    /**
     * Act - do whatever the Ancla wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Ancla (){
         ancla = new GifImage("ancla.gif");
    }
    public void act() 
    {
        // Add your action code here.
        setImage(ancla.getCurrentImage());
    }    
}
