import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

/**
 * Esta clase se encarga de cargar el escenario de la ciudad. Ademas lleva el control sobre los enemigos que alli aparecen.
 * Cuando termina de hacer su labor, regresa a el menu principal.
 * 
 * @author Daniel Wong
 * @version 1.2
 */
public class Ciudad extends SWorld
{
    
    private Principal principal;
    private int numEnemigos;
    private List<Soldado> enemigos;
    private int numAmigos;
    private List<Soldado> amigos;
    private Heroe enemigo;
    private boolean acceso;
    
    /**
     * Es el constructor de la clase Ciudad. En esta se otorgan valores a todos los elementos, como los Soldados
     * y el jefe final.
     */
    public Ciudad(Principal princ)
    {
        super(640, 480, 1, 1920);
        principal = princ;
        setMainActor(principal.getHero(), 20, 240);
        mainActor.setLocation(20, 320);
        setScrollingBackground(new GreenfootImage("Ciudad.png"));
        
        enemigo = new Heroe(principal.getHero().getnivel()+1, 400, true);
        enemigos = new ArrayList<Soldado>();
        numEnemigos =  3;
        amigos = new ArrayList<Soldado>();
        int i;
        for(i=0 ; i< numEnemigos; i++)
        {
            enemigos.add(i, new Soldado(principal.getHero().getnivel(), true));
            addObject(enemigos.get(i), 320+ 150*i,  320);
        }
        numAmigos=2;
        for(i=0; i<numAmigos; i++)
        {
            amigos.add(i, new Soldado(principal.getHero().getnivel(), false));
            addObject(amigos.get(i), 320- i*150, 320);
        }
       
        acceso=false;
        addObject(new Ground("Piso.png"), 320, 450);
        posicionamiento();
        
        super.act();
    }

    /**
     * Controla tanto el entorno como los soldados, asi como detectar si se ha llegado a algun fin de escenario.
     * Lo hace delegando sus responsabilidades.
     */
    public void act() 
    {
        super.act();
        controlIA();
        controlaFin();
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
            addObject(enemigo, 320, 320, true);
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
            enemigos.get(i).move(Greenfoot.getRandomNumber(320));
            
            if(j < numAmigos)
            {
                amigos.get(j).move(-Greenfoot.getRandomNumber(320));
                j++;
            }
        }
        enemigo.move(660);
        principal.getHero().move(-660);
        super.act();
    }
    
    /**
     * Con este metodo se controla si ya se ha ganado o si aun no
     */
    private void controlaFin()
    {
        if(principal.getHero().getVida()==0)
        {
            addObject(new Label("Haz Perdido\n Regresando al menu Principal",30), getHeight()/2,getWidth()/2, false);
            SimpleTimer rel = new SimpleTimer();
            rel.mark();
            repaint();
            while(rel.millisElapsed()<=4000);
            Greenfoot.setWorld(principal);
        }
        
        if(enemigo.getVida()==0)
        {
            addObject(new Label("HAZ GANADO", 30), getWidth()/2, getHeight()/2, false);
            SimpleTimer rel = new SimpleTimer();
            principal.getHero().setOro(- enemigo.getOro());
            rel.mark();
            repaint();
            while(rel.millisElapsed()<=4000);
            principal.reset();
            Greenfoot.setWorld(principal);
        }
    }
}
