package br.com.apresentacao.telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.2
 */
public class BarraDeMenu extends JMenuBar {

    /** Item Menu do menu principal. */
    private JMenu menu;
    /** Item Novo do menu principal. */
    private JMenu novo;
    /** Item de menu de sair. */
    private JMenuItem sair;
    /** Item de menu de sobre. */
    private JMenuItem sobre;
    /** Item de menu de sobre. */
    private JMenuItem cliente;
    /** Item de menu de sobre. */
    private JMenuItem funcionario;
    /** Mensagem sobre. */
    private StringBuilder msg;

    /** Construtor. */
    public BarraDeMenu() {
        initComponentes();
    }

    /**Inicializa os componentes.*/
    private void initComponentes() {
        String msgInicial = "Trabalho de Programação Orientada a Objetos\n";
        String nome1 = "\nBruno Pessanha de Carvalho";
        String nome2 = "\nMarcela Gomes Correa";
        String nome3 = "\nMarcelo Valença de Almeida";
        msg = new StringBuilder();
        msg.append(msgInicial);
        msg.append(nome1);
        msg.append(nome2);
        msg.append(nome3);
        menu = new JMenu("Menu");

        sair = new JMenuItem("Sair");
        sair.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {

            }
        });

        sobre = new JMenuItem("Sobre");
        sobre.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                JOptionPane.showMessageDialog(null, msg);
            }
        });

        menu.add(sobre);
        menu.add(sair);
        novo = new JMenu("Novo");

        cliente = new JMenuItem("Cliente");
        funcionario = new JMenuItem("Funcionario");

        novo.add(cliente);
        novo.add(funcionario);

        this.add(menu);
        this.add(novo);
    }

    /** Habilita o item de menu "Menu".*/
    public final void setMenuEnabled() {
        menu.setEnabled(true);
    }

    /** Habilita o item de menu "Novo".*/
    public final void setNovoEnabled() {
        novo.setEnabled(true);
    }

    /** Acessor o item de menu cliente.
     * @return cliente Menu item de Cliente.
     */
    public final JMenuItem getItemCliente() {
        return cliente;
    }

    /** Acessor o item de menu funcionário.
     * @return funcionario Menu item de Funcionário.
     */
    public final JMenuItem getItemFuncionario() {
        return funcionario;
    }

    /** Acessor o item de menu sair.
     * @return sair Menu item de sair.
     */
    public final JMenuItem getItemSair() {
        return sair;
    }
}
