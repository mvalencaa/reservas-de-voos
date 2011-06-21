package br.com.apresentacao.telas;

import br.com.apresentacao.controladoras.CntrInteracaoCliente;
import br.com.apresentacao.controladoras.CntrInteracaoFuncionario;
import br.com.apresentacao.controladoras.IInteracaoCliente;
import br.com.apresentacao.controladoras.IInteracaoFuncionario;
import br.com.apresentacao.controladoras.IInteracaoSistema;
import br.com.negocio.builders.BuilderInteracaoTelaLogin;
import br.com.negocio.builders.BuilderNegocioCliente;
import br.com.negocio.builders.BuilderNegocioFuncionario;
import br.com.persistencia.controladoras.ErroPersistencia;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.2
 */
public class TelaDeLogin extends JFrame {

    /** Rótulo Login.*/
    private JLabel labelLogin;
    /** Rótulo CPF/Matricula. */
    private JLabel labelCpfMatr;
    /** Campo de texto login.*/
    private JTextField campoLogin;
    /** Botão de seleção do Cliente.*/
    private JRadioButton radioCliente;
    /** Botão de seleção do Funcionário.*/
    private JRadioButton radioFuncionario;
    /** Botão entrar.*/
    private JButton botaoEntrar;
    /** Barra de menu. */
    private BarraDeMenu barraDeMenu;
    /** Tela de Login.*/
    private static TelaDeLogin telaDeLogin;
    /** Controladora Cliente. */
    private static IInteracaoCliente cntrCliente;
    /** Controladora Funcionário. */
    private static IInteracaoFuncionario cntrFuncionario;
    /** Controladora de Login.*/
    private IInteracaoSistema cntrLogin;
    /** Tamanho da Fonte.*/
    private static final int FONT_SIZE = 14;
    /** Tamanho do campo.*/
    private static final int FIELD_SIZE = 13;
    /** Parte de cima da Borda.*/
    private static final int BORDER_TOP = 5;
    /** Parte de baixo da Borda.*/
    private static final int BORDER_SIDE = 8;

    /** Construtor. */
    public TelaDeLogin() {
        super("Login");
        initComponentes();
    }

    /** Inicializa componentes da tela de login. */
    private void initComponentes() {

        barraDeMenu = new BarraDeMenu();
        barraDeMenu.getItemFuncionario().addActionListener(new ActionListener()
        {
            public void actionPerformed(final ActionEvent evt) {
                cntrLogin.setCntrInteracaoFuncionario(cntrFuncionario);
                cntrLogin.executar();
                cntrLogin.novoFuncionario();
            }
        });
        barraDeMenu.getItemCliente().addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                cntrLogin.setCntrInteracaoCliente(cntrCliente);
                cntrLogin.executar();
                cntrLogin.novoCliente();
            }
        });
        barraDeMenu.getItemSair().addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                dispose();
            }
        });
        setJMenuBar(barraDeMenu);

        labelLogin = new JLabel("Login:");
        labelCpfMatr = new JLabel("CPF/Matrícula:");
        campoLogin = new JTextField(FIELD_SIZE);

        radioCliente = new JRadioButton("Cliente");
        radioCliente.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                if (radioCliente.isSelected()) {
                    radioFuncionario.setSelected(false);
                }
            }
        });

        radioFuncionario = new JRadioButton("Funcionário");
        radioFuncionario.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                if (radioFuncionario.isSelected()) {
                    radioCliente.setSelected(false);
                }
            }
        });

        botaoEntrar = new JButton("Entrar");
        botaoEntrar.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {

                try {
                    if (radioFuncionario.isSelected()) {
                        cntrFuncionario.executar();
                        cntrFuncionario.login(campoLogin.getText());
                    } else if (radioCliente.isSelected()) {
                        cntrCliente.executar();
                        cntrCliente.login(campoLogin.getText());
                    }
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Erro",
                            JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        setLayout(new GridBagLayout());

        ((JComponent) getContentPane()).setBorder(new EmptyBorder(BORDER_TOP,
                BORDER_SIDE, 0, BORDER_SIDE));

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(2, 2, 2, 2);

        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        labelLogin.setFont(new Font("SansSerif", Font.BOLD, FONT_SIZE));
        labelLogin.setBorder(new EmptyBorder(0, 0, BORDER_TOP, 0));
        add(labelLogin, gbc);

        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        add(radioCliente, gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        add(radioFuncionario, gbc);

        gbc.gridy = 1;
        gbc.gridx = 2 + 1;
        gbc.gridwidth = 1;
        add(labelCpfMatr, gbc);

        gbc.gridy = 2;
        gbc.gridx = 2 + 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(campoLogin, gbc);

        gbc.gridy = 2 + 2;
        gbc.gridx = 2 + 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(botaoEntrar, gbc);

        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     *
     * @param cntr Controladora Cliente.
     */
    public final void setControladoraCliente(final IInteracaoCliente cntr) {
        cntrCliente = cntr;
    }

    /**
     *
     * @param cntr Controladora de Interacao com Funcionário.
     */
    public final void setControladoraFuncionario(
            final IInteracaoFuncionario cntr) {
        cntrFuncionario = cntr;
    }

    /**
     * Seta controladora.
     * @param cntr Controladora.
     */
    public final void setControladora(final IInteracaoSistema cntr) {
        this.cntrLogin = cntr;
    }

     /** Método Main.
      * @param args Argumentos passados via linha de comando.
      */
    public static void main(final String[] args) {
        telaDeLogin = new TelaDeLogin();
        cntrCliente = new CntrInteracaoCliente();
        cntrFuncionario = new CntrInteracaoFuncionario();
        telaDeLogin.setControladora(BuilderInteracaoTelaLogin.criar(cntrCliente,
                cntrFuncionario));
        try {
            BuilderNegocioCliente.criar(cntrCliente);
            BuilderNegocioFuncionario.criar(cntrFuncionario);
        } catch (ErroPersistencia ex) {
            System.out.println(ex.getMessage());
        }
    }
}
