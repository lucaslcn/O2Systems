/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.ConsultasDAO;
import dao.EstadoDAO;
import dao.ExameDAO;
import dao.FuncionarioDAO;
import dao.PessoaDAO;
import dao.UsuarioDAO;
import gema.Gema;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import negocio.Cidade;
import negocio.Consultas;
import negocio.Estado;
import negocio.Exames;
import negocio.Funcionario;
import negocio.Pessoa;
import negocio.Usuario;

/**
 *
 * @author Lucas
 */
public class ExportarDadosJIF extends javax.swing.JInternalFrame {

    Estado estado;
    Cidade cidade;
    Exames exames;
    Pessoa pessoa;
    Funcionario funcionario;
    Usuario usuario;
    Consultas consultas;
    Object k;
    String nome;
    int contador = 0;

    /**
     * Creates new form ExportarDadosJIF
     */
    public ExportarDadosJIF() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfdItem = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        JSONButton = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        btnPesquisar1 = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        btnCancelar = new javax.swing.JToggleButton();

        setTitle("Exportar dados");

        jLabel1.setText("Selecione o cadastro:");

        jLabel2.setText("Selecione o item:");

        tfdItem.setEditable(false);
        tfdItem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel3.setText("Formato:");

        buttonGroup1.add(JSONButton);
        JSONButton.setText("JSON");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("XML");

        btnPesquisar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/magnifier.png"))); // NOI18N
        btnPesquisar1.setText("Pesquisar");
        btnPesquisar1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPesquisar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisar1ActionPerformed(evt);
            }
        });

        jButton1.setText("Exportar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Estado", "Exame", "Pessoa", "Funcionario", "Usuario", "Consultas" }));

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cancel.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(153, 153, 153))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(JSONButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                .addComponent(tfdItem, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnPesquisar1)
                                .addGap(36, 36, 36))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(tfdItem, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnPesquisar1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(JSONButton)
                    .addComponent(jRadioButton2)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisar1ActionPerformed
        nome = jComboBox1.getItemAt(jComboBox1.getSelectedIndex());

        if (jComboBox1.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Selecione o cadastro corretamente!");
        } else {
            if (nome.equalsIgnoreCase("estado")) {
                k = (Estado) Gema.pesquisar(new EstadoDAO());
            } else if (nome.equalsIgnoreCase("exame")) {
                k = (Exames) Gema.pesquisar(new ExameDAO());
            } else if (nome.equalsIgnoreCase("pessoa")) {
                k = (Pessoa) Gema.pesquisar(new PessoaDAO());
            } else if (nome.equalsIgnoreCase("funcionario")) {
                k = (Funcionario) Gema.pesquisar(new FuncionarioDAO());
            } else if (nome.equalsIgnoreCase("usuario")) {
                k = (Usuario) Gema.pesquisar(new UsuarioDAO());
            } else if (nome.equalsIgnoreCase("consultas")) {
                k = (Consultas) Gema.pesquisar(new ConsultasDAO());
            }

            if (k != null) {
                tfdItem.setText("Item selecionado!");
            }
            System.out.println(k.getClass());
        }

    }//GEN-LAST:event_btnPesquisar1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (JSONButton.isSelected()) {
            ObjectMapper mapper = new ObjectMapper();

            try {
                File json = new File(nome + contador + ".json");
                String name = nome+contador+".json";
                mapper.writeValue(json, k);
                System.out.println("Java object converted to JSON String, written to file");
                System.out.println(mapper.writeValueAsString(k));
                tfdItem.setText("");
                JOptionPane.showMessageDialog(this, "Item " + name + " exportado com sucesso!");
                contador++;
                

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton JSONButton;
    private javax.swing.JToggleButton btnCancelar;
    private javax.swing.JToggleButton btnPesquisar1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTextField tfdItem;
    // End of variables declaration//GEN-END:variables
}
