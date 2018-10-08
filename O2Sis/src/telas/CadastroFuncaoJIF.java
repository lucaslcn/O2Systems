/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import persistencia.BasicScreen;
import dao.FuncaoDAO;
import gema.Gema;
import gema.Mensagens;
import gema.ValidaCampo;
import java.util.TreeMap;
import javax.swing.JOptionPane;
import negocio.Funcao;
import negocio.Usuario;
import org.hibernate.HibernateException;
import registros.Atividade;
import registros.PermissaoG;

/**
 *
 * @author elias
 */
public class CadastroFuncaoJIF extends javax.swing.JInternalFrame implements BasicScreen {

    Funcao funcao;
    Usuario usuario;
    TreeMap<Integer, Boolean> can;

    /**
     * Creates new form CadastroRemédioJIF
     */
    public CadastroFuncaoJIF(Usuario usuario, TreeMap<Integer, Boolean> can) {
        initComponents();
        limpar();

        this.usuario = usuario;
        this.can = can;

        cB_Usuario.removeAllItems();
        cB_Usuario.addItem("Não");
        cB_Usuario.addItem("Sim");

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
        tF_DescricaoFuncao = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cB_Usuario = new javax.swing.JComboBox<>();
        btnCancelar = new javax.swing.JToggleButton();
        btnPesquisar = new javax.swing.JToggleButton();
        btnDeletar = new javax.swing.JToggleButton();
        btnEditar = new javax.swing.JToggleButton();
        btnSalvar = new javax.swing.JToggleButton();

        setTitle("Cadastro de Função");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro Função");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Básicos"));

        jLabel3.setText("Descrição da Função (*)");

        tF_DescricaoFuncao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tF_DescricaoFuncao.setText("Pediatra");
        tF_DescricaoFuncao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tF_DescricaoFuncaoActionPerformed(evt);
            }
        });

        jLabel2.setText("Possui Usuário");

        cB_Usuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));
        cB_Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cB_UsuarioActionPerformed(evt);
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
                    .addComponent(tF_DescricaoFuncao, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cB_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tF_DescricaoFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cB_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        Funcao k = (Funcao) Gema.pesquisar(new FuncaoDAO());

        if (k != null) {
            this.funcao = k;
            preencher();
            situacaoVisualizacao();
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {
            String descFuncao = tF_DescricaoFuncao.getText();
            String temUsuario = cB_Usuario.getItemAt(cB_Usuario.getSelectedIndex());

            String[] campos = {"descrição da função", "possui usuario"};
            String[] valor = {descFuncao, temUsuario};
            Integer[] qtd = {1, 1};

            String p = ValidaCampo.campoVazio(campos, qtd, valor);
            if (p == null) {
                if (Gema.vazio(tF_DescricaoFuncao.getText(), 1)) {
                    String[] infoOld = auditoria();
                    popular();
                    String[] infoNew = auditoria();
                    Atividade logAuditoria = autoAuditoria(infoOld, infoNew);
                    String r;
                    if (funcao.getIdfuncao() != null) {
                        r = new FuncaoDAO().update(this.funcao, logAuditoria);
                    } else {
                        r = new FuncaoDAO().insert(this.funcao, logAuditoria);
                    }

                    if (r == null) {
                        Mensagens.retornoAcao(Mensagens.salvo("Funcao"));
                        limpar();
                        situacaoNovo();
                    } else {
                        Mensagens.retornoAcao(Mensagens.erroSalvar("Funcao"));
                        tF_DescricaoFuncao.requestFocus();
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

    private void cB_UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cB_UsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cB_UsuarioActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        int resposta = Mensagens.confirmarArquivamento();
        if (resposta == JOptionPane.NO_OPTION) {
        } else if (resposta == JOptionPane.YES_OPTION) {
            try {
//                Pegando dados antigos da tabela;
                String[] infoOld = auditoria();
//                Pegando dados novos da tabela
                String[] infoNew = auditoria();

                Atividade logAuditoria = autoAuditoria(infoOld, infoNew);

                this.funcao.setStatus(false);
                String r;
                r = new FuncaoDAO().archived(this.funcao, logAuditoria);
                situacaoNovo();
                if (r == null) {
                    Mensagens.retornoAcao(Mensagens.arquivado("Funcao"));
                    limpar();
                } else {
                    Mensagens.retornoAcao(Mensagens.erroArquivado("Funcao"));

                }
            } catch (HibernateException he) {
                System.out.println(he);
            }
        }

    }//GEN-LAST:event_btnDeletarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        situacaoEditar();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void tF_DescricaoFuncaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tF_DescricaoFuncaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tF_DescricaoFuncaoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnCancelar;
    private javax.swing.JToggleButton btnDeletar;
    private javax.swing.JToggleButton btnEditar;
    private javax.swing.JToggleButton btnPesquisar;
    private javax.swing.JToggleButton btnSalvar;
    private javax.swing.JComboBox<String> cB_Usuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField tF_DescricaoFuncao;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JPanel jP_btnDeAcao;
    
    public void preencher() {
        tF_DescricaoFuncao.setText(this.funcao.getDescricaoFuncao());
        if (this.funcao.getBooleanUser() == false) {
            cB_Usuario.setSelectedIndex(0);
        } else {
            cB_Usuario.setSelectedIndex(1);
        }
    }

    public void limpar() {
        this.funcao = new Funcao();
        tF_DescricaoFuncao.setText("");
        tF_DescricaoFuncao.requestFocus();
    }

    public void popular() {
        String descricaoFuncao = tF_DescricaoFuncao.getText();
        int controladoFuncao = cB_Usuario.getSelectedIndex();
        if (Gema.vazio(descricaoFuncao, 2)) {
            this.funcao.setDescricaoFuncao(descricaoFuncao);
            this.funcao.setStatus(true);
            if (controladoFuncao == 0) {
                this.funcao.setBooleanUser(false);
            } else {
                this.funcao.setBooleanUser(true);
            }
            this.funcao.setStatus(true);

        }
    }

    @Override
    public void situacaoNovo() {
        tF_DescricaoFuncao.setEnabled(true);
        cB_Usuario.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnDeletar.setEnabled(false);
        btnEditar.setEnabled(false);
        btnPesquisar.setEnabled(true);
        btnSalvar.setEnabled(true);
        permissao();
    }

    @Override
    public void situacaoEditar() {
        tF_DescricaoFuncao.setEnabled(true);
        cB_Usuario.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnDeletar.setEnabled(false);
        btnEditar.setEnabled(false);
        btnPesquisar.setEnabled(false);
        btnSalvar.setEnabled(true);
        permissao();
    }

    @Override
    public void situacaoVisualizacao() {
        tF_DescricaoFuncao.setEnabled(false);
        cB_Usuario.setEnabled(false);
        btnCancelar.setEnabled(true);
        btnDeletar.setEnabled(true);
        btnEditar.setEnabled(true);
        btnPesquisar.setEnabled(true);
        btnSalvar.setEnabled(false);
        permissao();
    }

    @Override
    public void permissao() {
        btnDeletar.setName("55");
        btnEditar.setName("54");
        btnPesquisar.setName("56");
        btnSalvar.setName("53");
       
        PermissaoG.myCan(can, jP_btnDeAcao.getComponents());
    }

    @Override
    public String[] auditoria() {
        String[] r
                = {
                    funcao.getIdfuncao() + "",
                    funcao.getDescricaoFuncao(),
                    funcao.getBooleanUser() + ""
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
}
