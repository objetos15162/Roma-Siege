import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BotonSalud here.
 * 
 * @author Daniel Wong 
 * @version 1.1
 */
public class BotonSalud extends Boton
{
    /**
     * Constructor de la clase BotonSalud.
     */
    public BotonSalud()
    {
        super("Boton Salud Activo.png", "Boton Salud Inactivo.png", 0);
    }
    
    public void llamaNuevoEscenario()
    {
        Principal world = (Principal)getWorld();
        
        if(world.tienda.getMejoraSalud() <= world.hero.getOro())
        {
            world.hero.setOro(world.tienda.getMejoraSalud());
            world.hero.setVida();
            world.tienda.setMejoraSalud();
        }
    }
}
