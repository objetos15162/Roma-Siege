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
            addObject(new Label("PRESIONA 'ENTER' PARA CONTINUAR", 40), 320, 240);
        }
    }
}
