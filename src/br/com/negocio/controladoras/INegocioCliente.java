package br.com.negocio.controladoras;

import br.com.apresentacao.entidades.Cliente;
import br.com.persistencia.controladoras.IPersistencia;

/**
 *
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.2
 */
public interface INegocioCliente {

    /** Assinatura do método executar. */
    void executar();

    /**
     * Seta a controladora de persistência responsável.
     *
     * @param cntrPersistenciaCliente Controladora a ser setada.
     */
    void setControladora(IPersistencia cntrPersistenciaCliente);

    /**
     * Assinatura do método responsável por cadastrar um cliente.
     *
     * @param cliente Cliente a ser cadastrado.
     * @throws ErroCadastro Exceção a ser lançada na ocorrência de um erro.
     */
    void cadastrar(Cliente cliente) throws ErroCadastro;

    /**
     * Assinatura do método responsável por cadastrar um cliente.
     *
     * @param cliente Cliente a ser cadastrado.
     */
    void editar(Cliente cliente) throws ErroEdicao;

    /**
     * Assinatura do método responsável por retornar um cliente.
     *
     * @param cpf Cliente a ser consultado.
     * @return Cliente retornado.
     */
    Cliente consultar(String cpf) throws ErroConsulta;

}
