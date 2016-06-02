import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta clase es exclusiva para el personaje principal. Guarda una cantidad de oro ademas
 * de los atributos de la superclase.
 * 
 * @author Daniel Wong 
 * @version 1.3
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
    
    /**
     * Constructor que lee un archivo y otorga los valores a partir de el.
     * @param archivo- El nombre del archivo del cual se piensan leer los datos.
     */
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
     * Este metodo revisa si la cantidad de oro que se le va a restar es enor o igual, y de no serlo no aplica nada.
     * Si la cantidad es negativa significa que el usuario gano oro.
     * 
     * @para  cantidad- es un entero que indica cuanta cantidad se va a modificar el oro.
     */
    public void setOro(int cantidad)
    {
        if(cantidad<=oro)
        {
            oro= oro-cantidad;
        }
    }
    
    /**
     * En este metodo se llama al toString de la superclase, ademas de agrefarle los atributos del heroe
     * al final. El orden de los datod quedaria en el siguiente:
     * Nombre, nivel, ataque, defensa, Vida Maxima, Aguante Maximo, Oro.
     * @override
     * @return caracteristicas Es la compilacion de cada atributo, separado por espacios, de la clase Heroe.
     */
    public String toString()
    {
        return super.toString() + " " + oro;
    }
}
