import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Principio here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Principal extends MenuInicio
{
    Heroe hero;
    Barco barco;
    Catapulta catapulta;
    
    /**
     * Constructor for objects of class Principio.
     * 
     */
    public Principal(Heroe actor, Barco balsa, Catapulta lanzador)
    {
        super(1);
        hero = actor;
        barco = balsa;
        catapulta = lanzador;
    }
}
