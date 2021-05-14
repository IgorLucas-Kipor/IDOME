/**
 * This class creates a movie file. Information about said item can
 * be stored and retrieve.
 * 
 * @author Igor Lucas and Guilherme Matos.
 * @version 0.8
 */
public class Movie extends VideoMedia
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private double boxOffice;

    /**
     * Constructor for objects of class movie.
     * @param theTitle The title of this movie.
     * @param theDirector The director of this movie.
     * @param time The running time of this movie.
     * @param boxOffice The amount of money this movie made in box office.
     */
    public Movie(String theTitle, String theDirector, int time, double boxOffice)
    {
        super(theTitle, theDirector, time);
        this.boxOffice = boxOffice;
    }

    /**
     * @return the movie's amount made in box office.
     */
    public double getBoxOffice()
    {
        return boxOffice;
    }

    /**
     * @return details of this movie.
     */
    public String toString() {
        boolean aux = getComment() != null;
        StringBuilder message = new StringBuilder();
        message.append(super.toString())
        .append(System.lineSeparator())
        .append("Box Office: ")
        .append(boxOffice)
        .append(System.lineSeparator())
        .append(System.lineSeparator())
        .append("Comment: ");
        if (aux) {
            message.append(getComment());
        } else {
            message.append("<no comment>");
        }
        message.append(System.lineSeparator());
        return message.toString();
    }
}
