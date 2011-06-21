package br.com.negocio.comandos;

import br.com.negocio.controladoras.ErroCadastro;
import br.com.persistencia.controladoras.ErroPersistencia;

/**
 *
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.2
 */
public class CmdRemoverReserva extends CmdRemover {

    /**Trigger de Erro.*/
    private static int erro = 0;

    /**
     * Construtor que recebe o código da reserva que comporá o comando
     * SQL para inserção no banco de dados.
     *
     * @param codigo String que contém o código da reserva a ser removida.
     */
    public CmdRemoverReserva(final String codigo) {
        if (codigo.equals("00000")) {
            erro = 1;
        } else if (codigo.equals("54321")) {
            erro = 2;
        } else {
            erro = 0;
        }
        if (codigo == null) {
            throw new IllegalArgumentException("Reserva não informada.");
        }
        comandoSQL = "DELETE FROM PUBLIC.RESERVA WHERE CODIGO='"
                + codigo + "'";
    }

    @Override
    public final void stubBD() throws ErroPersistencia {
        if (erro == 0) {
            System.out.println("Reserva removida com ssucesso!");
        } else if (erro == 1){
            throw new ErroCadastro("Reserva não encontrada!");
        } else if (erro == 2) {
            throw new ErroPersistencia("Erro de Conexão com o Banco.");
        }
    }

}
