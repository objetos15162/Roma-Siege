import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta clase tiene como objetivo imponer en pantalla un objeto Tienda, y controlarlo, ademas de implantar en pantalla 
 * diferentes botones, respectivos de la tienda.
 * 
 * @author Daniel Wong 
 * @version 1.2
 */
public class BotonTienda extends Boton
{
    public BotonTienda()
    {
        super("Boton Tienda Activo.png","Boton Tienda Inactivo.png", 3);
    }
    
    /**
     * En este metodo se invoca un objeto Tienda, y se volvera el ciclo principal hasta que el usuario 
     * salga de la tienda.
     */
    public void llamaNuevoEscenario()
    {
        Principal actual = (Principal) getWorld();
        Greenfoot.setWorld(actual.getTienda());
    }
}