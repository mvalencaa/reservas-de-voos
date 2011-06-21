package br.com.negocio.comandos;

import br.com.apresentacao.entidades.Cliente;
import br.com.persistencia.controladoras.ErroPersistencia;

/**
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.2
 */
public class CmdEditarCliente extends CmdEditar {

    /** Trigger de Erro. */
    private static int erro = 0;

    /**
     * Construtor que recebe um novo Cliente cujos atributos comporão
     * o comando SQL para edição no banco de dados.
     *
     * @param cliente  Cliente a ser editado no banco de dados.
     */
    public CmdEditarCliente(final Cliente cliente) {
        if (cliente.getCpf().equals("12345123451")) {
            erro = 1;
        } else {
            erro = 0;
        }
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não informado.");
        }
        comandoSQL = "UPDATE PUBLIC.CLIENTE SET"
                + "(NOME, TELEFONE) = ("
                + "'" + cliente.getNome() + "',"
                + "'" + cliente.getTelefone() + "') WHERE CPF='"
                + cliente.getCpf() + "'";
    }

    @Override
    public void stubBD() throws ErroPersistencia {
        if (erro == 0) {
            System.out.println("Cliente editado com Sucesso!");
        } else if (erro == 1){
            throw new ErroPersistencia("Erro de Conexão com o Banco.");
        }
    }
}
