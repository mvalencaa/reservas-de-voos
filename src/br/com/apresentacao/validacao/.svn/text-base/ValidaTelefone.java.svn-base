package br.com.apresentacao.validacao;

/**
 *
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.1
 */
public final class ValidaTelefone {

    /**
     * Construtor.
     */
    private ValidaTelefone() { }

    /** Tamanho permitido para o número do telefone. */
    private static final int TAMANHO_NUM_TELEFONE = 10;

    /**
     * Verifica se um número de voo está de acordo com o esperado
     * isto é:
     * <ul>
     *  <li> Não deve ser <code>null</code>; </li>
     *  <li> Não deve ser vazio; </li>
     *  <li> Deve ter comprimento igual a 10; </li>
     *  <li> Deve ser formado apenas por dígitos. </li>
     * </ul>
     *
     * @param telefone String que representa um telefone.
     * @return <code>true</code> se o telefone é válido.
     */
    public static String validar(final String telefone) {

        if ((telefone == null) || (telefone.isEmpty())
                || (telefone.length() != TAMANHO_NUM_TELEFONE)) {
            throw new IllegalArgumentException("Telefone " + telefone
                    + " inválido...");
        }

        char[] caracteres = telefone.toCharArray();
        for (char c : caracteres) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("Telefone " + telefone
                    + " inválido...");
            }
        }

        return telefone;
    }
}
