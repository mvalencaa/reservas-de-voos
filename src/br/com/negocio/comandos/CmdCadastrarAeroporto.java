package br.com.negocio.comandos;

import br.com.apresentacao.entidades.Aeroporto;
import br.com.negocio.controladoras.ErroCadastro;
import br.com.persistencia.controladoras.ErroPersistencia;

/**
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.2
 */
public class CmdCadastrarAeroporto extends CmdCadastrar {

    /** Trigger de Erro. */
    private static int erro = 0;

    /**
     * Construtor que recebe um novo Aeroporto cujo os atributos comporão.
     * o comando SQL para inserção no banco de dados.
     *
     * @param aeroporto Objeto que contém os atributos a serem inseridos.
     */
    public CmdCadastrarAeroporto(final Aeroporto aeroporto) {
        if (aeroporto.getCodigo().equals("AAA")) {
            erro = 1;
        } else if (aeroporto.getCodigo().equals("BBB")) {
            erro = 2;
        } else {
            erro = 0;
        }
        if (aeroporto == null) {
            throw new IllegalArgumentException("Aeroporto não informado");
        }
        comandoSQL = "INSERT INTO AEROPORTO VALUES"
                + "('" + aeroporto.getCodigo() + "',"
                + "'" + aeroporto.getCidade() + "')";
    }

    @Override
    public final void stubBD() throws ErroPersistencia {
        if (erro == 0) {
            System.out.println("Cadastrado com Sucesso!");
        } else if (erro == 1){
            throw new ErroCadastro("Aeroporto já cadastrado!");
        } else if (erro == 2) {
            throw new ErroPersistencia("Erro de Conexão com o Banco.");
        }
    }
}
