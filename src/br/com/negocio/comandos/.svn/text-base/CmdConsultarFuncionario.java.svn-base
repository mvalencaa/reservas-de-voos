package br.com.negocio.comandos;

import br.com.apresentacao.entidades.Funcionario;
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
public class CmdConsultarFuncionario extends CmdConsultar {

    /** Trigger de Erro. */
    private static int erro = 0;

    /** Funcionário a ser retornado. */
    private Funcionario resultado;

    /**
     * Construtor que recebe um novo Funcionário cujo os atributos comporão.
     * o comando SQL para consulta ao banco de dados.
     *
     * @param matricula Matrícula do Funcionário a ser consultado.
     */
    public CmdConsultarFuncionario(final String matricula) {
        if (matricula.equals("00000")) {
            erro = 1;
        } else if (matricula.equals("54321")) {
            erro = 2;
        } else {
            erro = 0;
        }
        if (matricula == null) {
            throw new IllegalArgumentException("Matrícula não informado.");
        }

        comandoSQL = "SELECT * FROM FUNCIONARIO WHERE MATRICULA='"
                + matricula + "'";
    }

    /**
     * Retorna o Funcionario encontrado da consulta realiza.
     * @return resultado O Funcionário.
     */
    public final Funcionario getResultado() {
        return resultado;
    }

    @Override
    public final void setResultado(final ResultSet resultSet)
            throws SQLException {
        if (resultSet.next()) {
            String nome = resultSet.getString("NOME");
            String telefone = resultSet.getString("TELEFONE");
            String matricula = resultSet.getString("MATRICULA");
            resultado = new Funcionario(nome, telefone, matricula);
        }
    }

    @Override
    public final void stubBD() throws ErroPersistencia {
        if (erro == 0) {
            resultado = new Funcionario("Clarisse Lispector", "1234567890",
                    "12345");
        } else if (erro == 1){
            throw new ErroConsulta("Cliente não encontrado!");
        } else if (erro == 2) {
            throw new ErroPersistencia("Erro de Conexão com o Banco.");
        }
    }
}
