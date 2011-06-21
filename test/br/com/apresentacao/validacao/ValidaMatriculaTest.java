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
public class ValidaMatriculaTest {

    /** Matrícula inválida contendo null. */
    private static final String MATRICULA_INVALIDA_NULL = null;
    /** Matrícula inválida vazia. */
    private static final String MATRICULA_INVALIDA_VAZIA = "";
    /** Matrícula inválida com tamanho menor que o correto. */
    private static final String MATRICULA_INVALIDA_TAMANHO1 = "1234";
    /** Matrícula inválida com tamanho maior que o correto. */
    private static final String MATRICULA_INVALIDA_TAMANHO2 = "123456";
    /** Matrícula inválida contendo somente letras. */
    private static final String MATRICULA_INVALIDA_LETRA1 = "aAaAa";
    /** Matrícula inválida contendo uma letra. */
    private static final String MATRICULA_INVALIDA_LETRA2 = "12a34";
    /** Matrícula válida. */
    private static final String MATRICULA_VALIDA = "12345";

    /**
     * Construtor.
     */
    public ValidaMatriculaTest() {
    }

    /**
     * Teste do método validar, da classe ValidaMatricula.
     */
    @Test
    public final void testValidar() {
        System.out.println("Validar matricula");

        try {
            ValidaMatricula.validar(MATRICULA_INVALIDA_NULL);
            fail("MATRICULA_INVALIDA_NULL não lançou exceção...");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            ValidaMatricula.validar(MATRICULA_INVALIDA_VAZIA);
            fail("MATRICULA_INVALIDA_VAZIA não lançou exceção...");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            ValidaMatricula.validar(MATRICULA_INVALIDA_TAMANHO1);
            fail("MATRICULA_INVALIDA_TAMANHO1 não lançou exceção...");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            ValidaMatricula.validar(MATRICULA_INVALIDA_TAMANHO2);
            fail("MATRICULA_INVALIDA_TAMANHO2 não lançou exceção...");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            ValidaMatricula.validar(MATRICULA_INVALIDA_LETRA1);
            fail("MATRICULA_INVALIDA_LETRA1 não lançou exceção...");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            ValidaMatricula.validar(MATRICULA_INVALIDA_LETRA2);
            fail("MATRICULA_INVALIDA_LETRA2 não lançou exceção...");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        assertEquals(MATRICULA_VALIDA, ValidaMatricula.validar(MATRICULA_VALIDA));
    }

}