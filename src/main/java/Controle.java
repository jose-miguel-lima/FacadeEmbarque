import java.util.ArrayList;
import java.util.List;

public abstract class Controle {

    private List<Passageiro> passageirosComPendencia = new ArrayList<Passageiro>();

    public void addPassageiroPendente(Passageiro passageiro) {
        if (!this.passageirosComPendencia.contains(passageiro)) {
            this.passageirosComPendencia.add(passageiro);
        }
    }

    public void removerPassageiroPendente(Passageiro passageiro) {
        this.passageirosComPendencia.remove(passageiro);
    }

    public boolean verificarPassageiroComPendencia(Passageiro passageiro) {
        return this.passageirosComPendencia.contains(passageiro);
    }

    public abstract String getNome();

}
