package br.com.negocio.comandos;

import br.com.persistencia.controladoras.ErroPersistencia;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.2
 */
public abstract class CmdBD {

    /** String que conterá o comando SQL a ser executado. */
    protected String comandoSQL;

    /**
     * Método protegido executar que será implementado pelas classes
     * que herdam desta.
     *
     * @param conexao Conexão com o banco de dados.
     * @throws SQLException Exceção.
     */
    public abstract void executar(final Connection conexao)
            throws ErroPersistencia;

    /** Método acessor para o parâmetro comandoSQL.
     *
     * @return comandoSQL Uma string que contém o comando.
     */
    public final String getComandoSQL() {
        return comandoSQL;
    }

    /**
     * Método que testa a camada de persistência.
     *
     * @throws ErroPersistencia Exceção lançada na ocorrência de um erro.
     */
    public abstract void stubBD() throws ErroPersistencia;
}
