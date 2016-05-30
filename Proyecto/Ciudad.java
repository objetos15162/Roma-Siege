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
    private int numAmigos;
    private List<Soldado> amigos;
    private Heroe enemigo;
    private boolean acceso;
    
    public Ciudad(Principal princ)
    {
        super(640, 480, 1, 600);
        principal = princ;
        enemigo = new Heroe(principal.getHero().getnivel()+4, 400, true);
        enemigos = new ArrayList<Soldado>();
        numEnemigos = principal.getBarco(). getCapacidad() + 2;
        
        setMainActor(principal.getHero(), 20, 240);
        mainActor.setLocation(0, 342);
        setScrollingBackground(new GreenfootImage("Ciudad.png"));
        addObject(new Ground("Piso.png"), 320, 430);
        int i;
        for(i=0 ; i< numEnemigos; i++)
        {
            enemigos.add(i, new Soldado(principal.getHero().getnivel(), true));
            addObject(enemigos.get(i), 320+ 10*i,  342);
        }
        numAmigos=numEnemigos-2;
        for(i=0; i<numAmigos; i++)
        {
            amigos.add(i, new Soldado(principal.getHero().getnivel(), false));
            addObject(amigos.get(i), 320- i*10, 342);
        }
        acceso=false;
        posicionamiento();
    }

    public void act() 
    {
        if(!acceso)
        {
            controlIA();
        }
        else
        {
            if(enemigo.getVida()==0)
            {
                addObject(new Label("HAZ GANADO", 30), getWidth()/2, getHeight()/2, false);
                int i=0;
                while(i<100) 
                {
                    i++;
                }
                principal.reset();
                Greenfoot.setWorld(principal);
            }
        }
    }    
    
    /**
     * Con este metodo se lleva control sobre los enemigos y los amigos.
     */
    public void controlIA()
    {
        int i;
        Soldado auxiliar;
        for(i=0; i<enemigos.size(); i++)
        {
            if(enemigos.get(i).getVida()==0)
            {
                auxiliar=enemigos.get(i);
                enemigos.remove(auxiliar);
                removeObject(auxiliar);
            }
        }
        
        for(i=0; i < amigos.size(); i++)
        {
            if(amigos.get(i).getVida()==0)
            {
                auxiliar=amigos.get(i);
                amigos.remove(auxiliar);
                removeObject(auxiliar);
            }
        }
        
        if(enemigos.isEmpty() && !acceso)
        {
            acceso=true;
            addObject(enemigo, 320, 342, true);
            enemigo.move(500);
        }
    }
    
    /**
     * Acomoda cada personaje del escenario en un lugar al azar.
     */
    private void posicionamiento()
    {
        int i, j;
        
        for(i=0, j=0; i<numEnemigos ; i++)
        {
            enemigos.get(i).move(Greenfoot.getRandomNumber(640));
            if(j < numAmigos)
            {
                amigos.get(j).move(Greenfoot.getRandomNumber(-640));
                j++;
            }
        }
        //enemigo.move(660);
        principal.getHero().move(-660);
        super.act();
    }
}
