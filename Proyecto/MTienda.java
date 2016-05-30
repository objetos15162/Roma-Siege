import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class MTienda here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MTienda extends World
{
    Principal principal;
    
    private int precioAtk;
    private int precioDef;
    private int precioVida;
    private int precioAguante;
    
    private BotonAguante aguante;
    private BotonAtk ataque;
    private BotonSalud salud;
    private BotonDef defensa;
    
    private int contador;
    /**
     * Constructor for objects of class MTienda.
     * 
     */
    public MTienda()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(640, 480, 1);
        precioAtk = 200;
        precioDef = 200;
        precioVida = 300;
        precioAguante = 400;
        
        aguante = new BotonAguante();
        ataque = new BotonAtk();
        salud = new BotonSalud();
        defensa = new BotonDef();
        
        addObject(aguante, 500, 80);
        addObject(ataque, 500, 190);
        addObject(salud, 500, 300);
        addObject(defensa, 500, 410);
        contador=0;
    }
    
    public void act()
    {
        String key = Greenfoot.getKey();
        if(key != null)
        {
            if(key == "escape" || key == "enter")
            {                
                principal.tienda=this;
                Greenfoot.setWorld(principal);
            }
        }
        
        if(contador >= 50)
        {
            List <Label> lista = getObjects(Label.class);
            if(lista != null)
            {
               for(Label l : lista)
               {
                   removeObject(l);
               }
            }
            contador = 0;
            Label mensaje = new Label(" Bienvenido Guerrero, \n ¿Que te Gustaria Entrenar?", 24);
            Label precAtk = new Label(precioAtk+" Monedas", 24);
            Label precAgu = new Label(precioAguante + " Monedas", 24);
            Label precDef = new Label(precioDef + " Monedas", 24);
            Label precVid = new Label(precioVida + " Monedas", 24);
            addObject(precAtk,ataque.getX()-120, ataque.getY());
            addObject(precAgu,aguante.getX()-120, aguante.getY());
            addObject(precDef,defensa.getX()-120, defensa.getY());
            addObject(precVid,salud.getX()-120, salud.getY());
        }
        else
        {
            contador++;
        }
    }
    
    /**
     * Este metodo da valor a la variable mundo... ... curiosamente
     * @param auxiliar- Es el mundo principal al cual se va a regresar.
     */
    public void setMundo(Principal auxiliar)
    {
        principal=auxiliar;
    }
    
    
    public void compraAtk()
    {
        if(precioAtk <= principal.hero.getOro())
        {
            principal.hero.setOro(precioAtk);
            precioAtk = (int) (precioAtk * 1.2);
            principal.hero.setAtk();
            Label exito = new Label("¡Buen entrenamiento! pareces mas fuerte", 28);
            addObject(exito, 100, 400);
        }
        else
        {
            Label error = new Label("No tienes suficiente con que pagar\n Tienes: "+principal.hero.getOro(), 20);
            addObject(error, 100, 50);
        }
        contador = 0;
    }
    
    public void compraDef()
    {
        if(precioDef <= principal.hero.getOro())
        {
            principal.hero.setOro(precioDef);
            precioDef = (int) (precioDef * 1.2);
            principal.hero.setDef();
            Label exito = new Label("¡Buen entrenamiento! pareces mas fuerte", 28);
            addObject(exito, 100, 400);
        }
        else
        {
            Label error = new Label("No tienes suficiente con que pagar\n Tienes: "+principal.hero.getOro(), 20);
            addObject(error, 100, 50);
        }
        contador = 0;
    }
    
    public void compraVida()
    {
         if(precioVida <= principal.hero.getOro())
        {
            principal.hero.setOro(precioVida);
            precioVida = (int) (precioVida*1.2);
            principal.hero.setVida();
            Label exito = new Label("¡Buen entrenamiento! pareces mas fuerte", 28);
            addObject(exito, 100, 400);
        }
        else
        {
            Label error = new Label("No tienes suficiente con que pagar\n Tienes: "+principal.hero.getOro(), 20);
            addObject(error, 100, 50);
            
        }
        contador = 0;
    }
    
    public void compraAguante()
    {
         if(precioAguante <= principal.hero.getOro())
        {
            principal.hero.setOro(precioAguante);
            precioAguante = (int) (precioAguante * 1.2);
            principal.hero.setAguante();
            Label exito = new Label("¡Buen entrenamiento! pareces mas fuerte", 28);
            addObject(exito, 100, 400);
            
        }
        else
        {
            Label error = new Label("No tienes suficiente con que pagar\n Tienes: "+principal.hero.getOro(), 20);
            addObject(error, 100, 50);
            
        }
        contador = 0;
    }
}
