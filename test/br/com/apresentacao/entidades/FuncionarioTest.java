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
public class FuncionarioTest {

    /** Funcionário. */
    private static Funcionario funcionario;

    /** Construtor. */
    public FuncionarioTest() {
    }

    /** Configura a classe.
     * @throws Exception Exceção.
     */
    @BeforeClass
    public static void setUpClass() throws Exception {
        funcionario = new Funcionario("Junior de Melo", "6184738219", "12345");
    }

    /**
     * Teste do método validar, da classe Funcionario.
     */
    @Test
    public final void testGetMatricula() {
        System.out.println("getMatricula");

        String expResult = "12345";
        String result = funcionario.getMatricula();
        assertEquals(expResult, result);
    }

}