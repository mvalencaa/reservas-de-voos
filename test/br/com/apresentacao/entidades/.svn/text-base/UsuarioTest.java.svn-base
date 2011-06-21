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
public class UsuarioTest {

    /** Usuário. */
    private static Usuario pessoa;

    /** Construtor. */
    public UsuarioTest() {
    }

    /** Configura a classe.
     * @throws Exception Exceção.
     */
    @BeforeClass
    public static void setUpClass() throws Exception {
        pessoa = new Usuario("Maria Clara", "6178451236");
    }

    /**
     * Teste do método validar.
     */
    @Test
    public final void testGetNome() {
        System.out.println("getNome");

        String expResult = "Maria Clara";
        String result = pessoa.getNome();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método validar.
     */
    @Test
    public final void testSetNome() {
        System.out.println("setNome");

        String nome = "Marcos de Miranda";
        pessoa.setNome(nome);
        assertEquals(nome, pessoa.getNome());
    }

    /**
     * Teste do método validar.
     */
    @Test
    public final void testGetTelefone() {
        System.out.println("getTelefone");

        String expResult = "6178451236";
        String result = pessoa.getTelefone();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método validar.
     */
    @Test
    public final void testSetTelefone() {
        System.out.println("setTelefone");

        String telefone = "6178945612";
        pessoa.setTelefone(telefone);
        assertEquals(telefone, pessoa.getTelefone());
    }

}