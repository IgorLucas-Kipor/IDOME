
/**
 * Escreva a descrição da classe Movie aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Movie extends VideoMedia
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
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
     * Exemplo de método - substitua este comentário pelo seu próprio
     * 
     * @param  y   exemplo de um parâmetro de método
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
