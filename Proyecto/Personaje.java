import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Esta clase sera la base para todos los objetos que participaran como NPC y para el jugador. Tendra la informacion de los objetos tales como ataque, defensa, etc,
 * asi como su posicion en el espacio.
 * 
 * @author Daniel Alejandro Wong Ramirez 
 * @author Juan Carlos Partida V<quez
 * @version 1.0
 */
public class Personaje extends Actor
{
    private int nivel;       // Como es obvio es el nivel de la unidad
    private float atk;       // Es el daño basico que una unidad puede hacer. 
    private float def;       // Es la cantidad de resistencia que puede oponer al daño.
    private float aguante;   // Esta es la cantidad de daño que puede recibir una unidad antes que su vida empieze a reducir.
    private int vida;        // Es la cantidad de daño que puede recibir una unidad antes de quedar KO o muerta...
    private float exp;       // Esta variable, dependiendo de si es un enemigo  no, varia. Siendo asi que si es un enemigo, la cantidad de experiencia del enemigo se pasa a la unidad que la derroto. En caso contrario, 
    private float nextLevel; // Indica cuanto es necesario ganar de experiencia para aumentar el ni
    private boolean isEnemy; // Indica si la unidad es enemiga.
    private String nombre;   // Es el nombre de la unidad. Se asigna automaticamente si es una unidad no Jugador
    
    private int direccion;   // Con esta varible se representa la direccion. 1 es a la derecha, -1 a la izquierda.
    private boolean inAtk;   // Esta varible indica si esta en medio de un ataque. Si es asi solo se apagara hasta que la animacion de ataque termine.
    private GifImage inmovilDerecha;
    private GifImage inmovilIzquierda;
    private GifImage movimientoDerecha;
    private GifImage movimientoIzquierda;
    private GifImage ataqueImgD;
    private GifImage ataqueImgI;
    private List<GreenfootImage> gif;
    private int positionList;
    /**
     * Esta funcion es el constructor. Inicia los valores del personaje dependiendo del nivel que se le mande.
     */
    public Personaje(int niv, String nom, boolean ene)
    {
        if(niv != 1 && ene == false)
        {
            nivel=niv;
            //lee los datos desde un archivo.
        }
        else
        {
            if(niv <= 0)
            {
                niv = (-niv) + 1;
            }
            nivel = niv;
            atk = niv * 10 + Greenfoot.getRandomNumber(niv * 10/ 2);
            def = niv * 10 + Greenfoot.getRandomNumber((int)(niv * 10 / 1.5));
            aguante = niv * 10 + Greenfoot.getRandomNumber((int)(niv * 10 / 1.25));
            vida = niv * 100 + Greenfoot.getRandomNumber(niv * 100);
            nombre = nom;
            isEnemy = ene;
            if(ene)
            {
                exp = (atk+def+aguante+(vida/10))/niv*5;
                direccion = -1;
            }
            else
            {
                exp=0;
                nextLevel= 100;
                direccion=1;
            }
        }
        inAtk=false;
     /*   ataqueImgD= new GifImage(ataqD);
        ataqueImgI= new GifImage(ataqI);
        inmovilDerecha = new GifImage(inmovilD);
        inmovilIzquierda = new GifImage(inmovilI);
        movimientoDerecha = new GifImage(movD);
        movimientoIzquierda= new GifImage(movI);*/
        gif=null;
        positionList=0;
    }
    
    /**
     * Act - do whatever the Personaje wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
       if(isEnemy != true)
       {
          // moveHero();
       }
    }
    
    /**
     * Este metodo genera la animacion estandar mientras no se mueva hacia algun lado.
     * 
     */
    private void movEstandar()
    {
        if(direccion==1)
        {
            setImage(inmovilDerecha.getCurrentImage());
        }
        else
        {
            setImage(inmovilIzquierda.getCurrentImage());
        }
    }
    
    /**
     * Este metodo otorga la direccion a la que el usuario o computadora decidio apuntar y lo mueve en esa direccion.
     * 
     * @param key - Esta variable indica que tecla se presiono.
     */
    private void moveHero()
    {
        if(Greenfoot.isKeyDown("right"))
        {
            move(5);
        }
        if(Greenfoot.isKeyDown("left"))
        {
            move(-5);
        }
         
    }
   
