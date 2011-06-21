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
public class CmdConsultarVagasVoo extends CmdConsultar {

    /** Trigger de Erro. */
    private static int erro = 0;
    /** Resultado a ser retornado. */
    private static int resultado;

    /**
     * Construtor da classe CmdConsultarVagasVoo.
     *
     * @param codigoVoo Código do voo.
     */
    public CmdConsultarVagasVoo(final String codigoVoo) {
        if (codigoVoo.equals("AAA111")) {
            erro = 1;
        } else if (codigoVoo.equals("BBB222")) {
            erro = 2;
        } else {
            erro = 0;
        }
        System.out.println(codigoVoo);
        comandoSQL = "SELECT NROVAGAS FROM VOO WHERE NUMERO='"
                + codigoVoo + "'";
    }

    /**
     * Retorna o resultado da consulta.
     *
     * @return resultado Resultado.
     */
    public final int getResultado() {
        return resultado;
    }

    @Override
    public final void stubBD() throws ErroPersistencia {
        if (erro == 0) {
            resultado = 1;
        } else if (erro == 1){
            resultado = 0;
        } else if (erro == 2) {
            throw new ErroPersistencia("Erro de Conexão com o Banco.");
        }
    }

    @Override
    public final void setResultado(final ResultSet resultSet)
            throws SQLException {
        if (resultSet.next()) {
            resultado = Integer.valueOf(resultSet.getString("NROVAGAS"));
        }
    }

}
