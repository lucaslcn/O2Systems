/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import gema.Mensagens;
import java.awt.Color;
import java.util.TreeMap;
import negocio.Usuario;
import registros.LogAuditoria;
import registros.PermissaoG;

/**
 *
 * @author XorNOTE
 */
public class AuditoriaJIF extends javax.swing.JInternalFrame {
    Usuario usuario;
    TreeMap<Integer, Boolean> can;
    /**
     * Creates new form AuditoriaJIF
     */
    public AuditoriaJIF(Usuario u, TreeMap<Integer, Boolean> can) {
        initComponents();
        this.usuario = u;
        this.can = can;
        if( LogAuditoria.status() ){
            ligado();
        } else {
            desligado();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jL_titulo = new javax.swing.JLabel();
        jP_btnDeAcao = new javax.swing.JPanel();
        btnLigado = new javax.swing.JButton();
        btnDesligado = new javax.swing.JButton();
        btnRegistros = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        jL_status = new javax.swing.JLabel();

        setTitle("Controle de Auditoria");

        jL_titulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jL_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jL_titulo.setText("Auditoria");

        btnLigado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/lightbulb.png"))); // NOI18N
        btnLigado.setText("Ligado");
        btnLigado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLigadoActionPerformed(evt);
            }
        });

        btnDesligado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/lightbulb_off.png"))); // NOI18N
        btnDesligado.setText("Desligado");
        btnDesligado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesligadoActionPerformed(evt);
            }
        });

        btnRegistros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/report.png"))); // NOI18N
        btnRegistros.setText("Registros");
        btnRegistros.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnRegistros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrosActionPerformed(evt);
            }
        });

        btnFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cancel.png"))); // NOI18N
        btnFechar.setText("Fechar");
        btnFechar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jP_btnDeAcaoLayout = new javax.swing.GroupLayout(jP_btnDeAcao);
        jP_btnDeAcao.setLayout(jP_btnDeAcaoLayout);
        jP_btnDeAcaoLayout.setHorizontalGroup(
            jP_btnDeAcaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP_btnDeAcaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jP_btnDeAcaoLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(btnLigado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDesligado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jP_btnDeAcaoLayout.setVerticalGroup(
            jP_btnDeAcaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_btnDeAcaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jP_btnDeAcaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLigado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDesligado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(jP_btnDeAcaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jL_status.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jL_status.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jL_status.setText("Ativado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jL_status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jL_titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jP_btnDeAcao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jL_titulo)
                .addGap(18, 18, 18)
                .addComponent(jL_status)
                .addGap(18, 18, 18)
                .addComponent(jP_btnDeAcao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLigadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLigadoActionPerformed
        String r = onOff();
        if(r == null){
            ligado();
        } else {
            Mensagens.retornoAcao(Mensagens.tivemosProblemas("altererar o status da AUDITORIA.") + Mensagens.mensagemTecnica(r));
        }
    }//GEN-LAST:event_btnLigadoActionPerformed

    private void btnDesligadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesligadoActionPerformed
        String r = onOff();
        if(r == null){
            desligado();
        } else {
            Mensagens.retornoAcao(Mensagens.tivemosProblemas("altererar o status da AUDITORIA.") + Mensagens.mensagemTecnica(r));
        }
    }//GEN-LAST:event_btnDesligadoActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnRegistrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrosActionPerformed
        RegistroAuditoriaJD p = new RegistroAuditoriaJD(new javax.swing.JFrame(), true, this.usuario);
        dispose();
        p.setLocationRelativeTo(null);
        p.setVisible(true);
    }//GEN-LAST:event_btnRegistrosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDesligado;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnLigado;
    private javax.swing.JButton btnRegistros;
    private javax.swing.JLabel jL_status;
    private javax.swing.JLabel jL_titulo;
    private javax.swing.JPanel jP_btnDeAcao;
    // End of variables declaration//GEN-END:variables
    private void ligado(){
        btnLigado.setEnabled(false);
        btnLigado.setBackground(Color.LIGHT_GRAY);
        btnDesligado.setEnabled(true);
        btnDesligado.setBackground(Color.RED);
        
        jL_status.setText("Ligada");
//        jL_status.setForeground(Color.GREEN);
        
        permissao();
    }
    
    private void desligado(){
        btnLigado.setEnabled(true);
        btnLigado.setBackground(Color.GREEN);
        btnDesligado.setEnabled(false);
        btnDesligado.setBackground(Color.LIGHT_GRAY);
        
        jL_status.setText("Desligada");
//        jL_status.setForeground(Color.red);
        
        permissao();
    }
    
    private String onOff(){
        return LogAuditoria.onOff(this.usuario);
    }
    
    private void permissao(){
        btnDesligado.setName("15");
        btnLigado.setName("14");
        btnRegistros.setName("16");
        PermissaoG.myCan(can, jP_btnDeAcao.getComponents());
    }
}


