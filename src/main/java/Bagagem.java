public class Bagagem extends Controle {

    private static Bagagem bagagem = new Bagagem();

    private Bagagem() {};

    public static Bagagem getInstancia() {
        return bagagem;
    }

    public String getNome() {
        return "Bagagem";
    }
}
