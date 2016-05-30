import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Playa here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Playa extends SWorld
{
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
    private SimpleTimer reloj; 
    public Principal principal;
    private Base base;
    private boolean acceso;
    private Counter contador;
    /**
     * Constructor for objects of class Playa.
     * No solo de manera logica, si no tambien de manera grafica.
     */
    public Playa(Principal prin)
    {
        super(810, 600, 1, 1280);
        principal=prin;
        setMainActor(prin.catapulta, 20, 0);
        mainActor.setLocation(0, 510);
        setScrollingBackground(new GreenfootImage("Playa.png"));
        addObject(new Ground("Arena.png"), 405, 600);
        base= new Base(principal.catapulta.getnivel());
        addObject(base, 660, 300);
        base.move(280);
        principal.catapulta.move(-235);
        super.act();
        reloj = new SimpleTimer();
        contador= new Counter("Time: ");
        addObject(contador, 100, 100, false);
        acceso=false;
        reloj.mark();
    }
    
    public void act()
    {
       actualizaContador();
       controlaBalas();
       super.act();
       if(!acceso)
       {
           if(contador.getValue()<=45)
           {
               if(base.getVida()==0)
               {
                   acceso=true;
               }
           }
           else
           {
               salir();
           }
       }
       else
       {
           setMainActor(principal.hero, 0, 0);
           mainActor.setLocation(0, 500);
           addObject(new Label("Bien hecho", 24), 120, 500, false);
           while(principal.hero.getX()<700)
           {
               principal.hero.mover();
               super.act();
               repaint();
           }
           Greenfoot.setWorld(new Ciudad(principal));
       }
       
    }
    
    /**
     * 
     */
    private void actualizaContador()
    {
        if(reloj.millisElapsed()>=1000)
        {
            contador.add(reloj.millisElapsed()/1000);
            reloj.mark();
        }
    }
    
    /**
     * en este metodo te saca de la partida y te regresa al menu priipal
     */
    private void salir()
    {
        addObject(new Label("Has perdido", 28), 405, 350);
        reloj.mark();
        repaint();
        while(reloj.millisElapsed()<6000);
        Greenfoot.setWorld(principal);
    }
    
    /**Este metodo detecta si existen balas en el mundo, y de ser asi
     * controla que aun sigan en movimiento, si no las elimina
     */
    private void controlaBalas()
    {
       List<Bala> balas = getObjects(Bala.class);
       if(balas != null)
       {
           for(Bala bal : balas)
           {
               if(bal != null && !bal.getVolando())
               {
                  removeObject(bal);
               }
           }
       }
    }
}















