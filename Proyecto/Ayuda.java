import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ayuda here.
 * 
 * @author Daniel Wong 
 * @version 1.3
 */
public class Ayuda extends Actor
{
    private String imagen1;
    private String imagen2;
    private String imagen3;
    private int num;
    
    /**
     * Este es el constructor de la clase Ayuda. Solo inicia las tres cadenas con
     * el nombre de las imagenes que necesita.
     */
    public Ayuda()
    {
        imagen1= "Ayuda 1.png";
        imagen2= "Ayuda 2.png";
        imagen3= "Ayuda 3.png";
        num=1;
        
    }
    
    /**
     * Act - do whatever the Ayuda wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        String tecla;
        tecla=Greenfoot.getKey();
        if(num!=0)
        {
            if(tecla!=null)
            {
                switch(tecla)
                {
                    case "D": case "d":
                        if(num+1<=3)
                        {
                            num++;
                            ponImagen(num);
                        }
                        else
                        {
                            num=1;
                            ponImagen(num);
                        }
                        break;
                    case "a": case "A":
                        if(num-1>=1)
                        {
                            num--;
                            ponImagen(num);
                        }
                        else
                        {
                            num=3;
                            ponImagen(num);
                        }
                        break;
                    case "enter": case "escape":
                        num=0;
                        break;
                }
            }
        }
    }
    
    /**
     * ponImagen - Cambia la imagen del objeto. Recibe un entero que le indica
     * que imagen poner. El entero no tiene que ser superior a tres o inferior a 1.
     * 
     * @param numero Un numero entero que varia de 1 a 3.
     */
    private void ponImagen(int numero)
    {
        if(numero>0 && numero<=3)
        {
            switch(numero)
            {
                case 1: setImage(imagen1);
                        break;
                case 2: setImage(imagen2);
                        break;
                case 3: setImage(imagen3);
                        break;
            }
        }
    }
    
    /**
     * getNum regresa el numero de imagen se esta mostrando.
     * 
     * @return num Un entero que indica que imagen esta presente.
     */
    public int getNum()
    {
        return num;
    }
}
