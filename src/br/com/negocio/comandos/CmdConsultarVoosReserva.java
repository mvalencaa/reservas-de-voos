package br.com.negocio.comandos;

import br.com.apresentacao.entidades.Aeroporto;
import br.com.apresentacao.entidades.Voo;
import br.com.negocio.controladoras.ErroConsulta;
import br.com.persistencia.controladoras.ErroPersistencia;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.2
 */
public class CmdConsultarVoosReserva extends CmdConsultarVoo {

    /**Trigger de Erro.*/
    private static int erro = 0;
    /** Lista de voos a ser retornada. */
    private List<Voo> resultado;

    /**
     * Construtor que recebe um código de reserva como parametro e busca todos
     * os voos que estão cadastrados nessa reserva.
     *
     * @param codReserva Código da reserva que será consultada.
     */
    public CmdConsultarVoosReserva(final String codReserva) {
        if (codReserva.equals("54321")) {
            erro = 1;
        } else {
            erro = 0;
        }
        if (codReserva == null) {
            throw new IllegalArgumentException("CPF não informado");
        }
        comandoSQL = "SELECT * FROM PUBLIC.RESERVA"
                + "WHERE RESERVA.CODIGO = '" + codReserva + "'";
    }

    @Override
    public final List<Voo> getResultado() {
        return resultado;
    }

    @Override
    public final void stubBD() throws ErroPersistencia {
        if (erro == 1) {
            throw new ErroConsulta("Erro de conexão com Banco");
        } else {
            resultado = new ArrayList<Voo>();
            Voo voo = new Voo("ABC237", 8, "12:00:00", "18:00:00", "08/08/2010",
                    "08/08/2011", new Aeroporto("Brasília", "BSB"),
                    new Aeroporto("Cabo Frio", "CBF"));
            resultado.add(voo);
            voo = new Voo("UHE572", 5, "16:30:00", "18:00:00", "09/05/2010",
                    "06/03/2010", new Aeroporto("Tocantinópolis", "TOC"),
                    new Aeroporto("São Paulo", "SPO"));
            resultado.add(voo);
        }

    }

}
