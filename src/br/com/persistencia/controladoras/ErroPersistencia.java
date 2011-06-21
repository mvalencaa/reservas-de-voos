package br.com.persistencia.controladoras;

/**
 *
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.2
 */
public class ErroPersistencia extends Exception {

    /**
     * Contrutor da classe.
     *
     * @param mensagem Mensagem a ser mostrada na ocorrência de uma exceção.
     */
    public ErroPersistencia(final String mensagem) {
        super(mensagem);
    }
}
