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
public class ValidaTelefoneTest {
    /** Telefone inválido contendo null. */
    private static final String TELEFONE_INVALIDO_NULL = null;
    /** Telefone inválido contendo uma string vazia. */
    private static final String TELEFONE_INVALIDO_VAZIO = "";
    /** Telefone com tamanho de 8 caracteres. */
    private static final String TELEFONE_INVALIDO_TAMANHO9 = "191928374";
    /** Telefone com tamanho de 11 caracteres. */
    private static final String TELEFONE_INVALIDO_TAMANHO11 = "19192837465";
    /** Telefone inválido contendo uma letra. */
    private static final String TELEFONE_INVALIDO_LETRA = "992aft6457";
    /** Telefone válido. */
    private static final String TELEFONE_VALIDO = "9923645721";

    /**
     * Construtor.
     */
    public ValidaTelefoneTest() {
    }

    /**
     * Teste do método validar, da classe ValidaTelefone.
     * @throws Exception Execão.
     */
    @Test
    public final void testValidar() throws Exception {
        System.out.println("validar telefone");

        try {
            ValidaTelefone.validar(TELEFONE_INVALIDO_NULL);
            fail("TELEFONE_INVALIDO_NULL não lançou exceção...");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            ValidaTelefone.validar(TELEFONE_INVALIDO_VAZIO);
            fail("TELEFONE_INVALIDO_VAZIO não lançou exceção...");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            ValidaTelefone.validar(TELEFONE_INVALIDO_TAMANHO9);
            fail("TELEFONE_INVALIDO_TAMANHO9 não lançou exceção...");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            ValidaTelefone.validar(TELEFONE_INVALIDO_TAMANHO11);
            fail("TELEFONE_INVALIDO_TAMANHO11 não lançou exceção...");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            ValidaTelefone.validar(TELEFONE_INVALIDO_LETRA);
            fail("TELEFONE_INVALIDO_LETRA não lançou exceção...");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        assertEquals(TELEFONE_VALIDO, ValidaTelefone.validar(TELEFONE_VALIDO));

    }

}