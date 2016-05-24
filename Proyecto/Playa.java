import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Playa here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Playa extends SWorld
{
    /*
     * super(400, 400, 1, 1000); // scroll world constructor call; last parameter is scroll width
        // in the following statement, the main actor is placed in the center of the window
        setMainActor(new Wombat(), 250, 300); // the int parameters are centered window x and y ranges
        // to start the main actor elsewhere
        mainActor.setLocation(100, 342);
        GreenfootImage bg = new GreenfootImage("scene.jpg");
        setScrollingBackground(bg); // set the scolling background image
        // add other scrollable objects normally
        addObject(new Ground(), 200, 390);
        addObject(new Box(), 20, 345);
        // use of the following also adds scrollable objects
        addObject(new Box(), 380, 345, true); // the boolean determines scrollable state
        // use the following for non-scrollable objects
        addObject(new Score(), 40, 390, false);
     */
     
    
    
    /**
     * Constructor for objects of class Playa.
     * 
     */
    public Playa()
    {
        super(640, 480, 1, 600);
    }
}
