package br.com.negocio.comandos;

import br.com.apresentacao.entidades.Reserva;
import br.com.negocio.controladoras.ErroCadastro;
import br.com.persistencia.controladoras.ErroPersistencia;

/**
 *
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.2
 */
public class CmdCadastrarReserva extends CmdCadastrar {

    /**Trigger de Erro.*/
    private static int erro = 0;

    /**
     * Construtor que recebe uma nova reserva cujo os atributos comporão.
     * o comando SQL para inserção no banco de dados.
     *
     * @param reserva um objeto que contém os atributos a serem inseridos.
     */
    public CmdCadastrarReserva(final Reserva reserva) {
        if (reserva.getCodigo().equals("00000")) {
            erro = 1;
        } else if (reserva.getCodigo().equals("54321")) {
            erro = 2;
        } else {
            erro = 0;
        }
        if (reserva == null) {
            throw new IllegalArgumentException("Reserva não informada.");
        }
        System.out.println(reserva.getCodigo());
        System.out.println(reserva.getCpf());
        comandoSQL = "INSERT INTO RESERVA VALUES"
                + "('" + reserva.getCodigo() + "',"
                + "'" + reserva.getCpf() + "')";
    }

    @Override
    public final void stubBD() throws ErroPersistencia {
        if (erro == 0) {
            System.out.println("Reserva Cadastrada com Sucesso!");
        } else if (erro == 1){
            throw new ErroCadastro("Reserva já cadastrada!");
        } else if (erro == 2) {
            throw new ErroPersistencia("Erro de Conexão com o Banco.");
        }
    }
}
