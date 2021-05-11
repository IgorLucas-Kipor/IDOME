/**
 * The Item class represents a multi-media item.
 * Information about the item is stored and can be retrieved.
 * This class serves as a superclass for more specific itms.
 * 
 * @author Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */
public abstract class Item
{
    private String title;
    private int playingTime;
    private String comment;

    /**
     * Initialise the fields of the item.
     * @param theTitle The title of this item.
     * @param time The running time of this item.
     */
    public Item(String theTitle, int time)
    {
        title = theTitle;
        playingTime = time;
        comment = null;
    }
    
    public String getTitle() {
        return title;   
    }

    /**
     * Enter a comment for this item.
     * @param comment The comment to be entered.
     */
    protected void setComment(String comment)
    {
        this.comment = comment;
    }

    /**
     * @return The comment for this item.
     */
    protected String getComment()
    {
        return comment;
    }


    /**
     * Print details of this item to the text terminal.
     */
    
    public String toString() {
        return title + System.lineSeparator() + "Total duration: "
        + playingTime + " minutes";  
    }
}
