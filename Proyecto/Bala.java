import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Es un proyectil, el cual se encarga de simular su caida con gravedad.
 * 
 * @author Carlos Partida
 * @author Daniel Wong
 * 
 * @version 2.1
 */
public class Bala extends Actor
{
    private Personaje origen;
    private int direction;
    private int daño;
    private int velX;
    private int velY;
    private int tiempo;
    private boolean volando;
    private int controlador;
    /**
     * El constructor de la bala
     */
    public Bala(int dir, int velXbase, int velYbase, int atkBarco, Personaje ori)
    {
      origen = ori;
      direction = dir;
      velX= dir * 10 + velXbase;
      velY=10 + velYbase;
      daño = (int)(atkBarco * 1.5);
      if(!origen.getisEnemy())
      {
          daño = daño * 2;
      }
      tiempo=velY;
      volando=true;
      controlador=0;
    }
    
    /**
     * Se da cuenta en este metodo si el proyectil sige en el aire y de serlo asi, le otorga nuevos valores de velocidad en x y y.
     */
    public void act() 
    {
        if(volando)
        {
            if(controlador >= 5)
            {
                setLocation(getX() + velX, getY() - velY);
                efectoGravedad();
                controlador=0;
            }
            else
            {
                controlador++;
            }
        }
        
        if(isTouching(Personaje.class))
        {
            List<Personaje> afectados = getIntersectingObjects(Personaje.class);
            for(Personaje b : afectados)
            {
                if(!b.equals(origen))
                {
                    b.reduceVida(daño);
                    if(b.getVida()==0 && !origen.getisEnemy())
                    {
                        origen.aumentaExp(b.getExp());
                    }
                    volando=false;
                }
            }
        }
        
        if(getY() >= getWorld().getHeight()-50)
        {
            volando = false;
        }
        
    }    
   
    /**
     * En este metodo se simula la gravedad para reducir la velocidad en y
     */
    private void efectoGravedad()
    {
        velY-= 2;
        if(velY <= (int)(-tiempo*1.5))
        {
            velY=0;
            velX=0;
            volando=false;
        }
    }
    
    /**
     * Este metodo regresa la varible que indica si aun esta en el aire este objeto
     * @return volando- VARIBALE BOOLEANA QUE INDICA SI LA BALA AUN TIENE ALTURA.
     */
    public boolean getVolando()
    {
        return volando;
    }
}
