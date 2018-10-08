/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import com.toedter.calendar.JDateChooser;
import dao.AgendamentoExamesDAO;
import dao.ExameDAO;
import dao.FormaPagamentoDAO;
import dao.PacienteDAO;
import dao.PlanoDAO;
import gema.Gema;
import gema.Mensagens;
import gema.ValidaCampo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import negocio.AgendamentoExames;
import negocio.Exames;
import negocio.Paciente;
import negocio.Plano;
import negocio.Usuario;
import org.hibernate.HibernateException;
import persistencia.BasicScreen;
import registros.Atividade;
import registros.PermissaoG;

/**
 *
 * @author Lucas
 */
public class AgendamentoExamesJIF extends javax.swing.JInternalFrame implements BasicScreen {

    Paciente paciente;
    Exames exame;
    AgendamentoExames ae;
    Plano plano;
    Usuario usuario;
    TreeMap<Integer, Boolean> can;
    Date data;

    /**
     * Creates new form AgendamentoConsulta
     */
    public AgendamentoExamesJIF(Usuario usuario, TreeMap<Integer, Boolean> can) {
        initComponents();
        limpar();
        this.usuario = usuario;
        this.can = can;
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
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        btnPesquisar = new javax.swing.JToggleButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfdExames = new javax.swing.JTextField();
        btnPesquisar1 = new javax.swing.JToggleButton();
        tfHora = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        tfdPlano = new javax.swing.JTextField();
        btnPesquisar2 = new javax.swing.JToggleButton();
        tfdPaciente = new javax.swing.JTextField();
        jcData = new com.toedter.calendar.JDateChooser();
        btnCancelar = new javax.swing.JToggleButton();
        btnPesquisar3 = new javax.swing.JToggleButton();
        btnDeletar = new javax.swing.JToggleButton();
        btnEditar = new javax.swing.JToggleButton();
        btnSalvar = new javax.swing.JToggleButton();

        setTitle("Agendamento de Exames");
        setName("Agendamento de consultas"); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Agendamento de Exame");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados da consulta"));

        jLabel10.setText("Hora (*)");

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/magnifier.png"))); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        jLabel9.setText("Data (*)");

        jLabel3.setText("Paciente (*)");

        jLabel4.setText("Exame (*)");

        tfdExames.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btnPesquisar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/magnifier.png"))); // NOI18N
        btnPesquisar1.setText("Pesquisar");
        btnPesquisar1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPesquisar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisar1ActionPerformed(evt);
            }
        });

        try {
            tfHora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel11.setText("Plano Saúde (*)");

        tfdPlano.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfdPlanoFocusLost(evt);
            }
        });

        btnPesquisar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/magnifier.png"))); // NOI18N
        btnPesquisar2.setText("Pesquisar");
        btnPesquisar2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPesquisar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisar2ActionPerformed(evt);
            }
        });

        tfdPaciente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfdPaciente.setText("Anderson Caye");

        jcData.setDate(new Date());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jcData, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(tfHora, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tfdPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfdExames, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPesquisar1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPesquisar2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(10, 10, 10)
                        .addComponent(tfdPlano, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113)))
                .addGap(51, 51, 51))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tfdPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfdExames, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(btnPesquisar1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(tfHora, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcData, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(tfdPlano, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cancel.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnPesquisar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/magnifier.png"))); // NOI18N
        btnPesquisar3.setText("Pesquisar");
        btnPesquisar3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPesquisar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisar3ActionPerformed(evt);
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
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesquisar3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.getAccessibleContext().setAccessibleName("Dados do Agendamento");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private javax.swing.JPanel jP_btnDeAcao;
    
    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        Paciente k = (Paciente) Gema.pesquisar(new PacienteDAO());

        if (k != null) {
            this.paciente = k;
            preencherPaciente();
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnPesquisar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisar1ActionPerformed
        Exames k = (Exames) Gema.pesquisar(new ExameDAO());

        if (k != null) {
            this.exame = k;
            preencherExame();
        }


    }//GEN-LAST:event_btnPesquisar1ActionPerformed

    private void tfdPlanoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfdPlanoFocusLost
        tfdPlano.setText(this.plano.getNomePlano());
    }//GEN-LAST:event_tfdPlanoFocusLost

    private void btnPesquisar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisar2ActionPerformed
        Plano k = (Plano) Gema.pesquisar(new PlanoDAO());

        if (k != null) {
            this.plano = k;
            preencherPlano();
        }
    }//GEN-LAST:event_btnPesquisar2ActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        int resposta = Mensagens.questionarAcao();
        if (resposta == JOptionPane.NO_OPTION) {

        } else if (resposta == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnPesquisar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisar3ActionPerformed
        AgendamentoExames k = (AgendamentoExames) Gema.pesquisar(new AgendamentoExamesDAO());

        if (k != null) {
            this.ae = k;
            preencher();
            situacaoVisualizacao();
        }
    }//GEN-LAST:event_btnPesquisar3ActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        int resposta = Mensagens.confirmarArquivamento();
        if (resposta == JOptionPane.YES_OPTION) {
            try {
                String[] infoOld = auditoria();
                String[] infoNew = auditoria();
                Atividade logAuditoria = autoAuditoria(infoOld, infoNew);

                this.ae.setStatus(false);
                String r;
                r = new AgendamentoExamesDAO().update(this.ae, logAuditoria);
                situacaoNovo();
                if (r == null) {
                    Mensagens.retornoAcao(Mensagens.arquivado("Agendamento Exame")); //Acrecentar o resultado da auditoria a msg.
                    limpar();
                    situacaoNovo();
                } else {
                    Mensagens.retornoAcao(Mensagens.erroArquivado("Agendamento Exame"));

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

            int paciente = this.paciente.getIdpaciente();
            int exame = this.exame.getIdexame();
            String data = jcData.getDateFormatString();
            String hora = tfHora.getText();
            int plano = this.plano.getIdplano();

            String[] campos = {"paciente", "exame", "data", "hora", "plano"};
            String[] valor = {paciente + "", exame + "", data, hora, plano + ""};
            Integer[] qtd = {1, 1, 1, 1, 1};

            String r = ValidaCampo.campoVazio(campos, qtd, valor);

            if (r == null) {
                String[] infoOld = auditoria();

                popular();

                String[] infoNew = auditoria();
                Atividade logAuditoria = autoAuditoria(infoOld, infoNew);

                String s;
                if (ae.getIdagendamentoExames() != null) {
                    s = new AgendamentoExamesDAO().update(this.ae, logAuditoria);
                } else {
                    s = new AgendamentoExamesDAO().insert(this.ae, logAuditoria);
                }

                if (s == null) {
                    Mensagens.retornoAcao(Mensagens.salvo("Agendamento Exame"));
                    limpar();
                    situacaoNovo();
                } else {
                    Mensagens.retornoAcao(Mensagens.erroSalvar("Agendamento Exame"));
                    tfdPaciente.requestFocus();
                }
            } else {
                Mensagens.retornoAcao(Mensagens.preenchaOsCampos("Os seguintes campos obrigatórios estão vazios:\n" + r));
            }
        } catch (HibernateException he) {
            System.out.println(he);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    @Override
    public void preencher() {
        paciente = ae.getIdpaciente();
        tfdPaciente.setText(paciente.getIdpessoa().getNomePessoa());
        exame = ae.getIdexame();
        tfdExames.setText(ae.getIdexame().getNomeExame());
        plano = ae.getIdplano();
        tfdPlano.setText(ae.getIdplano().getNomePlano());

        tfHora.setText(ae.getHoraExame().getHours() + ":" + ae.getHoraExame().getMinutes());
        jcData.setDate(ae.getDataExame()); 
    }

    public void preencherPaciente() {
        tfdPaciente.setText(this.paciente.getIdpessoa().getNomePessoa());
    }

    public void preencherExame() {
        tfdExames.setText(this.exame.getNomeExame());
    }

    public void preencherPlano() {
        tfdPlano.setText(this.plano.getNomePlano());
    }

    @Override
    public void limpar() {
        this.ae = new AgendamentoExames();
        this.paciente = new Paciente();
        this.exame = new Exames();
        this.plano = new Plano();

        this.ae.setIdpaciente(paciente);
        this.ae.setIdexame(exame);
        this.ae.setIdplano(plano);

        tfdPaciente.setText("");
        tfdExames.setText("");
        tfdPlano.setText("");
        jcData = new JDateChooser();
        tfHora.setText("");
    }

    @Override
    public void popular() {
        this.ae.setIdpaciente(paciente);
        this.ae.setIdexame(exame);
        this.ae.setIdplano(plano);
        this.ae.setIdformaPagamento(new FormaPagamentoDAO().consultarId(2));
        this.ae.setStatus(true);

        String[] data = jcData.getDateFormatString().split("/");
        String[] hora = tfHora.getText().split(":");

        String date = jcData.getDateFormatString();

        int year = Integer.parseInt(data[2]);
        int month = Integer.parseInt(data[1]);
        int day = Integer.parseInt(data[0]);
        int hour = Integer.parseInt(hora[0]);
        int min = Integer.parseInt(hora[1]);

        Date dataExame = null;
        Date dataEntrega = null;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            dataExame = formato.parse(date);
            dataEntrega = formato.parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(AgendamentoExamesJIF.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.ae.setDataExame(dataExame);
        this.ae.setHoraExame(new Date(year, month, day, hour, min));
        this.ae.setDataEntrega(dataEntrega);

    }

    @Override
    public void situacaoNovo() {
        tfdPaciente.setEnabled(true);
        tfdExames.setEnabled(true);
        jcData.setEnabled(true);
        tfHora.setEnabled(true);
        tfdPlano.setEnabled(true);

        btnCancelar.setEnabled(true);
        btnDeletar.setEnabled(false);
        btnEditar.setEnabled(false);
        btnPesquisar.setEnabled(true);
        btnSalvar.setEnabled(true);
        permissao();
    }

    @Override
    public void situacaoEditar() {
        tfdPaciente.setEnabled(true);
        tfdExames.setEnabled(true);
        jcData.setEnabled(true);
        tfHora.setEnabled(true);
        tfdPlano.setEnabled(true);

        btnCancelar.setEnabled(true);
        btnDeletar.setEnabled(true);
        btnEditar.setEnabled(false);
        btnPesquisar.setEnabled(true);
        btnSalvar.setEnabled(true);
        permissao();
    }

    @Override
    public void situacaoVisualizacao() {
        tfdPaciente.setEnabled(false);
        tfdExames.setEnabled(false);
        jcData.setEnabled(false);
        tfHora.setEnabled(false);
        tfdPlano.setEnabled(false);

        btnCancelar.setEnabled(true);
        btnDeletar.setEnabled(false);
        btnEditar.setEnabled(true);
        btnPesquisar.setEnabled(true);
        btnSalvar.setEnabled(false);
        permissao();
    }

    @Override
    public void permissao() {
        btnDeletar.setName("65");
        btnEditar.setName("64");
        btnPesquisar.setName("66");
        btnSalvar.setName("63");
       
        PermissaoG.myCan(can, jP_btnDeAcao.getComponents());
    }

    @Override
    public String[] auditoria() {
        String[] r
                = {
                    ae.getIdagendamentoExames() + "",
                    ae.getDataExame() + "",
                    ae.getHoraExame() + "",
                    ae.getIdpaciente().getIdpaciente() + "",
                    ae.getIdexame() + "",
                    ae.getIdplano() + ""

                };
        return r;
    }

    @Override
    public Atividade autoAuditoria(String[] iOld, String[] iNew) {
        Atividade logAuditoria = new Atividade();
        logAuditoria.setInformacaoOld(iOld);
        logAuditoria.setInformacaoNew(iNew);
        logAuditoria.setOnde(Atividade.FROM_CONSULTAS);
        logAuditoria.setUsuario(usuario);
        return logAuditoria;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnCancelar;
    private javax.swing.JToggleButton btnDeletar;
    private javax.swing.JToggleButton btnEditar;
    private javax.swing.JToggleButton btnPesquisar;
    private javax.swing.JToggleButton btnPesquisar1;
    private javax.swing.JToggleButton btnPesquisar2;
    private javax.swing.JToggleButton btnPesquisar3;
    private javax.swing.JToggleButton btnSalvar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private com.toedter.calendar.JDateChooser jcData;
    private javax.swing.JFormattedTextField tfHora;
    private javax.swing.JTextField tfdExames;
    private javax.swing.JTextField tfdPaciente;
    private javax.swing.JTextField tfdPlano;
    // End of variables declaration//GEN-END:variables
}
