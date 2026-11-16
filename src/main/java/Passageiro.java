import java.util.List;

public class Passageiro {

    public boolean embarcar() {
        return PassageiroFacade.verificarPendenciasEmbarque(this);
    }

    public List<String> getPendencias() {
        return PassageiroFacade.listarPendenciasEmbarque(this);
    }
}
