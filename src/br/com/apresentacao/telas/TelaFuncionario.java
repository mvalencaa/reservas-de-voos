package br.com.apresentacao.telas;

import br.com.apresentacao.controladoras.IInteracaoFuncionario;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.2
 */
public class TelaFuncionario extends TelaUsuario {

    /**Referencia para esta tela.*/
    private static TelaFuncionario referencia = null;
    /** Rótulo para matrícula. */
    private JLabel labelMatricula;
    /** Campo de texto para matrícula. */
    private JTextField fieldMatricula;
    /** Botão para adicionar voos. */
    private JButton botaoCadastrarVoos;
    /** Botão para acessar menu de Aeroportos. */
    private JButton botaoAeroporto;
    /** Controladora do módulo de interação. */
    private IInteracaoFuncionario cntrInteracao;
    /** Tamanho do campo.*/
    private static final int FIELD_SIZE = 13;
    /** Parte de cima da Borda.*/
    private static final int BORDER_TOP = 5;
    /** Parte de baixo da Borda.*/
    private static final int BORDER_SIDE = 8;

    /** Construtor. */
    public TelaFuncionario() {
        setTitle("Sistema de Reserva de Voos - Funcionário");
        initComponentes();
    }

    /** Inicializa componentes.*/
    private void initComponentes() {

        labelMatricula = new JLabel("Matrícula:");
        fieldMatricula = new JTextField(FIELD_SIZE);
        botaoSalvar = new JButton("Salvar Alterações");
        botaoSalvar = new JButton("Salvar Alterações");
        botaoSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                cntrInteracao.salvarAlteracoes(fieldNome.getText(),
                        fieldTelefone.getText(), fieldMatricula.getText());
            }
        });

        botaoCadastrarVoos = new JButton("Voos");
        botaoCadastrarVoos.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                cntrInteracao.listarVoo();
            }
        });

        botaoAeroporto = new JButton("Aeroportos");
        botaoAeroporto.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                cntrInteracao.listarAeroporto();
            }
        });

        ((JComponent) getContentPane()).setBorder(new EmptyBorder(BORDER_TOP,
            BORDER_SIDE, 0, BORDER_SIDE));

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(2, 2, 2, 2);

        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        labelNome.setBorder(new EmptyBorder(0, 0, BORDER_TOP, 0));
        add(labelNome, gbc);

        gbc.gridy = 0;
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        add(fieldNome, gbc);

        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        add(labelMatricula, gbc);

        gbc.gridy = 1;
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        add(fieldMatricula, gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        add(labelTelefone, gbc);

        gbc.gridy = 2;
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        add(fieldTelefone, gbc);

        gbc.gridy = 2 + 1;
        gbc.gridx = 2;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(botaoSalvar, gbc);

        gbc.gridy = 2 + 1;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        add(botaoCadastrarVoos, gbc);

        gbc.gridy = 2 + 1;
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        add(botaoAeroporto, gbc);

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**Seta controladora de Interacao.
     *
     * @param cntrInteracaoFunc Controladora.
     */
    public final void setControladora(final IInteracaoFuncionario
            cntrInteracaoFunc) {
        this.cntrInteracao = cntrInteracaoFunc;
    }

    /**Muda o campo Matricula para mostrar a matricula do funcionario.
     * @param matricula Matricula do funcionario, não poderá ser alterada
     * depois do login.
     */
    public final void setFieldMatricula(final String matricula) {
        this.fieldMatricula.setText(matricula);
        /*Assegura que o cpf nao pode ser alterado.*/
        this.fieldMatricula.setEditable(false);
    }
}
