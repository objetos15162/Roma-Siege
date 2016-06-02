import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta clase tiene como responsabilidad llevar el control sobre 
 * 
 * @author Daniel Wong 
 * @version 3.1
 */
public class MenuInicio extends World
{
   private BotonNuevo nuevo;
   //private BotonCargar cargar;
   private BotonAyuda ayuda;
   private BotonSalir salir;
   private BotonGuardar guardar;
   private BotonJugar jugar;
   private BotonTienda tienda;
   
   private int opcion;
   private int activacion;
   
    /**
     * Constructor for objects of class MenuInicio.
     * 
     */
    public MenuInicio(int escenarioAct)
    {    
        super(640, 480, 1); 
        activacion=escenarioAct;
        if(escenarioAct==0)
        {
            nuevo  = new BotonNuevo();
            //cargar = new BotonCargar();
            ayuda  = new BotonAyuda();
            salir  = new BotonSalir();
            opcion = 1;
            cambiaImagen(true);
        
            addObject(nuevo,  320, 185);
            //addObject(cargar, 465, 185);
            addObject(ayuda,  165, 305);
            addObject(salir,  465, 305);
        }
        else
        {
            jugar = new BotonJugar();
            guardar = new BotonGuardar();
            tienda = new BotonTienda();
            salir = new BotonSalir();
            
            opcion=1;
            addObject(jugar,  165, 185);
            addObject(guardar, 465, 185);
            addObject(tienda,  165, 305);
            addObject(salir,  465, 305);
        }
    }
    
    /**
     * LLEVA CONTROL TOTAL POR TECLADO DE LOS BOTONES DE ALGUNO DE LOS MUNDOS.
     * SE ACTUALIZA CADA BOTON SI ES SELECCIONADO POR EL PUNTERO.
     */
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
                    switch(activacion)
                    {
                        case 0:
                            switch(opcion)
                            { 
                                case 1: 
                                    nuevo.llamaNuevoEscenario();
                                    break;
                            
                                case 2:
                                    //cargar.llamaNuevoEscenario();
                                    break;
                            
                                case 3:
                                    ayuda.llamaNuevoEscenario();
                                    break;
                            
                                case 4:
                                    salir.llamaNuevoEscenario();
                                    break;
                            }
                            break;
                        
                        case 1:
                            switch(opcion)
                            {
                                case 1:
                                    jugar.llamaNuevoEscenario();
                                    break;
                                case 2:
                                    guardar.llamaNuevoEscenario();
                                    break;
                                case 3:
                                    tienda.llamaNuevoEscenario();
                                    break;
                                case 4:
                                    salir.llamaNuevoEscenario();
                                    break;
                            }
                            break;
                }
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
        switch(activacion)
        {
            case 0:
                switch(opcion)
                {
                    case 1: 
                        nuevo.cambia(actividad);
                        break;
                    case 2:
                        //cargar.cambia(actividad);
                        break;
                    case 3:
                        ayuda.cambia(actividad);
                        break;
                    case 4:
                        salir.cambia(actividad);
                        break;
                }
                break;
            case 1:
                switch(opcion)
                {
                    case 1: 
                        jugar.cambia(actividad);
                        break;
                    case 2:
                        guardar.cambia(actividad);
                        break;
                    case 3:
                        tienda.cambia(actividad);
                        break;
                    case 4:
                        salir.cambia(actividad);
                        break;
                }
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
