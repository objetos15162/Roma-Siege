import greenfoot.*;

/**
 * A surface for the main actor to gravitate toward.
 */
public class Ground extends Actor
{
    /**
     * Creates a long platform for the main actor.
     */
    public Ground(String esn)
    {
        GreenfootImage road = new GreenfootImage(esn);
        GreenfootImage image = new GreenfootImage(road.getWidth(), road.getHeight());
        int w=road.getWidth();
        for(int offset=0; offset<road.getWidth(); offset+=w) image.drawImage(road, offset, 0);
        setImage(image);
    }
}
