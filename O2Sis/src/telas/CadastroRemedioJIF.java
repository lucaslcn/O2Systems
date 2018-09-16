/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import persistencia.BasicScreen;
import dao.RemedioDAO;
import gema.Gema;
import gema.Mensagens;
import gema.ValidaCampo;
import java.util.TreeMap;
import javax.swing.JOptionPane;
import negocio.Remedio;
import negocio.Usuario;
import org.hibernate.HibernateException;
import registros.Atividade;

/**
 *
 * @author elias
 */
public class CadastroRemedioJIF extends javax.swing.JInternalFrame implements BasicScreen {

    Remedio remedio;
    Usuario usuario;
    TreeMap<Integer, Boolean> can;

    /**
     * Creates new form CadastroRemédioJIF
     */
    public CadastroRemedioJIF(Usuario usuario, TreeMap<Integer, Boolean> can) {
        initComponents();
        limpar();

        this.usuario = usuario;
        this.can = can;

        CB_Controlado.removeAllItems();
        CB_Controlado.addItem("Não");
        CB_Controlado.addItem("Sim");

        situacaoNovo();
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
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        TF_NomeRemedio = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        CB_Controlado = new javax.swing.JComboBox<>();
        btnCancelar = new javax.swing.JToggleButton();
        btnPesquisar = new javax.swing.JToggleButton();
        btnDeletar = new javax.swing.JToggleButton();
        btnEditar = new javax.swing.JToggleButton();
        btnSalvar = new javax.swing.JToggleButton();

        setTitle("Cadastro de Remédio");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro Remédio");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Básicos"));

        jLabel3.setText("Nome Remédio (*)");

        TF_NomeRemedio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TF_NomeRemedio.setText("Tylenol");

        jLabel2.setText("Controlado (*)");

        CB_Controlado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));
        CB_Controlado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_ControladoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TF_NomeRemedio, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(CB_Controlado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TF_NomeRemedio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(CB_Controlado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cancel.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/magnifier.png"))); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnDeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/application_delete.png"))); // NOI18N
        btnDeletar.setText("Arquivar");
        btnDeletar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/application_edit.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/application_add.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        int resposta = Mensagens.questionarAcao();
        if (resposta == JOptionPane.NO_OPTION) {

        } else if (resposta == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        Remedio k = (Remedio) Gema.pesquisar(new RemedioDAO());

        if (k != null) {
            this.remedio = k;
            preencher();
            situacaoVisualizacao();
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {
            String nomeRemedio = TF_NomeRemedio.getText();
            String controlado = CB_Controlado.getItemAt(CB_Controlado.getSelectedIndex());

            String[] campos = {"nome remédio","controlado"};
            String[] valor = {nomeRemedio, controlado};
            Integer[] qtd = {1,1};

            String p = ValidaCampo.campoVazio(campos, qtd, valor);
            if (p == null) {
                if (Gema.vazio(TF_NomeRemedio.getText(), 1)) {
                    String[] infoOld = auditoria();
                    popular();
                    String[] infoNew = auditoria();
                    Atividade logAuditoria = autoAuditoria(infoOld, infoNew);
                    String r;
                    if (remedio.getIdremedio() != null) {
                        r = new RemedioDAO().update(this.remedio, logAuditoria);
                    } else {
                        r = new RemedioDAO().insert(this.remedio, logAuditoria);
                    }

                    if (r == null) {
                        Mensagens.retornoAcao(Mensagens.salvo("Remédio"));
                        limpar();
                        situacaoNovo();
                    } else {
                        Mensagens.retornoAcao(Mensagens.erroSalvar("Remédio"));
                        TF_NomeRemedio.requestFocus();
                    }
                } else {
                    Mensagens.retornoAcao(Mensagens.preenchaOsCampos());
                }
            } else {
                Mensagens.retornoAcao(Mensagens.preenchaOsCampos("Os seguintes campos obrigatórios estão vazios:\n" + p));

            }
        } catch (HibernateException he) {
            System.out.println(he);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void CB_ControladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_ControladoActionPerformed
        // T,ODO add your handling code here:
    }//GEN-LAST:event_CB_ControladoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        situacaoEditar();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        int resposta = Mensagens.confirmarexclusao();
        if (resposta == JOptionPane.NO_OPTION) {
        } else if (resposta == JOptionPane.YES_OPTION) {
            try {
//                Pegando dados antigos da tabela;
                String[] infoOld = auditoria();
//                Pegando dados novos da tabela
                String[] infoNew = auditoria();

                Atividade logAuditoria = autoAuditoria(infoOld, infoNew);

                this.remedio.setStatus(false);
                String r;
                r = new RemedioDAO().archived(this.remedio, logAuditoria);
                situacaoNovo();
                if (r == null) {
                    Mensagens.retornoAcao(Mensagens.arquivado("Remédio"));
                    limpar();
                } else {
                    Mensagens.retornoAcao(Mensagens.erroArquivado("Remédio"));

                }
            } catch (HibernateException he) {
                System.out.println(he);
            }
        }
    }//GEN-LAST:event_btnDeletarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CB_Controlado;
    private javax.swing.JTextField TF_NomeRemedio;
    private javax.swing.JToggleButton btnCancelar;
    private javax.swing.JToggleButton btnDeletar;
    private javax.swing.JToggleButton btnEditar;
    private javax.swing.JToggleButton btnPesquisar;
    private javax.swing.JToggleButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    public void preencher() {
        TF_NomeRemedio.setText(this.remedio.getNomeRemedio());
        if (this.remedio.getControlado() == false) {
            CB_Controlado.setSelectedIndex(0);
        } else {
            CB_Controlado.setSelectedIndex(1);
        }
    }

    public void limpar() {
        this.remedio = new Remedio();
        TF_NomeRemedio.setText("");
        CB_Controlado.setSelectedIndex(0);
        TF_NomeRemedio.requestFocus();
    }

    public void popular() {
        String nomeRemedio = TF_NomeRemedio.getText();
        int controladoRemedio = CB_Controlado.getSelectedIndex();
        if (Gema.vazio(nomeRemedio, 2)) {
            this.remedio.setNomeRemedio(nomeRemedio);
            if (controladoRemedio == 0) {
                this.remedio.setControlado(false);
            } else {
                this.remedio.setControlado(true);
            }

        }
    }

    @Override
    public void situacaoNovo() {
        TF_NomeRemedio.setEnabled(true);
        CB_Controlado.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnDeletar.setEnabled(false);
        btnEditar.setEnabled(false);
        btnPesquisar.setEnabled(true);
        btnSalvar.setEnabled(true);
        permissao();
    }

    @Override
    public void situacaoEditar() {
        TF_NomeRemedio.setEnabled(true);
        CB_Controlado.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnDeletar.setEnabled(false);
        btnEditar.setEnabled(false);
        btnPesquisar.setEnabled(false);
        btnSalvar.setEnabled(true);
        permissao();
    }

    @Override
    public void situacaoVisualizacao() {
        TF_NomeRemedio.setEnabled(false);
        CB_Controlado.setEnabled(false);
        btnCancelar.setEnabled(true);
        btnDeletar.setEnabled(true);
        btnEditar.setEnabled(true);
        btnPesquisar.setEnabled(true);
        btnSalvar.setEnabled(false);
        permissao();
    }

    @Override
    public String[] auditoria() {
        String[] r
                = {
                    remedio.getIdremedio() + "",
                    remedio.getNomeRemedio(),
                    remedio.getControlado() + ""
                };
        return r;
    }

    @Override
    public Atividade autoAuditoria(String[] iOld, String[] iNew) {
        Atividade logAuditoria = new Atividade();
        logAuditoria.setInformacaoOld(iOld);
        logAuditoria.setInformacaoNew(iNew);
        logAuditoria.setOnde(Atividade.FROM_FUNCAO);
        logAuditoria.setUsuario(usuario);

        return logAuditoria;
    }

    @Override
    public void permissao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
