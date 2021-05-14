import java.util.ArrayList;

/**
 * The database class provides a facility to store audio and media files.
 * The details of these files can be collected and printed in a interface or
 * terminal, as the user desires.
 * 
 * 
 * @author Igor Lucas and Guilherme Matos.
 * @version 0.8
 */
public class Database
{
    private ArrayList<Item> items;

    /**
     * Construct an empty Database.
     */
    public Database()
    {
        items = new ArrayList<Item>();
    }

    /**
     * @return the list of added items.
     */
    public ArrayList<Item> getItems() {
        return items;   
    }

    /**
     * Add an item to the database.
     * @param theItem The item to be added.
     */
    public void addItem(Item theItem)
    {
        items.add(theItem);
    }

    /**
     * Removes a item from the database.
     * @params theItem The item to be removed.
     */
    public void removeItem(Item theItem) {
        items.remove(theItem);  
    }

    /**
     * @return a list of all added items in string format.
     */
    public String list()
    {
        StringBuilder print = new StringBuilder();
        for(Item item : items)

        {
            print.append(item);
            print.append(System.lineSeparator());
        }
        return print.toString();
    }

}
