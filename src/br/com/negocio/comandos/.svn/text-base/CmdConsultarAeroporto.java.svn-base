package br.com.negocio.comandos;

import br.com.apresentacao.entidades.Aeroporto;
import br.com.persistencia.controladoras.ErroPersistencia;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.2
 */
public class CmdConsultarAeroporto extends CmdConsultar {


    /** Lista de aeroportos a serem retornados. */
    private List<Aeroporto> resultado;

    /**Construtor.*/
    public CmdConsultarAeroporto() {
        comandoSQL = "SELECT * FROM AEROPORTO";
    }

    @Override
    public final void setResultado(final ResultSet resultSet)
            throws SQLException {
        resultado = new ArrayList<Aeroporto>();
        while (resultSet.next()) {
            String codigo = resultSet.getString("CODIGO");
            String cidade = resultSet.getString("CIDADE");
            Aeroporto aero = new Aeroporto(cidade, codigo);
            resultado.add(aero);
        }
    }

    /**
     * Retorna o resultado da query de consulta de aeroportos.
     *
     * @return resultado Resultado.
     */
    public final List<Aeroporto> getResultado() {
        return resultado;
    }

    @Override
    public final void stubBD() throws ErroPersistencia {
        resultado = new ArrayList<Aeroporto>();
        resultado.add(new Aeroporto("Braslia", "BSB"));
        resultado.add(new Aeroporto("Rio de Janeiro", "RJO"));
        resultado.add(new Aeroporto("Goiania", "GYN"));
    }

}
