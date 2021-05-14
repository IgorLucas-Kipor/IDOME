/**
 * This class creates a audio media file. Information about said item can
 * be stored and retrieve.
 * 
 * @author Igor Lucas and Guilherme Matos.
 * @version 0.8
 */
public class AudioMedia extends Item
{
    private String artist;
    private int numberOfTracks;

    /**
     * Initialize the Audio Media.
     * @param theTitle The title of the Audio Media.
     * @param theArtist The artist of the Audio Media.
     * @param tracks The number of tracks on the Audio Media.
     * @param time The playing time of the Audio Media.
     */
    public AudioMedia(String theTitle, String theArtist, int time, int tracks)
    {
        super(theTitle, time);
        artist = theArtist;
        numberOfTracks = tracks;
    }

    /**
     * @return The artist for this Audio Media.
     */
    public String getArtist()
    {
        return artist;
    }

    /**
     * @return The number of tracks on this Audio Media.
     */
    public int getNumberOfTracks()
    {
        return numberOfTracks;
    }

    /**
     * @return a string with details of this Audio Media.
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
