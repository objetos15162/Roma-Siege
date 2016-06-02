import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
/**
 * Hace que el entorno sea como un mar. Prepara el entonrno para que dependiendo del nivel del usuario, tenga mas barcos a los cuales vencer.
 * 
 * @author Daniel Wong
 * @version 1.8
 */

public class Mar extends SWorld
{
    public Principal principal;
    private int numBarcosEnemigos;
    private List<Barco> enemigos;
    private boolean acceso;
    
    /**
     * Constructor principal de la clase Mar
     * @param princ- Es un mundo principal del cual se mando a llamar este escenario
     */
    public Mar(Principal princ)
    {
        super(640, 480, 1, 3400);
        principal = princ;
        setMainActor(principal.getBarco(), 20, 240);
        mainActor.setLocation(0, 342);
        setScrollingBackground(new GreenfootImage("Mar.png"));
        numBarcosEnemigos = principal.getBarco().getnivel()+2;
        enemigos = new ArrayList<Barco>();
        int i;
        for(i = 0; i < numBarcosEnemigos; i++)
        {
            enemigos.add(i, new Barco(principal.getBarco().getnivel(), true));
            addObject(enemigos.get(i), 500 + (i * 15), 342);
        }
        addObject(new Ground("Olas.png"), 320, 430);
        posicionamiento();
        acceso = false;
    }

    /**
     * Como los demas mundos, este tiene la obligacion de controlar el entorno, los proyectiles y los enemigos.
     * Ademas de darse cuenta si se ha llegado a un fin.
     */
    public void act() 
    {
       super.act();
       controlaBalas();
       controlaEnemigos();
       
       if(principal.getBarco().getVida()==0)
       {
           int i=0;
           addObject(new Label("Has perdido \n Regresando al menu Principal", 30), getHeight()/2, getWidth()/2, false);
           while(i<200) 
           {
               i++;
           }
           Greenfoot.setWorld(principal);
       }
       
       if(acceso)
       {
           while(principal.getBarco().getX() < 620)
           {
               principal.getBarco().mover(5);
               super.act();
               repaint();
           }
           int i=0;
           addObject(new Label("Pasando al siguiente Nivel", 30), getHeight()/2, getWidth()/2, false);
           repaint();
           while(i<2000) 
           {
               i++;
           }
           Greenfoot.setWorld(new Playa(principal));
       }
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
    
    /**
     * Este metodo verifica que aun quedan enemigos en el mapa, si no, da autorizacion para entrar en el siguiente escenario.
     */
    private void controlaEnemigos()
    {
        int i=0;
        if(enemigos.isEmpty())
        {
            acceso=true;
        }
        
        Barco auxiliar;
        for(i=0; i<enemigos.size(); i++)
        {
            if(enemigos.get(i).getVida()==0)
            {
                auxiliar=enemigos.get(i);
                principal.setOroAcumulado((int) (enemigos.get(i).getExp()/2));
                enemigos.remove(auxiliar);
                removeObject(auxiliar);
            }
        }
    }
    
    /**
     * Este metodo movera a todos los personajes a sus posiciones iniciales, y mostrara una pantalla de cargar... por fines graficos..
     */
    private void posicionamiento()
    {
        //añade pantalla de carga;
        int i;
        for(i=0; i<numBarcosEnemigos; i++)
        {
            enemigos.get(i).move(i*(int)(1700/numBarcosEnemigos)-20);
        }
        
        principal.getBarco().move(-(1700-330));
        super.act();
        //elimina pantalla de carga;
    }
}
