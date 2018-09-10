/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import dao.AgendamentoExamesDAO;
import dao.ExameDAO;
import dao.PacienteDAO;
import dao.PessoaDAO;
import dao.PlanoDAO;
import gema.Formatacao;
import gema.Gema;
import gema.Mensagens;
import gema.ValidaCampo;
import java.math.BigDecimal;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import negocio.AgendamentoExames;
import negocio.Exames;
import negocio.Paciente;
import negocio.Pessoa;
import negocio.Plano;
import negocio.Usuario;
import org.hibernate.HibernateException;
import persistencia.BasicScreen;
import registros.Atividade;

/**
 *
 * @author elias
 */
public class AgendamentoExamesJIF extends javax.swing.JInternalFrame implements BasicScreen{

    AgendamentoExames ae;
    Usuario usuario;
    Plano plano;
    Exames exame;
    Paciente paciente;

    /**
     * Creates new form AgendamentoExamesJIF
     */
    public AgendamentoExamesJIF(Usuario usuario) {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tf_NomeExame = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tf_Exame = new javax.swing.JTextField();
        tfPlanoSaude = new javax.swing.JTextField();
        tfData = new javax.swing.JFormattedTextField();
        tfHora = new javax.swing.JFormattedTextField();
        btnPesquisarExame = new javax.swing.JButton();
        btnPesquisarPlano = new javax.swing.JButton();
        btnPesquisarCPF = new javax.swing.JButton();
        tf_NomePessoa = new javax.swing.JTextField();
        tf_NomePlano = new javax.swing.JTextField();
        tfPaciente = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JToggleButton();
        btnPesquisar = new javax.swing.JToggleButton();
        btnDeletar = new javax.swing.JToggleButton();
        btnEditar = new javax.swing.JToggleButton();
        btnSalvar = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Básicos"));

        jLabel3.setText("Paciente (*)");

        tf_NomeExame.setEditable(false);
        tf_NomeExame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_NomeExameActionPerformed(evt);
            }
        });

        jLabel2.setText("Exame (*)");

        jLabel9.setText("Data (*)");

        jLabel10.setText("Hora (*)");

        jLabel11.setText("Plano Saúde (*)");

        tf_Exame.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_ExameFocusLost(evt);
            }
        });

        tfPlanoSaude.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfPlanoSaudeFocusLost(evt);
            }
        });

        try {
            tfData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            tfHora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btnPesquisarExame.setText("Pesquisar");
        btnPesquisarExame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarExameActionPerformed(evt);
            }
        });

        btnPesquisarPlano.setText("Pesquisar");
        btnPesquisarPlano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarPlanoActionPerformed(evt);
            }
        });

        btnPesquisarCPF.setText("Pesquisar");
        btnPesquisarCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarCPFActionPerformed(evt);
            }
        });

        tf_NomePessoa.setEditable(false);
        tf_NomePessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_NomePessoaActionPerformed(evt);
            }
        });

        tf_NomePlano.setEditable(false);
        tf_NomePlano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_NomePlanoActionPerformed(evt);
            }
        });

        tfPaciente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfPacienteFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPesquisarCPF)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_NomePessoa))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfData, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfHora, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tf_Exame, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPesquisarExame)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_NomeExame, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfPlanoSaude, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesquisarPlano)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_NomePlano, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(113, 113, 113))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(btnPesquisarCPF)
                    .addComponent(tf_NomePessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tf_Exame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisarExame)
                    .addComponent(tf_NomeExame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(tfData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(tfPlanoSaude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisarPlano)
                    .addComponent(tf_NomePlano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        jLabel1.setText("Cadastro Exames");

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 165, Short.MAX_VALUE)
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        int resposta = Mensagens.confirmarexclusao();
        if (resposta == JOptionPane.YES_OPTION) {
            try {
                String[] infoOld = auditoria();
                String[] infoNew = auditoria();
                Atividade logAuditoria = autoAuditoria(infoOld, infoNew);

                this.exame.setStatus(false);
                String r;
                r = new ExameDAO().update(this.exame, logAuditoria);
                situacaoNovo();
                if (r == null) {
                    Mensagens.retornoAcao(Mensagens.arquivado("Exame")); //Acrecentar o resultado da auditoria a msg.
                    limpar();
                    situacaoNovo();
                } else {
                    Mensagens.retornoAcao(Mensagens.erroArquivado("Exame"));

                }
            } catch (HibernateException he) {
                System.out.println(he);
            }
        }
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        situacaoEditar();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {

            int pessoa = this.paciente.getIdpaciente();
            int exame = this.exame.getIdexame();
            String data = tfData.getText();
            String hora = tfHora.getText();
            int plano = this.plano.getIdplano();

            String[] campos = {"pessoa", "exame", "data", "hora"};
            String[] valor = {pessoa + "", exame + "", hora, data};
            Integer[] qtd = {1, 1, 1, 1};

            String r = ValidaCampo.campoVazio(campos, qtd, valor);

            if (r == null) {
                String[] infoOld = auditoria();

                popular();

                String[] infoNew = auditoria();
                Atividade logAuditoria = autoAuditoria(infoOld, infoNew);

                String s;
                if (ae.getIdagendamentoExames()!= null) {
                    s = new AgendamentoExamesDAO().update(this.ae, logAuditoria);
                } else {
                    s = new AgendamentoExamesDAO().insert(this.ae, logAuditoria);
                }

                if (s == null) {
                    Mensagens.retornoAcao(Mensagens.salvo("Agendamento do Exame"));
                    limpar();
                    situacaoNovo();
                } else {
                    Mensagens.retornoAcao(Mensagens.erroSalvar("Agendamento do Exame"));
                    tfPaciente.requestFocus();
                }
            } else {
                Mensagens.retornoAcao(Mensagens.preenchaOsCampos("Os seguintes campos obrigatórios estão vazios:\n" + r));
            }
        } catch (HibernateException he) {
            System.out.println(he);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void tf_NomeExameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_NomeExameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_NomeExameActionPerformed

    private void btnPesquisarCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarCPFActionPerformed
        Paciente k = (Paciente) Gema.pesquisar(new PacienteDAO());

        if (k != null) {
            this.paciente = k;
            preencherpessoa();
        }
    }//GEN-LAST:event_btnPesquisarCPFActionPerformed

    private void btnPesquisarExameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarExameActionPerformed
        Exames k = (Exames) Gema.pesquisar(new ExameDAO());

        if (k != null) {
            this.exame = k;
            preencherexame();
        }
    }//GEN-LAST:event_btnPesquisarExameActionPerformed

    private void btnPesquisarPlanoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarPlanoActionPerformed
        Plano k = (Plano) Gema.pesquisar(new PlanoDAO());

        if (k != null) {
            this.plano = k;
            preencherplano();
        }
    }//GEN-LAST:event_btnPesquisarPlanoActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        Exames k = (Exames) Gema.pesquisar(new ExameDAO());

        if (k != null) {
            this.exame = k;
            preencher();
            situacaoVisualizacao();
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void tf_NomePessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_NomePessoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_NomePessoaActionPerformed

    private void tf_NomePlanoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_NomePlanoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_NomePlanoActionPerformed

    private void tf_ExameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_ExameFocusLost
        tf_NomeExame.setText(this.exame.getNomeExame());
    }//GEN-LAST:event_tf_ExameFocusLost

    private void tfPlanoSaudeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfPlanoSaudeFocusLost
        tf_NomePlano.setText(this.plano.getNomePlano());
    }//GEN-LAST:event_tfPlanoSaudeFocusLost

    private void tfPacienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfPacienteFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPacienteFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnCancelar;
    private javax.swing.JToggleButton btnDeletar;
    private javax.swing.JToggleButton btnEditar;
    private javax.swing.JToggleButton btnPesquisar;
    private javax.swing.JButton btnPesquisarCPF;
    private javax.swing.JButton btnPesquisarExame;
    private javax.swing.JButton btnPesquisarPlano;
    private javax.swing.JToggleButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JFormattedTextField tfData;
    private javax.swing.JFormattedTextField tfHora;
    private javax.swing.JTextField tfPaciente;
    private javax.swing.JTextField tfPlanoSaude;
    private javax.swing.JTextField tf_Exame;
    private javax.swing.JTextField tf_NomeExame;
    private javax.swing.JTextField tf_NomePessoa;
    private javax.swing.JTextField tf_NomePlano;
    // End of variables declaration//GEN-END:variables

    @Override
    public void preencher() {
      //tfPaciente.setText(Integer.toString(this.ae.getIdpaciente()));
      //tf_Exame.setValue(this.ae.getDuracao());
      //tfData.setValue(this.ae.getPrazoRetirada());
      //tfHora.setText(this.ae.getValor() + "");
      //tfPlanoSaude.setText(this.ae.getValor() + "");
    }
    
    public void preencherpessoa() {
        tfPaciente.setText(Integer.toString(this.paciente.getIdpaciente()));
    }
    
    public void preencherexame() {
        tf_Exame.setText(Integer.toString(this.exame.getIdexame()));
    }
    
    public void preencherplano() {
        tfPlanoSaude.setText(Integer.toString(this.plano.getIdplano()));
    }
    

    @Override
    public void limpar() {
        this.ae = new AgendamentoExames();
        tfData.setText("");
        tfHora.setText("");
        tfPlanoSaude.setText("");
        tf_Exame.setText("");
        tfPaciente.setText("");
        
        tfPaciente.requestFocus();
    }

    @Override
    public void popular() {
        this.ae.setIdpaciente(this.paciente);
        this.ae.setIdexame(this.exame);
        this.ae.setIdplano(this.plano);
        this.ae.setDataExame(tfData.getData);
        this.ae.setHoraExame(tfHora.getText());
        
        this.exame.setStatus(true);
    }

    @Override
    public void situacaoNovo() {
        tfData.setEnabled(true);
        tfHora.setEnabled(true);
        tfPaciente.setEnabled(true);
        tfPlanoSaude.setEnabled(true);
        tf_Exame.setEnabled(true);

        btnCancelar.setEnabled(true);
        btnDeletar.setEnabled(false);
        btnEditar.setEnabled(false);
        btnPesquisar.setEnabled(true);
        btnSalvar.setEnabled(true);
        permissao();
    }

    @Override
    public void situacaoEditar() {
        tfData.setEnabled(true);
        tfHora.setEnabled(true);
        tfPaciente.setEnabled(true);
        tfPlanoSaude.setEnabled(true);
        tf_Exame.setEnabled(true);

        btnCancelar.setEnabled(true);
        btnDeletar.setEnabled(false);
        btnEditar.setEnabled(false);
        btnPesquisar.setEnabled(false);
        btnSalvar.setEnabled(true);
        permissao();
    }

    @Override
    public void situacaoVisualizacao() {
        tfData.setEnabled(false);
        tfHora.setEnabled(false);
        tfPaciente.setEnabled(false);
        tfPlanoSaude.setEnabled(false);
        tf_Exame.setEnabled(false);

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
        String[] r
                = {
                    exame.getIdexame() + "",
                    exame.getNomeExame(),
                    exame.getDuracao() + "",
                    exame.getPrazoRetirada() + "",
                    exame.getValor() + "",
                    exame.getStatus() + ""
                };
        return r;
    }

    @Override
    public Atividade autoAuditoria(String[] iOld, String[] iNew) {
        Atividade logAuditoria = new Atividade();
        logAuditoria.setInformacaoOld(iOld);
        logAuditoria.setInformacaoNew(iNew);
        logAuditoria.setOnde(Atividade.FROM_EXAME);
        logAuditoria.setUsuario(usuario);
        return logAuditoria;
    }
}
