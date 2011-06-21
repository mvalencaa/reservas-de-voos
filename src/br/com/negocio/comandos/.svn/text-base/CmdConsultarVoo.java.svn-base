package br.com.negocio.comandos;

import br.com.apresentacao.entidades.Aeroporto;
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
public class CmdConsultarVoo extends CmdConsultar {

    /** Trigger de Erro. */
    private static int erro = 0;
    /** Lista de voos a ser retornada. */
    private List<Voo> resultado;

    /**
     * Construtor que recebe um novo Voo cujo os atributos comporão.
     * o comando SQL para consulta ao banco de dados.
     *
     * @param cidadeOrigem Cidade de Origem do Voo.
     * @param cidadeDestino Cidade de Destino do Voo.
     * @param dataSaida Data de saída do voo.
     * @throws ErroPersistencia Erro Persistencia.
     */
    public CmdConsultarVoo(final String cidadeOrigem,
            final String cidadeDestino, final String dataSaida)
            throws ErroPersistencia {
        if (dataSaida.equals("01/01/2001")) {
            erro = 1;
        } else if (dataSaida.equals("02/02/2002")) {
            erro = 2;
        } else {
            erro = 0;
        }
        if (cidadeOrigem.equals("") || cidadeDestino.equals("")
                || dataSaida.equals("")) {
            throw new ErroPersistencia("Voo não informado");
        }
        comandoSQL = "SELECT NUMERO, NROVAGAS, HORASAIDA, HORACHEGADA,"
                + "DATASAIDA, DATACHEGADA, DESTINO.CIDADE, DESTINO.CODIGO,"
                + "ORIGEM.CIDADE, ORIGEM.CODIGO "
                + "FROM VOO, AEROPORTO ORIGEM, AEROPORTO_SAIDA,"
                + "AEROPORTO DESTINO, AEROPORTO_CHEGADA "
                + "WHERE (VOO.NUMERO = AEROPORTO_SAIDA.VOO_NUMERO AND "
                + "VOO.NUMERO = AEROPORTO_CHEGADA.VOO_NUMERO AND "
                + "DESTINO.CODIGO = AEROPORTO_CHEGADA.AEROPORTO_CODIGO AND "
                + "ORIGEM.CODIGO = AEROPORTO_SAIDA.AEROPORTO_CODIGO AND "
                + "DESTINO.CIDADE = '" + cidadeDestino + "' AND "
                + "ORIGEM.CIDADE = '" + cidadeOrigem + "' AND "
                + "VOO.DATASAIDA = '" + dataSaida + "')";
    }

    public CmdConsultarVoo() {
        comandoSQL = "SELECT NUMERO, NROVAGAS, HORASAIDA, HORACHEGADA,"
                + "DATASAIDA, DATACHEGADA, DESTINO.CIDADE, DESTINO.CODIGO,"
                + "ORIGEM.CIDADE, ORIGEM.CODIGO "
                + "FROM VOO, AEROPORTO ORIGEM, AEROPORTO_SAIDA,"
                + "AEROPORTO DESTINO, AEROPORTO_CHEGADA "
                + "WHERE (VOO.NUMERO = AEROPORTO_SAIDA.VOO_NUMERO AND "
                + "VOO.NUMERO = AEROPORTO_CHEGADA.VOO_NUMERO AND "
                + "DESTINO.CODIGO = AEROPORTO_CHEGADA.AEROPORTO_CODIGO AND "
                + "ORIGEM.CODIGO = AEROPORTO_SAIDA.AEROPORTO_CODIGO)";
    }

    @Override
    public final void setResultado(final ResultSet resultSet)
            throws SQLException {
        resultado = new ArrayList<Voo>();

        while (resultSet.next()) {
            Voo voo = new Voo(resultSet.getString("NUMERO"));
            voo.setNroVagas(Integer.parseInt(resultSet.getString("NROVAGAS")));
            voo.setHoraSaida(resultSet.getString("HORASAIDA"));
            voo.setHoraChegada(resultSet.getString("HORACHEGADA"));
            voo.setDataSaida(resultSet.getString("DATASAIDA"));
            voo.setDataChegada(resultSet.getString("DATACHEGADA"));

            Aeroporto aeroportoChegada = new Aeroporto(
                    resultSet.getString("CIDADE"),
                    resultSet.getString("CODIGO"));
            Aeroporto aeroportoSaida = new Aeroporto(
                    resultSet.getString(9),
                    resultSet.getString(10));
            voo.setAeroportoSaida(aeroportoSaida);
            voo.setAeroportoChegada(aeroportoChegada);

            resultado.add(voo);
        }
    }

    /**
     * Retorna uma lista de voos encontrados da consulta realiza.
     *
     * @return resultado Lista de voos.
     */
    public List<Voo> getResultado() {
        return resultado;
    }

    @Override
    public void stubBD() throws ErroPersistencia {
        if (erro == 0) {
             resultado = new ArrayList<Voo>();
            Voo voo = new Voo("ZYA343", 8, "12:00:00", "18:00:00", "08/08/2010",
                    "08/08/2011", new Aeroporto("Campinas", "CAM"),
                    new Aeroporto("Mato Grosso", "MTG"));
            resultado.add(voo);
            voo = new Voo("UHE572", 5, "16:30:00", "18:00:00", "09/05/2010",
                    "06/03/2010", new Aeroporto("Natal", "NAT"),
                    new Aeroporto("São Paulo", "SPO"));
            resultado.add(voo);
            voo = new Voo("ABC237", 8, "12:00:00", "18:00:00", "08/08/2010",
                    "08/08/2011", new Aeroporto("Brasília", "BSB"),
                    new Aeroporto("Cabo Frio", "CBF"));
            resultado.add(voo);
            voo = new Voo("UHE572", 5, "16:30:00", "18:00:00", "09/05/2010",
                    "06/03/2010", new Aeroporto("Tocantinópolis", "TOC"),
                    new Aeroporto("São Paulo", "SPO"));
            resultado.add(voo);
            voo = new Voo("KRA378", 8, "21:30:00", "09:00:00", "10/10/2010",
                    "11/10/2010", new Aeroporto("Porto Seguro", "PSG"),
                    new Aeroporto("Porto Alegre", "PAL"));
            resultado.add(voo);
            voo = new Voo("OUT572", 5, "16:30:00", "18:00:00", "09/05/2010",
                    "06/03/2010", new Aeroporto("Rio de Janeiro", "RJO"),
                    new Aeroporto("Diamantina", "DIA"));
            resultado.add(voo);
        } else if (erro == 1){
            throw new ErroConsulta("Voo não encontrado!");
        } else if (erro == 2) {
            throw new ErroPersistencia("Erro de conexão com banco");
        }
    }
}
