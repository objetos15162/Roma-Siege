import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta clase contendra numeros enteros para saber el "precio" de las mejoras que estan disponibles.
 * 
 * 
 * @author Daniel Wong
 * @author Juan Partida 
 * @version 1.7
 */
public class Tienda extends Actor
{
    private int mejoraAtk;
    private int mejoraDef;
    private int mejoraSalud;
    private int mejoraAguante;
    private Label mensaje;
    private boolean isCopy;
    /**
     * Es el constructor normal de la clase Tienda. Le otorga valores predefinidos a las varibles.
     */
    public Tienda()
    {
        mejoraAtk= 600;
        mejoraDef= 400;
        mejoraSalud= 300;
        mejoraAguante= 200;
        isCopy = false;
    }
    
    /**
     * Este Constructor recibe como parametro todos los valores de una tienda, y podremos suponer que es una copia
     */
    public Tienda(int preAtk, int preDef, int preSal, int preAgu)
    {
        mejoraAtk= preAtk;
        mejoraDef= preDef;
        mejoraSalud= preSal;
        mejoraAguante= preAgu;
        isCopy = true;
    }
    
    /**
     * Este es el constructor de la clase tienda, el cual recibe el nombre de un archivo, y otorga los valores a partir de lo que lee.
     * (aun en construccion :v)
     */
    public Tienda(String archivo)
    {
        //Aqui se leen los datos del archivo
    }
    
    /**
     * Al ser llamado, empieza un ciclo autonomo que controla los botones caracteristicos de esta clase, ademas de iniciar una copia de este objeto
     * para trab.
     */
    public void actII()
    {
        BotonAtk ataque=new BotonAtk();
        BotonDef defensa= new BotonDef();
        BotonSalud vida= new BotonSalud();
        BotonAguante aguante = new BotonAguante();
        String key = null;
        
    }
    
    /**
     * Regresa el precio de la mejora de ataque
     */
    public int getMejoraAtk()
    {
        return mejoraAtk;
    }
    
    /**
     * Modifica el precio de la mejora de ataque
     */
    public void setMejoraAtk()
    {
        mejoraAtk= (int)(mejoraAtk*1.3);
    }
    
    /**
     * Regresa el precio de la mejora de defensa.
     */
    public int getMejoraDef()
    {
        return mejoraDef;
    }
    
    /**
     * Modifica el precio de la mejora de Defensa por 1.2 veces mas su precio
     */
    public void setMejoraDef()
    {
        mejoraDef= (int)(mejoraDef*1.2);
    }
    
    /**
     * Regresa el precio de la mejora de salud.
     */
    public int getMejoraSalud()
    {
        return mejoraSalud;
    }
    
    /**
     * Modifica el precio de la mejora de salud en una cantidad igual a 1.2 veces su precio anterior.
     */
     public void setMejoraSalud()
    {
        mejoraDef= (int)(mejoraSalud*1.2);
    }
    
    /**
     * Regresa el precio de la mejora de aguante
     */
    public int getMejoraAguante()
    {
        return mejoraAguante;
    }
    
    /**
     * Modifica el precio de la mejora de Aguante
     */
     public void setMejoraAguante()
    {
        mejoraDef= (int)(mejoraAguante*1.1);
    }
}

