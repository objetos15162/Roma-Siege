import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
import javax.swing.*;
import java.util.*;

/**
 * Write a description of class Gun here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gun extends Actor
{
    /**
     * Act - do whatever the Gun wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     GreenfootImage image;
    private int  x= 5;
    private int y =5;
    private int height = 25;
    private int width =25;
    public Gun(){
      image = new GreenfootImage(40, 40);
    }
    public void act() 
    {
        World mundo = getWorld();
        MyWorld w = (MyWorld)mundo;
        int x=0;
        ShipEnemy s =(ShipEnemy)getOneIntersectingObject(ShipEnemy.class);
        move(5);
        draw();
        if(this.getX()== (w.getWidth()-1))
        {
            w.removeObject(this);
        }
        else{
              if(s != null){
                  s.destroy();
                  w.removeObject(this);
                  
                }
        }
       
    }    
    /**
     * Dibuja un circulo relleno de color negro
     */
    public void draw()
     {
         image.setColor(Color.BLACK);
         image.fillOval(x, y, x+height, y+width);
         
         setImage(image);
       
        }
}
