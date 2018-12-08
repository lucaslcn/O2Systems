package graficos;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import negocio.Consultas;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/* @author XorNOTE */
public class GraficoBaras_ConsultaPorPlanos {
    //criar o dataset
    public CategoryDataset createDataSet(List<Consultas> consulta){
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        TreeMap<String, List<Consultas>> resultado = new TreeMap();
        for (Consultas c : consulta){
            String key = c.getIdplano().getIdplano() + ": " + c.getIdplano().getNomePlano();
            if (resultado.containsKey(key)) {
                List<Consultas> temp = resultado.get(key);
                temp.add(c);
                
                resultado.put(key, temp);
            } else {
                List<Consultas> temp = new ArrayList();
                temp.add(c);
                
                resultado.put(key, temp);
            }
        }
        
        for (String s : resultado.keySet()) {
            List<Consultas> c = resultado.get(s);
            String nomePlano = c.get(0).getIdplano().getIdplano() + ": " + c.get(0).getIdplano().getNomePlano();
            dataSet.addValue(c.size(), nomePlano, "");
        }
        
        return dataSet;
    }
    //criar o gráfico de barras
    public JFreeChart createBarChart(CategoryDataset dataSet){
        JFreeChart graficoBarras = ChartFactory.createBarChart("Consultas por Planos", "", "Consultas", dataSet, PlotOrientation.VERTICAL, true, false, false);
        return graficoBarras;
    }
    //criar o gráfico completo
    public ChartPanel criarGrafico( List<Consultas> consulta ){
        CategoryDataset dataset = this.createDataSet(consulta);
        JFreeChart grafico = createBarChart(dataset);
        
        ChartPanel painel = new ChartPanel(grafico);
        //painel.setPreferredSize(new Dimension(500, 350));
        
        return painel;
    }
}
