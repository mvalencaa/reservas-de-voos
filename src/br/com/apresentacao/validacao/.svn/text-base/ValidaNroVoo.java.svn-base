package br.com.apresentacao.validacao;

/**
 *
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.1
 */
public final class ValidaNroVoo {

    /**
     * Construtor.
     */
    private ValidaNroVoo() { }

    /** Tamanho do número do voo. */
    private static final int TAMANHO_NUMERO_VOO = 6;
    /** Número máximo de digitos do número do voo. */
    private static final int MAX_DIGITOS = 3;

    /**
     * Verifica se um número de voo está de acordo com o esperado,
     * isto é:
     * <ul>
     *  <li> Não deve ser <code>null</code>; </li>
     *  <li> Não deve ser vazio; </li>
     *  <li> Deve ter comprimento igual a 6; </li>
     *  <li> Deve ser formado pela concatenação de 3 letras e 3 dígitos,
     * respectivamente. </li>
     * </ul>
     *
     * @param nroVoo String que representa o número de um voo.
     * @return <code>true</code> se o voo é válido.
     */
    public static String validar(final String nroVoo) {

        if ((nroVoo == null) || (nroVoo.isEmpty())
                || (nroVoo.length() != TAMANHO_NUMERO_VOO)) {
            throw new IllegalArgumentException("Número de voo " + nroVoo
                    + " inválido...");
        }

        char[] caracteres = nroVoo.substring(0, MAX_DIGITOS).toCharArray();
        for (char c : caracteres) {
            if (Character.isDigit(c)) {
                throw new IllegalArgumentException(
                        "Número de voo " + nroVoo + " inválido...");
            }
        }

        caracteres = nroVoo.substring(MAX_DIGITOS, TAMANHO_NUMERO_VOO)
                .toCharArray();
        for (char c : caracteres) {
            if (Character.isLetter(c)) {
                throw new IllegalArgumentException(
                        "Número do voo " + nroVoo + " inválido...");
            }
        }

        return nroVoo;
    }
}
