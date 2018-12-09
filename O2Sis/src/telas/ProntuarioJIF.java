/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import dao.AuditoriaDAO;
import dao.ConsultasDAO;
import dao.ExameDAO;
import persistencia.BasicScreen;
import dao.PlanoDAO;
import dao.ProntuarioDAO;
import gema.Gema;
import gema.Mensagens;
import gema.ValidaCampo;
import gema.XML;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import negocio.Consultas;
import negocio.Exames;
import negocio.Listapermissao;
import negocio.Prontuario;
import negocio.Receita;
import negocio.Requisicao;
import negocio.Usuario;
import oracle.jrockit.jfr.tools.ConCatRepository;
import org.hibernate.HibernateException;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import registros.Atividade;
import registros.LogAuditoria;
import registros.PermissaoG;

/**
 *
 * @author XorNOTE
 */
public class ProntuarioJIF extends javax.swing.JInternalFrame implements BasicScreen {

    Prontuario prontuario;
    Consultas consulta;
    TreeMap<Integer, Boolean> can;
//    Receita receita;
//    Requisicao requisicao;
    Usuario usuario;

    /**
     * Creates new form CadastroPlanoSaudeJIF
     *
     * @param usuario
     * @param permissao
     */
    public ProntuarioJIF(Usuario usuario, TreeMap<Integer, Boolean> can) {
        initComponents();
        this.usuario = usuario;
        this.can = can;
        limpar();
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

        jLabel2 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JToggleButton();
        btnPesquisar = new javax.swing.JToggleButton();
        btnEditar = new javax.swing.JToggleButton();
        btnSalvar = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTF_CodigoConsulta = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTF_NomePaciente = new javax.swing.JTextField();
        jPanelTriagem = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTA_CamporTextoTriagem = new javax.swing.JTextArea();
        jPanelAtendimento = new javax.swing.JPanel();
        btn_Receita = new javax.swing.JButton();
        btn_Exame = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTA_CamporTextoAtendimento = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        setClosable(true);
        setTitle("Prontuário");

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
        jLabel1.setText("Prontuário de Consulta");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Prontuário"));

        jLabel3.setText("Código Consulta");

        jTF_CodigoConsulta.setEditable(false);
        jTF_CodigoConsulta.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTF_CodigoConsulta.setText("123456789");
        jTF_CodigoConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_CodigoConsultaActionPerformed(evt);
            }
        });

        jLabel9.setText("Paciente");

        jTF_NomePaciente.setEditable(false);
        jTF_NomePaciente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTF_NomePaciente.setText("Anderson Caye");
        jTF_NomePaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_NomePacienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTF_CodigoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTF_NomePaciente, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTF_CodigoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTF_NomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelTriagem.setBorder(javax.swing.BorderFactory.createTitledBorder("Triagem"));

        jTA_CamporTextoTriagem.setColumns(20);
        jTA_CamporTextoTriagem.setRows(5);
        jScrollPane1.setViewportView(jTA_CamporTextoTriagem);

        javax.swing.GroupLayout jPanelTriagemLayout = new javax.swing.GroupLayout(jPanelTriagem);
        jPanelTriagem.setLayout(jPanelTriagemLayout);
        jPanelTriagemLayout.setHorizontalGroup(
            jPanelTriagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTriagemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelTriagemLayout.setVerticalGroup(
            jPanelTriagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTriagemLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );

        jPanelAtendimento.setBorder(javax.swing.BorderFactory.createTitledBorder("Atendimento"));

        btn_Receita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/application_add.png"))); // NOI18N
        btn_Receita.setText("Criar Receita");
        btn_Receita.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        btn_Exame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/application_add.png"))); // NOI18N
        btn_Exame.setText("Solicitar Exames");
        btn_Exame.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jTA_CamporTextoAtendimento.setColumns(20);
        jTA_CamporTextoAtendimento.setRows(5);
        jTA_CamporTextoAtendimento.setPreferredSize(new java.awt.Dimension(164, 100));
        jScrollPane2.setViewportView(jTA_CamporTextoAtendimento);

        javax.swing.GroupLayout jPanelAtendimentoLayout = new javax.swing.GroupLayout(jPanelAtendimento);
        jPanelAtendimento.setLayout(jPanelAtendimentoLayout);
        jPanelAtendimentoLayout.setHorizontalGroup(
            jPanelAtendimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAtendimentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAtendimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanelAtendimentoLayout.createSequentialGroup()
                        .addComponent(btn_Receita, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Exame, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelAtendimentoLayout.setVerticalGroup(
            jPanelAtendimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAtendimentoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAtendimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Receita, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Exame, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jButton2.setText("Ler XML");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Gerar XML");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelTriagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelAtendimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelTriagem, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelAtendimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        Prontuario k = (Prontuario) Gema.pesquisar(new ProntuarioDAO());

        if (k != null) {
            this.prontuario = k;
            this.consulta = new ConsultasDAO().consultarId(prontuario.getIdprontuario());
            preencher();
            situacaoVisualizacao();
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {

            String triagem = jTA_CamporTextoTriagem.getText();
            String atendimento = jTA_CamporTextoAtendimento.getText();

            String[] campos = {"triagem", "atendimento"};
            String[] valor = {triagem, atendimento};
            Integer[] qtd = {1, 1};

            String r = ValidaCampo.campoVazio(campos, qtd, valor);

            if (r == null) {
                String[] infoOld = auditoria();

                popular();

                String[] infoNew = auditoria();
                Atividade logAuditoria = autoAuditoria(infoOld, infoNew);

                String s;
                if (prontuario.getIdprontuario() != null) {
                    s = new ExameDAO().update(this.prontuario, logAuditoria);
                } else {
                    s = new ExameDAO().insert(this.prontuario, logAuditoria);
                }

                if (s == null) {
                    Mensagens.retornoAcao(Mensagens.salvo("Prontuario"));
                    limpar();
                    situacaoNovo();
                } else {
                    Mensagens.retornoAcao(Mensagens.erroSalvar("Prontuario"));
                    jTF_CodigoConsulta.requestFocus();
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

    private void jTF_CodigoConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_CodigoConsultaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTF_CodigoConsultaActionPerformed

    private void jTF_NomePacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_NomePacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTF_NomePacienteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            Integer id = this.prontuario.getIdprontuario();
            if (id == null) {
                id = 0;
            }

            if (id != 0) {
                XML.GeraXML(jTF_CodigoConsulta.getText(), jTF_NomePaciente.getText(), jTA_CamporTextoTriagem.getText(), jTA_CamporTextoAtendimento.getText());
                Mensagens.retornoAcao(Mensagens.GerarXML());
            } else {
                Mensagens.retornoAcao(Mensagens.erroGerarXML());
            }

        } catch (ParserConfigurationException ex) {
            Mensagens.retornoAcao(Mensagens.erroGerarXML());
        } catch (TransformerException ex) {
            Mensagens.retornoAcao(Mensagens.erroGerarXML());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        try {
            String EnderecoAnexo = "";
            File[] Anexo;

            JFileChooser file = new JFileChooser("XML\\");
            file.setMultiSelectionEnabled(true);
            file.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int i = file.showOpenDialog(null);
            if (i == 1) {
                EnderecoAnexo = "";
                Anexo = null;
            } else {
                Anexo = file.getSelectedFiles();
                for (File enderec : Anexo) {
                    EnderecoAnexo = (enderec.getPath());
                    LerXML(EnderecoAnexo);
                    situacaoVisualizacao();
                    this.prontuario.setIdreceita(null);
                    this.prontuario.setIdrequisicao(null);
                    Mensagens.retornoAcao(Mensagens.LerXML());
                }
            }

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ProntuarioJIF.class.getName()).log(Level.SEVERE, null, ex);
            Mensagens.retornoAcao(Mensagens.erroLerXML());

        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnCancelar;
    private javax.swing.JToggleButton btnEditar;
    private javax.swing.JToggleButton btnPesquisar;
    private javax.swing.JToggleButton btnSalvar;
    private javax.swing.JButton btn_Exame;
    private javax.swing.JButton btn_Receita;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelAtendimento;
    private javax.swing.JPanel jPanelTriagem;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTA_CamporTextoAtendimento;
    private javax.swing.JTextArea jTA_CamporTextoTriagem;
    private javax.swing.JTextField jTF_CodigoConsulta;
    private javax.swing.JTextField jTF_NomePaciente;
    // End of variables declaration//GEN-END:variables

    @Override
    public void preencher() {
        jTA_CamporTextoAtendimento.setText(this.prontuario.getAtendimento());
        jTA_CamporTextoTriagem.setText(this.prontuario.getTriagem());
        jTF_NomePaciente.setText(this.consulta.getIdpaciente().getIdpessoa().getNomepessoa());
        jTF_CodigoConsulta.setText(this.consulta.getIdconsultas() + "");

//        this.receita = this.prontuario.getIdreceita();
//        this.requisicao = this.prontuario.getIdrequisicao();
    }

    @Override
    public void limpar() {
        jTA_CamporTextoAtendimento.setText("");
        jTA_CamporTextoTriagem.setText("");
        jTF_NomePaciente.setText("");
        jTF_CodigoConsulta.setText("");

        this.prontuario = new Prontuario();
        this.consulta = new Consultas();
        btnPesquisar.requestFocus();
    }

    @Override
    public void popular() {
        this.prontuario.setAtendimento(jTA_CamporTextoAtendimento.getText());
        this.prontuario.setTriagem(jTA_CamporTextoTriagem.getText());
//        this.prontuario.setIdreceita(receita);
//        this.prontuario.setIdrequisicao(requisicao);
    }

    @Override
    public void situacaoNovo() {
        jTA_CamporTextoAtendimento.setEnabled(false);
        jTA_CamporTextoTriagem.setEnabled(false);

        btn_Exame.setEnabled(false);
        btn_Receita.setEnabled(false);

        btnCancelar.setEnabled(true);
//        btnDeletar.setEnabled(false);
        btnEditar.setEnabled(false);
        btnPesquisar.setEnabled(true);
        btnSalvar.setEnabled(false);

        permissao();
    }

    @Override
    public void situacaoEditar() {
        jTA_CamporTextoAtendimento.setEnabled(true);
        jTA_CamporTextoTriagem.setEnabled(true);

        btn_Exame.setEnabled(true);
        btn_Receita.setEnabled(true);

        btnCancelar.setEnabled(true);
//        btnDeletar.setEnabled(false);
        btnEditar.setEnabled(false);
        btnPesquisar.setEnabled(false);
        btnSalvar.setEnabled(true);
        permissao();
    }

    @Override
    public void situacaoVisualizacao() {
        jTA_CamporTextoAtendimento.setEnabled(false);
        jTA_CamporTextoTriagem.setEnabled(false);

        btn_Exame.setEnabled(true);
        btn_Receita.setEnabled(true);

        btnCancelar.setEnabled(true);
//        btnDeletar.setEnabled(true);
        btnEditar.setEnabled(true);
        btnPesquisar.setEnabled(true);
        btnSalvar.setEnabled(false);
        permissao();
    }

    @Override
    public void permissao() {
        jTA_CamporTextoTriagem.setEnabled(PermissaoG.canUse(jTA_CamporTextoTriagem.isEnabled(), can.get(71)));
        jTA_CamporTextoAtendimento.setEnabled(PermissaoG.canUse(jTA_CamporTextoAtendimento.isEnabled(), can.get(72)));
        btn_Exame.setEnabled(PermissaoG.canUse(btn_Exame.isEnabled(), can.get(94)));
        btn_Receita.setEnabled(PermissaoG.canUse(btn_Receita.isEnabled(), can.get(95)));
        btnEditar.setEnabled(PermissaoG.canUse(btnEditar.isEnabled(), can.get(70)));
        btnPesquisar.setEnabled(PermissaoG.canUse(btnPesquisar.isEnabled(), can.get(68)));
        btnSalvar.setEnabled(PermissaoG.canUse(btnSalvar.isEnabled(), can.get(69)));
    }

    @Override
    public String[] auditoria() {
        String[] r
                = {
                    prontuario.getIdprontuario() + "",
                    prontuario.getTriagem(),
                    prontuario.getAtendimento() + "",
                    prontuario.getIdreceita() + "",
                    prontuario.getIdrequisicao() + "",};
        return r;
    }

    @Override
    public Atividade autoAuditoria(String[] iOld, String[] iNew) {
        Atividade logAuditoria = new Atividade();
        logAuditoria.setInformacaoOld(iOld);
        logAuditoria.setInformacaoNew(iNew);
        logAuditoria.setOnde(Atividade.FROM_PRONTUARIO);
        logAuditoria.setUsuario(usuario);
        return logAuditoria;
    }

    public void LerXML(String endereco) throws ParserConfigurationException {

        try {
            //objetos para construir e fazer a leitura do documento
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            //abre e faz o parser de um documento xml de acordo com o nome passado no parametro
            org.w3c.dom.Document doc = builder.parse(endereco);

            //cria uma lista de pessoas. Busca no documento todas as tag pessoa
            NodeList listaDePessoas = doc.getElementsByTagName("prontuario");

            //pego o tamanho da lista de pessoas
            int tamanhoLista = listaDePessoas.getLength();

            //varredura na lista de pessoas
            for (int i = 0; i < tamanhoLista; i++) {

                //pego cada item (pessoa) como um nó (node)
                Node noPessoa = listaDePessoas.item(i);

                //verifica se o noPessoa é do tipo element (e não do tipo texto etc)
                if (noPessoa.getNodeType() == Node.ELEMENT_NODE) {

                    //caso seja um element, converto o no Pessoa em Element pessoa
                    org.w3c.dom.Element elementoPessoa = (org.w3c.dom.Element) noPessoa;

                    //já posso pegar o atributo do element
                    String id = elementoPessoa.getAttribute("codigo");

                    //imprimindo o id
                    jTF_CodigoConsulta.setText(id);

                    //recupero os nos filhos do elemento pessoa (nome, idade e peso)
                    NodeList listaDeFilhosDaPessoa = elementoPessoa.getChildNodes();

                    //pego o tamanho da lista de filhos do elemento pessoa
                    int tamanhoListaFilhos = listaDeFilhosDaPessoa.getLength();

                    //varredura na lista de filhos do elemento pessoa
                    for (int j = 0; j < tamanhoListaFilhos; j++) {

                        //crio um no com o cada tag filho dentro do no pessoa (tag nome, idade e peso)
                        Node noFilho = listaDeFilhosDaPessoa.item(j);

                        //verifico se são tipo element
                        if (noFilho.getNodeType() == Node.ELEMENT_NODE) {

                            //converto o no filho em element filho
                            org.w3c.dom.Element elementoFilho = (org.w3c.dom.Element) noFilho;

                            //verifico em qual filho estamos pela tag
                            switch (elementoFilho.getTagName()) {
                                case "codigo":
                                    //imprimo o nome
                                    jTF_CodigoConsulta.setText(elementoFilho.getTextContent());
                                    this.prontuario.setIdprontuario(Integer.parseInt(elementoFilho.getTextContent()));
                                    break;

                                case "paciente":
                                    //imprimo o nome
                                    jTF_NomePaciente.setText(elementoFilho.getTextContent());
                                    break;

                                case "triagem":
                                    //imprimo a idade
                                    jTA_CamporTextoTriagem.setText(elementoFilho.getTextContent());
                                    this.prontuario.setTriagem(elementoFilho.getTextContent());
                                    break;

                                case "atendimento":
                                    //imprimo o peso
                                    jTA_CamporTextoAtendimento.setText(elementoFilho.getTextContent());
                                    this.prontuario.setAtendimento(elementoFilho.getTextContent());
                                    break;

                            }
                        }
                    }
                }
            }

        } catch (ParserConfigurationException ex) {
            java.util.logging.Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            java.util.logging.Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
