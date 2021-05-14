import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

/**
 * Escreva a descrição da classe Viewer aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Viewer
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private JFrame frame;
    private JLabel label;
    private Database database;
    private JTextArea outputArea;
    private JTextArea inputArea;

    /**
     * Create an ImageViewer show it on screen.
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

        frame.setContentPane(createPanel());

        // building is done - arrange the components and show        
        frame.pack();

        // center the frame on screen
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(d.width/2 - frame.getWidth()/2, d.height/2 - frame.getHeight()/2);
        frame.setVisible(true);
    }

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

        inputArea = new JTextArea("Use this area to input commands. " +
            System.lineSeparator() + "To enter a new item with the GUI, " 
            + "insert values in the following " +
            "order: type,title,time,field1,field2. No spaces, separating each " +
            "value with a ','." + System.lineSeparator() +
            "If you want to insert items in the database through a .txt file" +
            ", input it's complete path in the area, including the extension."+
            System.lineSeparator() + "If you want to insert a comment, please "+
            "enter values in the following order: itemTitle,comment. "+
            "Again, no space between the values, separating each value with a "+
            "','." + System.lineSeparator() + "If you want to save a report "+
            "of the current list, please write the full path where you want to "+
            "save the file, including the saved filed desired name and extension."
            + System.lineSeparator() + "If you want to remove a media from the "
            +"list, insert only his name here, with no other character.");

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

    private void list() {
        String text = database.list();
        outputArea.setText(text);
    }

    private void addItem() {
        String text = inputArea.getText();
        String fields[] = text.split(",");
        if (fields[0].toLowerCase().equals("movie")) {
            addMovie(fields);
        } else if (fields[0].toLowerCase().equals("tvseries")) {
            addTvSeries(fields);
        } else if (fields[0].toLowerCase().equals("audiomedia")) {
            addAudioMedia(fields);
        } else {
            outputArea.setText("Invalid item, please try again.");   
        }
    }

    private void importFile() {
        String path = inputArea.getText();
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
        } catch (IOException e) {
            outputArea.setText("Error: " + e.getMessage());   
        }

    }

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
        } catch (IOException e) {
            outputArea.setText("Error: " + e.getMessage());   
        }
    }

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
    }

    private void removeItem() {
        String toRemove = inputArea.getText();
        Boolean itemRemoved = false;
        for (Item i : database.getItems()) {
            if (i.getTitle().toLowerCase().equals(toRemove.toLowerCase())) {
                database.removeItem(i); 
                itemRemoved = true;
            }
        }
        if (itemRemoved == false) {
            outputArea.setText("No such item was found.");   
        } else {
            outputArea.setText("Media removed.");   
        }
    }

    private void addMovie(String fields[]) {

        StringBuilder repeatedTitles = new StringBuilder();

        Boolean titleExists = verifyTitle(fields, repeatedTitles);

        if (titleExists == false) {
            Movie item = new Movie(fields[1], fields[3],
                    Integer.parseInt(fields[2]), Double.parseDouble(fields[4]));
            database.addItem(item);
        } else {
            outputArea.setText(repeatedTitles.toString());
        }
    }

    private void addTvSeries(String fields[]) {
        StringBuilder repeatedTitles = new StringBuilder();

        Boolean titleExists = verifyTitle(fields, repeatedTitles);

        if (titleExists == false) {
            TvSeries item = new TvSeries(fields[1], fields[3],
                    Integer.parseInt(fields[2]), Integer.parseInt(fields[4]));
            database.addItem(item);
        } else {
            outputArea.setText(repeatedTitles.toString());
        }
    }

    private Boolean verifyTitle(String fields[], StringBuilder titles) {
        Boolean titleExists = false;
        for (Item i : database.getItems()) {
            if (i.getTitle().toLowerCase().equals(fields[1].toLowerCase())) {
                titleExists = true;
                titles.append(fields[1] + " - ");
            }
        }
        titles.append("already exists.");
        return titleExists;
    }

    private void addAudioMedia(String fields[]) {
        StringBuilder repeatedTitles = new StringBuilder();

        Boolean titleExists = verifyTitle(fields, repeatedTitles);
        if (titleExists == false) {
            AudioMedia item = new AudioMedia(fields[1], fields[3],
                    Integer.parseInt(fields[2]), Integer.parseInt(fields[4]));
            database.addItem(item);
        } else {
            outputArea.setText(repeatedTitles.toString());
        }
    }

}