import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Barco here.
 * 
 * @author Daniel Wong 
 * @version 1.1
 */
public class Barco extends Personaje
{
    private float velocidad;
    private int capacidad;
    private boolean mejoraVelocidad1;
    private boolean mejoraVelocidad2;
    private boolean mejoraVelocidad3;
    
<<<<<<< HEAD
    public Barco(int nivel, boolean esEnemigo)
    {
        super(nivel, esEnemigo, "Barco", "", "", "", "", "");
=======
    public Barco(String nombre, boolean enemy)
    {
        super(1, nombre, enemy);
>>>>>>> origin/master
        mejoraVelocidad1=false;
        mejoraVelocidad2=false;
        mejoraVelocidad3=false;
        velocidad=10;
        capacidad=5 + Greenfoot.getRandomNumber(4+nivel);
    }
    /**
     * Act - do whatever the Barco wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
       if ( Greenfoot.isKeyDown("left"))
        {
           // move(-1);
        }
       if(Greenfoot.isKeyDown("right"))
        {
          //  move(1);
        }
    }
    
    /**
     *  getVelocidad regresa la variable velocidad
     *  @return velocidad
     */
    public float getVelocidad()
    {
        return velocidad;
    }
    
    /**
     * Metodo que aplica las diferentes mejoras de velocidad
     */
    public void mejoraVel(int opc)
    {
        if(opc>0 && opc<4)
            {
                switch(opc)
                {
                    case 1: if(!mejoraVelocidad1)
                            {
                                ;
                            }
                    break;
                }
            }
    }
    
}
