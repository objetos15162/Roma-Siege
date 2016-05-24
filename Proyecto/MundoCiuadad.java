import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MundoCiuadad here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MundoCiuadad extends World
{

    /**
     * Constructor for objects of class MundoCiuadad.
     * 
     */
    private final int LIMIT_LEFT = 1800;
    private final int LIMIT_RIGHT = -1100;
    private final int LIMIT_UP = 70;
    private final int LIMIT_DOWN = 450;
    private Ciudad city;

    public MundoCiuadad()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(640, 480, 1,false); 
        int x = LIMIT_LEFT;
        city = new Ciudad();
        
        addObject(city,x ,getHeight()/2);

        addObject( new Catapulta(1,false), getHeight()/2, getWidth()/2);  
    }
     public void scroll(int direction, int directionUpDown)
    {
        int x= city.getX() + direction;
        int y= city.getY() + directionUpDown;
       
        if( x<=LIMIT_LEFT && x >= LIMIT_RIGHT ) 
        {
           
           city.setLocation(city.getX()+direction,city.getY());
            
        }
        if( y>=LIMIT_UP && y<=LIMIT_DOWN)
        {
            city.setLocation(city.getX(),city.getY()+directionUpDown);
        }
    }
    @Override
    public void act()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            scroll(4,0);
           
        }
        if(Greenfoot.isKeyDown("right"))
        {
            scroll(-4,0);
     
        }
        if(Greenfoot.isKeyDown("up"))
        {
            scroll(0,4);
        }
        if(Greenfoot.isKeyDown("Down"))
        {
            scroll(0,-4);
        }
    }
        
}
