/**
 * The CD class represents a CD object. Information about the 
 * CD is stored and can be retrieved.
 * 
 * @author Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */
public class AudioMedia extends Item
{
    private String artist;
    private int numberOfTracks;

    /**
     * Initialize the CD.
     * @param theTitle The title of the CD.
     * @param theArtist The artist of the CD.
     * @param tracks The number of tracks on the CD.
     * @param time The playing time of the CD.
     */
    public AudioMedia(String theTitle, String theArtist, int time, int tracks)
    {
        super(theTitle, time);
        artist = theArtist;
        numberOfTracks = tracks;
    }

    /**
     * @return The artist for this CD.
     */
    public String getArtist()
    {
        return artist;
    }

    /**
     * @return The number of tracks on this CD.
     */
    public int getNumberOfTracks()
    {
        return numberOfTracks;
    }

    /**
     * Print details of this CD to the text terminal.
     */
    public String toString() {
    boolean aux = getComment() != null;
    StringBuilder message = new StringBuilder();
    message.append(super.toString())
    .append(System.lineSeparator())
    .append("Artist: ")
    .append(artist)
    .append(System.lineSeparator())
    .append("Number of tracks: ")
    .append(numberOfTracks)
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
