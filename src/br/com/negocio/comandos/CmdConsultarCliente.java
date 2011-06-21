package br.com.negocio.comandos;

import br.com.apresentacao.entidades.Cliente;
import br.com.negocio.controladoras.ErroConsulta;
import br.com.persistencia.controladoras.ErroPersistencia;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.2
 */
public class CmdConsultarCliente extends CmdConsultar {

    /** Trigger de Erro. */
    private static int erro = 0;

    /** Cliente a ser retornado. */
    private Cliente resultado;

    /**
     * Construtor que recebe um novo Cliente cujo os atributos comporão.
     * o comando SQL para consulta ao banco de dados.
     *
     * @param cpf CPF do Cliente a ser consultado.
     */
    public CmdConsultarCliente(final String cpf) {
        if (cpf.equals("00000000000")) {
            erro = 1;
        } else if (cpf.equals("12345123451")) {
            erro = 2;
        } else {
            erro = 0;
        }
        if (cpf == null) {
            throw new IllegalArgumentException("CPF não informado.");
        }

        comandoSQL = "SELECT * FROM CLIENTE WHERE CPF='"
                + cpf + "'";
    }

    /**
     * Retorna o Cliente encontrado da consulta realiza.
     * @return resultado O Cliente.
     */
    public final Cliente getResultado() {
        return resultado;
    }

    @Override
    public final void setResultado(final ResultSet resultSet)
            throws SQLException {
        if (resultSet.next()) {
            String nome = resultSet.getString("NOME");
            String telefone = resultSet.getString("TELEFONE");
            String cpf = resultSet.getString("CPF");
            resultado = new Cliente(nome, telefone, cpf);
        }
    }

    @Override
    public final void stubBD() throws ErroPersistencia {
        if (erro == 0) {
            resultado = new Cliente("Clarisse Lispector", "1234567890",
                    "12345678901");
        } else if (erro == 1){
            throw new ErroConsulta("Cliente não encontrado!");
        } else if (erro == 2) {
            throw new ErroPersistencia("Erro de Conexão com o Banco.");
        }
    }
}
