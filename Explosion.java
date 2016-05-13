import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Explosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explosion extends Actor
{
    /**
     * Act - do whatever the Explosion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GifImage explocion;
    public Explosion(){
         explocion =  new GifImage("explosion.gif");
    }
    public void act() {
        setImage(explocion.getCurrentImage());
       // Greenfoot.playSound("explosion3.wav");
        
            getStop();
            Greenfoot.stop();
        
    }
    /**
     * indica cuando la imagen se detiene
     */
    public void getStop()
    {
        boolean ban = false;
        if(explocion.isRunning()){
           try{
            wait(75);
            ban = true;
           }
           catch(Exception e){
            }
           
        }
       
    }
}
















