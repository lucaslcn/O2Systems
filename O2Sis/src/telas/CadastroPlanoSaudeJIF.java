/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import persistencia.BasicScreen;
import dao.PlanoDAO;
import gema.Gema;
import gema.Mensagens;
import java.util.Date;
import javax.swing.JOptionPane;
import negocio.Log;
import negocio.Plano;
import negocio.Usuario;
import org.hibernate.HibernateException;
import registros.Atividade;
import registros.LogAuditoria;
import registros.LogErro;

/**
 *
 * @author XorNOTE
 */
public class CadastroPlanoSaudeJIF extends javax.swing.JInternalFrame implements BasicScreen {

    Plano plano;
    Usuario usuario;

    /**
     * Creates new form CadastroPlanoSaudeJIF
     */
    public CadastroPlanoSaudeJIF(Usuario usuario) {
        initComponents();
        limpar();
        situacaoNovo();
        this.usuario = usuario;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JToggleButton();
        btnPesquisar = new javax.swing.JToggleButton();
        btnDeletar = new javax.swing.JToggleButton();
        btnEditar = new javax.swing.JToggleButton();
        btnSalvar = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTF_NomePlano = new javax.swing.JTextField();

        jLabel2.setText("jLabel2");

        setClosable(true);
        setTitle("Cadastro Plano de Saúde");

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
        btnDeletar.setSelected(true);
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro Plano de Saúde");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Básicos"));

        jLabel3.setText("Nome Plano (*)");

        jTF_NomePlano.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTF_NomePlano.setText("Unimed Nacional");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTF_NomePlano)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTF_NomePlano, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
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
        Plano k = (Plano) Gema.pesquisar(new PlanoDAO());

        if (k != null) {
            this.plano = k;
            preencher();
            situacaoVisualizacao();
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {
            if (Gema.vazio(jTF_NomePlano.getText(), 1)) {
//                Pegando dados antigos da tabela;
                String[] infoOld = auditoria();
                
                popular();
//                Pegando dados novos da tabela
                String[] infoNew = auditoria();

//                Preenchendo a auditoria
                Atividade logAuditoria = new Atividade();
                logAuditoria.setInformacaoOld(infoOld);
                logAuditoria.setInformacaoNew(infoNew);
                logAuditoria.setOnde(Atividade.FROM_PLANO);
                logAuditoria.setUsuario(usuario);
                
                String r;
                if (plano.getIdplano() != null) {
                    r = new PlanoDAO().update(this.plano);
                    logAuditoria.setAcao(Atividade.ACAO_EDITADO); // Defido para a Auditoria Editado
                } else {
                    r = new PlanoDAO().insert(this.plano);
                    logAuditoria.setAcao(Atividade.ACAO_INSERIDO); // Defido para a Auditoria Inserido
                }

                if (r == null) {
                    
                    String audi = "";
                    if(LogAuditoria.status()){
                        audi = logAuditoria.registraatividade();
                        if(audi == null){
                            audi = "";
                        } else {
                            audi = "\n" + audi;
                        }
                    }
                    
                    Mensagens.retornoAcao(Mensagens.salvo("plano de saúde") + audi);
                    limpar();
                    situacaoNovo();
                } else {
                    Mensagens.retornoAcao(Mensagens.erroSalvar("Plano de saúde"));
                    jTF_NomePlano.requestFocus();
                }
            } else {
                Mensagens.retornoAcao(Mensagens.preenchaOsCampos());
            }
        } catch (HibernateException he) {
            System.out.println(he);
            Log log = new Log();
            log.setData(new Date());
            log.setHora(new Date());
            log.setOnde(Atividade.FROM_PLANO);
            log.setErro(he.toString());
            
            LogErro erro = new LogErro(log);
            String g = erro.registrarErro();
            System.out.println("Erro ao gravar o Log: "+g);
        }

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        situacaoEditar();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        int resposta = Mensagens.confirmarexclusao();
        if (resposta == JOptionPane.YES_OPTION) {
            try {
//                Pegando dados antigos da tabela;
                String[] infoOld = auditoria();
//                Pegando dados novos da tabela
                String[] infoNew = auditoria();
//                Preenchendo a auditoria
                Atividade logAuditoria = new Atividade();
                logAuditoria.setInformacaoOld(infoOld);
                logAuditoria.setInformacaoNew(infoNew);
                logAuditoria.setOnde(Atividade.FROM_PLANO);
                logAuditoria.setAcao(Atividade.ACAO_ARQUIVADO);
                logAuditoria.setUsuario(usuario);
                
                this.plano.setStatus(false);
                String r;
                r = new PlanoDAO().update(this.plano);
                situacaoNovo();
                if (r == null) {
//                    Executando a Auditoria
                    String audi = "";
                    if(LogAuditoria.status()){
                        audi = logAuditoria.registraatividade();
                        if(audi == null){
                            audi = "";
                        } else {
                            audi = "\n" + audi;
                        }
                    }
                    Mensagens.retornoAcao(Mensagens.arquivado("Plano de Saúde"));
                    limpar();
                    situacaoNovo();
                } else {
                    Mensagens.retornoAcao(Mensagens.erroArquivado("Plano de Saúde"));

                }
            } catch (HibernateException he) {
                System.out.println(he);
            }
        }
    }//GEN-LAST:event_btnDeletarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnCancelar;
    private javax.swing.JToggleButton btnDeletar;
    private javax.swing.JToggleButton btnEditar;
    private javax.swing.JToggleButton btnPesquisar;
    private javax.swing.JToggleButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTF_NomePlano;
    // End of variables declaration//GEN-END:variables

    @Override
    public void preencher() {
        jTF_NomePlano.setText(this.plano.getNomePlano());
    }

    @Override
    public void limpar() {
        this.plano = new Plano();
        jTF_NomePlano.setText("");
        jTF_NomePlano.requestFocus();
    }

    @Override
    public void popular() {
        String nomePlano = jTF_NomePlano.getText();
        if (Gema.vazio(nomePlano, 2)) {
            this.plano.setStatus(true);
            this.plano.setNomePlano(nomePlano);
        }
    }

    @Override
    public void situacaoNovo() {
        jTF_NomePlano.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnDeletar.setEnabled(false);
        btnEditar.setEnabled(false);
        btnPesquisar.setEnabled(true);
        btnSalvar.setEnabled(true);
        permissao();
    }

    @Override
    public void situacaoEditar() {
        jTF_NomePlano.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnDeletar.setEnabled(false);
        btnEditar.setEnabled(false);
        btnPesquisar.setEnabled(false);
        btnSalvar.setEnabled(true);
        permissao();
    }

    @Override
    public void situacaoVisualizacao() {
        jTF_NomePlano.setEnabled(false);
        btnCancelar.setEnabled(true);
        btnDeletar.setEnabled(true);
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
            plano.getIdplano()+"",
            plano.getNomePlano(),
            plano.getStatus()+""
        };
        return r;
    }

}
