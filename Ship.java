import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class IronSpider here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ship extends ShipWar
{
    private GifImage ship;
   // private ArrayList <GreenfootImage> images; 
    private boolean shooting = false;
    private int posX;
    private int posY;
    /**
     * Act - do whatever the IronSpider wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Ship(){
        ship = new GifImage("ship.gif");
       // ironAraña.getImages();
        posX = 0;
        posY =0;
        
    }
    public void act() 
    {
        World mundo = getWorld();
        MyWorld myWorld = (MyWorld)mundo;
        boolean ban = false;
      //  Greenfoot.playSound("Wave3.wav");
        if(Greenfoot.isKeyDown("right")){
          setImage(ship.getCurrentImage());
          move(4);
        }
       else{
          // setImage(ship.getCurrentImage());
          if(Greenfoot.isKeyDown("left")){
              move(-4);
              setImage(ship.getCurrentImage());
            }
          else{  
             if(Greenfoot.isKeyDown("down")){
             if(this.getY() != 667 ){
                setImage(ship.getCurrentImage());
                setLocation(getX(),getY()+5);
              }
          }
           else{
               if(Greenfoot.isKeyDown("up") && getY()!=360){
                    
                       setImage(ship.getCurrentImage());
                       setLocation(getX(),getY()-5);
                      
                 }
               else{
                    setImage(ship.getCurrentImage());
               }
             }
         }
        }
       if(Greenfoot.isKeyDown("z") && !shooting)
        {
            Gun g = new Gun();
            myWorld.addObject(g,this.getX()+60,this.getY()+25);
            Greenfoot.playSound("cañon.mp3");
            shooting=true;
        }
       
       if(!Greenfoot.isKeyDown("z"))
       {
          shooting = false;
        }
        posX = getX();
        posY = getY();
    }
    public int getPosX(){
         return posX;
    }
    public int getPosY() {
       return posY;
    }
 }
  

