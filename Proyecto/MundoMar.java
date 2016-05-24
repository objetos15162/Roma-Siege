import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Mar here.
 * 
 * @author Daniel Wong
 * @author Juan Partida 
 * @version 0.1
 */
public class MundoMar extends World
{

    /**
     * Constructor for objects of class Mar.
     * 
     */
    private final int LIMIT_LEFT = -300;
    private final int LIMIT_RIGHT = 1500;
    private Mar[] mar;
    private int middleImage = 2;

    public MundoMar()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(640, 480, 1, false); 
        int x = LIMIT_LEFT;
        mar = new Mar[5];
        for(int i=0; i < mar.length ; i++)
        {
            mar[i]= new Mar();
        
            addObject(mar[i], x ,getHeight()/2);
            x = x+ 640;
        }
        
        addObject( new Barco("hero",false), getHeight()/2, getWidth()/2);  
    }
    public void scroll(int direction)
    {
        int x= mar[middleImage].getX() + direction;
       
        if( x>=LIMIT_LEFT && x <= LIMIT_RIGHT){
            for(int i=0; i < mar.length ; i++)
            {
                mar[i].setLocation(mar[i].getX()+direction,mar[i].getY());
            }
        }
    }
    @Override
    public void act()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            scroll(4);
           
        }
        if(Greenfoot.isKeyDown("right"))
        {
            scroll(-4);
     
        }
    }
        
}
