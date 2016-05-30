import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Este tipo de boton esta diseñado para hacer los calculos referentes a la compra de la mejora para el ataque del personaje.
 * 
 * @author Daniel Wong 
 * @version 1.2
 */
public class BotonAtk extends Boton
{
    public BotonAtk()
    {
        super("Boton Atk Activo.png", "Boton Atk Inactivo.png", 0);
    }
    
    /**
     * En este metodo se verifica que el heroe posea suficiente oro para comprar la mejoraAtk de la tienda. 
     * De ser asi, procede con hacer los calculos. Pone un mensaje en pantalla sobre la transaccion.
     */
    public void llamaNuevoEscenario()
    {
        MTienda auxiliar= (MTienda) getWorld();
        auxiliar.compraAtk();
    }
}
