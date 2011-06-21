package br.com.negocio.controladoras;

import br.com.apresentacao.entidades.Funcionario;
import br.com.persistencia.controladoras.IPersistencia;

/**
 *
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.2
 */
public interface INegocioFuncionario {

    /** Assinatura do método executar. */
    void executar();

    /**
     * Seta a controladora de persistência responsável.
     *
     * @param cntrPersistenciaFuncionario Controladora a ser setada.
     */
     void setControladora(IPersistencia cntrPersistenciaFuncionario);

    /**
     * Assinatura do método responsável por cadastrar um novo funcionário.
     *
     * @param funcionario Novo funcionário a ser cadastrado.
     */
    void cadastrar(Funcionario funcionario) throws ErroCadastro;

    /**
     * Assinatura do método responsável por editar um novo funcionário.
     *
     * @param funcionario Novo funcionário a ser cadastrado.
     */
    void editar(Funcionario funcionario) throws ErroEdicao;

    /**
     * Assinatura do método responsável por consultar um novo funcionário.
     *
     * @param matricula Funcionário a ser consultado.
     * @return Funcionario do banco de dados que possui dada matricula.
     */
    Funcionario consultar(String matricula) throws ErroConsulta;

}
