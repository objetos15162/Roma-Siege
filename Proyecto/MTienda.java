import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * La clase tienda comprende 4 tipos de botones. Los cuales controla. Para salir de esta clase Tienes que presionar esc o enter.
 * 
 * @author Daniel Wong 
 * @version 2.1
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
     * Constructor for objects of class MTienda. Otorga valores iniciales predefinidos.
     * Solo se llama cuando se genera una nueva partida.
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
    
    /**
     * Controla tanto el teclado como de actualizar los precios de pantalla
     */
    public void act()
    {
        String key = Greenfoot.getKey();
        if(key != null)
        {
            if(key == "escape" || key == "enter")
            {                
                principal.setTienda(this);
                Greenfoot.setWorld(principal);
            }
        }
        
        if(contador >= 500)
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
            Label mensaje = new Label(" Bienvenido Guerrero, \n ¿Que te Gustaria Entrenar?", 30);
            Label precAtk = new Label(precioAtk+" Monedas", 24);
            Label precAgu = new Label(precioAguante + " Monedas", 24);
            Label precDef = new Label(precioDef + " Monedas", 24);
            Label precVid = new Label(precioVida + " Monedas", 24);
            addObject(new Label("Para salir presiona 'ESC' ó 'ENTER'", 30), 580, 100);
            addObject(mensaje, 200, 400);
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
    
    /**
     * Hace los calculos para mejorar el ataque y reducir el oro
     */
    public void compraAtk()
    {
        if(precioAtk <= principal.getHero().getOro())
        {
            principal.getHero().setOro(precioAtk);
            precioAtk = (int) (precioAtk * 1.2);
            principal.getHero().setAtk();
            Label exito = new Label("¡Buen entrenamiento! pareces mas fuerte", 28);
            addObject(exito, 100, 400);
        }
        else
        {
            Label error = new Label("No tienes suficiente con que pagar\n Tienes: "+ principal.getHero().getOro(), 20);
            addObject(error, 100, 50);
        }
        contador = 0;
    }
    
    /**
     * Hace los calculos para mejorar la defensa y reducir el oro
     */
    public void compraDef()
    {
        if(precioDef <= principal.getHero().getOro())
        {
            principal.getHero().setOro(precioDef);
            precioDef = (int) (precioDef * 1.2);
            principal.getHero().setDef();
            Label exito = new Label("¡Buen entrenamiento! pareces mas fuerte", 28);
            addObject(exito, 100, 400);
        }
        else
        {
            Label error = new Label("No tienes suficiente con que pagar\n Tienes: "+ principal.getHero().getOro(), 20);
            addObject(error, 100, 50);
        }
        contador = 0;
    }
    
    
    /**
     * Hace los calculos para mejorar la vida y reducir el oro
     */
    public void compraVida()
    {
         if(precioVida <= principal.getHero().getOro())
        {
            principal.getHero().setOro(precioVida);
            precioVida = (int) (precioVida*1.2);
            principal.getHero().setVida();
            Label exito = new Label("¡Buen entrenamiento! pareces mas fuerte", 28);
            addObject(exito, 100, 400);
        }
        else
        {
            Label error = new Label("No tienes suficiente con que pagar\n Tienes: "+ principal.getHero().getOro(), 20);
            addObject(error, 100, 50);
            
        }
        contador = 0;
    }
    
    /**
     * Hace los calculos para mejorar el aguante y reducir el oro
     */
    public void compraAguante()
    {
         if(precioAguante <= principal.getHero().getOro())
        {
            principal.getHero().setOro(precioAguante);
            precioAguante = (int) (precioAguante * 1.2);
            principal.getHero().setAguante();
            Label exito = new Label("¡Buen entrenamiento! pareces mas fuerte", 28);
            addObject(exito, 100, 400);
            
        }
        else
        {
            Label error = new Label("No tienes suficiente con que pagar\n Tienes: "+ principal.getHero().getOro(), 20);
            addObject(error, 100, 50);
            
        }
        contador = 0;
    }
}
