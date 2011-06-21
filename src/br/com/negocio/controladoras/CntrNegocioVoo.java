package br.com.negocio.controladoras;

import br.com.apresentacao.controladoras.CntrInteracaoCliente;
import br.com.apresentacao.controladoras.IInteracaoCliente;
import br.com.apresentacao.entidades.Voo;
import br.com.negocio.comandos.CmdConsultarVoo;
import br.com.persistencia.controladoras.ErroPersistencia;
import br.com.persistencia.controladoras.IPersistencia;
import java.util.List;

/**
 *
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.2
 */
public class CntrNegocioVoo implements INegocioVoos {

    /**Controladora de interacao Cliente.*/
    private IInteracaoCliente cntrInteracaoCliente;
    /** Controladora de persistência. */
    protected IPersistencia cntrPersistencia;


    /**
     * Executar.
     */
    public final void executar() {
        cntrInteracaoCliente = new CntrInteracaoCliente();
        cntrInteracaoCliente.setControladoraVoos(this);
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
     * Retorna uma lista de voos especificados correspondentes com a cidade de
     * origem, cidade de destino e data de saída.
     *
     * @param cidadeOrigem Cidade de origem do voo.
     * @param cidadeDestino Cidade de destino do voo.
     * @param dataSaida Data de saída do voo.
     * @return Lista de voos correspondentes cadastrados no sistema.
     *
     * @throws ErroPersistencia Exceção lançada na ocorrência de algum erro.
     */
    public final List<Voo> consultarVoos(final String cidadeOrigem,
            final String cidadeDestino, final String dataSaida)
            throws ErroConsulta {
        try {
            CmdConsultarVoo cmd = new CmdConsultarVoo(
                    cidadeOrigem, cidadeDestino, dataSaida);
            cntrPersistencia.executar(cmd);
            return cmd.getResultado();
        } catch (ErroPersistencia e) {
            throw new ErroConsulta("Erro ao tentar consultar os voos" +
                    " cadastrados para a data de saida " + dataSaida);
        }
    }

    /**
     * Retorna uma lista de todos os voos cadastrados no sistema.
     *
     * @return Lista de todos os voos cadastrados no sistema.
     *
     * @throws ErroPersistencia Exceção lançada na ocorrência de algum erro.
     */
    public List<Voo> consultarVoos() throws ErroConsulta {
        try {
            CmdConsultarVoo cmd = new CmdConsultarVoo();
            cntrPersistencia.executar(cmd);
            return cmd.getResultado();
        } catch (ErroPersistencia e) {
            throw new ErroConsulta("Erro ao tentar consultar os voos do" +
                    " sistema." + e.getMessage());
        }
    }


}
