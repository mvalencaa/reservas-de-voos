package br.com.negocio.comandos;

import br.com.apresentacao.entidades.Funcionario;
import br.com.persistencia.controladoras.ErroPersistencia;

/**
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.2
 */
public class CmdEditarFuncionario extends CmdEditar {

    /** Trigger de Erro. */
    private static int erro = 0;

    /**
     * Construtor que recebe um novo Funcionário cujos atributos comporão
     * o comando SQL para edição no banco de dados.
     *
     * @param funcionario  Funcionário a ser editado no banco de dados.
     */
    public CmdEditarFuncionario(final Funcionario funcionario) {
        if (funcionario.getMatricula().equals("54321")) {
            erro = 1;
        } else {
            erro = 0;
        }
        if (funcionario == null) {
            throw new IllegalArgumentException("Funcionário não informado.");
        }
        comandoSQL = "UPDATE PUBLIC.FUNCIONARIO SET"
                + "(NOME, TELEFONE) = ("
                + "'" + funcionario.getNome() + "',"
                + "'" + funcionario.getTelefone() + "') WHERE MATRICULA='"
                + funcionario.getMatricula() + "'";
    }

    @Override
    public void stubBD() throws ErroPersistencia {
        if (erro == 0) {
            System.out.println("Funcionário editado com Sucesso!");
        } else if (erro == 1){
            throw new ErroPersistencia("Erro de Conexão com o Banco.");
        }
    }
}
