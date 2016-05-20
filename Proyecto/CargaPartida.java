import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta clase se encargara de leer los archivos de un heroe guardado anteriomente. Si no existe alguno creara una nueva partida.
 * Luego de leerlos pasara a un mundo Principal.
 * 
 * @author Daniel Wong 
 * @version 0.1
 */
public class CargaPartida extends World
{

    /**
     * Constructor for objects of class CargaPartida.
     * 
     */
    public CargaPartida()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(640, 480, 1); 
        //Aqui se supone que debe cargar 2 archivos y pasar los datos a la pantalla en un cuadro de texto donde tenga los datos de la partida
    }
    
    
    /**
     * En este metodo se estara controlano que archivo se escogio para cargar
     */
    public void act()
    {
        ; //Aqui solo cuida cual de los dos dialogos de texto se le dio click para cargar los datos   
    }
    /*
     * File
     * BufferedReader(Filereader) --> .readLine()
     * Filereader(File)
     * FileWriter(String nombre, bool ) -- si es true se escribe --> .close() para cerrar el archivo  <--- en un try/catch
     * PrintWriter(FileWriter)
     */
}
