package br.com.apresentacao.entidades;

import br.com.apresentacao.validacao.ValidaData;
import br.com.apresentacao.validacao.ValidaHorario;
import br.com.apresentacao.validacao.ValidaNroVoo;

/**
 * Classe que representa um voo.
 *
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.1
 */
public class Voo {

    /** Numero máximo de vagas suportado por cada voo. */
    private int nroVagas;
    /** Numero do voo. */
    private final String numero;
    /** Hora de saida. */
    private String horaSaida;
    /** Hora de chegada. */
    private String horaChegada;
    /** Data de saida. */
    private String dataSaida;
    /** Data de chegada. */
    private String dataChegada;
    /** Aeroporto de saida. */
    private Aeroporto aeroportoSaida;
    /** Aeroporto de chegada. */
    private Aeroporto aeroportoChegada;

    public Voo(String numero) {
        this.numero = numero;
    }

    /**
     * Controi um novo voo.
     *
     * @param numero Numero do voo.
     * @param vagas Vagas do Voo.
     * @param horaSaida Hora de saida do voo.
     * @param horaChegada Hora de chegada do voo.
     * @param dataSaida Data de saida do voo.
     * @param dataChegada Data de chegada do voo.
     * @param aeroportoSaida Aeroporto de saida.
     * @param aeroportoChegada Aeroporto de chegada.
     */
    public Voo(final String numero, final int vagas,
            final String horaSaida, final String horaChegada,
            final String dataSaida, final String dataChegada,
            final Aeroporto aeroportoSaida,final Aeroporto aeroportoChegada) {
        this.numero = ValidaNroVoo.validar(numero);
        this.nroVagas = vagas;
        this.horaSaida = ValidaHorario.validar(horaSaida);
        this.horaChegada = ValidaHorario.validar(horaChegada);
        this.dataSaida = ValidaData.validar(dataSaida);
        this.dataChegada = ValidaData.validar(dataChegada);
        this.aeroportoSaida = aeroportoSaida;
        this.aeroportoChegada = aeroportoChegada;
    }

    /**
     * Retorna a data de chegada.
     * @return Data de chegada.
     */
    public final String getDataChegada() {
        return dataChegada;
    }

    /**
     * Altera a data de chegada.
     * @param dataChegada Nova data de chegada.
     */
    public final void setDataChegada(final String dataChegada) {
        this.dataChegada = ValidaData.validar(dataChegada);
    }

    /**
     * Retorna a data de saida.
     * @return Data de saida.
     */
    public final String getDataSaida() {
        return dataSaida;
    }

    /**
     * Altera a data de saida.
     * @param dataSaida Nova data de saida.
     */
    public final void setDataSaida(final String dataSaida) {
        this.dataSaida = ValidaData.validar(dataSaida);
    }

    /**
     * Retorna a data de chegada.
     * @return Data de chegada.
     */
    public final String getHoraChegada() {
        return horaChegada;
    }

    /**
     * Altera a hora de chegada.
     * @param horarioChegada Nova data de chegada.
     */
    public final void setHoraChegada(final String horarioChegada) {
        this.horaChegada = ValidaHorario.validar(horarioChegada);
    }

    /**
     * Retorna a hora de saida.
     * @return Hora de saida.
     */
    public final String getHoraSaida() {
        return horaSaida;
    }

    /**
     * Altera a hora de saida.
     * @param horarioSaida Nova data de saida.
     */
    public final void setHoraSaida(final String horarioSaida) {
        this.horaSaida = ValidaHorario.validar(horarioSaida);
    }

    /**
     * Retorna o numero do voo.
     * @return Numero do voo.
     */
    public final String getNumero() {
        return numero;
    }

    /**
     * Retorna o numero de vagas diponiveis no voo.
     * @return Numero de vagas disponiveis.
     */
    public final int getNroVagas() {
        return nroVagas;
    }

    /**
     * Altera o numero de vagas disponiveis.
     * @param nroVagas Novo numero de vagas.
     */
    public final void setNroVagas(final int nroVagas) {
        this.nroVagas = nroVagas;
    }

    /**
     * Retorna o aeroporto de chegada.
     * @return Aeroporto de chegada.
     */
    public final Aeroporto getAeroportoChegada() {
        return aeroportoChegada;
    }

    /**
     * Altera o aeroporto de chegada.
     * @param aeroportoChegada Novo aeroporto de chegada.
     */
    public final void setAeroportoChegada(final Aeroporto aeroportoChegada) {
        this.aeroportoChegada = aeroportoChegada;
    }

    /**
     * Retorna o aeroporto de saida.
     * @return Aeroporto de saida.
     */
    public final Aeroporto getAeroportoSaida() {
        return aeroportoSaida;
    }

    /**
     * Altera o aeroporto de saida.
     * @param aeroportoSaida Novo aeroporto de saida.
     */
    public final void setAeroportoSaida(final Aeroporto aeroportoSaida) {
        this.aeroportoSaida = aeroportoSaida;
    }

}
