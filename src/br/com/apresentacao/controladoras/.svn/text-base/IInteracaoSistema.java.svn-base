package br.com.apresentacao.controladoras;


/**
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.2
 */
public interface IInteracaoSistema extends ICntrInteracao {
    /** Novo cliente.*/
    void novoCliente();

    /** Cadastra novo cliente com os dados passados.
     * @param nome Nome do cliente.
     * @param cpf CPF do cliente.
     * @param telefone Telefone do Cliente.
     */
    void cadastrarNovoCliente(String nome, String cpf, String telefone);

    /** Novo funcionario.*/
    void novoFuncionario();

    /**Cadastra novo funcionario com os dados passados.
     * @param nome Nome do funcionário
     * @param matricula Matrícula do funcionario
     * @param telefone Telefone do funcionario.
     */
    void cadastrarNovoFuncionario(String nome, String matricula,
            String telefone);

    /**
     * Seta a controladora correspondente.
     *
     * @param cntrIFuncionario Controladora a ser setada.
     */
    void setCntrInteracaoFuncionario(IInteracaoFuncionario cntrIFuncionario);

    /**
     * Seta a controladora correspondente.
     *
     * @param cntrICliente Controladora a ser setada.
     */
    void setCntrInteracaoCliente(IInteracaoCliente cntrICliente);
}
