import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Regresa al Inicio. NO hace ninguna otra cosa que regresar al inicio del juego.
 * 
 * @author Daniel Wong 
 * @version 1.0
 */
public class BotonSalir extends Boton
{   
    /**
     * Este es el constructor de la clase BotonSalir.
     */
    public BotonSalir()
    {
        super("Boton Salir Activo.png", "Boton Salir Inactivo.png", 4);
    }  
    
    /**
     * llamaNuevoEscenario-Salir- Termina el juego. No recive nada y
     * no regresa nada. En este caso sale del juego. Por el momento
     */
    public void llamaNuevoEscenario()
    {
        //Aqui se supone que sale del juego :v
        Greenfoot.setWorld(new Inicio());
    }
    
}
