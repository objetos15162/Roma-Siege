import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Esta clase sera la base para todos los objetos que participaran como NPC y para el jugador. Tendra la informacion de los objetos tales como ataque, defensa, etc,
 * asi como su posicion en el espacio.
 * 
 * @author Daniel Alejandro Wong Ramirez 
 * @version 3.5
 */
public class Personaje extends Actor
{
    private int nivel;       // Como es obvio es el nivel de la unidad
    private float atk;       // Es el daño basico que una unidad puede hacer. Es el ataque.
    private float def;       // Es la cantidad de resistencia que puede oponer al daño. Es la defensa.
    private float aguante;   // Esta es la cantidad de daño que puede recibir una unidad antes que su vida empieze a reducir.
    private float maxAguante;// Varible auxiliar para el aguante
    private int vida;        // Es la cantidad de daño que puede recibir una unidad antes de quedar KO o muerta...
    private int maxVida;     // Varible auxiliar para la vida
    private float exp;       // Esta variable, dependiendo de si es un enemigo  no, varia. Siendo asi que si es un enemigo, la cantidad de experiencia del enemigo se pasa a la unidad que la derroto. En caso contrario, 
    private float nextLevel; // Indica cuanto es necesario ganar de experiencia para aumentar el ni
    private boolean isEnemy; // Indica si la unidad es enemiga.
    private String nombre;   // Es el nombre de la unidad. Se asigna automaticamente si es una unidad no Jugador
    
    private Counter vitalidad;
    private Counter resistencia;
    private boolean añadido;
    
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
        vida = nivel * 25 + Greenfoot.getRandomNumber(nivel * 10);
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
        if(ataqD != null)
        {
            ataqueImgD= new GifImage(ataqD);
            ataqueImgI= new GifImage(ataqI);
            inmovilDerecha = new GifImage(inmovilD);
            inmovilIzquierda = new GifImage(inmovilI);
            movimientoDerecha = new GifImage(movD);
            movimientoIzquierda= new GifImage(movI);
        }
        gif=null;
        positionList=1;
        control=0;
        
