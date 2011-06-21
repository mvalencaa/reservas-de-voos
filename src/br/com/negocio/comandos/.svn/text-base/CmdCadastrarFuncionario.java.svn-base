package br.com.negocio.comandos;

import br.com.apresentacao.entidades.Funcionario;
import br.com.negocio.controladoras.ErroCadastro;
import br.com.persistencia.controladoras.ErroPersistencia;

/**
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.2
 */
public class CmdCadastrarFuncionario extends CmdCadastrar {

    /** Trigger de Erro. */
    private static int erro = 0;

    /**
     * Construtor que recebe um novo Funcionário cujos atributos comporão
     * o comando SQL para inserção no banco de dados.
     *
     * @param funcionario um objeto que contém os atributos a serem inseridos.
     */
    public CmdCadastrarFuncionario(final Funcionario funcionario) {
        if (funcionario.getMatricula().equals("00000")) {
            erro = 1;
        } else if (funcionario.getMatricula().equals("54321")) {
            erro = 2;
        } else {
            erro = 0;
        }
        if (funcionario == null) {
            throw new IllegalArgumentException("Funcionário não informado");
        }
        comandoSQL = "INSERT INTO FUNCIONARIO VALUES"
                + "('" + funcionario.getMatricula() + "',"
                + "'" + funcionario.getNome() + "',"
                + "'" + funcionario.getTelefone() + "')";
    }

    @Override
    public final void stubBD() throws ErroPersistencia {
        if (erro == 0) {
            System.out.println("Cadastrado com Sucesso!");
        } else if (erro == 1){
            throw new ErroCadastro("Funcionário já cadastrado!");
        } else if (erro == 2) {
            throw new ErroPersistencia("Erro de Conexão com o Banco.");
        }
    }
}
