import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Soldado here.
 * 
 * @author Daniel Wong
 * @version 0.1
 */
public class Soldado extends Personaje
{
    public Soldado(int niv, boolean enemy)
    {
        super(niv , "???", enemy, "Soldado InmovilD.gif", "Soldado InmovilI.gif", "Soldado CorriendoD.gif", "Soldado CorriendoI.gif", "Soldado AtaqueD.gif", "Soldado AtaqueI.gif");
    }
    
    
    /**
     * Act - do whatever the Soldado wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // se movera de manera automatica.
    }    
}
