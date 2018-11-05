/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.AgendamentoExamesDAO;
import dao.ConsultasDAO;
import dao.FuncionarioDAO;
import dao.PessoaDAO;
import dao.UsuarioDAO;
import gema.Gema;
import gema.Mensagens;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import negocio.AgendamentoExames;
import negocio.Cidade;
import negocio.Consultas;
import negocio.Estado;
import negocio.Exames;
import negocio.Funcionario;
import negocio.Pessoa;
import negocio.Usuario;
import persistencia.BasicScreen;
import registros.Atividade;

/**
 *
 * @author Lucas
 */
public class ImportarDadosJIF extends javax.swing.JInternalFrame implements BasicScreen {

    String nome;
    Estado estado;
    Cidade cidade;
    Exames exames;
    Pessoa pessoa;
    Funcionario funcionario;
    Usuario usuario;
    Consultas consultas;
    AgendamentoExames agendamentoExames;

    /**
     * Creates new form ImportarDadosJIF
     */
    public ImportarDadosJIF() {
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

        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        tfdJsonText = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnCancelar = new javax.swing.JToggleButton();

        setTitle("Importar dados");

        jLabel1.setText("Selecione o cadastro:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Agendamento de Exames", "Consultas", " " }));

        jLabel2.setText("Copie o texto a ser importado");

        tfdJsonText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdJsonTextActionPerformed(evt);
            }
        });

        jButton1.setText("Importar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, 0, 356, Short.MAX_VALUE)
                        .addGap(144, 144, 144))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addComponent(tfdJsonText, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(tfdJsonText, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfdJsonTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdJsonTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdJsonTextActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        nome = jComboBox1.getItemAt(jComboBox1.getSelectedIndex());
        String jsonText = tfdJsonText.getText();
        ObjectMapper mapper = new ObjectMapper();

//         k = mapper.readValue(jsonText, Object);
//         
        if (jComboBox1.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Selecione o cadastro corretamente!");
        } else {
            if (nome.equalsIgnoreCase("agendamento de exames")) {

                try {
                    agendamentoExames = mapper.readValue(jsonText, AgendamentoExames.class);
                } catch (IOException ex) {
                    Logger.getLogger(ImportarDadosJIF.class.getName()).log(Level.SEVERE, null, ex);
                }

                String[] infoOld = auditoria();

                popular();

                String[] infoNew = auditoria();
                Atividade logAuditoria = autoAuditoria(infoOld, infoNew);

                String s;
                if (agendamentoExames.getIdagendamentoExames() != null) {
                    s = new AgendamentoExamesDAO().update(this.agendamentoExames, logAuditoria);
                } else {
                    s = new AgendamentoExamesDAO().insert(this.agendamentoExames, logAuditoria);
                }

                if (s == null) {
                    Mensagens.retornoAcao(Mensagens.salvo("Agendamento Exame"));
                    limpar();
                    situacaoNovo();
                } else {
                    Mensagens.retornoAcao(Mensagens.erroSalvar("Agendamento Exame"));
                }

            } else if (nome.equalsIgnoreCase("consultas")) {
                try {
                    consultas = mapper.readValue(jsonText, Consultas.class);
                } catch (IOException ex) {
                    Logger.getLogger(ImportarDadosJIF.class.getName()).log(Level.SEVERE, null, ex);
                }

                String[] infoOld = auditoria();

                //popular();

                String[] infoNew = auditoria();
                Atividade logAuditoria = autoAuditoria(infoOld, infoNew);

                String s;
                if (consultas.getIdconsultas() != null) {
                    s = new AgendamentoExamesDAO().update(this.consultas, logAuditoria);
                } else {
                    s = new AgendamentoExamesDAO().insert(this.consultas, logAuditoria);
                }

                if (s == null) {
                    Mensagens.retornoAcao(Mensagens.salvo("Consulta"));
                    limpar();
                    situacaoNovo();
                } else {
                    Mensagens.retornoAcao(Mensagens.erroSalvar("Consulta"));
                }

            }
        }

//        if (JSONButton.isSelected()) {
//            ObjectMapper mapper = new ObjectMapper();
//
//            try {
//                File json = new File(nome + contador + ".json");
//                String name = nome+contador+".json";
//                mapper.writeValue(json, k);
//                System.out.println("Java object converted to JSON String, written to file");
//                System.out.println(mapper.writeValueAsString(k));
//                tfdItem.setText("");
//                JOptionPane.showMessageDialog(this, "Item " + name + " exportado com sucesso!");
//                contador++;
//
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        int resposta = Mensagens.questionarAcao();
        if (resposta == JOptionPane.NO_OPTION) {

        } else if (resposta == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnCancelar;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField tfdJsonText;
    // End of variables declaration//GEN-END:variables

    @Override
    public void preencher() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void limpar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void popular() {
        
    }

    @Override
    public void situacaoNovo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void situacaoEditar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void situacaoVisualizacao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void permissao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[] auditoria() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return null;
    }

    @Override
    public Atividade autoAuditoria(String[] iOld, String[] iNew) {
        return null;
    }
}
