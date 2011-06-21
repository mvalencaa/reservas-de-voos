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
public class ValidaCpfTest {

    /** CPF inválido contendo null. */
    private static final String CPF_INVALIDO_NULL = null;
    /** CPF inválido contendo uma string vazia. */
    private static final String CPF_INVALIDO_VAZIO = "";
    /** CPF inválido de tamanho 10. */
    private static final String CPF_INVALIDO_TAMANHO10 = "aaaaaaaaaa";
    /** CPF inválido de tamanho 12. */
    private static final String CPF_INVALIDO_TAMANHO12 = "aaaaaaaaaaaa";
    /** CPF inválido somente de letras. */
    private static final String CPF_INVALIDO_LETRAS = "aaaaaaaaaaa";
    /** CPF inválido contendo letras. */
    private static final String CPF_INVALIDO_NRO_LETRAS = "a1a1a1a1a1a";
    /** CPF válido. */
    private static final String CPF_VALIDO = "11111111111";

    /**
     * Construtor.
     */
    public ValidaCpfTest() {
    }

    /**
     * Teste do método validar.
     */
    @Test
    public final void testValidar() {
        System.out.println("validar cpf");

        try {
            ValidaCpf.validar(CPF_INVALIDO_NULL);
            fail("CPF_INVALIDO_NULL não lançou exceção");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            ValidaCpf.validar(CPF_INVALIDO_VAZIO);
            fail("CPF_INVALIDO_VAZIO não lançou exceção");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            ValidaCpf.validar(CPF_INVALIDO_TAMANHO10);
            fail("CPF_INVALIDO_TAMANHO10 não lançou exceção");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            ValidaCpf.validar(CPF_INVALIDO_TAMANHO12);
            fail("CPF_INVALIDO_TAMANHO12 não lançou exceção");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            ValidaCpf.validar(CPF_INVALIDO_LETRAS);
            fail("CPF_INVALIDO_LETRAS não lançou exceção");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            ValidaCpf.validar(CPF_INVALIDO_NRO_LETRAS);
            fail("CPF_INVALIDO_NRO_LETRAS não lançou exceção");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        assertEquals(CPF_VALIDO, ValidaCpf.validar(CPF_VALIDO));
    }

}