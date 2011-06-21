package br.com.negocio.comandos;

import br.com.apresentacao.entidades.Voo;
import br.com.persistencia.controladoras.ErroPersistencia;

/**
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.2
 */
public class CmdEditarVoo extends CmdEditar {

    /** Trigger de Erro. */
    private static int erro = 0;

    /**
     * Construtor que recebe um novo Voo cujos atributos comporão
     * o comando SQL para edição no banco de dados.
     *
     * @param voo Voo a ser editado no banco de dados.
     */
    public CmdEditarVoo(final Voo voo) {
        if (voo.getNumero().equals("BBB222")) {
            erro = 1;
        } else {
            erro = 0;
        }
        if (voo == null) {
            throw new IllegalArgumentException("Voo não informado.");
        }
        comandoSQL = "UPDATE VOO SET"
                    + "(NROVAGAS, HORASAIDA, HORACHEGADA, DATASAIDA, "
                    + "DATACHEGADA)="
                    + "('" + voo.getNroVagas() + "',"
                    + "'" + voo.getHoraSaida() + "',"
                    + "'" + voo.getHoraChegada() + "',"
                    + "'" + voo.getDataSaida() + "',"
                    + "'" + voo.getDataChegada() + "') WHERE NUMERO = '"
                    + voo.getNumero() + "'";
    }

    @Override
    public void stubBD() throws ErroPersistencia {
        if (erro == 0) {
            System.out.println("Voo editado com Sucesso!");
        } else if (erro == 1){
            throw new ErroPersistencia("Erro de Conexão com o Banco.");
        }
    }
}
