package br.com.apresentacao.entidades;


import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.1
 */
public class AeroportoTest {

    /** Aeroporto. */
    private static Aeroporto aeroporto;

    /** Construtor. */
    public AeroportoTest() {
    }

    /** Configura a classe.
     * @throws Exception Exceção.
     */
    @BeforeClass
    public static void setUpClass() throws Exception {
        aeroporto = new Aeroporto("Brasília", "BSB");
    }

    /**
     * Teste do método validar.
     */
    @Test
    public final void testGetCidade() {
        System.out.println("getCidade");

        String expResult = "Brasília";
        String result = aeroporto.getCidade();

        assertEquals(expResult, result);
    }

    /**
     * Teste do método validar.
     */
    @Test
    public final void testGetCodigo() {
        System.out.println("getCodigo");

        String expResult = "BSB";
        String result = aeroporto.getCodigo();
        assertEquals(expResult, result);
    }

}