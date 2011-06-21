package br.com.negocio.controladoras;

import br.com.apresentacao.entidades.Reserva;
import br.com.apresentacao.entidades.Voo;
import br.com.persistencia.controladoras.IPersistencia;
import java.util.List;

/**
 *
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.2
 */
public interface INegocioReserva {

    /**Executar.*/
    void executar();

    /**
     * Seta a controladora de persistência responsável.
     *
     * @param cntrPersistenciaCliente Controladora a ser setada.
     */
    void setControladora(IPersistencia cntrPersistenciaCliente);

    /**
     * Assinatura do método responsável por retornar uma lista de
     * reservas pertencentes a determinado cliente.
     *
     * @param cpf CPF do cliente.
     * @return Lista de reservas
     * @throws ErroConsulta Exceção a ser lançada na ocorrência de um erro.
     */
    List<Reserva> consultarReservas(String cpf) throws ErroConsulta;

    /**
     * Assinatura do método responsável por cancelar uma reserva.
     * @param codigo Código da reserva.
     */
    void cancelarReserva(String codigo) throws ErroRemove;

    /**
     * Assinatura do método responsável por efetuar uma reserva.
     * @param reserva Reserva.
     */
    void efetuarReserva(Reserva reserva) throws ErroCadastro;

    /**
     * Assinatura do método responsável por retornar uma lista de
     * códigos das reservas.
     *
     * @param cpf CPF do cliente.
     * @return Lista de códigos de reserva.
     */
    List<String> getCodigos(String cpf) throws ErroConsulta;

    /**
     * Assinatura do método responsável por retornar uma lista de
     * voos de uma reserva
     *
     * @param codReserva Código de uma Reserva.
     * @return Lista de voos.
     */
    List<Voo> consultarVoosReserva(String codReserva) throws ErroConsulta;
}
