package br.com.negocio.controladoras;

import br.com.persistencia.controladoras.ErroPersistencia;

/**
 *
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.2
 */
public class ErroEdicao extends ErroPersistencia {

    /**
     * Contrutor da classe.
     *
     * @param mensagem Mensagem a ser mostrada na ocorrência de uma exceção.
     */
    public ErroEdicao(final String mensagem) {
        super(mensagem);
    }
}
