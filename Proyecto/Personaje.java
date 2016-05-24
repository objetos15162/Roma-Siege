import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Esta clase sera la base para todos los objetos que participaran como NPC y para el jugador. Tendra la informacion de los objetos tales como ataque, defensa, etc,
 * asi como su posicion en el espacio.
 * 
 * @author Daniel Alejandro Wong Ramirez 
 * @version 2.3
 */
public class Personaje extends Actor
{
    private int nivel;       // Como es obvio es el nivel de la unidad
    private float atk;       // Es el daño basico que una unidad puede hacer. 
    private float def;       // Es la cantidad de resistencia que puede oponer al daño.
    private float aguante;   // Esta es la cantidad de daño que puede recibir una unidad antes que su vida empieze a reducir.
    private float maxAguante;// Varible auxiliar para el aguante
    private int vida;        // Es la cantidad de daño que puede recibir una unidad antes de quedar KO o muerta...
    private int maxVida;     // Varible auxiliar para la vida
    private float exp;       // Esta variable, dependiendo de si es un enemigo  no, varia. Siendo asi que si es un enemigo, la cantidad de experiencia del enemigo se pasa a la unidad que la derroto. En caso contrario, 
    private float nextLevel; // Indica cuanto es necesario ganar de experiencia para aumentar el ni
    private boolean isEnemy; // Indica si la unidad es enemiga.
    private String nombre;   // Es el nombre de la unidad. Se asigna automaticamente si es una unidad no Jugador
    
    private int control;     // Esta varible es para controlar las acciones automaticas de los personajes.
    private int direccion;   // Con esta varible se representa la direccion. 1 es a la derecha, -1 a la izquierda.
    private boolean inAtk;   // Esta varible indica si esta en medio de un ataque. Si es asi solo se apagara hasta que la animacion de ataque termine.
    private GifImage inmovilDerecha;
    private GifImage inmovilIzquierda;
    private GifImage movimientoDerecha;
    private GifImage movimientoIzquierda;
    private GifImage ataqueImgD;
    private GifImage ataqueImgI;
    private List<GreenfootImage> gif;  //Esta variable es para obtener la lista de imagenes que tiene un gif
    private int positionList;  //  Esta varible entera sirve para identificar en que posicion del gif esta actualmente.
    /**
     * Esta funcion es el constructor. Inicia los valores del personaje dependiendo del nivel que se le mande.
     */
    public Personaje(int niv, boolean ene, String inmovilD, String inmovilI, String movD, String movI, String ataqD, String ataqI)
    {
        nivel = niv;
        atk = nivel * 10 + Greenfoot.getRandomNumber(nivel * 10/ 2);
        def = nivel * 10 + Greenfoot.getRandomNumber((int)(nivel * 10 / 1.5));
        aguante = nivel * 10 + Greenfoot.getRandomNumber((int)(nivel * 10 / 1.25));
        maxAguante = aguante;
        vida = nivel * 100 + Greenfoot.getRandomNumber(nivel * 100);
        maxVida = vida;
        nombre = "???";
        isEnemy = ene;
        if(ene)
        {
            exp = (atk+def+aguante+(vida/10))/nivel*5;
            direccion = -1;
        }
        else
        {
            exp=0;
            nextLevel= 100;
            direccion=1;
        }
        
        inAtk=false;
        ataqueImgD= new GifImage(ataqD);
        ataqueImgI= new GifImage(ataqI);
        inmovilDerecha = new GifImage(inmovilD);
        inmovilIzquierda = new GifImage(inmovilI);
        movimientoDerecha = new GifImage(movD);
        movimientoIzquierda= new GifImage(movI);
        gif=null;
        positionList=1;
        control=0;
    }
    
    /**
     * Este otro constructor recibe el nombre de un archivo para leer los datos desde alli
     * 
     * @param tipoArchivo Es una cadena que indica el nombre del archivo, y el tipo de Personaje que se creara
     */
    public Personaje(String nomArchivo)
    {
        // aqui se leera el archivo
        ;
    }
    
