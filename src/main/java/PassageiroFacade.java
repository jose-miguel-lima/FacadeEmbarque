import java.util.ArrayList;
import java.util.List;

public class PassageiroFacade {

    public static boolean verificarPendenciasEmbarque(Passageiro passageiro) {
        if (Documentacao.getInstancia().verificarPassageiroComPendencia(passageiro)) {
            return false;
        }
        if (Bagagem.getInstancia().verificarPassageiroComPendencia(passageiro)) {
            return false;
        }
        if (Taxas.getInstancia().verificarPassageiroComPendencia(passageiro)) {
            return false;
        }
        return true;
    }

    public static List<String> listarPendenciasEmbarque(Passageiro passageiro) {
        List<String> pendencias = new ArrayList<String>();
        if (Documentacao.getInstancia().verificarPassageiroComPendencia(passageiro)) {
            pendencias.add(Documentacao.getInstancia().getNome());
        }
        if (Bagagem.getInstancia().verificarPassageiroComPendencia(passageiro)) {
            pendencias.add(Bagagem.getInstancia().getNome());
        }
        if (Taxas.getInstancia().verificarPassageiroComPendencia(passageiro)) {
            pendencias.add(Taxas.getInstancia().getNome());
        }
        return pendencias;
    }
}
