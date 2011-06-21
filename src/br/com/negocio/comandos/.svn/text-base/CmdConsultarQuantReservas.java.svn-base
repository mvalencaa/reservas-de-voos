package br.com.negocio.comandos;

import br.com.persistencia.controladoras.ErroPersistencia;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.2
 */
public class CmdConsultarQuantReservas extends CmdConsultar {

    /**Trigger de Erro.*/
    private static int erro = 0;
    /**Resultado da Consulta.*/
    private static int resultado;

    /**
     * Construtor do comando.
     *
     * @param cpf CPF do cliente.
     */
    public CmdConsultarQuantReservas(final String cpf) {
        if (cpf.equals("00000000001")) {
            erro = 1;
        } else if (cpf.equals("12345123451")) {
            erro = 2;
        } else {
            erro = 0;
        }
        comandoSQL = "SELECT COUNT (*) FROM RESERVA WHERE "
                + "CLIENTE_CPF='" + cpf + "'";
    }

    /**
     * Retorna o número de reservas.
     *
     * @return resultado Resultado.
     */
    public final int getResultado() {
        return resultado;
    }

    @Override
    public final void setResultado(final ResultSet resultSet)
            throws SQLException {

        if (resultSet.next()) {
            int aux = resultSet.getInt(1);
            resultado = aux;
        }
        System.out.println("Passou!");
    }

    @Override
    public final void stubBD() throws ErroPersistencia {
        if (erro == 0) {
            resultado = 1;
        } else if (erro == 1){
            resultado = 2;
        } else if (erro == 2) {
            throw new ErroPersistencia("Erro de Conexão com o Banco.");
        }
    }
}
