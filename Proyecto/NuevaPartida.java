import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class NuevaPartida here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NuevaPartida extends SWorld
{
    private Heroe hero;
    private ArrayList<Label> dialogos;
    private int cont;
    private boolean actividad;
    /*
     * super(400, 400, 1, 1000); // scroll world constructor call; last parameter is scroll width
        // in the following statement, the main actor is placed in the center of the window
        setMainActor(new Wombat(), 250, 300); // the int parameters are centered window x and y ranges
        // to start the main actor elsewhere
        mainActor.setLocation(100, 342);
        GreenfootImage bg = new GreenfootImage("scene.jpg");
        setScrollingBackground(bg); // set the scolling background image
        // add other scrollable objects normally
        addObject(new Ground(), 200, 390);
        addObject(new Box(), 20, 345);
        // use of the following also adds scrollable objects
        addObject(new Box(), 380, 345, true); // the boolean determines scrollable state
        // use the following for non-scrollable objects
        addObject(new Score(), 40, 390, false);
     */
    /**
     * Constructor for objects of class NuevaPartida.
     * 
     */
    public NuevaPartida()
    {
        super(640, 480, 1, 1920);
        hero= new Heroe(1, 150, false);
        setMainActor(hero, 120, 220);
        mainActor.setLocation(20, 295);
        setScrollingBackground(new GreenfootImage("Inicio.png"));
        addObject(new Ground("Ground.png"), 320, 420);
        //addObject(new Heroe(2, 100, true), 100, 300);
        cont=0;
        actividad=false;
        dialogos= new ArrayList();
        dialogos.add(0, new Label(hero.getName() + ": pero que... ¿pasó?", 24));
        dialogos.add(1, new Label(hero.getName() + ": toda mi familia... ¿muerta?", 28));
        dialogos.add(2, new Label(hero.getName() + ": ¡Juro que encontrare al responsable!, si no, mi nombre dejara de ser...", 20));
        
    }
    
    /**
     * Esto es lo que hara la clase inicio. Añadira unos cuadros de texto.
     */
    public void act()
    {
        super.act();
        if(hero.getX()>= super.getWidth() / 2 - 10 + cont * 70 && hero.getX() <= super.getWidth() / 2 + 10 + cont * 70 && cont < dialogos.size())
        {
            addObject(dialogos.get(cont), hero.getX()- (30 * cont), hero.getY()-100 - (20 * cont));
            cont++;
        }
        
        if( cont >= dialogos.size())
        {
            hero.setName();
            while(hero.getX() <= getWidth() - 10)
            {
                hero.otorgaDireccion("d");
                super.act();
                repaint();
            }
            Greenfoot.setWorld(new Principal(hero, new Barco(1, false), new Catapulta(1)));
        }
    }
}