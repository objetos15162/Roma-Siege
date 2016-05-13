import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Templo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Templo extends World
{

    /**
     * Constructor for objects of class Templo.
     * 
     */
    public Templo()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 450, 1); 
    prepare();
}
    public void act(){
     //   suelo();
    }
    public void suelo(){
        for (int i=0;i<5;i++){
            addObject(new bloque(),100,100);
        }
    }
/**
 * Prepare the world for the start of the program.
 * That is: create the initial objects and add them to the world.
 */
private void prepare()
{
    bloque bloque = new bloque();
    addObject(bloque,33,425);
    bloque.setLocation(27,424);
    bloque bloque2 = new bloque();
    addObject(bloque2,86,432);
    bloque bloque3 = new bloque();
    addObject(bloque3,139,432);
    bloque bloque4 = new bloque();
    addObject(bloque4,192,436);
    bloque bloque5 = new bloque();
    addObject(bloque5,254,438);
    bloque bloque6 = new bloque();
    addObject(bloque6,285,438);
    bloque bloque7 = new bloque();
    addObject(bloque7,327,438);
    bloque bloque8 = new bloque();
    addObject(bloque8,361,445);
    bloque bloque9 = new bloque();
    addObject(bloque9,475,449);
    bloque bloque10 = new bloque();
    addObject(bloque10,448,442);
    bloque bloque11 = new bloque();
    addObject(bloque11,570,437);
    bloque bloque12 = new bloque();
    addObject(bloque12,588,437);
    bloque bloque13 = new bloque();
    addObject(bloque13,649,432);
    bloque bloque14 = new bloque();
    addObject(bloque14,693,439);
    bloque2.setLocation(79,424);
    bloque3.setLocation(133,424);
    bloque4.setLocation(186,424);
    bloque5.setLocation(239,423);
    bloque6.setLocation(291,424);
    bloque7.setLocation(344,425);
    bloque8.setLocation(396,426);
    bloque10.setLocation(450,427);
    bloque10.setLocation(448,426);
    bloque9.setLocation(500,426);
    bloque11.setLocation(552,426);
    bloque12.setLocation(603,427);
    bloque13.setLocation(655,427);
    bloque14.setLocation(693,439);
    bloque14.setLocation(693,439);
    bloque14.setLocation(693,439);
    bloque14.setLocation(693,439);
    bloque14.setLocation(693,439);
    bloque14.setLocation(693,439);
    bloque14.setLocation(693,439);
    bloque14.setLocation(693,439);
    bloque14.setLocation(693,439);
    bloque14.setLocation(693,439);
    bloque14.setLocation(693,439);
    bloque14.setLocation(693,439);
    bloque14.setLocation(693,439);
    bloque14.setLocation(693,439);
    bloque14.setLocation(693,439);
    bloque14.setLocation(693,439);
    bloque14.setLocation(693,439);
    bloque14.setLocation(693,439);
    bloque14.setLocation(693,439);
    bloque14.setLocation(693,439);
    bloque14.setLocation(693,439);
    bloque14.setLocation(693,439);
    bloque14.setLocation(693,439);
    bloque14.setLocation(693,439);
    bloque14.setLocation(693,439);
    bloque14.setLocation(693,439);
    bloque14.setLocation(693,439);
    bloque14.setLocation(693,439);
    bloque14.setLocation(693,439);
    bloque14.setLocation(693,439);
    bloque14.setLocation(693,439);
    bloque14.setLocation(693,439);
    bloque14.setLocation(693,439);
    bloque14.setLocation(693,439);
    bloque14.setLocation(693,439);
    bloque14.setLocation(693,439);
    bloque14.setLocation(693,439);
    bloque14.setLocation(682,428);
    seya seya = new seya();
    addObject(seya,30,375);
    seya.setLocation(23,370);
}
}
