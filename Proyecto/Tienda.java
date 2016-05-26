import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta clase contendra banderas para saber que mejoras ya han sido adquiridas.
 * 
 * 
 * @author Daniel Wong
 * @author Juan Partida 
 * @version 1.0
 */
public class Tienda extends Actor
{
    private int mejoraAtk;
    private int mejoraDef;
    private int mejoraSalud;
    private int mejoraAguante;
    
    public Tienda()
    {
        mejoraAtk= 600;
        mejoraDef= 400;
        mejoraSalud= 300;
        mejoraAguante= 200;
        
        World world= getWorld();
        world.addObject(new BotonAtk(),420, 240);
        world.addObject(new BotonDef(),540, 240);
        world.addObject(new BotonSalud(),420, 360);
        world.addObject(new BotonAguante(),540, 360);
    }
    
    public Tienda(String archivo)
    {
        //Aqui se leen los datos del archivo
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
     * Modifica el precio de la mejora de salud.
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

