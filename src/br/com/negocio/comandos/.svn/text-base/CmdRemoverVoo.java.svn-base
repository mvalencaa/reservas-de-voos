package br.com.negocio.comandos;

import br.com.negocio.controladoras.ErroCadastro;
import br.com.persistencia.controladoras.ErroPersistencia;

/**
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.2
 */
public class CmdRemoverVoo extends CmdRemover {

    /** Trigger de Erro. */
    private static int erro = 0;

    /**
     * Construtor que recebe o código do voo que comporá o comando SQL para
     * inserção no banco de dados.
     *
     * @param voo String que contém o código do voo a ser removido.
     */
    public CmdRemoverVoo(final String voo) {
        if (voo.equals("AAA111")) {
            erro = 1;
        } else if (voo.equals("BBB222")) {
            erro = 2;
        } else {
            erro = 0;
        }
        if (voo == null) {
            throw new IllegalArgumentException("Voo não informado.");
        }
        comandoSQL = "DELETE FROM PUBLIC.VOO WHERE NUMERO='" + voo + "'";
    }

    @Override
    public final void stubBD() throws ErroPersistencia {
        if (erro == 0) {
            System.out.println("Removido com Sucesso!");
        } else if (erro == 1){
            throw new ErroCadastro("Voo não encontrado!");
        } else if (erro == 2) {
            throw new ErroPersistencia("Erro de Conexão com o Banco.");
        }
    }
}
