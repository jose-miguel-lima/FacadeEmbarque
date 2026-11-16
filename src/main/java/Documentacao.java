public class Documentacao extends Controle {

    private static Documentacao documentacao = new Documentacao();

    private Documentacao() {};

    public static Documentacao getInstancia() {
        return documentacao;
    }

    public String getNome() {
        return "Documentação";
    }
}
