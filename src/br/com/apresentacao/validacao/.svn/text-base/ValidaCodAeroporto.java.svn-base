package br.com.apresentacao.validacao;

/**
 *
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.1
 */
public final class ValidaCodAeroporto {

    /**
     * Construtor.
     */
    private ValidaCodAeroporto() { }

    /** Tamanho do código do aeroporto. */
    private static final int TAMANHO_CODIGO_AEROPORTO = 3;

    /**
     * Verifica se o código de um aeroporto está de acordo com o esperado,
     * isto é:
     * <ul>
     *  <li> Não deve ser <code>null</code>; </li>
     *  <li> Não deve ser vazio; </li>
     *  <li> Deve conter apenas letras; </li>
     *  <li> Deve ter comprimento igual a 3. </li>
     * </ul>
     *
     * @param codigo String que representa o código do aeroporto.
     * @return <code>true</code> se o código é válido.
     */

    public static String validar(final String codigo) {

        if ((codigo == null) || (codigo.isEmpty())
                || (codigo.length() != TAMANHO_CODIGO_AEROPORTO)) {
            throw new IllegalArgumentException("Código " + codigo
                    + " inválido...");
        }

        char[] caracteres = codigo.toCharArray();
        for (char c : caracteres) {
            if (!Character.isLetter(c)) {
                throw new IllegalArgumentException("Código " + codigo
                        + " inválido...");
            }
        }

        return codigo;
    }
}
