import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * EL OBJETIVO DE ESTA CLASE ES INICIALIZAR UNA NUEVA PARTIDA, GENERANDO NUEVOS DATOS PARA CADA PERSONAJE QUE
 * EL USUARIO USARA EN EL JUEGO.
 * 
 * @author Daniel Wong
 * @version 1.2
 */
public class NuevaPartida extends SWorld
{
    private Heroe hero;
    private ArrayList<Label> dialogos;
    private int cont;
    private boolean actividad;
    
    /**
     * Constructor for objects of class NuevaPartida.
     * 
     */
    public NuevaPartida()
    {
        super(640, 480, 1, 1920);
        hero= new Heroe(1, 200, false);
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
        dialogos.add(2, new Label(hero.getName() + ": ¡Juro que encontrare al responsable¡", 28));
        
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
            if(hero.getName()=="Dan")
            {
                hero.setOro(-20000);
            }
            
            while(hero.getX() <= getWidth() - 100)
            {
                hero.otorgaDireccion("d");
                super.act();
                repaint();
            }
            Principal nuevo = new Principal(hero, new Barco(1, false), new Catapulta(1), new MTienda());
            Greenfoot.setWorld(nuevo);
        }
    }
}