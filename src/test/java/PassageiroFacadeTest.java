import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PassageiroFacadeTest {

    @Test
    void deveVerificarPendenciasSemPassarPeloPassageiro() {
        Passageiro passageiro = new Passageiro();
        Bagagem.getInstancia().addPassageiroPendente(passageiro);

        assertEquals(false, PassageiroFacade.verificarPendenciasEmbarque(passageiro));
    }

    @Test
    void deveListarTodasAsPendencias() {
        Passageiro passageiro = new Passageiro();
        Documentacao.getInstancia().addPassageiroPendente(passageiro);
        Bagagem.getInstancia().addPassageiroPendente(passageiro);
        Taxas.getInstancia().addPassageiroPendente(passageiro);

        assertEquals(List.of("Documentação", "Bagagem", "Taxas"),
                PassageiroFacade.listarPendenciasEmbarque(passageiro));
    }

    @Test
    void deveAtualizarAListaQuandoUmaPendenciaForResolvida() {
        Passageiro passageiro = new Passageiro();
        Documentacao.getInstancia().addPassageiroPendente(passageiro);
        Bagagem.getInstancia().addPassageiroPendente(passageiro);

        Documentacao.getInstancia().removerPassageiroPendente(passageiro);

        assertEquals(List.of("Bagagem"), PassageiroFacade.listarPendenciasEmbarque(passageiro));
    }

}
