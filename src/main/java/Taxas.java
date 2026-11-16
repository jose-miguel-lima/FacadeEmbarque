public class Taxas extends Controle {

    private static Taxas taxas = new Taxas();

    private Taxas() {};

    public static Taxas getInstancia() {
        return taxas;
    }

    public String getNome() {
        return "Taxas";
    }
}
