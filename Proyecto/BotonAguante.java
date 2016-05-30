import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BotonAguante here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BotonAguante extends Boton
{
    public BotonAguante()
    {
        super("Boton Aguante Activo.png", "Boton Aguante Inactivo.png", 0);
    }
    
    public void llamaNuevoEscenario()
    {
        MTienda auxiliar= (MTienda) getWorld();
        auxiliar.compraAguante();
    }
}
