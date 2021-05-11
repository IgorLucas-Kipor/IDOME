
/**
 * Escreva a descri��o da classe Movie aqui.
 * 
 * @author (seu nome) 
 * @version (n�mero de vers�o ou data)
 */
public class Movie extends VideoMedia
{
    // vari�veis de inst�ncia - substitua o exemplo abaixo pelo seu pr�prio
    private double boxOffice;

    /**
     * COnstrutor para objetos da classe Movie
     */
    public Movie(String theTitle, String theDirector, int time, double boxOffice)
    {
        super(theTitle, theDirector, time);
        this.boxOffice = boxOffice;
    }

    /**
     * Exemplo de m�todo - substitua este coment�rio pelo seu pr�prio
     * 
     * @param  y   exemplo de um par�metro de m�todo
     * @return     a soma de x com y 
     */
    public double getBoxOffice()
    {
        return boxOffice;
    }
    
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
