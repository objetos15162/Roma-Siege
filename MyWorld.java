import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
  //  private SimpleTimer time;
    private int cont;
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 526, 1); 
        addObject(new Ship(),100,271);
       // Greenfoot.playSound("Wave3.wav");
        cont=0;
        
    }
    @Override 
    public void act()
    {
        
        addEnemys();
        if(cont == 0)
          { Greenfoot.playSound("Wave3.wav");
            }
        counter();
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    
    public void counter()
    {
        
        cont++;
    }
    public void addEnemys(){
        int y = 185;
        if(cont ==300){
            for(int i =0 ;i<4;i++)
            {
                addObject(new ShipEnemy(),this.getWidth(),y);
                y+=75;
            }
            cont=0;
        }
    }
}
