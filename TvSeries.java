/**
 * This class creates a tv series file. Information about said item can
 * be stored and retrieve.
 * 
 * @author Igor Lucas and Guilherme Matos.
 * @version 0.8
 */
public class TvSeries extends VideoMedia
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private int numberOfSeasons;

    /**
     * Constructor for objects of class tv series.
     * @param theTitle The title of this tv series.
     * @param theDirector The director of this tv series.
     * @param time The running time of this tv series.
     * @param seasons The number of seasons this tv series has.
     */
    public TvSeries(String theTitle, String theDirector, int time, int seasons)
    {
        super(theTitle, theDirector, time);
        numberOfSeasons = seasons;
    }

    /**
     * @return the number of seasons this tv series has.
     */
    public int getNumberOfSeasons()
    {
        return numberOfSeasons;
    }

    /**
     * @return details of this tv series.
     */
    public String toString() {
        boolean aux = getComment() != null;
        StringBuilder message = new StringBuilder();
        message.append(super.toString())
        .append(System.lineSeparator())
        .append("Number of seasons: ")
        .append(numberOfSeasons)
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
