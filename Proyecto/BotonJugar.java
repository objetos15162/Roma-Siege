import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Se encarga de iniciar una partida nueva, e invoca un escenario para ello. 
 * 
 * @author Daniel Wong 
 * @version 1.0
 */
public class BotonJugar extends Boton
{
    /**
     * 
     */
    public BotonJugar()
    {
        super("Boton Jugar Activo.png","Boton Jugar Inactivo.png", 1);
    }
    
    /**
     * 
     */
    public void llamaNuevoEscenario()
    {
        Principal auxiliar = (Principal) getWorld();
        auxiliar.iniciarPartida();
    }
    
}
