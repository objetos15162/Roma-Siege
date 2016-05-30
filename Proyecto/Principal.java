import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Principio here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Principal extends MenuInicio
{
    private Heroe hero;
    private Barco barco;
    private Catapulta catapulta;
    private MTienda tienda;
    private int oroAcumulado;
    /**
     * Constructor for objects of class Principio.
     * 
     */
    public Principal(Heroe actor, Barco balsa, Catapulta lanzador, MTienda tendedero)
    {
        super(1);
        hero = actor;
        barco = balsa;
        catapulta = lanzador;
        tienda = tendedero;
        oroAcumulado=0;
        tienda.setMundo(this);
    }
    
    /**
     * Este Metodo resetea los valores de los personajes principales.
     */
    public void reset()
    {
        hero.reset();
        barco.reset();
        catapulta.reset();
    }
    
    /**
     * EN ESTE METODO SE MANDA A LLAMAR PARA INICIAR UNA PARTIDA
     */
    public void iniciarPartida()
    {
        Greenfoot.setWorld(new Mar(this));
    }
    
    /**
     * Variable que regresa un objeto de la clase Barco
     * @return Barco- Barco del usuario.
     */
    public Barco getBarco()
    {
        return barco;
    }
    
    /**
     * Variable que regresa un objeto de la clase Heroe
     * @return hero- Barco del usuario.
     */
    public Heroe getHero()
    {
        return hero;
    }
    
    /**
     * Variable que regresa un objeto de la clase Catapulta
     * @return catapulta- catapulta del usuario.
     */
    public Catapulta getCatapulta()
    {
        return catapulta;
    }
    
    /**
     * Metodo que regresa un objeto de la clase MTienda
     * @return tienda- Tienda que esta a la disposicion del usuario.
     */
    public MTienda getTienda()
    {
        return tienda;
    }
    
    /**
     * Metodo que cambia un objeto de la clase MTienda por otro igual
     * @return tienda- Tienda que esta a la disposicion del usuario.
     */
    public void setTienda(MTienda nuevo)
    {
        tienda=nuevo;
    }
}
