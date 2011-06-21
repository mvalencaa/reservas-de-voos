package br.com.negocio.comandos;

import br.com.apresentacao.entidades.Aeroporto;
import br.com.apresentacao.entidades.Cliente;
import br.com.apresentacao.entidades.Reserva;
import br.com.apresentacao.entidades.Voo;
import br.com.negocio.controladoras.ErroConsulta;
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
public class CmdConsultarReserva extends CmdConsultar {

    /** Trigger de Erro. */
    private static int erro = 0;

    /** Reserva a ser retornada. */
    private List<Reserva> resultado;

    /**
     * Construtor do comando de consultar rservas.
     *
     * @param cpf CPF do cliente.
     */
    public CmdConsultarReserva(final String cpf) {
        if (cpf.equals("00000000000")) {
            erro = 1;
        } else if (cpf.equals("12345123451")) {
            erro = 2;
        } else {
            erro = 0;
        }
        comandoSQL = "SELECT RESERVA_CODIGO, NUMERO, NROVAGAS, HORASAIDA, "
                + "HORACHEGADA, DATASAIDA, DATACHEGADA, "
                + "ORIGEM.CODIGO, ORIGEM.CIDADE, DESTINO.CODIGO, "
                + "DESTINO.CIDADE, CPF, NOME, TELEFONE "
                + "FROM RESERVA, RESERVA_VOO, VOO, CLIENTE, AEROPORTO ORIGEM, "
                + "AEROPORTO_SAIDA, AEROPORTO DESTINO, AEROPORTO_CHEGADA WHERE "
                + "RESERVA.CODIGO = RESERVA_VOO.RESERVA_CODIGO AND "
                + "RESERVA_VOO.VOO_NUMERO = VOO.NUMERO AND "
                + "RESERVA.CLIENTE_CPF = CLIENTE.CPF AND "
                + "VOO.NUMERO = AEROPORTO_CHEGADA.VOO_NUMERO AND "
                + "VOO.NUMERO = AEROPORTO_SAIDA.VOO_NUMERO AND "
                + "DESTINO.CODIGO = AEROPORTO_CHEGADA.AEROPORTO_CODIGO AND "
                + "ORIGEM.CODIGO = AEROPORTO_SAIDA.AEROPORTO_CODIGO AND "
                + "RESERVA.CLIENTE_CPF = '" + cpf + "'";
    }

    @Override
    public final void setResultado(final ResultSet resultSet)
            throws SQLException {

        List<Voo> voos = new ArrayList<Voo>();

        String codigo;
        String codigoAnterior = null;
        Reserva reserva = null;
        resultado = new ArrayList<Reserva>();

        while (resultSet.next()) {

            codigo = resultSet.getString("RESERVA_CODIGO");

            voos = new ArrayList<Voo>();

            Voo voo = new Voo(resultSet.getString("NUMERO"));

            voo.setNroVagas(resultSet.getInt("NROVAGAS"));

            voo.setHoraSaida(resultSet.getString("HORASAIDA"));
            voo.setHoraChegada(resultSet.getString("HORACHEGADA"));
            voo.setDataSaida(resultSet.getString("DATASAIDA"));
            voo.setDataChegada(resultSet.getString("DATACHEGADA"));

            Aeroporto aeroportoSaida = new Aeroporto(
                    resultSet.getString("CIDADE"),
                    resultSet.getString("CODIGO"));
            Aeroporto aeroportoChegada = new Aeroporto(
                    resultSet.getString(11),
                    resultSet.getString(10));

            voo.setAeroportoSaida(aeroportoSaida);
            voo.setAeroportoChegada(aeroportoChegada);

            voos.add(voo);

            String cpf = resultSet.getString("CPF");
            String nome = resultSet.getString("NOME");
            String telefone = resultSet.getString("TELEFONE");

            Cliente cliente = new Cliente(nome, telefone, cpf);
           
            if((codigoAnterior != null) && (codigoAnterior.equals(codigo))) {
                reserva.addVoo(voo);
            } else {
                reserva = new Reserva(codigo, voos, cliente);
                resultado.add(reserva);
            }

            codigoAnterior = codigo;
        }

    }

    /**
     * Retorna resultado da pesquisa.
     *
     * @return resultado Resultado.
     */
    public final List<Reserva> getResultado() {
        return resultado;
    }

    @Override
    public final void stubBD() throws ErroPersistencia {
        if (erro == 0) {
            resultado = new ArrayList<Reserva>();
            List<Voo> voos = new ArrayList<Voo>();
            Cliente cliente = new Cliente("Michael Jackson", "6192867743",
                "10987654321");
            Voo voo = new Voo("ABC123", 10, "12:00:00", "18:00:00",
                    "08/08/2010", "08/08/2011",
                    new Aeroporto("Brasília", "BSB"),
                    new Aeroporto("Rio de Janeiro", "RJO"));
            voos.add(voo);
            voo = new Voo("PEA358", 11, "12:00:00", "18:00:00", "08/08/2010",
                    "08/08/2011", new Aeroporto("Belo Horizonte", "BHO"),
                    new Aeroporto("São Paulo", "SPO"));
            voos.add(voo);
            resultado.add(new Reserva("12345", voos, cliente));
        } else if (erro == 1){
            throw new ErroConsulta("Reserva não encontrada!");
        } else if (erro == 2) {
            throw new ErroPersistencia("Erro de Conexão com o Banco.");
        }
    }
}
