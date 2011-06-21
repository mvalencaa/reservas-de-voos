package br.com.negocio.comandos;

import br.com.persistencia.controladoras.ErroPersistencia;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.2
 */
public abstract class CmdConsultar extends CmdBD {

    public final void executar(final Connection conexao)
            throws ErroPersistencia {
        if (conexao == null)
            throw new IllegalArgumentException("Conexão não informada.");

        try {
            Statement st = conexao.createStatement();
            ResultSet res = st.executeQuery(getComandoSQL());
            setResultado(res);
            st.execute("commit;");
        } catch (SQLException e) {
            throw new ErroPersistencia("Erro na execução do comando SQL: " +
                    e.getMessage());
        }
    }

    /**
     * Seta o resultado da consulta.
     *
     * @param resultSet Objeto que contém os resultados consultados no banco.
     * @throws SQLException Exceção lançada na ocorrência de um erro.
     */
    public abstract void setResultado(ResultSet resultSet)
            throws SQLException;
}
