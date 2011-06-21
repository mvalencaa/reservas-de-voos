package br.com.negocio.controladoras;

import br.com.apresentacao.controladoras.CntrInteracaoCliente;
import br.com.apresentacao.controladoras.IInteracaoCliente;
import br.com.apresentacao.entidades.Cliente;
import br.com.negocio.comandos.CmdCadastrarCliente;
import br.com.negocio.comandos.CmdConsultarCliente;
import br.com.negocio.comandos.CmdEditarCliente;
import br.com.persistencia.controladoras.ErroPersistencia;
import br.com.persistencia.controladoras.IPersistencia;

/**
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.2
 */
public class CntrNegocioCliente implements INegocioCliente {

    /** Controladora de interação com cliente. */
    private IInteracaoCliente cntrInteracaoCliente;
    /** Controladora de persistência. */
    private IPersistencia cntrPersistencia;

    /**
     * Inicializa a controladora de interação com cliente.
     */
    public final void executar() {
        cntrInteracaoCliente = new CntrInteracaoCliente();
        cntrInteracaoCliente.setControladoraCliente(this);
    }

    /**
     * Seta a controladora de persistência.
     *
     * @param cntrPersistenciaCliente Controladora de persistência.
     */
    public final void setControladora(final IPersistencia
            cntrPersistenciaCliente) {
        this.cntrPersistencia = cntrPersistenciaCliente;
    }

    /**
     * Cadastra o cliente passado como parâmetro.
     *
     * @param cliente Cliente a ser cadastrado.
     *
     * @throws ErroPersistencia Exceção lançada na ocorrência de algum erro.
     */
    public final void cadastrar(final Cliente cliente) throws ErroCadastro {
        try {
            CmdCadastrarCliente cmd = new CmdCadastrarCliente(cliente);
            cntrPersistencia.executar(cmd);
        } catch (ErroPersistencia e) {
            throw new ErroCadastro("Erro ao tentar cadastrar o cliente " +
                    cliente.getNome() + e.getMessage());
        }
    }

    /**
     * Retorna o cliente com o CPF passado como parâmetro.
     *
     * @param cpf CPF do cliente.
     * @return Cliente com o CPF especificado.
     *
     * @throws ErroPersistencia Exceção lançada na ocorrência de algum erro.
     */
    public Cliente consultar(String cpf) throws ErroConsulta {
        try {
            CmdConsultarCliente cmd = new CmdConsultarCliente(cpf);
            cntrPersistencia.executar(cmd);
            return cmd.getResultado();
        } catch (ErroPersistencia e) {
            System.out.println(e.getMessage());
            throw new ErroConsulta("Erro ao tentar consultar o cpf " + cpf);
        }
    }

    /**
     * Altera os dados do cliente passado como parâmetro.
     *
     * @param cliente Cliente cujos dados serão alterados.
     *
     * @throws ErroPersistencia Exceção lançada na ocorrência de algum erro.
     */
    public void editar(Cliente cliente) throws ErroEdicao {
        try {
            CmdEditarCliente cmd = new CmdEditarCliente(cliente);
            cntrPersistencia.executar(cmd);
        } catch (ErroPersistencia e) {
            throw new ErroEdicao("Erro ao tentar editar os dados do" +
                    "cliente " + cliente.getNome());
        }
    }
}
