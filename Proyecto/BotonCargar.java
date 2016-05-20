import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BotonCargar here.
 * 
 * @author Daniel Wong 
 * @version 1.1
 */
public class BotonCargar extends Boton
{
    /**
     * 
     */
    public BotonCargar()
    {
        super("Boton Cargar Activo.png","Boton Cargar Inactivo.png", 2);
    }
    
    /**
     * llamaNuevoEscenario-Cargar- Genera un nuevo mundo donde cargara
     * un archivo anteriormente guardado
     * con todos los datos que pueda tener un jugador.
     */
    public void llamaNuevoEscenario()
    {
        Greenfoot.setWorld(new CargaPartida());
    }
}
