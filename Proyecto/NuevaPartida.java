import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NuevaPartida here.
 * 
 * @author Daniel Wong 
 * @version 1.0
 */
public class NuevaPartida extends World
{
    Heroe hero;
    //Genera una tienda
    
    /**
     * Constructor for objects of class NuevaPartida.
     * 
     */
    public NuevaPartida()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(640, 480, 1); 
        hero= new Heroe(1, 150);
        addObject(hero, 150,350);
        //Crea una archivo
    }
    
}
