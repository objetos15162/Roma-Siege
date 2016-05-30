import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Heroe here.
 * 
 * @author Daniel Wong 
 * @version 1.2
 */
public class Heroe extends Personaje
{
    private int oro;
    
    /**
     *  Constructor de la subclase Heroe. Este construtor manda 
     */
    public Heroe(int niv, int monedas, boolean ene)
    {
        super(niv, ene, "Drinker inmovilD.gif", "Drinker inmovilI.gif", "Drinker CorriendoD.gif", "Drinker CorriendoI.gif", "Drinker AtaqueD.gif", "Drinker AtaqueI.gif");
        oro=monedas;
    }
    
    public Heroe(String archivo)
    {
        super(archivo);
        //monedas=leeArchivo(archivo);
    }
    
    /**
     * This method returns the gold of the Hero already have;
     * @return oro
     */
    public int getOro()
    {
        return oro;
    }
    
    /**
     * 
     */
    public void setOro(int cantidad)
    {
        if(cantidad<=oro)
        {
            oro= oro-cantidad;
        }
    }
}
