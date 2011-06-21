package br.com.apresentacao.validacao;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.1
 */
public class ValidaNomeTest {

    /** Nome inválido contendo null. */
    private static final String NOME_INVALIDO_NULL = null;
    /** Nome inválido vazio. */
    private static final String NOME_INVALIDO_VAZIO = "";
    /** Nome inválido contendo tamanho inválido. */
    private static final String NOME_INVALIDO_TAMANHO =
            "Marcelo Valença de Almeida";
    /** Nome válido. */
    private static final String NOME_VALIDO = "Marcelo Valença";

    /**
     * Construtor.
     */
    public ValidaNomeTest() {
    }

    /**
     * Teste do método validar, da classe ValidaNome.
     * @throws Exception Exceção.
     */
    @Test
    public final void testValidar() throws Exception {
        System.out.println("validar nome");

        try {
            ValidaNome.validar(NOME_INVALIDO_NULL);
            fail("NOME_INVALIDO_NULL não lançou exceção...");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            ValidaNome.validar(NOME_INVALIDO_VAZIO);
            fail("NOME_INVALIDO_VAZIO não lançou exceção...");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            ValidaNome.validar(NOME_INVALIDO_TAMANHO);
            fail("NOME_INVALIDO_TAMANHO não lançou exceção...");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        assertEquals(NOME_VALIDO, ValidaNome.validar(NOME_VALIDO));
    }

}