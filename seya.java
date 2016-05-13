import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class seya here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class seya extends Actor
{
    /**
     * Act - do whatever the seya wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GifImage der;
    private GifImage izq;
    private GifImage set;
    private GifImage setIzq;
    private boolean sentido = false;
    public seya (){
        der = new GifImage("seyaRun.gif");
        izq= new GifImage("seyaRunIzq.gif");
        set = new GifImage ("seyaSet.gif");
        setIzq= new GifImage("seyaSetIzq.gif");
    }
    public void act() 
    {
        
        if(Greenfoot.isKeyDown("right")){
           setImage(der.getCurrentImage());
           move(3);
           sentido =false;
        }
        else{
        
               if(Greenfoot.isKeyDown("left")){
                  setImage(izq.getCurrentImage());
                  move(-3);
                  sentido=true;
               }
        }
        
        if(!Greenfoot.isKeyDown("right") && !Greenfoot.isKeyDown("left") && sentido == false){
            setImage(set.getCurrentImage());
        }
        else{
            if(!Greenfoot.isKeyDown("right") && !Greenfoot.isKeyDown("left") && sentido == true){
                setImage(setIzq.getCurrentImage());
            }
        }
    }    
}
