package br.com.persistencia.fabrica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.3
 */
public class FabricaDeConexoes implements IFabricaDeConexoes {

    /**URL do banco.*/
    private String url = "jdbc:hsqldb:file:c:/bd/banco";
    /**User do banco.*/
    private String user = "root";
    /**Senha do banco.*/
    private String password = "root";

    /**
     * Pega a conexão com o Banco de Dados.
     * @return Conexão.
     * @throws SQLException Exceção.
     */
    public final Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
