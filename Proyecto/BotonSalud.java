import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta clase manda a llamar que se suba la salud del heroe del usuario.
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
        super("Boton Vida Activo.png", "Boton Vida Inactivo.png", 0);
    }
    
    public void llamaNuevoEscenario()
    {
        MTienda auxiliar= (MTienda) getWorld();
        auxiliar.compraVida();
    }
    
}
