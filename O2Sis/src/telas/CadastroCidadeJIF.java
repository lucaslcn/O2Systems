/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import dao.CidadeDAO;
import dao.EstadoDAO;
import gema.Gema;
import gema.Mensagens;
import gema.ValidaCampo;
import java.util.TreeMap;
import javax.swing.JOptionPane;
import negocio.Cidade;
import negocio.Estado;
import negocio.Usuario;
import org.hibernate.HibernateException;
import persistencia.BasicScreen;
import registros.Atividade;

/**
 *
 * @author lucas.lucian
 */
public class CadastroCidadeJIF extends javax.swing.JInternalFrame implements BasicScreen {

     Usuario usuario;
     TreeMap<Integer, Boolean> can;
     Cidade cidade;
     Estado estado;

    /**
     * Creates new form CadastroCidadeJIF
     */
    public CadastroCidadeJIF() {
        initComponents();
        limpar();
        situacaoNovo();
        this.usuario = usuario;
        this.can = can;
        btnDeletar.setVisible(false);
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSalvar = new javax.swing.JToggleButton();
        btnEditar = new javax.swing.JToggleButton();
        btnDeletar = new javax.swing.JToggleButton();
        btnPesquisar = new javax.swing.JToggleButton();
        btnCancelar2 = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        TF_CIDADE = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TF_ESTADO = new javax.swing.JTextField();
        btnPesquisar8 = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();

        setTitle("Cidade");

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/application_add.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
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

        btnDeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/application_delete.png"))); // NOI18N
        btnDeletar.setSelected(true);
        btnDeletar.setText("Deletar");
        btnDeletar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/magnifier.png"))); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnCancelar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cancel.png"))); // NOI18N
        btnCancelar2.setText("Cancelar");
        btnCancelar2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCancelar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar2ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Básicos"));

        jLabel3.setText("Nome da cidade (*)");

        TF_CIDADE.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TF_CIDADE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_CIDADEActionPerformed(evt);
            }
        });

        jLabel2.setText("Estado (*)");

        TF_ESTADO.setEditable(false);
        TF_ESTADO.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TF_ESTADO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_ESTADOActionPerformed(evt);
            }
        });

        btnPesquisar8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/magnifier.png"))); // NOI18N
        btnPesquisar8.setText("Pesquisar");
        btnPesquisar8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPesquisar8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisar8ActionPerformed(evt);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TF_ESTADO)
                    .addComponent(TF_CIDADE))
                .addGap(18, 18, 18)
                .addComponent(btnPesquisar8, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TF_CIDADE, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TF_ESTADO, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro Cidade");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnCancelar2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
                .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {
            String nome_cidade = TF_CIDADE.getText();

            String[] campos = {"cidade"};
            String[] valor = {nome_cidade};
            Integer[] qtd = {1};

            String r = ValidaCampo.campoVazio(campos, qtd, valor);
            if (r == null) {
                String[] infoOld = auditoria();
                popular();
                String[] infoNew = auditoria();
                Atividade logAuditoria = autoAuditoria(infoOld, infoNew);
                String s;
                if (cidade.getIdcidade() != null) {
                    s = new CidadeDAO().update(this.cidade, logAuditoria);
                } else {
                    s = new CidadeDAO().insert(this.cidade, logAuditoria);
                }

                if (s == null) {
                    Mensagens.retornoAcao(Mensagens.salvo("Cidade"));
                    limpar();
                    situacaoNovo();
                } else {
                    Mensagens.retornoAcao(Mensagens.erroSalvar("Cidade"));
                    TF_CIDADE.requestFocus();
                }
            } else {
                Mensagens.retornoAcao(Mensagens.preenchaOsCampos("Os seguintes campos obrigatórios estão vazios:\n" + r));

            }
        } catch (HibernateException he) {
            System.out.println(he);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        situacaoEditar();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed

        Cidade k = (Cidade) Gema.pesquisar(new CidadeDAO());

        if (k != null) {
            this.cidade = k;
            preencher();
            situacaoVisualizacao();
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnCancelar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar2ActionPerformed
        int resposta = Mensagens.questionarAcao();
        if (resposta == JOptionPane.NO_OPTION) {

        } else if (resposta == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_btnCancelar2ActionPerformed

    private void TF_CIDADEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_CIDADEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_CIDADEActionPerformed

    private void TF_ESTADOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_ESTADOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_ESTADOActionPerformed

    private void btnPesquisar8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisar8ActionPerformed
        Estado k = (Estado) Gema.pesquisar(new EstadoDAO());

        if (k != null) {
            this.estado = k;
            preencherEstado();
        }

    }//GEN-LAST:event_btnPesquisar8ActionPerformed

    public void preencherEstado() {
        TF_ESTADO.setText(this.estado.getNomeEstado());
        cidade.setIdestado(estado);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TF_CIDADE;
    private javax.swing.JTextField TF_ESTADO;
    private javax.swing.JToggleButton btnCancelar;
    private javax.swing.JToggleButton btnCancelar1;
    private javax.swing.JToggleButton btnCancelar2;
    private javax.swing.JToggleButton btnDeletar;
    private javax.swing.JToggleButton btnEditar;
    private javax.swing.JToggleButton btnPesquisar;
    private javax.swing.JToggleButton btnPesquisar1;
    private javax.swing.JToggleButton btnPesquisar2;
    private javax.swing.JToggleButton btnPesquisar3;
    private javax.swing.JToggleButton btnPesquisar4;
    private javax.swing.JToggleButton btnPesquisar5;
    private javax.swing.JToggleButton btnPesquisar6;
    private javax.swing.JToggleButton btnPesquisar7;
    private javax.swing.JToggleButton btnPesquisar8;
    private javax.swing.JToggleButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void preencher() {
        TF_CIDADE.setText(this.cidade.getNomeCidade());
        TF_ESTADO.setText(this.estado.getNomeEstado());
    }

    @Override
    public void limpar() {
        this.cidade = new Cidade();
        this.estado = new Estado();
        TF_CIDADE.setText("");
        TF_ESTADO.setText("");
        TF_CIDADE.requestFocus();
    }

    @Override
    public void popular() {
        this.cidade.setNomeCidade(TF_CIDADE.getText());
        this.cidade.setIdestado(estado);
    }

    @Override
    public void situacaoNovo() {
        TF_CIDADE.setEnabled(true);
        TF_ESTADO.setEnabled(true);
        btnCancelar2.setEnabled(true);
        btnDeletar.setEnabled(false);
        btnEditar.setEnabled(false);
        btnPesquisar.setEnabled(true);
        btnSalvar.setEnabled(true);
    }

    @Override
    public void situacaoEditar() {
        TF_CIDADE.setEnabled(true);
        TF_ESTADO.setEnabled(true);
        btnCancelar2.setEnabled(true);
        btnDeletar.setEnabled(false);
        btnEditar.setEnabled(false);
        btnPesquisar.setEnabled(false);
        btnSalvar.setEnabled(true);
        permissao();
    }

    @Override
    public void situacaoVisualizacao() {
        TF_CIDADE.setEnabled(false);
        TF_ESTADO.setEnabled(false);
        btnCancelar2.setEnabled(true);
        btnDeletar.setEnabled(false);
        btnEditar.setEnabled(true);
        btnPesquisar.setEnabled(true);
        btnSalvar.setEnabled(false);
        permissao();
    }

    @Override
    public void permissao() {
    }

    @Override
    public String[] auditoria() {
        String[] r = 
        {
            this.cidade.getIdcidade()+"",
            this.cidade.getNomeCidade(),
            this.cidade.getIdestado()+""
        };
        
        return r;
    }

    @Override
    public Atividade autoAuditoria(String[] iOld, String[] iNew) {
        Atividade logAuditoria = new Atividade();
        logAuditoria.setInformacaoOld(iOld);
        logAuditoria.setInformacaoNew(iNew);
        logAuditoria.setOnde(Atividade.FROM_CIDADE);
        logAuditoria.setUsuario(usuario);
        
        return logAuditoria;
    }
}
