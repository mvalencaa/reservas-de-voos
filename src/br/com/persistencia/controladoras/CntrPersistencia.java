package br.com.persistencia.controladoras;

import br.com.negocio.comandos.CmdBD;
import java.sql.Connection;

/**
 *
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.2
 */
public abstract class CntrPersistencia implements IPersistencia {

    /** Conexão. */
    private static Connection conexao;

    /**
     * Construtor.
     * @throws ErroPersistencia Exceção.
     */
    public CntrPersistencia() throws ErroPersistencia {
        criarDriver();
    }

    public static void setConnection(Connection con) {
        conexao = con;
    }

    public void executar(CmdBD cmd) throws ErroPersistencia {
        cmd.executar(conexao);
    }

    /**
     * Cria driver.
     */
    protected void criarDriver() { }
}
