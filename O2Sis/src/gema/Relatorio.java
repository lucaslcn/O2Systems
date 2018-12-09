/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gema;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author XorNOTE
 */
public class Relatorio {
    
    public void gerarListagem(String caminho, List tabela){
        try {
            // Compila o relatorio
            JasperReport relatorio = JasperCompileManager.compileReport( getClass().getResourceAsStream("/relatorios/"+caminho));

            // Mapeia campos de parametros para o relatorio, mesmo que nao existam
            Map parametros = new HashMap();

            // Executa relatoio
            JasperPrint impressao = JasperFillManager.fillReport(relatorio, parametros, new JRBeanCollectionDataSource(tabela));

            // Exibe resultado em video
            JasperViewer.viewReport(impressao, false);
//            JasperExportManager.exportReportToPdfFile("Relatório O2systems");
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório: " + e);
        }
    }
    
    public void gerarRelatorio(String caminho, HashMap parametros, List tabela){
        try {
            // Compila o relatorio
            JasperReport relatorio = JasperCompileManager.compileReport(getClass().getResourceAsStream("/relatorios/"+caminho));

            // Mapeia campos de parametros para o relatorio, mesmo que nao existam
            HashMap param = parametros;

//            // adiciona parametros
//            param.put("dataInicial", dataInicial.getText());
//            param.put("dataFinal", dataFinal.getText());

            // Executa relatoio
            JasperPrint impressao = JasperFillManager.fillReport(relatorio, param, new JRBeanCollectionDataSource(tabela) );

            // Exibe resultado em video
            JasperViewer.viewReport(impressao, false);
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório: " + e);
        }
    }
    
}
