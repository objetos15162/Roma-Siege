import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta clase se dedica a atrapar los botones que el usuario presiona mientras que pone en pantalla un imagen
 * donde se tienen las instrucciones sobre el control de los personajes.
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
     * Act - do whatever the Ayuda wants to do. TEste metodo detecta que tecla se presiono por el usuario, y hace algo
     * dependiendo de cual se presiono.
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
