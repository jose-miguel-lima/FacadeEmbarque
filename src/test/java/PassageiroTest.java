import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PassageiroTest {

    @Test
    void deveRetornarPendenciaDocumentacaoEmbarque() {
        Passageiro passageiro = new Passageiro();
        Documentacao.getInstancia().addPassageiroPendente(passageiro);

        assertEquals(false, passageiro.embarcar());
    }

    @Test
    void deveRetornarPendenciaBagagemEmbarque() {
        Passageiro passageiro = new Passageiro();
        Bagagem.getInstancia().addPassageiroPendente(passageiro);

        assertEquals(false, passageiro.embarcar());
    }

    @Test
    void deveRetornarPendenciaTaxasEmbarque() {
        Passageiro passageiro = new Passageiro();
        Taxas.getInstancia().addPassageiroPendente(passageiro);

        assertEquals(false, passageiro.embarcar());
    }

    @Test
    void deveRetornarPassageiroSemPendenciaEmbarque() {
        Passageiro passageiro = new Passageiro();

        assertEquals(true, passageiro.embarcar());
    }

    @Test
    void deveEmbarcarDepoisDeResolverAPendencia() {
        Passageiro passageiro = new Passageiro();
        Taxas.getInstancia().addPassageiroPendente(passageiro);
        assertEquals(false, passageiro.embarcar());

        Taxas.getInstancia().removerPassageiroPendente(passageiro);
        assertEquals(true, passageiro.embarcar());
    }

    @Test
    void naoDeveEmbarcarEnquantoHouverQualquerPendenciaRestante() {
        Passageiro passageiro = new Passageiro();
        Documentacao.getInstancia().addPassageiroPendente(passageiro);
        Bagagem.getInstancia().addPassageiroPendente(passageiro);

        Documentacao.getInstancia().removerPassageiroPendente(passageiro);

        assertEquals(false, passageiro.embarcar());
    }

    @Test
    void naoDeveAfetarOutroPassageiro() {
        Passageiro comPendencia = new Passageiro();
        Passageiro semPendencia = new Passageiro();
        Bagagem.getInstancia().addPassageiroPendente(comPendencia);

        assertEquals(false, comPendencia.embarcar());
        assertEquals(true, semPendencia.embarcar());
    }

    @Test
    void deveListarPendenciasNaOrdemDaVerificacao() {
        Passageiro passageiro = new Passageiro();
        Taxas.getInstancia().addPassageiroPendente(passageiro);
        Documentacao.getInstancia().addPassageiroPendente(passageiro);

        assertEquals(List.of("Documentação", "Taxas"), passageiro.getPendencias());
    }

    @Test
    void deveListarVazioParaPassageiroSemPendencia() {
        Passageiro passageiro = new Passageiro();

        assertTrue(passageiro.getPendencias().isEmpty());
    }

}
