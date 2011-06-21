package br.com.negocio.comandos;

import br.com.negocio.controladoras.ErroCadastro;
import br.com.persistencia.controladoras.ErroPersistencia;

/**
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.2
 */
public class CmdRemoverAeroporto extends CmdRemover {

    /** Trigger de Erro. */
    private static int erro = 0;

    /**
     * Construtor que recebe o código do aeroporto que comporá o comando SQL
     * para inserção no banco de dados.
     *
     * @param aeroporto String que contém o código do aeroporto a ser
     * removido.
     */
    public CmdRemoverAeroporto(final String aeroporto) {
        if (aeroporto.equals("AAA")) {
            erro = 1;
        } else if (aeroporto.equals("BBB")) {
            erro = 2;
        } else {
            erro = 0;
        }
        if (aeroporto == null) {
            throw new IllegalArgumentException("Código não informado.");
        }
        comandoSQL = "DELETE FROM PUBLIC.AEROPORTO WHERE CODIGO='"
                + aeroporto + "'";
    }

    @Override
    public final void stubBD() throws ErroPersistencia {
        if (erro == 0) {
            System.out.println("Removido com Sucesso!");
        } else if (erro == 1){
            throw new ErroCadastro("Aeroporto não encontrado!");
        } else if (erro == 2) {
            throw new ErroPersistencia("Erro de Conexão com o Banco.");
        }
    }
}