        resistencia = new Counter("Aguante: ");
        resistencia.setValue((int)aguante);
        vitalidad = new Counter("Vida: ");
        vitalidad.setValue((int)vida);
        añadido=false;
    }
    
    /**
     * Este otro constructor recibe el nombre de un archivo para leer los datos desde alli
     * 
     * @param nomArchivo Es una cadena que indica el nombre del archivo, y el tipo de Personaje que se creara
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
        if(!añadido)
        {
            reiniciaConts();
            añadeConts();
            añadido=true;
        }
        
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
        mueveConts();
    }
    
    /**
     * este metodo reinicia el valor de los contadores graficos de la vida y el aguante
     */
    public void reiniciaConts()
    {
        vitalidad.setValue(vida);
        resistencia.setValue((int)aguante);
    }
    
    /**
     * Este metodo invoca a los dos contadores que indican la vida y resistencia de cada jugador.
     */
    public void añadeConts()
    {
        World world = getWorld();
        world.addObject(vitalidad, this.getX(), this.getY()-100);
        world.addObject(resistencia, this.getX(), this.getY()-140);
    }
    
    /**
     * En este metodo tambien se invoca a pantalla dos contadores. pero en las coordenadas dadas.
     * Es usado por la clase base.
     */
    public void añadeConts(int x, int y)
    {
        SWorld world = (SWorld)getWorld();
        world.addObject(vitalidad, x, y-100, false);
        world.addObject(resistencia, x, y-140, false);
    }
    
    /**
     * este metodo mueve los dos contadores justo hacia donde el jugador
     */
    public void mueveConts()
    {
        int movimiento = this.getX() - vitalidad.getX(); 
        vitalidad.move(movimiento);
        resistencia.move(movimiento);
    }
    
    /**
     * Este metodo genera la animacion estandar mientras no se mueva hacia algun lado.
     * 
     */
    public void movEstandar()
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
     *  NOTA: Falta optimizarse.
     *  @return String - Es null si no hay nada en un perimetro, o si se esta controlando su cantidad de ataques.
     */
    private String actAutomatico()
    {        
        if(isEnemy)
        {
            List <Personaje> actores = getObjectsInRange(400, Personaje.class);
            for( Personaje p: actores)
            {
                if(p != null && !p.getisEnemy())
                {
                    if(p.getX() - this.getX() >= -30 && p.getX() - this.getX() <= 0)
                    {
                        if(control< atk*2-4*nivel)
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
                    
                    if( p.getX() - this.getX()<= 30 && p.getX() - this.getX() >= 0)
                    {
                        if(control<atk*2-4*nivel)
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
                        if(p.getX() - this.getX() > 30)
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
     * Al acabar, verifica que actores esta tocando. Si alguno es enemigo, le reduce la vida. Esta ultima accino la delega a otro metodo
     */
    public void atacar()
    { 
        if(gif== null)
        {
            if(direccion== -1)
            {
                gif = ataqueImgI.getImages();
            }
            else
            {
                gif = ataqueImgD.getImages();
            }   
        }
        
        if(positionList<gif.size())
        {
            setImage(gif.get(positionList));
            positionList++;
        }
        else
        {
            gif=null;
            generaDaño();
            positionList=0;
            inAtk=false;
        }
    }
    
    /**
     * En este metodo se clacula el daño (si se hizo alguno) despues de la animacion de dar el ataque.
     */
    public void generaDaño()
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
    }
    
    /**
     * Este metodo de atacar solo es usado por el barco y la catapulta
     */
    public boolean atacar(int identificador)
    {   
        gif = ataqueImgI.getImages();
        
        if(positionList<gif.size())
        {
            setImage(gif.get(positionList));
            positionList++;
            return true;
        }
        else
        {
            positionList=0;
            return false;
        }
    }
    
    /**
     * Este Metodo Aumenta la experiencia. Si sobrepasa el limite, manda a aumentar todas las caracteristicas del personaje. Si aun despues de aumentar
     * las estadisticas aun queda experiencia, se llama de manera recursiva hasta que el monto sea negativo.
     * @param monto Esta varible representa Cuanto se va a aumentar la experiencia.
     */
    public void aumentaExp(float monto)
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
        
        resistencia.setValue((int)aguante); 
        vitalidad.setValue(vida);
    }
    
    /**
     * Este metodo reduce la vida ya la resistencia del Personaje
     * 
     * @param daño Esta varible indica cuanto daño se le va a hacer a la unidad
     */
    public void reduceVida(float daño)
    {
        
        if(aguante>0)
        {
            aguante -= daño;
            resistencia.add((int)-daño);
            if(aguante<=0)
            {
                aguante=0;
                resistencia.setValue((int)aguante);
                //getWorld().removeObject(resistencia);
            }
            
        }
        else
        {
            if(daño - def <= 0)
            {
                daño=1;
            }
            else
            {
                daño -= def;
            }
            vida -= daño;
            vitalidad.add(-(int)daño);
            if(vida<=0)
            {
                vida=0;
                vitalidad.setValue(vida);
                //getWorld().removeObject(vitalidad);
            }
        }
    }
    
    /**
     * Este metodo se encarga de cargar la imagen correspondiente para que el personaje se mueva.
     */
    public void mover()
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
     * Este metodo mover solo funciona para el barco y la catapulta
     * @param vel- La velocidad con la que se va a mover el personaje en cuestion.
     */
    public void mover(int vel)
    {
        if(vel != 0)
        {
            setImage(movimientoIzquierda.getCurrentImage());
            move(vel);
            mueveConts();
        }
        else
        {
            setImage(inmovilIzquierda.getCurrentImage());
        }
    }
    
    /**
     * este metodo regresa el ataque del personaje
     * @return atk- La varible que indica el ataque del Personaje
     */
    public float getAtk()
    {
        return atk;
    }
    
    /**
     * This method returns the level
     */
    public int getnivel()
    {
        return nivel;
    }
    
    /**
     * SE ENCARGA DE MODIFICAR LA VARIBLE DE ATAQUE EN CIERTA CANTIDAD
     */
    public void setAtk()
    {
        atk= atk*(float)1.1;
    }
    
    /**
     * SE ENCARGA DE MODIFICAR LA VARIBLE DE DEFENSA EN CIERTA CANTIDAD
     */
    public void setDef()
    {
        def = def*(float)1.1;
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
     * En este metodo se regresa el valor de la variable que indica la vida maxima
     */
    public int getMaxVida()
    {
        return maxVida;
    }
    
    /**
     * Modifica la cantidad de vida maxima
     */
    public void setVida()
    {
        maxVida = (int)(maxVida*1.05);
        vida=maxVida;
    }
    
    /**
     * Modifica el monto de aguante maximo.
     */
    public void setAguante()
    {
        maxAguante = (int)(maxAguante*1.2);
        aguante = maxAguante;
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
    
    /**
     * En este metodo se cambian las imagenes del personaje. Esta diseñado solo para los barcos y la catapulta.
     * 
     * @param atkGif String que contiene el nombre de la imagen nueva de ataque a poner.
     * @param movGif String que contiene el nombre de la imagen nueva de movimiento.
     * @param inmGif String que contiene el nombre de la imagen nueva sin movimiento.
     */
    public void setGifs(String atkGif, String movGif, String inmGif)
    {
        ataqueImgD= new GifImage(atkGif);
        ataqueImgI= new GifImage(atkGif);
        inmovilDerecha = new GifImage(inmGif);
        inmovilIzquierda = new GifImage(inmGif);
        movimientoDerecha = new GifImage(movGif);
        movimientoIzquierda= new GifImage(movGif);
    }
    
    /**
     * Metodo para cambiar los gifs de los soldados
     */
    public void setGifs(String atkI, String atkD, String movI, String movD, String inmI, String inmD)
    {
        ataqueImgD= new GifImage(atkD);
        ataqueImgI= new GifImage(atkI);
        inmovilDerecha = new GifImage(inmD);
        inmovilIzquierda = new GifImage(inmI);
        movimientoDerecha = new GifImage(movD);
        movimientoIzquierda= new GifImage(movI);
    }
    
    /**
     * Este metodo es para la BAS. Cambia todos los stats del personaje y deja en 0 el ataque. En cambio aumenta la defensa, la vida, y el aguante.
     */
    public void cambiaStats()
    {
        def += atk*(nivel+2);
        aguante += atk*(nivel+1);
        vida+= atk*(nivel);
        atk=0;
    }
    
    /**
     * Regresa la direccion
     * @return direccion - Entero que va de -1 a 1.
     */
    public int getDireccion()
    {
        return direccion;
    }
    
    /**
     * Coloca la direccion
     * @param dir- NUevo valor para la direccion. Debe ser -1 o 1.
     */
    public void setDireccion(int dir)
    {
        direccion=dir;
    }
    
    /**
     * Resetea los valores del personaje
     */
    public void reset()
    {
        vida=maxVida;
        aguante=maxAguante;
        añadido=false;
    }
    
    /**
     * Regresa la defensa de este personaje.
     * @return def- Variable flotante que representa la cantidad de daño en la que se va a reducir el daño.
     */
    public float getDef()
    {
        return def;
    }
    
    /**
     * regresa el aguante del personaje
     * @return aguante- Flotante que representa cuanto puede aguantar antes de que empieze a sufrir en vida
     */
    public float getAguante()
    {
        return aguante;
    }
    
    /**
     * Se pasan las caracteristicas del personaje a un String en el Siguiente Orden:
     * Nombre, Nivel, Ataque, Defensa, Vida Maxima y Aguante Maximo, todos separados con espacios.
     * @override toString
     */
    public String toString()
    {
        return nombre+ " " + nivel + " " + atk + " " + def + " " + maxVida + " " + maxAguante;
    }
    
    /**
     * Regresa una variable booleana que es la que indica si los contadores de aguante y vida ya se añadieron al mundo.
     * @return añadido-Varible de control sobre los contadores de aguante y vida
     */
    public boolean getAñadido()
    {
        return añadido;
    }
    
    /**
     * Modifica la variable añadido (bandera para saber si aun no se añaden los contadores al mundo)
     * @param cambio- varibable booleana con la que se va a cambiar la bandera de añadido
     */
    public void setAñadido(boolean cambio)
    {
        añadido=cambio;
    }
    
    /**
     * Este metodo regresa la bandera que indica si se encuentra completando la animacion de ataque
     */
    public boolean getInAtk()
    {
        return inAtk;
    }
    
    /**
     * Modifica la varible que indica si esta en ataque
     */
    public void setInAtk(boolean nuevo)
    {
        inAtk = nuevo;
    }
}
