/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import dao.ConsultasDAO;
import java.awt.BorderLayout;
import java.util.List;
import negocio.Consultas;
import graficos.*;

/**
 *
 * @author XorNOTE
 */
public class JanelaGraficoDashbordJIF extends javax.swing.JInternalFrame {

    /**
     * Creates new form JanelaGraficoDashbordJIF
     */
    public JanelaGraficoDashbordJIF() {
        initComponents();
        
        this.graficoUm();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        graficoUm = new javax.swing.JPanel();

        setClosable(true);

        graficoUm.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout graficoUmLayout = new javax.swing.GroupLayout(graficoUm);
        graficoUm.setLayout(graficoUmLayout);
        graficoUmLayout.setHorizontalGroup(
            graficoUmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 876, Short.MAX_VALUE)
        );
        graficoUmLayout.setVerticalGroup(
            graficoUmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 494, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(graficoUm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(294, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(graficoUm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel graficoUm;
    // End of variables declaration//GEN-END:variables
    public void graficoUm(){
        graficoUm.setLayout(new BorderLayout());
        
        List <Consultas> consultas = new ConsultasDAO().select("Consultas");
        
        GraficoBaras_ConsultaPorMedicos g = new GraficoBaras_ConsultaPorMedicos();
        
        this.graficoUm.add( g.criarGrafico(consultas) );
        
        pack();
    }
}