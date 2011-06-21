package br.com.negocio.controladoras;

import br.com.apresentacao.controladoras.CntrInteracaoFuncionario;
import br.com.apresentacao.controladoras.IInteracaoFuncionario;
import br.com.apresentacao.entidades.Funcionario;
import br.com.negocio.comandos.CmdCadastrarFuncionario;
import br.com.negocio.comandos.CmdConsultarFuncionario;
import br.com.negocio.comandos.CmdEditarFuncionario;
import br.com.persistencia.controladoras.ErroPersistencia;
import br.com.persistencia.controladoras.IPersistencia;

/**
 *
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.2
 */
public class CntrNegocioFuncionario implements INegocioFuncionario {

    /** Controladora de interação com funcionário. */
    private IInteracaoFuncionario cntrInteracaoFuncionario;
    /** Controladora de persistência. */
    private IPersistencia cntrPersistencia;

    /**
     * Inicializa as controladoras de interação com funcionário.
     */
    public final void executar() {
        cntrInteracaoFuncionario = new CntrInteracaoFuncionario();
        cntrInteracaoFuncionario.setControladoraFuncionario(this);
    }

    /**
     * Seta a controladora de persistência.
     *
     * @param cntr Controladora de persisência.
     */
    public final void setControladora(final IPersistencia cntr) {
        this.cntrPersistencia = cntr;
    }

    /**
     * Cadastra o funcionário passado como parâmetro.
     *
     * @param funcionario Funcionário a ser cadastrado.
     *
     * @throws ErroPersistencia Exceção lançada na ocorrência de algum erro.
     */
    public final void cadastrar(final Funcionario funcionario)
            throws ErroCadastro {
        try {
            CmdCadastrarFuncionario cmd = new
                    CmdCadastrarFuncionario(funcionario);
            cntrPersistencia.executar(cmd);
        } catch (ErroPersistencia e) {
            throw new ErroCadastro("Erro ao tentar cadastrar o" +
                    "funcionario " + funcionario.getNome());
        }
    }

    /**
     * Retorna o funcionário com a matrícula passada como parâmetro.
     *
     * @param matricula Matrícula do funcionário.
     * @return funcinoario Funcionário com a matrícula especificada.
     *
     * @throws ErroPersistencia Exceção lançada na ocorrência de algum erro.
     */
    public Funcionario consultar(String matric) throws ErroConsulta {
        try {
            CmdConsultarFuncionario cmd = new CmdConsultarFuncionario(matric);
            cntrPersistencia.executar(cmd);
            return cmd.getResultado();
        } catch (ErroPersistencia e) {
            throw new ErroConsulta("Erro ao tentar consultar a matrícula "
                    + matric);
        }
    }

    public void editar(Funcionario funcionario) throws ErroEdicao {
        try {
            CmdEditarFuncionario cmd = new CmdEditarFuncionario(funcionario);
            cntrPersistencia.executar(cmd);
        } catch(ErroPersistencia e) {
            throw new ErroEdicao("Erro ao tentar editar o funcionário "
                    + funcionario.getNome());
        }
    }
}
