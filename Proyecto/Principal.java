import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * ESTA CLSE ES LA ENCARGADA DE MANEJAR LOS ENTORNOS DE JUEGO, ASI COMO DE ACCEDER A LAS OPCIONES DE MENU Y GUARDAR LOS DATOS.
 * COMO SU NOMBRE LO INDICA, ES LA CLASE PRINCIPAL DEL PROGRAMA.
 * 
 * @author Daniel Wong
 * @version 2.1
 */
public class Principal extends MenuInicio
{
    private Heroe hero;
    private Barco barco;
    private Catapulta catapulta;
    private MTienda tienda;
    private int oroAcumulado;
    private boolean impresion;
    /**
     * Constructor for objects of class Principio.
     * 
     */
    public Principal(Heroe actor, Barco balsa, Catapulta lanzador, MTienda tendedero)
    {
        super(1);
        hero = actor;
        barco = balsa;
        catapulta = lanzador;
        tienda = tendedero;
        oroAcumulado=0;
        tienda.setMundo(this);
        impresion=false;
        reset();
    }
    
    /**Solo se asegura de que se impriman los datos del jugador
     * 
     */
    public void act()
    {
        super.act();
        if(!impresion)
        {
            reset();
            eliminaImpresiones();
            imprime();
            impresion=true;
        }
    }
    
    /**
     * Este metodo imprimira los datos del Jugador
     */
    public void imprime()
    {
        addObject(new Label("Nombre: "+ hero.getName()+ "   Nv."+ hero.getnivel() + "\n Ataque: "+hero.getAtk()+"   Defensa: "+ hero.getDef()+ "\n Vida Max. :" + hero.getVida()+ "   Aguante: " + hero.getAguante() , 25), 250, 75);
    }
    
    
    /**
     * Este Metodo resetea los valores de los personajes principales.
     */
    public void reset()
    {
        hero.reset();
        barco.reset();
        catapulta.reset();
    }
    
    /**
     * EN ESTE METODO SE MANDA A LLAMAR PARA INICIAR UNA PARTIDA
     */
    public void iniciarPartida()
    {
        Greenfoot.setWorld(new Mar(this));
        impresion=false;
    }
    
    /**
     * Variable que regresa un objeto de la clase Barco
     * @return Barco- Barco del usuario.
     */
    public Barco getBarco()
    {
        return barco;
    }
    
    /**
     * Variable que regresa un objeto de la clase Heroe
     * @return hero- Barco del usuario.
     */
    public Heroe getHero()
    {
        return hero;
    }
    
    /**
     * Variable que regresa un objeto de la clase Catapulta
     * @return catapulta- catapulta del usuario.
     */
    public Catapulta getCatapulta()
    {
        return catapulta;
    }
    
    /**
     * Metodo que regresa un objeto de la clase MTienda
     * @return tienda- Tienda que esta a la disposicion del usuario.
     */
    public MTienda getTienda()
    {
        return tienda;
    }
    
    /**
     * Metodo que cambia un objeto de la clase MTienda por otro igual
     * @return tienda- Tienda que esta a la disposicion del usuario.
     */
    public void setTienda(MTienda nuevo)
    {
        tienda=nuevo;
        impresion = false;
    }
    
    /**
     * Este metodo modifica el oro acumulado. Solo se modifica mediante 
     * los distintos mundos, y solo bajo circunstancias especiales.
     */
    public void setOroAcumulado(int cantidad)
    {
        oroAcumulado+=cantidad;
    }
    
    /**
     * Este metodo regresa el oro acumulado hasta el momento
     */
    public int getOroAcumulado()
    {
        return oroAcumulado;
    }
    
    /**
     * Este metodo elimina todo el texto en el mundo
     */
    public void eliminaImpresiones()
    {
        List<Label> txt = getObjects(Label.class);
        if(txt != null)
        {
            for(Label l: txt)
            {
                removeObject(l);
            }
        }
    }
    
    /**
     * Este metodo recibe un barco, el cualsera el reemplazo de el barco de este objeto
     * @param barc- Objeto barco con nuevas caracteristicas.
     */
    public void setBarco(Barco barc)
    {
        barco=barc;
    }
}
