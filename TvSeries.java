
/**
 * Escreva a descri��o da classe TvSeries aqui.
 * 
 * @author (seu nome) 
 * @version (n�mero de vers�o ou data)
 */
public class TvSeries extends VideoMedia
{
    // vari�veis de inst�ncia - substitua o exemplo abaixo pelo seu pr�prio
    private int numberOfSeasons;

    /**
     * COnstrutor para objetos da classe TvSeries
     */
    public TvSeries(String theTitle, String theDirector, int time, int seasons)
    {
        super(theTitle, theDirector, time);
        numberOfSeasons = seasons;
    }

    /**
     * Exemplo de m�todo - substitua este coment�rio pelo seu pr�prio
     * 
     * @param  y   exemplo de um par�metro de m�todo
     * @return     a soma de x com y 
     */
    public int getNumberOfSeasons()
    {
        return numberOfSeasons;
    }
    
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
