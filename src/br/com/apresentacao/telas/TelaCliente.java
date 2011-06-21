package br.com.apresentacao.telas;

import br.com.apresentacao.controladoras.CntrInteracaoCliente;
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
public class TelaCliente extends TelaUsuario {

    /** Rótulo CPF. */
    private JLabel labelCpf;
    /** Campo de texto para inserção de CPF. */
    private JTextField fieldCpf;
    /** Botão para listar reservas. */
    private JButton botaoReservas;
    /** Botão para listar voos. */
    private JButton botaoListarVoos;
    /** Controladora do módulo de interação. */
    private CntrInteracaoCliente cntrInteracao;
    /** Tamanho da Fonte.*/
    private static final int FONT_SIZE = 14;
    /** Tamanho do campo.*/
    private static final int FIELD_SIZE = 13;
    /** Parte de cima da Borda.*/
    private static final int BORDER_TOP = 5;
    /** Parte de baixo da Borda.*/
    private static final int BORDER_SIDE = 8;

    /** Construtor da Tela Cliente.*/
    public TelaCliente() {
        setTitle("Sistema de Reserva de Voos - Cliente");
        initComponentes();
    }

    /** Inicializa componentes da tela cliente.*/
    private void initComponentes() {

        labelCpf = new JLabel("CPF:");
        fieldCpf = new JTextField(FIELD_SIZE);
        botaoSalvar = new JButton("Salvar Alterações");
        botaoSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                cntrInteracao.salvarAlteracoes(fieldNome.getText(),
                        fieldTelefone.getText(), fieldCpf.getText());
            }
        });

        botaoReservas = new JButton("Reservas");
        botaoReservas.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                cntrInteracao.listarReservas();
            }
        });

        botaoListarVoos = new JButton("Voos");
        botaoListarVoos.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                cntrInteracao.listarVoos();
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
        add(labelCpf, gbc);

        gbc.gridy = 1;
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        add(fieldCpf, gbc);

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

        gbc.gridy = 2 + 2;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        add(botaoReservas, gbc);

        gbc.gridy = 2 + 2;
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        add(botaoListarVoos, gbc);

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
     * Seta a controladora de Interecao para Cliente.
     * @param cntr Controladora
     */
    public final void setControladora(final CntrInteracaoCliente cntr) {
        this.cntrInteracao = cntr;
    }

    /**
     * Muda o campo Cpf para mostrar o cpf do cliente que acabou de logar.
     * @param cpf CPF do Cliente, após logar o CPF nao pode ser alterado.
     */
    public final void setFieldCpf(final String cpf) {
        this.fieldCpf.setText(cpf);
        /*Assegura que o cpf nao pode ser alterado.*/
        this.fieldCpf.setEditable(false);
    }
}
