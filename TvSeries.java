
/**
 * Escreva a descrição da classe TvSeries aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class TvSeries extends VideoMedia
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
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
     * Exemplo de método - substitua este comentário pelo seu próprio
     * 
     * @param  y   exemplo de um parâmetro de método
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
