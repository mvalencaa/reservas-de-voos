package br.com.negocio.comandos;

import br.com.persistencia.controladoras.ErroPersistencia;

/**
 *
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.2
 */
public class CmdCadastrarReservaVoo extends CmdCadastrar {

    /**
     * Comando responsável por cadastrar o relacionamento entre a reserva
     * criada e os voos existentes.
     *
     * @param reservaCod Código da reserva criada.
     * @param vooNro Número do voo escolhido.
     */
    public CmdCadastrarReservaVoo(final String reservaCod,
            final String vooNro) {
        System.out.println(reservaCod);
        System.out.println(vooNro);
        comandoSQL = "INSERT INTO RESERVA_VOO VALUES"
                + "('" + reservaCod + "',"
                + "'" + vooNro + "')";
    }

    @Override
    public void stubBD() throws ErroPersistencia {

    }
}
