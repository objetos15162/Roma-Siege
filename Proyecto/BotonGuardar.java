import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BotonGuardar here.
 * 
 * @author Daniel Wong 
 * @version 0.1
 */
public class BotonGuardar extends Boton
{
    public BotonGuardar()
    {
        super("Boton Guardar Activo.png", "Boton Guardar Inactivo.png", 2);
    }
    
    
    public void llamaNuevoEscenario()
    {
        World world= getWorld();
    }
}
