import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BotonDef here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BotonDef extends Boton
{
    public BotonDef()
    {
        super("Boton Def Activo.png", "Boton Def Inactivo.png", 0);
    }
    
    public void llamaNuevoEscenario()
    {
        Principal world = (Principal)getWorld();
        
        if(world.tienda.getMejoraDef() <= world.hero.getOro())
        {
            world.hero.setOro(world.tienda.getMejoraDef());
            world.hero.setDef();
            world.tienda.setMejoraDef();
        }
    }
}
