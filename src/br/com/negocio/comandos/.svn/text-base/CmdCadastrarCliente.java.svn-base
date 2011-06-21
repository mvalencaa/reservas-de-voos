package br.com.negocio.comandos;

import br.com.apresentacao.entidades.Cliente;
import br.com.negocio.controladoras.ErroCadastro;
import br.com.persistencia.controladoras.ErroPersistencia;

/**
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.2
 */
public class CmdCadastrarCliente extends CmdCadastrar {

    /** Trigger de Erro. */
    private static int erro = 0;

    /**
     * Construtor que recebe um novo Cliente cujo os atributos comporão.
     * o comando SQL para inserção no banco de dados.
     *
     * @param cliente um objeto que contém os atributos a serem inseridos.
     */
    public CmdCadastrarCliente(final Cliente cliente) {
        if (cliente.getCpf().equals("00000000000")) {
            erro = 1;
        } else if (cliente.getCpf().equals("12345123451")) {
            erro = 2;
        } else {
            erro = 0;
        }
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não informado");
        }
        comandoSQL = "INSERT INTO CLIENTE VALUES"
                + "('" + cliente.getCpf() + "',"
                + "'" + cliente.getNome() + "',"
                + "'" + cliente.getTelefone() + "')";
    }

    @Override
    public final void stubBD() throws ErroPersistencia {
        if (erro == 0) {
            System.out.println("Cadastrado com Sucesso!");
        } else if (erro == 1){
            throw new ErroCadastro("Cliente já cadastrado!");
        } else if (erro == 2) {
            throw new ErroPersistencia("Erro de Conexão com o Banco.");
        }
    }
}
