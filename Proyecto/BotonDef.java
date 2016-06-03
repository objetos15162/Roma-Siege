import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * manda a llamar que se aumente la defensa del personaje principal
 * 
 * @author daniel wong 
 * @version 1.0
 */
public class BotonDef extends Boton
{
    public BotonDef()
    {
        super("Boton Def Activo.png", "Boton Def Inactivo.png", 0);
    }
    
    public void llamaNuevoEscenario()
    {
        MTienda auxiliar= (MTienda) getWorld();
        auxiliar.compraDef();
    }
}
