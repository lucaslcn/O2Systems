/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import dao.UsuarioDAO;
import negocio.Usuario;
import registros.Permissao;

/**
 *
 * @author anderson.caye
 */
public class PrincipalJF extends javax.swing.JFrame {

    Usuario usuario;
        
    /**
     * Creates new form Principal
     */
    public PrincipalJF(Usuario usuario) {
        this.setExtendedState(MAXIMIZED_BOTH);
        initComponents();
        this.usuario = usuario;
        permissao();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jDesktopRun = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuO2System = new javax.swing.JMenu();
        itemMenuDadosAcesso = new javax.swing.JMenuItem();
        itemMenuUsuario = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        itemMenuAuditoria = new javax.swing.JMenuItem();
        itemMenuSobre = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        itemMenuLogout = new javax.swing.JMenuItem();
        itemMenuSair = new javax.swing.JMenuItem();
        menuCadastro = new javax.swing.JMenu();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        itemMenuFuncionario = new javax.swing.JMenuItem();
        itemMenuPaciente = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        itemMenuPlano = new javax.swing.JMenuItem();
        itemMenuRemedio = new javax.swing.JMenuItem();
        itemMenuExame = new javax.swing.JMenuItem();
        itemMenuFormaPagamento = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        menuAgendamento = new javax.swing.JMenu();
        itemMenuConsultasMarcadas = new javax.swing.JMenuItem();
        itemMenuExamesMarcados = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        itemMenuAgendarConsulta = new javax.swing.JMenuItem();
        itemMenuAgendarExames = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        itemMenuProntuario = new javax.swing.JMenuItem();
        menuRelatorios = new javax.swing.JMenu();

        jMenuItem5.setText("jMenuItem5");

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("O2 Systems");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/bg_principal.jpg"))); // NOI18N

        jDesktopRun.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopRunLayout = new javax.swing.GroupLayout(jDesktopRun);
        jDesktopRun.setLayout(jDesktopRunLayout);
        jDesktopRunLayout.setHorizontalGroup(
            jDesktopRunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
        );
        jDesktopRunLayout.setVerticalGroup(
            jDesktopRunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopRunLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jMenuBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        menuO2System.setText("O2 Systems");

        itemMenuDadosAcesso.setText("Dados de Acesso");
        menuO2System.add(itemMenuDadosAcesso);

        itemMenuUsuario.setText("Usuários");
        menuO2System.add(itemMenuUsuario);
        menuO2System.add(jSeparator5);

        itemMenuAuditoria.setText("Auditoria");
        itemMenuAuditoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuAuditoriaActionPerformed(evt);
            }
        });
        menuO2System.add(itemMenuAuditoria);

        itemMenuSobre.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F11, 0));
        itemMenuSobre.setText("Sobre");
        itemMenuSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuSobreActionPerformed(evt);
            }
        });
        menuO2System.add(itemMenuSobre);
        menuO2System.add(jSeparator4);

        itemMenuLogout.setText("Logout");
        itemMenuLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuLogoutActionPerformed(evt);
            }
        });
        menuO2System.add(itemMenuLogout);

        itemMenuSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F12, 0));
        itemMenuSair.setText("Sair");
        itemMenuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuSairActionPerformed(evt);
            }
        });
        menuO2System.add(itemMenuSair);

        jMenuBar1.add(menuO2System);

        menuCadastro.setText("Cadastro");
        menuCadastro.add(jSeparator2);

        itemMenuFuncionario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        itemMenuFuncionario.setText("Funcionário");
        itemMenuFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuFuncionarioActionPerformed(evt);
            }
        });
        menuCadastro.add(itemMenuFuncionario);

        itemMenuPaciente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        itemMenuPaciente.setText("Paciente");
        itemMenuPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuPacienteActionPerformed(evt);
            }
        });
        menuCadastro.add(itemMenuPaciente);
        menuCadastro.add(jSeparator1);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem3.setText("Estado");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        menuCadastro.add(jMenuItem3);

        itemMenuPlano.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
        itemMenuPlano.setText("Plano");
        itemMenuPlano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuPlanoActionPerformed(evt);
            }
        });
        menuCadastro.add(itemMenuPlano);

        itemMenuRemedio.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.ALT_MASK));
        itemMenuRemedio.setText("Remédio");
        itemMenuRemedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuRemedioActionPerformed(evt);
            }
        });
        menuCadastro.add(itemMenuRemedio);

        itemMenuExame.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK));
        itemMenuExame.setText("Exame");
        itemMenuExame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuExameActionPerformed(evt);
            }
        });
        menuCadastro.add(itemMenuExame);

        itemMenuFormaPagamento.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.ALT_MASK));
        itemMenuFormaPagamento.setText("Forma Pagamento");
        itemMenuFormaPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuFormaPagamentoActionPerformed(evt);
            }
        });
        menuCadastro.add(itemMenuFormaPagamento);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem2.setText("Função");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menuCadastro.add(jMenuItem2);

        jMenuBar1.add(menuCadastro);

        menuAgendamento.setText("Agendamento");

        itemMenuConsultasMarcadas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        itemMenuConsultasMarcadas.setText("Consultas Marcadas");
        menuAgendamento.add(itemMenuConsultasMarcadas);

        itemMenuExamesMarcados.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        itemMenuExamesMarcados.setText("Exames Marcados");
        menuAgendamento.add(itemMenuExamesMarcados);
        menuAgendamento.add(jSeparator3);

        itemMenuAgendarConsulta.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        itemMenuAgendarConsulta.setText("Agendar Consultas");
        itemMenuAgendarConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuAgendarConsultaActionPerformed(evt);
            }
        });
        menuAgendamento.add(itemMenuAgendarConsulta);

        itemMenuAgendarExames.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        itemMenuAgendarExames.setText("Agendar Exames");
        itemMenuAgendarExames.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuAgendarExamesActionPerformed(evt);
            }
        });
        menuAgendamento.add(itemMenuAgendarExames);
        menuAgendamento.add(jSeparator6);

        itemMenuProntuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        itemMenuProntuario.setText("Prontuário");
        itemMenuProntuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuProntuarioActionPerformed(evt);
            }
        });
        menuAgendamento.add(itemMenuProntuario);

        jMenuBar1.add(menuAgendamento);

        menuRelatorios.setText("Relatórios");
        jMenuBar1.add(menuRelatorios);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopRun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopRun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemMenuFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuFuncionarioActionPerformed
        CadastroFuncionarioJIF k = new CadastroFuncionarioJIF(this.usuario);
        jDesktopRun.add(k);
        k.setLocation(this.getWidth() / 2 - k.getWidth() / 2, /*this.getHeight() / 2 - k.getHeight() / 2*/ 0);
        k.setVisible(true);
    }//GEN-LAST:event_itemMenuFuncionarioActionPerformed

    private void itemMenuPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuPacienteActionPerformed
        CadastroPacienteJIF k = new CadastroPacienteJIF(this.usuario);
        jDesktopRun.add(k);
        k.setLocation(this.getWidth() / 2 - k.getWidth() / 2, /*this.getHeight() / 2 - k.getHeight() / 2*/ 0);
        k.setVisible(true);
    }//GEN-LAST:event_itemMenuPacienteActionPerformed

    private void itemMenuPlanoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuPlanoActionPerformed
        CadastroPlanoSaudeJIF k = new CadastroPlanoSaudeJIF(this.usuario);
        jDesktopRun.add(k);
        k.setLocation(this.getWidth() / 2 - k.getWidth() / 2, /*this.getHeight() / 2 - k.getHeight() / 2*/ 10);
        k.setVisible(true);
    }//GEN-LAST:event_itemMenuPlanoActionPerformed

    private void itemMenuRemedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuRemedioActionPerformed
        CadastroRemedioJIF k = new CadastroRemedioJIF(this.usuario);
        jDesktopRun.add(k);
        k.setLocation(this.getWidth() / 2 - k.getWidth() / 2, /*this.getHeight() / 2 - k.getHeight() / 2*/ 10);
        k.setVisible(true);
    }//GEN-LAST:event_itemMenuRemedioActionPerformed

    private void itemMenuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_itemMenuSairActionPerformed

    private void itemMenuFormaPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuFormaPagamentoActionPerformed
        CadastroFormaPagamentoJIF k = new CadastroFormaPagamentoJIF(this.usuario);
        jDesktopRun.add(k);
        k.setLocation(this.getWidth() / 2 - k.getWidth() / 2, /*this.getHeight() / 2 - k.getHeight() / 2*/ 10);
        k.setVisible(true);
    }//GEN-LAST:event_itemMenuFormaPagamentoActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        CadastroFuncaoJIF k = new CadastroFuncaoJIF(this.usuario);
        jDesktopRun.add(k);
        k.setLocation(this.getWidth() / 2 - k.getWidth() / 2, /*this.getHeight() / 2 - k.getHeight() / 2*/ 10);
        k.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        CadastroEstadoJIF k = new CadastroEstadoJIF(this.usuario);
        jDesktopRun.add(k);
        k.setLocation(this.getWidth() / 2 - k.getWidth() / 2, /*this.getHeight() / 2 - k.getHeight() / 2*/ 10);
        k.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void itemMenuExameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuExameActionPerformed
        CadastroExameJIF k = new CadastroExameJIF(this.usuario);
        jDesktopRun.add(k);
        k.setLocation(this.getWidth() / 2 - k.getWidth() / 2, /*this.getHeight() / 2 - k.getHeight() / 2*/ 10);
        k.setVisible(true);
    }//GEN-LAST:event_itemMenuExameActionPerformed

    private void itemMenuSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuSobreActionPerformed
        SobreJIF k = new SobreJIF();
        jDesktopRun.add(k);
        k.setLocation(this.getWidth() / 2 - k.getWidth() / 2, /*this.getHeight() / 2 - k.getHeight() / 2*/ 10);
        k.setVisible(true);
    }//GEN-LAST:event_itemMenuSobreActionPerformed

    private void itemMenuAuditoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuAuditoriaActionPerformed
        AuditoriaJIF k = new AuditoriaJIF(this.usuario);
        jDesktopRun.add(k);
        k.setLocation(this.getWidth() / 2 - k.getWidth() / 2, /*this.getHeight() / 2 - k.getHeight() / 2*/ 10);
        k.setVisible(true);
    }//GEN-LAST:event_itemMenuAuditoriaActionPerformed

    private void itemMenuProntuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuProntuarioActionPerformed
        ProntuarioJIF k = new ProntuarioJIF(this.usuario);
        jDesktopRun.add(k);
        k.setLocation(this.getWidth() / 2 - k.getWidth() / 2, /*this.getHeight() / 2 - k.getHeight() / 2*/ 10);
        k.setVisible(true);
    }//GEN-LAST:event_itemMenuProntuarioActionPerformed

    private void itemMenuAgendarExamesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuAgendarExamesActionPerformed
        AgendamentoExamesJIF k = new AgendamentoExamesJIF(this.usuario);
        jDesktopRun.add(k);
        k.setLocation(this.getWidth() / 2 - k.getWidth() / 2, /*this.getHeight() / 2 - k.getHeight() / 2*/ 10);
        k.setVisible(true);
    }//GEN-LAST:event_itemMenuAgendarExamesActionPerformed

    private void itemMenuAgendarConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuAgendarConsultaActionPerformed
        AgendamentoConsultaJIF k = new AgendamentoConsultaJIF(this.usuario);
        jDesktopRun.add(k);
        k.setLocation(this.getWidth() / 2 - k.getWidth() / 2, /*this.getHeight() / 2 - k.getHeight() / 2*/ 10);
        k.setVisible(true);
        
    }//GEN-LAST:event_itemMenuAgendarConsultaActionPerformed

    private void itemMenuLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuLogoutActionPerformed
        LoginJF login = new LoginJF();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_itemMenuLogoutActionPerformed

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(PrincipalJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(PrincipalJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(PrincipalJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(PrincipalJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new PrincipalJF().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemMenuAgendarConsulta;
    private javax.swing.JMenuItem itemMenuAgendarExames;
    private javax.swing.JMenuItem itemMenuAuditoria;
    private javax.swing.JMenuItem itemMenuConsultasMarcadas;
    private javax.swing.JMenuItem itemMenuDadosAcesso;
    private javax.swing.JMenuItem itemMenuExame;
    private javax.swing.JMenuItem itemMenuExamesMarcados;
    private javax.swing.JMenuItem itemMenuFormaPagamento;
    private javax.swing.JMenuItem itemMenuFuncionario;
    private javax.swing.JMenuItem itemMenuLogout;
    private javax.swing.JMenuItem itemMenuPaciente;
    private javax.swing.JMenuItem itemMenuPlano;
    private javax.swing.JMenuItem itemMenuProntuario;
    private javax.swing.JMenuItem itemMenuRemedio;
    private javax.swing.JMenuItem itemMenuSair;
    private javax.swing.JMenuItem itemMenuSobre;
    private javax.swing.JMenuItem itemMenuUsuario;
    private javax.swing.JDesktopPane jDesktopRun;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JMenu menuAgendamento;
    private javax.swing.JMenu menuCadastro;
    private javax.swing.JMenu menuO2System;
    private javax.swing.JMenu menuRelatorios;
    // End of variables declaration//GEN-END:variables

    private void permissao() {
        itemMenuAuditoria.setEnabled(Permissao.canUse(Permissao.FROM_AUDITORIA, usuario.getIdpermissao().getValorpermissao(), itemMenuAuditoria.isEnabled()));
        
        itemMenuAgendarConsulta.setEnabled(Permissao.canUse(Permissao.FROM_AGEN_CONSULTA, usuario.getIdpermissao().getValorpermissao(), itemMenuAgendarConsulta.isEnabled()));
        itemMenuAgendarExames.setEnabled(Permissao.canUse(Permissao.FROM_AGEN_EXAME, usuario.getIdpermissao().getValorpermissao(), itemMenuAgendarExames.isEnabled()));
        itemMenuConsultasMarcadas.setEnabled(Permissao.canUse(Permissao.FROM_CONSULAS_MARCADAS, usuario.getIdpermissao().getValorpermissao(), itemMenuConsultasMarcadas.isEnabled()));
        itemMenuDadosAcesso.setEnabled(Permissao.canUse(Permissao.FROM_DADOS_ACESSO, usuario.getIdpermissao().getValorpermissao(), itemMenuDadosAcesso.isEnabled()));
        itemMenuExame.setEnabled(Permissao.canUse(Permissao.FROM_CAD_EXAME, usuario.getIdpermissao().getValorpermissao(), itemMenuExame.isEnabled()));
        itemMenuExamesMarcados.setEnabled(Permissao.canUse(Permissao.FROM_EXAMES_MARCADOS, usuario.getIdpermissao().getValorpermissao(), itemMenuExamesMarcados.isEnabled()));
        itemMenuFormaPagamento.setEnabled(Permissao.canUse(Permissao.FROM_CAD_FORMA_PGTO, usuario.getIdpermissao().getValorpermissao(), itemMenuFormaPagamento.isEnabled()));
        itemMenuFuncionario.setEnabled(Permissao.canUse(Permissao.FROM_CAD_FUNCIONARIO, usuario.getIdpermissao().getValorpermissao(), itemMenuFuncionario.isEnabled()));
        itemMenuPaciente.setEnabled(Permissao.canUse(Permissao.FROM_CAD_PACIENTE, usuario.getIdpermissao().getValorpermissao(), itemMenuPaciente.isEnabled()));
        itemMenuPlano.setEnabled(Permissao.canUse(Permissao.FROM_CAD_PALANO_SAUDE, usuario.getIdpermissao().getValorpermissao(), itemMenuPlano.isEnabled()));
        itemMenuProntuario.setEnabled(Permissao.canUse(Permissao.FROM_PRONTUARIO, usuario.getIdpermissao().getValorpermissao(), itemMenuProntuario.isEnabled()));
        itemMenuRemedio.setEnabled(Permissao.canUse(Permissao.FROM_CAD_REMEDIO, usuario.getIdpermissao().getValorpermissao(), itemMenuAuditoria.isEnabled()));
        itemMenuUsuario.setEnabled(Permissao.canUse(Permissao.FROM_DADOS_USUARIO, usuario.getIdpermissao().getValorpermissao(), itemMenuUsuario.isEnabled()));
    }
}