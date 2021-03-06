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
public class ClienteTest {

    /** Cliente. */
    private static Cliente cliente;

    /** Construtor. */
    public ClienteTest() {
    }

    /** Configura a classe.
     * @throws Exception Exceção.
     */
    @BeforeClass
    public static void setUpClass() throws Exception {
        cliente = new Cliente("José Saramago", "6198128345", "12345678909");
    }

    /**
     * Teste do método validar, da classe Cliente.
     */
    @Test
    public final void testGetCpf() {
        System.out.println("getCpf");

        String expResult = "12345678909";
        String result = cliente.getCpf();
        assertEquals(expResult, result);
    }

}