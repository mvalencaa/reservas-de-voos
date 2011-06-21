package br.com.apresentacao.validacao;

/**
 *
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.1
 */
public final class ValidaMatricula {

    /**
     * Construtor.
     */
    private ValidaMatricula() { }

    /** Tamanho máximo permitido para o código de matrícula. */
    private static final int TAMANHO_COD = 5;

    /**
     * Verifica se uma matrícula está de acordo com o esperado,
     * isto é:
     * <ul>
     *  <li> Não deve ser <code>null</code>; </li>
     *  <li> Não deve ser vazia; </li>
     *  <li> Deve ter comprimento igual a 5; </li>
     *  <li> Deve conter apenas dígitos. </li>
     * </ul>
     *
     * @param matricula String que representa uma matrícula.
     * @return <code>true</code> se a matrícula é válida.
     */
    public static String validar(final String matricula) {

        if ((matricula == null) || (matricula.isEmpty())
                || (matricula.length() != TAMANHO_COD)) {
            throw new IllegalArgumentException("Matrícula " + matricula
                    + " inválida...");
        }

        char[] caracteres = matricula.toCharArray();
        for (char c : caracteres) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("Matrícula " + matricula
                    + " inválida...");
            }
        }

        return matricula;
    }
}