    /**
     *  Este metodo Es para ver donde hay enemigos, genera una accion si hay enemigos
     *  cerca. Funciona tanto para Enemigos como amigo.
     *  
     *  @return String - Es null si no hay nada en un perimetro.
     */
    private String actAutomatico()
    {
        World world = getWorld();        
        if(isEnemy)
        {
            List <Personaje> actores = getObjectsInRange(50, Personaje.class);
            for( Personaje p: actores)
            {
                if(p != null && !p.getisEnemy())
                {
                    if(p.getX() - this.getX() <=10)
                    {
                        direccion = -1;
                        return "n";                        
                    }
                    else
                    {
                        if( p.getX() - this.getX() >10)
                        {
                            return "a";
                        }
                    }
                    
                    if( p.getX() - this.getX()>= -10)
                    {
                        direccion = 1;
                        return "n";
                    }
                    else
                    {
                        if( p.getX() - this.getX()< -10)
                        {
                            return "d";
                        }
                    }
                }
            }
        }
        else
        {
            List <Personaje> actores = getObjectsInRange(50, Personaje.class);
            for( Personaje p: actores)
            {
                if(p != null && p.getisEnemy())
                {
                    if(p.getX() - this.getX() <=10)
                    {
                        direccion = -1;
                        return "n";                        
                    }
                    else
                    {
                        if( p.getX() - this.getX() >10)
                        {
                            return "a";
                        }
                    }
                    
                    if( p.getX() - this.getX()>= -10)
                    {
                        direccion = 1;
                        return "n";
                    }
                    else
                    {
                        if( p.getX() - this.getX()< -10)
                        {
                            return "d";
                        }
                    }
                }
            }
        }
        return null;
    }
    
    /**
     * Este metodo se encarga de poner la animacion de ataque hasta que acabe la animacion.
     * Al acabar, verifica que actores esta tocando. Si alguno es enemigo, le reduce la vida.
     */
    private void atacar()
    {
        if(gif.get(positionList) != null)
        {
            setImage(gif.get(positionList));
            positionList++;
        }
        else
        {
            World world = getWorld();
            List<Personaje> actores = getIntersectingObjects(Personaje.class);
            for(Personaje p: actores)
            {
                if(isEnemy)
                {
                    if(!p.getisEnemy())
                    {
                        p.reduceVida(atk);
                        if(p.getVida() == 0)
                        {
                            world.removeObject(p);
                        }
                    }
                }
                else
                {
                    if(p.getisEnemy())
                    {
                        p.reduceVida(atk);
                        if(p.getVida() == 0)
                        {
                            aumentaExp(p.getExp());
                            world.removeObject(p);
                        }
                    }
                }
            }
            positionList=0;
            inAtk=false;
        }
    }
    
    
    /**
     * Este Metodo Aumenta la experiencia. Si sobrepasa el limite, manda a aumentar todas las caracteristicas del personaje. Si aun despues de aumentar
     * las estadisticas aun queda experiencia, se llama de manera recursiva hasta que el monto sea negativo.
     * @param monto Esta varible representa Cuanto se va a aumentar la experiencia.
     */
    private void aumentaExp(float monto)
    {
        exp += monto;
        if(exp >= nextLevel)
        {
            monto = exp - nextLevel;
            aumentaNivel();
            if(monto > 0)
            {
                aumentaExp( monto );
            }
        }
    }
    
    /**
     * En este metodo se suben las estadisticas del Personaje de manera semi-aleatoria.
     */
    private void aumentaNivel()
    {
        nivel ++;
        atk += Greenfoot.getRandomNumber(9)+1;
        def += Greenfoot.getRandomNumber(9)+1;
        aguante += Greenfoot.getRandomNumber(9)+1;
        vida += Greenfoot.getRandomNumber(9)+1;
        exp = 0;
        nextLevel += nextLevel *0.2;
    }
    
    /**
     * Este metodo reduce la vida ya la resistencia del Personaje
     * 
     * @param daño Esta varible indica cuanto daño se le va a hacer a la unidad
     */
    private void reduceVida(float daño)
    {
        if(daño - def <= 0)
        {
            daño=1;
        }
        else
        {
            daño -= def;
        }
        
        if(aguante>0)
        {
            aguante -= daño;
            if(aguante<0)
            {
                aguante=0;
            }
        }
        else
        {
            vida -= daño;
            if(vida<0)
            {
                vida=0;
            }
        }
    }
    
    /**
     * Este metodo se encarga de cargar la imagen correspondiente para que el personaje se mueva.
     */
    private void mover()
    {
        if(direccion==-1)
        {
            setImage(movimientoIzquierda.getCurrentImage());
        }
        else
        {
            setImage(movimientoDerecha.getCurrentImage());
        }
        move(direccion * 4);
    }
    
    /**
     * This method returns the level
     * 
     */
    public int getNivel()
    {
        return nivel;
    }
    
    /**
     * This method returns the Life
     * 
     */
    public int getVida()
    {
        return vida;
    }
    
    /**
     * This method returns if the object is enemy
     * 
     */
     public boolean getisEnemy()
    {
        return isEnemy;
    }
    
    
    /**
     * This method returns the Name
     * 
     */
    public String getName()
    {
        return nombre;
    }
    
    /**
     * Este Metodo regresa la experiencia
     * 
     * @return exp Es la experiencia del Personaje. Es un flotante
     */
    public float getExp()
    {
        return exp;
    }
}
