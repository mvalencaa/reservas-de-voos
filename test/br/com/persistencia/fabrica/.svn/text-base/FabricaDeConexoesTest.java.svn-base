package br.com.persistencia.fabrica;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.3
 */
public class FabricaDeConexoesTest {

    public FabricaDeConexoesTest() {
    }

    /**
     * Test do método getConnection, da classe FabricaDeConexoes.
     */
    @Test
    public void testGetConnection() throws Exception {
        System.out.println("getConnection");
        try {
        FabricaDeConexoes instance = new FabricaDeConexoes();;
        assertNotNull(instance);
        } catch (Exception e) {
            System.out.println("Erro ao pegar conexão: " + e.getMessage());
            fail("Exceção lancada ao pegar conexão.");
        }
    }

}