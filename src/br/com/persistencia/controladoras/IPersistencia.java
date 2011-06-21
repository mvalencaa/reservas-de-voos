package br.com.persistencia.controladoras;

import br.com.negocio.comandos.CmdBD;

/**
 *
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.2
 */
public interface IPersistencia {

    void executar(CmdBD cmd) throws ErroPersistencia;

}
