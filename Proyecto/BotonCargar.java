import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Manda a llamar un escenario que se va a dedicar a cargar los datos del usuario.
 * Actualmente no se usa.
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
