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
public class ValidaDataTest {

    /** Data inválida contendo null. */
    private static final String DATA_INVALIDA_NULL = null;
    /** Data inválida contendo string vazia. */
    private static final String DATA_INVALIDA_VAZIO = "";
    /** Data inválida contendo letra no dia. */
    private static final String DATA_INVALIDA_LETRA1 = "1f/02/1978";
    /** Data inválida contendo letra no mês. */
    private static final String DATA_INVALIDA_LETRA2 = "12/t2/1978";
    /** Data inválida contendo letra no ano. */
    private static final String DATA_INVALIDA_LETRA3 = "12/02/19w8";
    /** Data inválida contendo barra a mais. */
    private static final String DATA_INVALIDA_BARRA1 = "1//02/1978";
    /** Data inválida contendo barra a mais. */
    private static final String DATA_INVALIDA_BARRA2 = "12/02/19/8";
    /** Data inválida sem barras. */
    private static final String DATA_INVALIDA_SEM_BARRA = "1202198";
    /** Data inválida com dias errados. */
    private static final String DATA_INVALIDA_DIA1 = "34/12/3000";
    /** Data inválida com dia inexistente. */
    private static final String DATA_INVALIDA_DIA2 = "30/02/2010";
    /** Data inválida com mês inexistente. */
    private static final String DATA_INVALIDA_MES = "21/25/2000";
    /** Data inválida com dois pontos no lugar das barras. */
    private static final String DATA_INVALIDA_FORMATO1 = "10:12:2000";
    /** Data inválida com hífen no lugar das barras. */
    private static final String DATA_INVALIDA_FORMATO2 = "34-12-2000";
    /** Data válida. */
    private static final String DATA_VALIDA = "10/12/1987";

    /**
     * Construtor.
     */
    public ValidaDataTest() {
    }


    /**
     * Teste do método validar.
     */
    @Test
    public final void testValidar() {
        System.out.println("Validar data");

        try {
            ValidaData.validar(DATA_INVALIDA_NULL);
            fail("DATA_INVALIDA_NULL não lançou exceção...");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            ValidaData.validar(DATA_INVALIDA_VAZIO);
            fail("DATA_INVALIDA_VAZIO não lançou exceção...");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            ValidaData.validar(DATA_INVALIDA_LETRA1);
            fail("DATA_INVALIDA_LETRA1 não lançou exceção...");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            ValidaData.validar(DATA_INVALIDA_LETRA2);
            fail("DATA_INVALIDA_LETRA2 não lançou exceção...");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            ValidaData.validar(DATA_INVALIDA_LETRA3);
            fail("DATA_INVALIDA_LETRA3 não lançou exceção...");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            ValidaData.validar(DATA_INVALIDA_BARRA1);
            fail("DATA_INVALIDA_BARRA1 não lançou exceção...");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            ValidaData.validar(DATA_INVALIDA_BARRA2);
            fail("DATA_INVALIDA_BARRA2 não lançou exceção...");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            ValidaData.validar(DATA_INVALIDA_SEM_BARRA);
            fail("DATA_INVALIDA_SEM_BARRA não lançou exceção...");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            ValidaData.validar(DATA_INVALIDA_DIA1);
            fail("DATA_INVALIDA_DIA1 não lançou exceção...");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            ValidaData.validar(DATA_INVALIDA_DIA2);
            fail("DATA_INVALIDA_DIA2 não lançou exceção...");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            ValidaData.validar(DATA_INVALIDA_MES);
            fail("DATA_INVALIDA_MES não lançou exceção...");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            ValidaData.validar(DATA_INVALIDA_FORMATO1);
            fail("DATA_INVALIDA_FORMATO1 não lançou exceção...");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            ValidaData.validar(DATA_INVALIDA_FORMATO2);
            fail("DATA_INVALIDA_FORMATO2 não lançou exceção...");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        assertEquals(DATA_VALIDA, ValidaData.validar(DATA_VALIDA));
    }

}