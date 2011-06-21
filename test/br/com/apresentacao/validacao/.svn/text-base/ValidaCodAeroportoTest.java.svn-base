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
public class ValidaCodAeroportoTest {

    /** Código inválido contendo null. */
    private static final String CODIGO_INVALIDO_NULL = null;
    /** Código inválido contendo uma string vazia. */
    private static final String CODIGO_INVALIDO_VAZIO = "";
    /** Código inválido somente de números. */
    private static final String CODIGO_INVALIDO_NRO = "111";
    /** Código inválido contendo um número. */
    private static final String CODIGO_INVALIDO_NRO_LETRA = "a1a";
    /** Código inválido contendo apenas uma letra. */
    private static final String CODIGO_INVALIDO_TAMANHO1 = "a";
    /** Código inválido contendo apenas duas letras. */
    private static final String CODIGO_INVALIDO_TAMANHO2 = "aa";
    /** Código inválido contendo mais que 3 letras. */
    private static final String CODIGO_INVALIDO_TAMANHO4 = "aaaa";
    /** Código válido. */
    private static final String CODIGO_VALIDO = "aaa";

    /**
     * Construtor.
     */
    public ValidaCodAeroportoTest() {
    }

    /**
     * Teste do método validar.
     */
    @Test
    public final void testValidar() {
        System.out.println("Validar codigo do aeroporto");

        try {
            ValidaCodAeroporto.validar(CODIGO_INVALIDO_NULL);
            fail("CODIGO_INVALIDO_NULL não lançou exceção...");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            ValidaCodAeroporto.validar(CODIGO_INVALIDO_VAZIO);
            fail("CODIGO_INVALIDO_VAZIO não lançou exceção...");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            ValidaCodAeroporto.validar(CODIGO_INVALIDO_NRO);
            fail("CODIGO_INVALIDO_NRO não lançou exceção...");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            ValidaCodAeroporto.validar(CODIGO_INVALIDO_NRO_LETRA);
            fail("CODIGO_INVALIDO_NRO_LETRA não lançou exceção...");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            ValidaCodAeroporto.validar(CODIGO_INVALIDO_TAMANHO1);
            fail("CODIGO_INVALIDO_TAMANHO1 não lançou exceção...");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            ValidaCodAeroporto.validar(CODIGO_INVALIDO_TAMANHO2);
            fail("CODIGO_INVALIDO_TAMANHO2 não lançou exceção...");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            ValidaCodAeroporto.validar(CODIGO_INVALIDO_TAMANHO4);
            fail("CODIGO_INVALIDO_TAMANHO4 não lançou exceção...");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        assertEquals(CODIGO_VALIDO, ValidaCodAeroporto.validar(CODIGO_VALIDO));
    }

}