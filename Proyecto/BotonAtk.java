import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BotonAtk here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BotonAtk extends Boton
{
    public BotonAtk()
    {
        super("Boton Atk Activo.png", "Boton Atk Inactivo.png", 0);
    }
    
    public void llamaNuevoEscenario()
    {
        Principal world = (Principal)getWorld();
        
        if(world.tienda.getMejoraAtk() <= world.hero.getOro())
        {
            world.hero.setOro(world.tienda.getMejoraSalud());
            world.hero.setAtk();
            world.tienda.setMejoraAtk();
        }
    }
}
