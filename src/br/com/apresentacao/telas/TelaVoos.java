/*
 * TelaVoos.java
 *
 * Created on 12/07/2010, 20:45:09
 */

package br.com.apresentacao.telas;

import br.com.apresentacao.controladoras.IInteracaoCliente;
import br.com.apresentacao.controladoras.IInteracaoFuncionario;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NetBeans
 * @version 0.2
 */
public class TelaVoos extends javax.swing.JFrame {

    /** Controladora do módulo de interação. */
    private IInteracaoCliente cntrInteracaoCliente;
    /** Controladora do módulo de interação. */
    private IInteracaoFuncionario cntrInteracaoFuncionario;

    /** Creates new form TelaVoos.*/
    public TelaVoos() {
        super("Listagem dos Voos");
        initComponents();
        setLocationRelativeTo(null);
        setModel();
        jButton4.setEnabled(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Selecione o voo que deseja editar ou os voos que deseja excluir:");

        jButton1.setText("Incluir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Excluir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Editar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Consultar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 289, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(28, 28, 28)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton4)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        /**Flag que informa que é um novo voo e nao uma edição.*/
        int[]indice = {-1};
        cntrInteracaoFuncionario.editarVoo(indice);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        cntrInteracaoFuncionario.removerVoo(jTable1.getSelectedRows());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        cntrInteracaoFuncionario.editarVoo(jTable1.getSelectedRows());
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        cntrInteracaoCliente.consultarVoos();
    }//GEN-LAST:event_jButton4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    public final void setControladoraCliente(final IInteracaoCliente
            cntrInteracao) {
        this.cntrInteracaoCliente = cntrInteracao;
    }

    public final void setControladoraFuncionario(final IInteracaoFuncionario
            cntrInteracao) {
        this.cntrInteracaoFuncionario = cntrInteracao;
    }

    /**Configura a tela para o modo Cliente, desabilitando funcionalidades
     * que servem somente para os funcionarios.*/
    public final void configModoCliente() {
        jLabel1.setText("Voos cadastrados");
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
        jButton4.setEnabled(true);
    }

    /**Desabilita a tabela caso não haja o que mostrar.*/
    public final void setTableDisabled() {
        jTable1.setEnabled(false);
    }

    public void addTable(String numero, String de, String codDe, String para,
            String codPara, String dataSaida, String dataChegada,
            String horaSaida, String horaChegada) {
        DefaultTableModel model = ((DefaultTableModel)jTable1.getModel());
        String []string = new String[] {numero, de, codDe, para, codPara,
        dataSaida, dataChegada, horaSaida, horaChegada};
        model.addRow(string);
    }

    private void setModel() {
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Código do Voo", "De", "Cod. Aeroporto.", "Para",
                "Cod. Aeroporto", "Data Saída", "Data Chegada", "Hora Saída",
                "Hora Chegada"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class,
                java.lang.String.class, java.lang.String.class,
                java.lang.String.class, java.lang.String.class,
                java.lang.String.class, java.lang.String.class,
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
    }
}