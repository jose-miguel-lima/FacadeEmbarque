import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControleTest {

    @Test
    void deveRetornarSempreAMesmaInstanciaDeCadaControle() {
        assertSame(Documentacao.getInstancia(), Documentacao.getInstancia());
        assertSame(Bagagem.getInstancia(), Bagagem.getInstancia());
        assertSame(Taxas.getInstancia(), Taxas.getInstancia());
    }

    @Test
    void deveRetornarONomeDeCadaControle() {
        assertEquals("Documentação", Documentacao.getInstancia().getNome());
        assertEquals("Bagagem", Bagagem.getInstancia().getNome());
        assertEquals("Taxas", Taxas.getInstancia().getNome());
    }

    @Test
    void deveRegistrarEVerificarPendencia() {
        Passageiro passageiro = new Passageiro();
        assertFalse(Bagagem.getInstancia().verificarPassageiroComPendencia(passageiro));

        Bagagem.getInstancia().addPassageiroPendente(passageiro);
        assertTrue(Bagagem.getInstancia().verificarPassageiroComPendencia(passageiro));
    }

    @Test
    void naoDeveDuplicarPendenciaDoMesmoPassageiro() {
        Passageiro passageiro = new Passageiro();
        Bagagem.getInstancia().addPassageiroPendente(passageiro);
        Bagagem.getInstancia().addPassageiroPendente(passageiro);

        Bagagem.getInstancia().removerPassageiroPendente(passageiro);

        assertFalse(Bagagem.getInstancia().verificarPassageiroComPendencia(passageiro));
    }

    @Test
    void naoDeveMisturarPendenciasEntreControles() {
        Passageiro passageiro = new Passageiro();
        Taxas.getInstancia().addPassageiroPendente(passageiro);

        assertTrue(Taxas.getInstancia().verificarPassageiroComPendencia(passageiro));
        assertFalse(Documentacao.getInstancia().verificarPassageiroComPendencia(passageiro));
        assertFalse(Bagagem.getInstancia().verificarPassageiroComPendencia(passageiro));
    }

}
