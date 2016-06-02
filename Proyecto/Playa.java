import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * LA CLASE PLAYA TIENE COMO OBJETIVO PREPARAR EL ESCENARIONPARA USAR LA CATAPULTA DEL JUGADOR
 * ADEMAS, SI EL JUGADOR LOGRA PASAR, SE ASIGNA DINERO AL MONTO DEL OBJETO PRINCIPAL.
 * 
 * @author Daniel Wong
 * @version 2.0
 */
public class Playa extends SWorld
{
    
    private SimpleTimer reloj; 
    public Principal principal;
    private Base base;
    private boolean acceso;
    private Counter contador;
    /**
     * Constructor for objects of class Playa.
     * No solo de manera logica, si no tambien de manera grafica. Aqui mismo se preparan ambas cosas.
     */
    public Playa(Principal prin)
    {
        super(810, 600, 1, 1280);
        principal=prin;
        setMainActor(prin.getCatapulta(), 20, 0);
        mainActor.setLocation(0, 510);
        setScrollingBackground(new GreenfootImage("Playa.png"));
        addObject(new Ground("Arena.png"), 405, 600);
        base= new Base(principal.getCatapulta().getnivel());
        addObject(base, 660, 300);
        base.move(280);
        principal.getCatapulta().move(-235);
        super.act();
        reloj = new SimpleTimer();
        contador= new Counter("Time: ");
        addObject(contador, 100, 100, false);
        acceso=false;
        reloj.mark();
        addObject(new Label("Tienes 45s para destruir \nla base. Suerte.", 30), 200, 150);
    }
    
    /**
     * En este metodo se procura actualizar y controlar el entorno; es decir
     * las balas, el jugador, y el contador del tiempo.
     */
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
           
           setMainActor(principal.getHero(), 0, 0);
           mainActor.setLocation(0, 500);
           addObject(new Label("Bien hecho", 24), 120, 500, false);
           while(principal.getHero().getX()<700)
           {
               if(reloj.millisElapsed()>=25)
               {
                   principal.getHero().mover();
                   super.act();
                   repaint();
                   reloj.mark();
                }
           }
           principal.reset();
           Greenfoot.setWorld(new Ciudad(principal));
       }
       
    }
    
    /**
     * Actualiza cada segundo que pasa el contador.
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















