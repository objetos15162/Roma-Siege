import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PantallaDeDatos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PantallaDeDatos extends World
{
    
    private String name;
    /**
     * Constructor for objects of class PantallaDeDatos.
     * 
     */
    public PantallaDeDatos()
    {    
        
        super(600, 400, 1); 
        DisplayText t1 = null;
        t1= new DisplayText();
        
       // addObject(t1,getWidth()/2,getHeight()/2);
        try{
              wait(100);
               addObject(t1,getWidth()/2,getHeight()/2);
        }
        catch(Exception e){
        }
        addAnclas();
    
    }
    public void act(){
     
      //addAnclas();
    }
    public void addAnclas(){
          addObject(new Ancla(),35,getHeight()-35);
          addObject(new Ancla(),getWidth()-35,35);
          addObject(new Ancla(),35,35);
          addObject(new Ancla(),getWidth()-35,getHeight()-35);
          
          
    }
/**
 * Prepare the world for the start of the program.
 * That is: create the initial objects and add them to the world.
 */
private void prepare()
{
    Ancla ancla = new Ancla();
    addObject(ancla,48,357);
    Ancla ancla2 = new Ancla();
    addObject(ancla2,562,368);
    Ancla ancla3 = new Ancla();
    addObject(ancla3,562,44);
    Ancla ancla4 = new Ancla();
    addObject(ancla4,41,41);
}
}
