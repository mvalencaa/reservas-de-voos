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
public class ValidaNroVooTest {

    /** Número de Voo inválido contendo null. */
    private static final String NROVOO_INVALIDO_NULL = null;
    /** Número de Voo inválido vazio. */
    private static final String NROVOO_INVALIDO_VAZIO = "";
    /** Número de Voo inválido contendo tamanho menor que o correto. */
    private static final String NROVOO_INVALIDO_TAMANHO1 = "aaaaa";
    /** Número de Voo inválido contendo tamanho maior que o correto. */
    private static final String NROVOO_INVALIDO_LETRA_DIGITO = "aaa1a1";
    /** Número de Voo inválido contendo digito e letra. */
    private static final String NROVOO_INVALIDO_DIGITO_LETRA = "123aAa";
    /** Número válido. */
    private static final String NROVOO_VALIDO = "aAa123";

    /**
     * Construtor.
     */
    public ValidaNroVooTest() {
    }

    /**
     * Teste do método validar, da classe ValidaNroVoo.
     */
    @Test
    public final void testValidar() {
       System.out.println("validar numero de voo");

       try {
           ValidaNroVoo.validar(NROVOO_INVALIDO_NULL);
           fail("NROVOO_INVALIDO_NULL não lançou exceção...");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
       try {
           ValidaNroVoo.validar(NROVOO_INVALIDO_VAZIO);
           fail("NROVOO_INVALIDO_VAZIO não lançou exceção...");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
       try {
           ValidaNroVoo.validar(NROVOO_INVALIDO_TAMANHO1);
           fail("NROVOO_INVALIDO_TAMANHO1 não lançou exceção...");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
       try {
           ValidaNroVoo.validar(NROVOO_INVALIDO_LETRA_DIGITO);
           fail("NROVOO_INVALIDO_TAMANHO2 não lançou exceção...");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
       try {
           ValidaNroVoo.validar(NROVOO_INVALIDO_DIGITO_LETRA);
           fail("NROVOO_INVALIDO_DIGITO_LETRA não lançou exceção...");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

       assertEquals(NROVOO_VALIDO, ValidaNroVoo.validar(NROVOO_VALIDO));

    }

}