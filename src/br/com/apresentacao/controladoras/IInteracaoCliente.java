package br.com.apresentacao.controladoras;

import br.com.apresentacao.entidades.Cliente;
import br.com.negocio.controladoras.INegocioCliente;
import br.com.negocio.controladoras.INegocioReserva;
import br.com.negocio.controladoras.INegocioVoos;

/**
 *
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.2
 */
public interface IInteracaoCliente extends ICntrInteracao {

    /**
     * Assinatur do metodo que seta a controladora.
     * @param cntrNegocioCliente Controladora de Clientes.
     */
    void setControladoraCliente(INegocioCliente cntrNegocioCliente);

    /**
     *
     * @param cntrNegocioReserva Controladora de Reservas.
     */
    void setControladoraReserva(INegocioReserva cntrNegocioReserva);

    /**
     *
     * @param cntrNegocioVoos Controladora de Voos.
     */
    void setControladoraVoos(INegocioVoos cntrNegocioVoos);

    /**
     * Realiza o login do cliente.
     *
     * @param cpf CPF do cliente utilizado no momento do login.
     */
    void login(String cpf);

    /**
     * Realiza as alterações realizadas pelo cliente.
     * @param cliente Cliente Nome do cliente.
     */
    void cadastrarCliente(Cliente cliente);

    /**
     * Realiza as alterações realizadas pelo cliente.
     * @param nome Nome do cliente.
     * @param telefone Telefone do cliente.
     * @param cpf CPF do Cliente.
     */
    void salvarAlteracoes(String nome, String telefone, String cpf);

    /**
     * Efetua uma reserva para o cliente.
     */
    void efetuarReserva();

    /**
     * Efetua uma reserva para o cliente.
     * @param voosSelecionados Voos selecionados.
     */
    void criarReserva(int []voosSelecionados);

    /**
     * Cancela uma reserva para o cliente.
     * @param reserva Reserva a ser cancelada.
     */
    void cancelarReserva(String reserva);

    /**
     * Lista as reservas para o cliente.
     */
    void listarReservas();

    /**
     * Lista os voos para o cliente.
     */
    void listarVoos();

    /**
     * Lista os voos para o cliente.
     */
    void consultarVoos();

    /**
     * Filtrar voos a partir das cidades de origem, destino e data.
     * @param cidadeOrigem Cidade de Origem.
     * @param cidadeDestino Cidade de Destino.
     * @param data Data de saída.
     */
    void filtrarVoos(String cidadeOrigem, String cidadeDestino, String data);
}
