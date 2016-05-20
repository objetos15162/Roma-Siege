import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boton here.
 * 
 * @author Daniel Wong 
 * @version 2.0
 */
public abstract class Boton extends Actor
{
    private boolean bandera;
    private String activo;
    private String inactivo;
    private int numero;
    /**
     * Este es el Constructor. Inicializa las varibles de instancia del objeto.
     * 
     * @param act Es una cadena en la que contiene el nobre de la imagen cuando esta "encendida".
     * @param ina Es una cadena con el nombre de la imagen del objeto cuando esta "Apagado".
     * @param num Es una varible de tipo entero la cual representa que tipo de Boton es.
     */
    public  Boton(String act, String ina, int num)
    {
        activo=act;
        inactivo=ina;
        bandera=false;
        numero=num;
    }
    
    /**
     * Este metodo contiene las instrucciones con las que actuara cada boton. Primero verifica si el usuario 
     * a pasado el puntero por el objeto, y de ser asi, cambia la opcion del mundo a la del objeto y luego cambia 
     * la imagen de este objeto por la imagen en la que esta "encendido". Y si se da click sobre este objeto se manda
     * a llamar un nuevo escenario.
     */
    public void act()
    {
        if(Greenfoot.mouseMoved(this) && !bandera)
        {
            MenuInicio world=(MenuInicio)getWorld();
            world.cambiaOpc(numero);
            cambia(true);
        }
        
        if(Greenfoot.mouseClicked(this))
        {
            llamaNuevoEscenario();
        }
    }
    
    /**
     *  Con este Metodo se cambia la imagen que se muestra.
     *  
     *  @param auxiliar Esta variable booleana indica si se quiere "apagar" o "encender" la imagen
     */
    public void cambia(boolean auxiliar)
    {
        if(!bandera && auxiliar)
        {
            bandera=true;
            setImage(activo);
            //Greenfoot.playSound("Push");
        }
        else
        {
            if(bandera && !auxiliar)
            {
                bandera=false;
                setImage(inactivo);
            }
        }
    }
    
    /**
     * Este metodo es un get para las bandera del boton.
     * 
     * @return bandera Regresa una varible booleana que indica que imagen esta actualmente activa del boton
     */
    public boolean getBandera()
    {
        return bandera;
    }
    /**
     * Este metodo abstracto permite poder invocar a las diferentes acciones e las subclases.
     */
    public abstract void llamaNuevoEscenario();
}
