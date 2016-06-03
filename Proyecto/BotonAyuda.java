import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta clase es la encargada de mostrar la ayuda en pantalla. Solo añade un objeto e impide que 
 * se muevan otros actores en el mundo hasta que se presione una de las teclas para salir.
 * @author Daniel Wong 
 * @version 1.4
 */
public class BotonAyuda extends Boton
{
    private Ayuda ayuda;
    /**
     * Constructor de la clase BotonAyuda.
     */
    public BotonAyuda()
    {
        super("Boton Ayuda Activo.png", "Boton Ayuda Inactivo.png", 3);
        ayuda=null;
    }
    
    /**
     * llamaNuevoEscenario-Ayuda- Carga una imagen y la muestra en pantalla con 
     * las instrucciones para jugar. En este caso solo pone un objeto ayuda
     * en pantalla.
     */
    public void llamaNuevoEscenario()
    {
        World world= getWorld();
        ayuda=new Ayuda();
        world.addObject(ayuda, 320, 240);
        world.repaint();
        actII();
    }
    
    /**
     * Con este metodo se manda a actuar de manera sintetica al metodo act() de la clase ayuda para
     * evitar que el usuario interactue con otros objetos que no sea el de ayuda.
     */
    private void actII()
    {
        World world = getWorld();
        while(ayuda != null && ayuda.getNum()!=0)
        {
            ayuda.act();
            world.repaint();
        }
        elimina();
    }
    
    /**
     * Elimina el objeto ayuda de la esta clase. Solo lo aplica si este objeto es diferente de null.
     */
    public void elimina()
    {        
        if(ayuda!=null)
        {
            if(ayuda.getNum()==0)
            {
                World world= getWorld();
                world.removeObject(ayuda);
            }
        }
    }
}
