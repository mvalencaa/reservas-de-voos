package br.com.negocio.controladoras;

import br.com.apresentacao.controladoras.CntrInteracaoCliente;
import br.com.apresentacao.controladoras.IInteracaoCliente;
import br.com.apresentacao.entidades.Reserva;
import br.com.apresentacao.entidades.Voo;
import br.com.negocio.comandos.CmdCadastrarReserva;
import br.com.negocio.comandos.CmdCadastrarReservaVoo;
import br.com.negocio.comandos.CmdConsultarQuantReservas;
import br.com.negocio.comandos.CmdConsultarReserva;
import br.com.negocio.comandos.CmdConsultarVagasVoo;
import br.com.negocio.comandos.CmdConsultarVoosReserva;
import br.com.negocio.comandos.CmdRemoverReserva;
import br.com.persistencia.controladoras.ErroPersistencia;
import br.com.persistencia.controladoras.IPersistencia;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.2
 */
public class CntrNegocioReserva implements INegocioReserva {

    /**Controladora de interacao Cliente.*/
    private IInteracaoCliente cntrInteracaoCliente;
    /**Controladora de persistencia cliente.*/
    private IPersistencia cntrPersistencia;

    /**
     * Inicializa as controladoras de interação com reserva.
     */
    public final void executar() {
        cntrInteracaoCliente = new CntrInteracaoCliente();
        cntrInteracaoCliente.setControladoraReserva(this);
    }

    /**
     * Seta a controladora de persistência.
     *
     * @param cntr Controladora de persistência.
     */
    public final void setControladora(final IPersistencia cntr) {
        this.cntrPersistencia = cntr;
    }

    /**
     * Retorna uma lista de reservas correspondentes com os parâmetros
     * passados.
     *
     * @param cpf CPF do cliente.
     * @return Lista de reservas do clente.
     *
     * @throws ErroPersistencia Exceção lançada na ocorrência de algum erro.
     */
    public final List<Reserva> consultarReservas(final String cpf)
            throws ErroConsulta {
        try {
            CmdConsultarReserva cmd = new CmdConsultarReserva(cpf);
            cntrPersistencia.executar(cmd);
            return cmd.getResultado();
        } catch (ErroPersistencia e) {
            throw new ErroConsulta("Erro ao consultar as reservas " +
                    "cadastradas para o CPF " + cpf + e.getMessage());
        }
    }

    /**
     * Cancela uma reserva cadastrada no sistema a partir de seu código.
     *
     * @param codigo Cógio da reserva a ser cancelada.
     *
     * @throws ErroPersistencia Exceção lançada na ocorrência de algum erro.
     */
    public void cancelarReserva(String codigo) throws ErroRemove {
        try {
            CmdRemoverReserva cmd = new CmdRemoverReserva(codigo);
            cntrPersistencia.executar(cmd);
        } catch (ErroPersistencia e) {
            throw new ErroRemove("Erro ao cancelar a reserva " + codigo);
        }
    }

    /**
     * Efetua uma nova reserva no sistema.
     *
     * @param reserva Nova reserva a ser cadastrada no sistema.
     *
     * @throws ErroPersistencia Exceção lançada na ocorrência de algum erro.
     */
    public void efetuarReserva(Reserva reserva) throws ErroCadastro {
        try {
            CmdConsultarQuantReservas cmd = new CmdConsultarQuantReservas(
                    reserva.getCpf());
            cntrPersistencia.executar(cmd);

            if (cmd.getResultado() < 2) {
                if (reserva.getVoos().size() < 6) {
                    CmdConsultarVagasVoo cmdVagas;

                    for (Voo voo : reserva.getVoos()) {
                        cmdVagas = new CmdConsultarVagasVoo(voo.getNumero());
                        cntrPersistencia.executar(cmdVagas);
                        if(cmdVagas.getResultado() == 0) {
                            throw new IllegalArgumentException(
                                    "Não há vagas no voo " + voo.getNumero());
                        }
                    }

                    CmdCadastrarReserva cmdCadastro = new CmdCadastrarReserva(
                        reserva);
                    cntrPersistencia.executar(cmdCadastro);

                    CmdCadastrarReservaVoo cmdCadastrarReservaVoo;
                    for(Voo voo : reserva.getVoos()) {
                        cmdCadastrarReservaVoo = new CmdCadastrarReservaVoo
                                (reserva.getCodigo(), voo.getNumero());
                        cntrPersistencia.executar(cmdCadastrarReservaVoo);
                    }
                } else {
                    throw new IllegalArgumentException("São permitidos no "
                            + "máximo 5 voos por cliente.");
                }
            } else {
                throw new IllegalArgumentException("São permitidas no máximo "
                        + "duas" + " reservas por cliente.");
            }

        } catch (ErroPersistencia e) {
            throw new ErroCadastro("Erro ao efetuar a reserva "
                    + reserva.getCodigo() + e.getMessage());
        }
    }

    /**
     * Retorna os códigos das reservas de um determinado cliente a partir de
     * seu CPF.
     *
     * @param cpf CPF do cliente.
     * @return Lista de cógidos das reservas cadastradas no sistema.
     *
     * @throws ErroPersistencia
     */
    public List<String> getCodigos(String cpf) throws ErroConsulta {
        try {
            List<String> codigos = new ArrayList<String>();
            CmdConsultarReserva cmd = new CmdConsultarReserva(cpf);
            cntrPersistencia.executar(cmd);

            for (Reserva reserva : cmd.getResultado()) {
                codigos.add(reserva.getCodigo());
            }

            return codigos;

        } catch (ErroPersistencia e) {
            throw new ErroConsulta("Erro ao tentar recuperar os códigos " +
                    "das reservas efetuadas para o CPF " + cpf);
        }
    }

    /**
     * Retorna uma lista de voos cadastrados no sistema a partir do código
     * de uma reserva.
     *
     * @param codReserva Código da reserva.
     * @return Lista de voos cadastrados na reserva correspondente ao código
     * passado.
     *
     * @throws ErroPersistencia Exceção lançada na ocorrência de algum erro.
     */
    public List<Voo> consultarVoosReserva(String codReserva)
            throws ErroConsulta {
        try {
            CmdConsultarVoosReserva cmd = new CmdConsultarVoosReserva(
                    codReserva);
            cntrPersistencia.executar(cmd);
            return cmd.getResultado();
        } catch (ErroPersistencia e) {
            throw new ErroConsulta("Erro ao tentar consultar os voos" +
                    "cadastrados para a reserva " + codReserva);
        }
    }

}
