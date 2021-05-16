import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

/**
 * The class viewer create a GUI that allows the user to access a database
 * in a interactive way through the use of buttons.
 * 
 * @author Igor Lucas and Guilherme Matos.
 * @version 0.8
 */
public class Viewer
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private JFrame frame;
    private JLabel label;
    private Database database;
    private JTextArea outputArea;
    private JTextArea inputArea;

    //---------------------------------Main Methods---------------------------

    /**
     * Create an Viewer with an instance of database and shows it on screen.
     */
    public Viewer()
    {
        makeFrame();
        database = new Database();
    }

    /**
     * Create the Swing frame and its content.
     */
    private void makeFrame()
    {
        frame = new JFrame("ImageViewer");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setContentPane(createPanel());

        // building is done - arrange the components and show        
        frame.pack();

        // center the frame on screen
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(d.width/2 - frame.getWidth()/2, d.height/2 - frame.getHeight()/2);
        frame.setVisible(true);
    }

    /**
     * Create the panel used in content pane of the frame.
     * @return the panel to be used.
     */
    private JPanel createPanel() {

        //criando painel
        JPanel panel = new JPanel();

        //definindo layout do painel
        panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        //definindo label
        JLabel label = new JLabel("IDOME - Interactive Database of Multimedia"
                +" Entertainment");

        //criando áreas de input e output
        outputArea = new JTextArea("This is the output area, where "+
            "the results of your commands will be shown.");

        inputArea = new JTextArea(promptText());

        //definindo características das áreas de input e output
        outputArea.setFont(new Font("Serif", Font.PLAIN, 12));
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);

        inputArea.setFont(new Font("Serif", Font.PLAIN, 12));
        inputArea.setLineWrap(true);
        inputArea.setWrapStyleWord(true);

        // Criando as barras de rolagem e adicionando as áreas de texto
        JScrollPane outputScroll = new JScrollPane(outputArea);
        JScrollPane inputScroll = new JScrollPane(inputArea);

        // Fazendo as barras serem verticais
        outputScroll.setVerticalScrollBarPolicy(
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        inputScroll.setVerticalScrollBarPolicy(
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Definindo o tamanho
        outputScroll.setPreferredSize(new Dimension(250, 250));
        inputScroll.setPreferredSize(new Dimension(150, 150));

        // Definindo bordas com títulos
        outputScroll.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createCompoundBorder(
                    BorderFactory.createTitledBorder("Output Box"),
                    BorderFactory.createEmptyBorder(5,5,5,5)),
                outputScroll.getBorder()));

        inputScroll.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createCompoundBorder(
                    BorderFactory.createTitledBorder("Input Box"),
                    BorderFactory.createEmptyBorder(5,5,5,5)),
                inputScroll.getBorder()));

        //criando os botões
        JButton listItem = new JButton("Listar itens");

        JButton addItem = new JButton("Adicionar mídia");

        JButton importFile = new JButton("Importar arquivo");

        JButton saveFile = new JButton("Salvar lista");

        JButton addComment = new JButton("Adicionar comentário");

        JButton removeItem = new JButton("Remover mídia");

        //adicionando os eventos aos botões
        listItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) { list(); }
            });

        addItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) { addItem(); }
            });  

        importFile.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) { importFile(); }
            });

        saveFile.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) { saveFile(); }
            });

        addComment.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) { addComment(); }
            });

        removeItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) { removeItem(); }
            });

        // Alinhando os componentes
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        outputScroll.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputScroll.setAlignmentX(Component.CENTER_ALIGNMENT);
        addItem.setAlignmentX(Component.CENTER_ALIGNMENT);
        listItem.setAlignmentX(Component.CENTER_ALIGNMENT);
        addComment.setAlignmentX(Component.CENTER_ALIGNMENT);
        importFile.setAlignmentX(Component.CENTER_ALIGNMENT);
        saveFile.setAlignmentX(Component.CENTER_ALIGNMENT);
        removeItem.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Adicionando elementos ao painel
        panel.add(label);
        panel.add(Box.createVerticalStrut(10));
        panel.add(outputScroll);
        panel.add(Box.createVerticalStrut(5));
        panel.add(inputScroll);
        panel.add(Box.createVerticalStrut(5));
        panel.add(listItem);
        panel.add(Box.createVerticalStrut(5));
        panel.add(addItem);
        panel.add(Box.createVerticalStrut(5));
        panel.add(addComment);
        panel.add(Box.createVerticalStrut(5));
        panel.add(importFile);
        panel.add(Box.createVerticalStrut(5));
        panel.add(saveFile);
        panel.add(Box.createVerticalStrut(5));
        panel.add(removeItem);
        panel.add(Box.createVerticalStrut(5));

        return panel;
    }

    //--------------------------------Action Event Methods--------------------

    /**
     * Lists all itens in the database list in the output area.
     */
    private void list() {
        String text = database.list();
        if (text.length() > 0) {
            outputArea.setText(text);
        } else {
            outputArea.setText("There are no items in the list.");
        }

        inputArea.setText(promptText());
    }

    /**
     * Adds a item to the database based on the informations in the input area,
     * then informs if succesful or not.
     */
    private void addItem() {
        String text = inputArea.getText();
        String fields[] = text.split(",");
        if (fields[0].toLowerCase().equals("movie")) {
            addMovie(fields);
            outputArea.append("Movie " + fields[1] + " added to the database."
                + System.lineSeparator());
        } else if (fields[0].toLowerCase().equals("tvseries")) {
            addTvSeries(fields);
            outputArea.append("Tv Series " + fields[1] + " added to the database."
                + System.lineSeparator());
        } else if (fields[0].toLowerCase().equals("audiomedia")) {
            addAudioMedia(fields);
            outputArea.append("Audio Media " + fields[1] + " added to the database."
                + System.lineSeparator());
        } else {
            outputArea.setText("Invalid item, please try again.");   
        }
        inputArea.setText(promptText());
    }

    /**
     * Adds items to the database based on a file imported to the application,
     * then prints a message for each successful item, a message for each
     * repeated item and a error message if the IO fails.
     */
    private void importFile() {
        String path = inputArea.getText();
        outputArea.setText(null);
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while(line != null) {
                String fields[] = line.split(",");
                if (fields[0].toLowerCase().equals("movie")) {
                    addMovie(fields);
                }
                else if (fields[0].toLowerCase().equals("tvseries")) {
                    addTvSeries(fields);   
                }
                else if (fields[0].toLowerCase().equals("audiomedia")) {
                    addAudioMedia(fields);   
                }
                line = br.readLine();
            }
            outputArea.setText("Import Successful.");
        } catch (IOException e) {
            outputArea.setText("Error: " + e.getMessage());   
        }
        inputArea.setText(promptText());
    }

    /**
     * Saves a file containing the current list on the database, informing the
     * date in which it was created, in a destination set by the user. Prints
     * a error message if the IO is unsuccessful.
     */
    private void saveFile() {
        String path = inputArea.getText();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            StringBuilder print = new StringBuilder();
            print.append("IDOME list, ");
            Date d = new Date();
            print.append(d)
            .append(System.lineSeparator())
            .append(System.lineSeparator());
            String list = database.list();
            print.append(list);
            bw.write(print.toString());
            outputArea.setText("Save completed!");
            inputArea.setText(promptText());
        } catch (IOException e) {
            outputArea.setText("Error: " + e.getMessage());   
        }
    }

    /**
     * Sets a comment into a item on the database, using the item's title to
     * find it. Prints a message confirming success or informing if the item
     * is not in the database.
     */
    private void addComment() {
        String text = inputArea.getText();
        String fields[] = text.split(",");
        Boolean foundItem = false;
        for (Item i : database.getItems()) {
            if (i.getTitle().toLowerCase().equals(fields[0].toLowerCase())) {
                i.setComment(fields[1]);
                foundItem = true;
            }
        }
        if (foundItem == false) {
            outputArea.setText("Item not in the list, please try again.");   
        } else {
            outputArea.setText("Comment set.");
        }
        inputArea.setText(promptText());
    }

    /**
     * Removes a item from the database, using it's name to find the item.
     * Prints a message confirming success or informing if the item could not
     * be found.
     */
    private void removeItem() {
        String toRemove = inputArea.getText();
        Item toBeRemoved = null;
        Boolean itemRemoved = false;
        for (Item i : database.getItems()) {
            if (i.getTitle().toLowerCase().equals(toRemove.toLowerCase())) {
                toBeRemoved = i;
                itemRemoved = true;
            }
        }
        database.removeItem(toBeRemoved); 
        if (itemRemoved == false) {
            outputArea.setText("No such item was found.");   
        } else {
            outputArea.setText("Media removed.");   
        }
        inputArea.setText(promptText());
    }

    //-------------------------------Support Methods-------------------------

    /**
     * Adds a movie to the database.
     * @params fields[] An array with the information to be added to the movie.
     */
    private void addMovie(String fields[]) {

        StringBuilder repeatedTitles = new StringBuilder();

        Boolean titleExists = verifyTitle(fields, repeatedTitles);

        if (titleExists == false) {
            Movie item = new Movie(fields[1], fields[3],
                    Integer.parseInt(fields[2]), Double.parseDouble(fields[4]));
            database.addItem(item);
        } else {
            outputArea.append(repeatedTitles.toString());
        }
    }

    /**
     * Adds a tv series to the database.
     * @params fields[] An array with the information to be added to the
     * tv series.
     */
    private void addTvSeries(String fields[]) {
        StringBuilder repeatedTitles = new StringBuilder();

        Boolean titleExists = verifyTitle(fields, repeatedTitles);

        if (titleExists == false) {
            TvSeries item = new TvSeries(fields[1], fields[3],
                    Integer.parseInt(fields[2]), Integer.parseInt(fields[4]));
            database.addItem(item);
        } else {
            outputArea.append(repeatedTitles.toString());
        }
    }

    /**
     * Adds a audio media to the database.
     * @params fields[] An array with the information to be added to the
     * audio media.
     */
    private void addAudioMedia(String fields[]) {
        StringBuilder repeatedTitles = new StringBuilder();

        Boolean titleExists = verifyTitle(fields, repeatedTitles);
        if (titleExists == false) {
            AudioMedia item = new AudioMedia(fields[1], fields[3],
                    Integer.parseInt(fields[2]), Integer.parseInt(fields[4]));
            database.addItem(item);
        } else {
            outputArea.append(repeatedTitles.toString());
        }
    }

    /**
     * Checks if a identical title already exists in the database
     * @params fields[] The information of the item trying to be added.
     * @params titles A StringBuilder building the string of repeated itens to
     * be printed in the output area.
     * @return true if there is a repeated title.
     */
    private Boolean verifyTitle(String fields[], StringBuilder titles) {
        Boolean titleExists = false;
        titles.append(System.lineSeparator());
        for (Item i : database.getItems()) {
            if (i.getTitle().toLowerCase().equals(fields[1].toLowerCase())) {
                titleExists = true;
                titles.append(fields[1] + " - ");
            }
        }
        titles.append("already exists.")
        .append(System.lineSeparator());
        return titleExists;
    }

    private String promptText() {
        StringBuilder message = new StringBuilder();
        message.append("Use this area to input commands.")
        .append(System.lineSeparator())
        .append("To enter a new item with the GUI, ")
        .append("insert values in the following order: ")
        .append("type,title,time,field1,field2. No spaces, separating each ")
        .append("value with a ','.")
        .append(System.lineSeparator())
        .append("If you want to insert items in the database through a .txt file")
        .append(", input it's complete path in the area, including the extension.")
        .append(System.lineSeparator())
        .append("If you want to insert a comment, please ")
        .append("enter values in the following order: itemTitle,comment. ")
        .append("Again, no space between the values, separating each value with a ")
        .append("','.")
        .append(System.lineSeparator())
        .append("If you want to save a report ")
        .append( "of the current list, please write the full path where you want to ")
        .append("save the file, including the saved filed desired name and extension.")
        .append(System.lineSeparator())
        .append("If you want to remove a media from the ")
        .append("list, insert only his name here, with no other character.");
        return message.toString();
    }

}