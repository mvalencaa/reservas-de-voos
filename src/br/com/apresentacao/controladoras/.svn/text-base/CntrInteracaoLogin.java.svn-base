package br.com.apresentacao.controladoras;

import br.com.apresentacao.entidades.Cliente;
import br.com.apresentacao.entidades.Funcionario;
import br.com.apresentacao.telas.TelaNovoCliente;
import br.com.apresentacao.telas.TelaNovoFuncionario;
import javax.swing.JOptionPane;

/**
 *
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.2
 */
public class CntrInteracaoLogin implements IInteracaoSistema {

    /**Tela para criar novo Cliente.*/
    private TelaNovoCliente novoCliente;
    /**Tela para criar novo Funcionário.*/
    private TelaNovoFuncionario novoFuncionario;
    /**Controladora de apresentação funcionário.*/
    private IInteracaoFuncionario cntrInteracaoFuncionario;
    /**Controladora de apresentação Cliente.*/
    private IInteracaoCliente cntrInteracaoCliente;

    /**Executar.*/
    public final void executar() {
        novoCliente = new TelaNovoCliente();
        novoCliente.setControladora(this);

        novoFuncionario = new TelaNovoFuncionario();
        novoFuncionario.setControladora(this);
    }

    /**Deixa a tela de novo Cliente visível.*/
    public final void novoCliente() {
        novoCliente.setVisible(true);
    }

    /** Cadastra novo cliente com os dados passados.
     * @param nome Nome do cliente.
     * @param cpf CPF do cliente.
     * @param telefone Telefone do Cliente.
     */
    public final void cadastrarNovoCliente(final String nome, final String cpf,
            final String telefone) {
        try {
            Cliente cliente = new Cliente(nome, telefone, cpf);
            cntrInteracaoCliente.cadastrarCliente(cliente);
            novoCliente.dispose();
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**Torna a tela de novo funcionário visível.*/
    public final void novoFuncionario() {
        novoFuncionario.setVisible(true);
    }

    /**Cadastra novo funcionario com os dados passados.
     * @param nome Nome do funcionário
     * @param matricula Matrícula do funcionario
     * @param telefone Telefone do funcionario.
     */
    public final void cadastrarNovoFuncionario(final String nome,
            final String matricula, final String telefone) {
        try {
            Funcionario func = new Funcionario(nome, telefone, matricula);
            cntrInteracaoFuncionario.cadastrarFuncionario(func);
            novoFuncionario.dispose();
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Seta a controladora correspondente.
     *
     * @param cntrIFuncionario Controladora a ser setada.
     */
    public final void setCntrInteracaoFuncionario(final IInteracaoFuncionario
            cntrIFuncionario) {
        this.cntrInteracaoFuncionario = cntrIFuncionario;
    }

    /**
     * Seta a controladora correspondente.
     *
     * @param cntrICliente Controladora a ser setada.
     */
    public final void setCntrInteracaoCliente(final IInteracaoCliente
            cntrICliente) {
        this.cntrInteracaoCliente = cntrICliente;
    }
}
