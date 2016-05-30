import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Catapulta here.
 * 
 * @author Daniel Wong
 * @version 0.1
 */
public class Catapulta extends Personaje
{
    
    public Catapulta(int niv)
    {
        super(niv, false, "Catapulta InmovilD.gif", "Catapulta InmovilD.gif", "Catapulta MovimientoD.gif", "Catapulta MovimientoD.gif", "Catapulta AtaqueD.gif", "Catapulta AtaqueD.gif");
    } 
    
    public void act()
    {
        if(!añadido)
        {
            añadeConts();
            añadido=true;
        }
        
        if(!inAtk)
            {
                String key = Greenfoot.getKey();
                if(key != null)
                {
                    key.toLowerCase();
                    switch(key)
                    {
                        case "d":
                            mover(10);
                            break;
                        case "a":
                            mover(-10);
                            break;
                        case "n":
                            inAtk=true;
                            break;
                    }
                }
                else
                {
                    mover(0);
                }
            }
            else
            {
                completeAtk();
            }
    }
    
    /**
     * Este metodo es invocado justo cuando se esta en proceso un ataque;
     */
    private void completeAtk()
    {
        inAtk=atacar(1);
        if(!inAtk)
        {
            int dir=1;
            Bala nueva = new Bala(dir, (int)(getAtk()*2), (int)(getAtk()*3), (int)getAtk(), this);
            getWorld().addObject(nueva, this.getX()+80, this.getY()-60);
        }
    }
}
