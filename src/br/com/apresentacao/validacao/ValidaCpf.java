package br.com.apresentacao.validacao;

/**
 *
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.1
 */
public final class ValidaCpf {

    /**
     * Construtor.
     */
    private ValidaCpf() { }

    /** Tamanho máximo permitido para o código do CPF. */
    private static final int TAMANHO_CPF = 11;

    /**
     * Verifica se um CPF está de acordo com o esperado,
     * isto é:
     * <ul>
     *  <li> Não deve ser <code>null</code>; </li>
     *  <li> Não deve ser vazio; </li>
     *  <li> Deve ter comprimento igual a 11; </li>
     *  <li> Deve ser formado apenas por dígitos. </li>
     * </ul>
     *
     * @param cpf String que representa um CPF.
     * @return <code>true</code> se o CPF é válido.
     */
    public static String validar(final String cpf) {

        if ((cpf == null) || (cpf.isEmpty()) || (cpf.length() != TAMANHO_CPF)) {
            throw new IllegalArgumentException("CPF " + cpf + " inválido...");
        }

        char[] caracteres = cpf.toCharArray();
        for (char c : caracteres) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("CPF " + cpf
                        + " inválido...");
            }
        }

        return cpf;
    }
}
