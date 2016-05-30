import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta clase es la pantalla con la que se inicia el juego
 * 
 * @author Daniel Wong
 * @version 1.2
 */
public class Inicio extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Inicio()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(640, 480, 1); 
        prepare();
    }

    /**
     *  Espera a que el usuario presione la tecla Enter para continuar.
     */
    public void act()
    {       
        if(Greenfoot.getKey()=="enter")
        {
            Greenfoot.setWorld(new MenuInicio(0));
        }
        else
        {
            ; //Aqui se supone que parpadeara un letrero "Presiona Enter" en la pantalla
        }
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
    }
}
