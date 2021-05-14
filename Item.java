/**
 * This class serves as base for all items. No items of this class
 * can be instantiated since it's an abstract class.
 * 
 * @author Igor Lucas and Guilherme Matos.
 * @version 0.8
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
    protected Item(String theTitle, int time)
    {
        title = theTitle;
        playingTime = time;
        comment = null;
    }

    /**
     * @return the item title.
     */
    protected String getTitle() {
        return title;   
    }

    /**
     * Set's a comment for this item.
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
     * @return details of this item.
     */

    public String toString() {
        return title + System.lineSeparator() + "Total duration: "
        + playingTime + " minutes";  
    }
}
