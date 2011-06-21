/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.persistencia.fabrica;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author mva
 */
public interface IFabricaDeConexoes {

    /**
     * Pega a conexão com o Banco de Dados.
     * @return Conexão.
     * @throws SQLException Exceção.
     */
    Connection getConnection() throws SQLException;
}
