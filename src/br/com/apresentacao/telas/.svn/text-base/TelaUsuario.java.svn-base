package br.com.apresentacao.telas;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.2
 */
public class TelaUsuario extends JFrame {

    /** Rótulo para nome.*/
    protected JLabel labelNome;
    /** Rótulo para telefone.*/
    protected JLabel labelTelefone;
    /** Campo de texto para nome.*/
    protected JTextField fieldNome;
    /** Campo de texto para telefone.*/
    protected JTextField fieldTelefone;
    /** Botão salvar alterações.*/
    protected JButton botaoSalvar;
    /** Tamanho do campo de texto.*/
    private static final int FIELD_SIZE_1 = 13;
    /** Tamanho do campo de texto.*/
    private static final int FIELD_SIZE_2 = 20;

    /** Construtor. */
    public TelaUsuario() {
        initComponentes();
    }

    /** Inicializa componentes. */
    private void initComponentes() {

        labelNome = new JLabel("Nome:");
        labelTelefone = new JLabel("Telefone:");
        fieldNome = new JTextField(FIELD_SIZE_2);
        fieldTelefone = new JTextField(FIELD_SIZE_1);

        setLayout(new GridBagLayout());
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }


    /**Altera o campo Nome para mostrar o nome do cliente logado.
     * @param nome Nome do cliente.
     */
    public final void setFieldNome(final String nome) {
        this.fieldNome.setText(nome);
    }

    /**Altera o campo Telefone para mostrar o telefone do cliente logado.
     * @param telefone Telefone do cliente.
     */
    public final void setFieldTelefone(final String telefone) {
        this.fieldTelefone.setText(telefone);
    }
}
