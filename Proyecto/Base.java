import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Base here.
 * 
 * @author Daniel Wong 
 * @version 0.1
 */
public class Base extends Personaje
{
    private GreenfootImage base100;
    private GreenfootImage base90;
    private GreenfootImage base70;
    private GreenfootImage base50;
    private GreenfootImage base20;
    private GreenfootImage base00;
    private int anterior;
    public Base(int niv)
    {
        super(niv, true, null, null, null, null, null , null);
        base100= new GreenfootImage("Base 100.png");
        base90= new GreenfootImage("Base 90.png");
        base70= new GreenfootImage("Base 70.png");
        base50= new GreenfootImage("Base 50.png");
        base20= new GreenfootImage("Base 20.png");
        base00= new GreenfootImage("Base 00.png");
        cambiaStats();
        setImage(base100);
        anterior= getMaxVida();
    }
    
    /**
     * Act - do whatever the Base wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(!getAñadido())
        {
            añadeConts(200, 150);
        }
        
        if(getVida() != anterior)
        {
            actualizaImg();
            anterior=getVida();
        }
    }  
    
    /**
     * Este metodo solo actualiza la imagen de la base sugun su vida
     */
    private void actualizaImg()
    {
        if(getVida() == 0)
        {
            setImage(base00);
        }
        else
        {
            if(getVida() <=getMaxVida()*.20)
            {
                setImage(base20);
            }
            else
            {
                if(getVida() <= getMaxVida()*.50)
                {
                    setImage(base50);
                }
                else
                {
                    if(getVida() <= getMaxVida()*.70)
                    {
                        setImage(base70);
                    }
                    else
                    {
                        if(getVida() <= getMaxVida()*.90)
                        {
                            setImage(base90);
                        }
                        else
                        {
                            if(getVida() == getMaxVida()*1)
                            {
                                setImage(base100);
                            }
                        }
                    }
                }
            }
        }
    }
    
}
