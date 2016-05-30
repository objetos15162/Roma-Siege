import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

/**
 * 
 * @author Daniel Wong
 * @version 1.2
 */
public class Ciudad extends SWorld
{
    
    public Principal principal;
    private int numEnemigos;
    private List<Soldado> enemigos;
    private Heroe enemigo;
    
    public Ciudad(Principal princ)
    {
        super(640, 480, 1, 600);
        principal = princ;
        enemigo = new Heroe(principal.hero.getnivel()+4, 400, true);
        enemigos = new ArrayList<Soldado>();
        numEnemigos = principal.barco. getCapacidad() + 2;
        
        setMainActor(principal.hero, 20, 240);
        mainActor.setLocation(0, 342);
        setScrollingBackground(new GreenfootImage("Ciudad.png"));
        addObject(new Ground("Olas.png"), 320, 430);
        int i;
        for(i=0 ; i< numEnemigos; i++)
        {
            enemigos.add(i, new Soldado(principal.hero.getnivel(), true));
            addObject(enemigos.get(i), 320+ 10*i,  342);
        }
    }

    public void act() 
    {
        // Add your action code here.
    }    

}