    /**
     * Act - do whatever the Personaje wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if(inAtk==false)
        {
            String key;
            if(!isEnemy)
            {
                if(Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("n"))
                {
                    key = Greenfoot.getKey();
                    if(key != null)
                    {
                        otorgaDireccion(key);
                    }
                }
                else
                {
                    movEstandar();
                }
            }
            else
            {
                key=actAutomatico();
                if(key != null)
                {
                    otorgaDireccion(key);
                }
                else
                {
                    movEstandar();
                }
            }
        }
        else
        {
            atacar();
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
    public void otorgaDireccion(String key)
    {
         switch(key)
         {
             case "a":
                 //Aqui se cambia la imagen por el del gif corriedo
                 direccion=-1;
                 mover();
                 break;
           
             case "d":
                 direccion=1;
                 mover();
                 break;
                    
             case "n":
                 if(direccion == -1)
                 {
                     gif = ataqueImgI.getImages();
                 }
                 else
                 {
                     gif = ataqueImgD.getImages();
                 }
                 inAtk=true;
                 break;
             
         }
    }
   
    /**
     *  Este metodo Es para ver donde hay enemigos, genera una accion si hay enemigos
     *  cerca. Funciona tanto para Enemigos como amigo. Limita el numero de ataques por personaje.
     *  Funciona como para aliados asi como para enemigos.
     *  
     *  @return String - Es null si no hay nada en un perimetro, o si se esta controlando su cantidad de ataques.
     */
    private String actAutomatico()
    {
        World world = getWorld();
        
        if(isEnemy)
        {
            List <Personaje> actores = getObjectsInRange(400, Personaje.class);
            for( Personaje p: actores)
            {
                if(p != null && !p.getisEnemy())
                {
                    if(p.getX() - this.getX() >= -10)
                    {
                        if(control< atk-2*nivel)
                        {
                            control++;
                            return null;
                        }
                        else
                        {
                            control=0;
                        }
                        direccion = -1;
                        return "n";                        
                    }
                    else
                    {
                        if( p.getX() - this.getX() < -10)
                        {
                            return "a";
                        }
                    }
                    
                    if( p.getX() - this.getX()<= 10)
                    {
                        if(control<atk-2*nivel)
                        {
                            control++;
                            return null;
                        }
                        else
                        {
                            control=0;
                        }
                        direccion = 1;
                        return "n";
                    }
                    else
                    {
                        if( p.getX() - this.getX()> -10)
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
                    if(p.getX() - this.getX() >=10)
                    {
                        direccion = -1;
                        return "n";                        
                    }
                    else
                    {
                        if( p.getX() - this.getX() <10)
                        {
                            return "a";
                        }
                    }
                    
                    if( p.getX() - this.getX()<= -10)
                    {
                        direccion = 1;
                        return "n";
                    }
                    else
                    {
                        if( p.getX() - this.getX() > -10)
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
        if(positionList<gif.size())
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
            aumentanivel();
            if(monto > 0)
            {
                aumentaExp( monto );
            }
        }
    }
    
    /**
     * En este metodo se suben las estadisticas del Personaje de manera semi-aleatoria.
     */
    private void aumentanivel()
    {
        nivel ++;
        atk += Greenfoot.getRandomNumber(9)+1;
        def += Greenfoot.getRandomNumber(9)+1;
        maxAguante += Greenfoot.getRandomNumber(9)+1;
        maxVida += Greenfoot.getRandomNumber(9)+1;
        vida=maxVida;
        aguante=maxAguante;
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
        move(direccion * 8);
    }
    
    /**
     * This method returns the level
     * 
     */
    public int getnivel()
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
    
    /**
     * Este metodo cambia el nombre del personaje
     */
    public void setName()
    {
        nombre= Greenfoot.ask("Nombre: "); 
    }
}
