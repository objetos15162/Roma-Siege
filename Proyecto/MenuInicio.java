import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta clase tiene como responsabilidad llevar el control sobre 
 * 
 * @author Daniel Wong 
 * @version 3.1
 */
public class MenuInicio extends World
{
   BotonNuevo nuevo;
   BotonCargar cargar;
   BotonAyuda ayuda;
   BotonSalir salir;
   private int opcion;
   
    /**
     * Constructor for objects of class MenuInicio.
     * 
     */
    public MenuInicio()
    {    
        super(640, 480, 1); 
        
        nuevo  = new BotonNuevo();
        cargar = new BotonCargar();
        ayuda  = new BotonAyuda();
        salir  = new BotonSalir();
        opcion = 1;
        cambiaImagen(true);
        
        addObject(nuevo,  165, 185);
        addObject(cargar, 465, 185);
        addObject(ayuda,  165, 305);
        addObject(salir,  465, 305);
    }
    
    public void act()
    {
        String key = Greenfoot.getKey();
        if(key != null)
        {
            switch(key)
            {
                case "w": case "W": case "up": case "s": case "S": case "down":
                    cambiaImagen(false);
                    if(opcion>=3)
                    {
                        opcion = opcion - 2;
                    }
                    else
                    {
                        if(opcion <= 2)
                        {
                            opcion = opcion + 2;
                        }
                    }
                    cambiaImagen(true);
                    break;
                case "a": case "A": case "left": case "d": case "D": case "right":
                    cambiaImagen(false);
                    if(opcion == 1 || opcion == 3)
                    {
                        opcion ++;
                    }
                    else
                    {
                        if(opcion == 2 || opcion == 4)
                        {
                            opcion --;
                        }
                    }
                    cambiaImagen(true);
                    break;
                    
                case "enter":
                    switch(opcion)
                    {
                        case 1: 
                            nuevo.llamaNuevoEscenario();
                            break;
                            
                        case 2:
                            cargar.llamaNuevoEscenario();
                            break;
                            
                        case 3:
                            ayuda.llamaNuevoEscenario();
                            break;
                            
                        case 4:
                            salir.llamaNuevoEscenario();
                            break;
                    }
                    break;
            }
        }
    }
    
    /**
     *  Con este metodo se manda a cambiar la imagen de cada boton
     *  
     *  @param actividad Esta variable indica si la imagen del boton va a pasar a activo ó a no activo
     */
    private void cambiaImagen(boolean actividad)
    {
        switch(opcion)
        {
            case 1: 
                nuevo.cambia(actividad);
                break;
            case 2:
                cargar.cambia(actividad);
                break;
            case 3:
                ayuda.cambia(actividad);
                break;
            case 4:
                salir.cambia(actividad);
                break;
        }
    }
    
    /**
     * Con este metodo se modifica la opcion del escenario
     * 
     * @param   nuevo La opcion por la que se va a cambiar
     */
    public void cambiaOpc(int nuevo)
    {
        if(nuevo != opcion)
        {
            cambiaImagen(false);
            opcion=nuevo;
            cambiaImagen(true);
        }
    }
}
