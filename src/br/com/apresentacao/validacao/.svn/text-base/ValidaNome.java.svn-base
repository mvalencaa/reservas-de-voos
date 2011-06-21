package br.com.apresentacao.validacao;

/**
 *
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.1
 */
public final class ValidaNome {

     /**
     * Construtor.
     */
    private ValidaNome() { }

    /** Tamanho máximo permitido para o nome do usuário. */
    private static final int MAX_TAMANHO_NOME = 20;

    /**
     * Verifica se o nome passado está de acordo com o esperado,
     * isto é:
     * <ul>
     *  <li> Não deve ser <code>null</code>; </li>
     *  <li> Não deve ser vazio; </li>
     *  <li> Deve ter comprimento menor ou igual a 20. </li>
     * </ul>
     *
     * @param nome String que representa o nome do usuário.
     * @return <code>true</code> se o nome é válido.
     */
    public static String validar(final String nome) {

        if ((nome == null) || (nome.isEmpty())
                || (nome.length() > MAX_TAMANHO_NOME)) {
            throw new IllegalArgumentException("Nome " + nome
                    + " inválido...");
        }

        return nome;
    }
}
