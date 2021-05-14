/**
 * This class serves as base for all video media files. No items of this class
 * can be instantiated since it's an abstract class.
 * 
 * @author Igor Lucas and Guilherme Matos.
 * @version 0.8
 */
public abstract class VideoMedia extends Item 
{
    private String director;

    /**
     * Constructor for objects of class Video Media.
     * @param theTitle The title of this Video Media.
     * @param theDirector The director of this Video Media.
     * @param time The running time of the main feature.
     */
    public VideoMedia(String theTitle, String theDirector, int time)
    {
        super(theTitle, time);
        director = theDirector;
    }

    /**
     * @return The director for this Video Media.
     */
    public String getDirector()
    {
        return director;
    }

    /**
     * @return details of this Video Media.
     */
    public String toString()
    {
        return super.toString() + System.lineSeparator() + "Director: " + director;
    }
}
