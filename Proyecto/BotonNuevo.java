import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Invoca un escenario nuevo, de la clase NuevaPartida.
 * 
 * @author Daniel Wong 
 * @version 1.1
 */
public class BotonNuevo extends Boton
{ 
    /**
     * Este es el Constructor de la clase.
     */
    public BotonNuevo()
    {
        super("Boton Nuevo Activo.png","Boton Nuevo Inactivo.png", 1);
    } 
    
    /**
     * llamaNuevoEscenario-Nuevo- Invoca a un nuevo mundo para empezar a jugar.
     */
    public void llamaNuevoEscenario()
    {
        Greenfoot.setWorld( new NuevaPartida());
    }
}
