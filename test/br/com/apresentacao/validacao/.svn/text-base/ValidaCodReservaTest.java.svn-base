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
public class ValidaCodReservaTest {

    /** Código inválido contendo null. */
    private static final String CODIGO_INVALIDO_NULL = null;
    /** Código inválido contendo uma string vazia. */
    private static final String CODIGO_INVALIDO_VAZIO = "";
    /** Código inválido somente de digitos. */
    private static final String CODIGO_INVALIDO_NRO = "aaa";
    /** Código inválido contendo uma letra. */
    private static final String CODIGO_INVALIDO_NRO_LETRA = "1a1";
    /** Código inválido contendo menos que 5 digitos. */
    private static final String CODIGO_INVALIDO_TAMANHO4 = "1111";
    /** Código inválido contendo mais que 5 digitos. */
    private static final String CODIGO_INVALIDO_TAMANHO6 = "111111";
    /** Código válido. */
    private static final String CODIGO_VALIDO = "11111";

    /**
     * Construtor.
     */
    public ValidaCodReservaTest() {
    }

    /**
     * Teste do método validar.
     */
    @Test
    public void testValidar() {
        System.out.println("Validar codigo da reserva");

        try {
            ValidaCodReserva.validar(CODIGO_INVALIDO_NULL);
            fail("CODIGO_INVALIDO_NULL não lançou exceção...");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            ValidaCodReserva.validar(CODIGO_INVALIDO_VAZIO);
            fail("CODIGO_INVALIDO_VAZIO não lançou exceção...");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            ValidaCodReserva.validar(CODIGO_INVALIDO_NRO);
            fail("CODIGO_INVALIDO_NRO não lançou exceção...");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            ValidaCodReserva.validar(CODIGO_INVALIDO_NRO_LETRA);
            fail("CODIGO_INVALIDO_NRO_LETRA não lançou exceção...");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            ValidaCodReserva.validar(CODIGO_INVALIDO_TAMANHO4);
            fail("CODIGO_INVALIDO_TAMANHO2 não lançou exceção...");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            ValidaCodReserva.validar(CODIGO_INVALIDO_TAMANHO6);
            fail("CODIGO_INVALIDO_TAMANHO4 não lançou exceção...");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        assertEquals(CODIGO_VALIDO, ValidaCodReserva.validar(CODIGO_VALIDO));
    }

}