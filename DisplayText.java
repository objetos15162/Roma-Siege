import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DisplayText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DisplayText extends Actor
{
    private String nombre;
    /**
     * Act - do whatever the DisplayText wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */ 
    public DisplayText(){
        nombre ="";
        nombre= Greenfoot.ask("Nombre del jugador: ");
        System.out.println(nombre);
    }
    public void act() 
    {
        // Add your action code here.
        
    }    
}
