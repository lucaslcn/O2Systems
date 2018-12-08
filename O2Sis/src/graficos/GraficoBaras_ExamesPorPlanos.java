package graficos;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import negocio.AgendamentoExames;
import negocio.Consultas;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/* @author XorNOTE */
public class GraficoBaras_ExamesPorPlanos {
    //criar o dataset
    public CategoryDataset createDataSet(List<AgendamentoExames> exames){
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        TreeMap<String, List<AgendamentoExames>> resultado = new TreeMap();
        for (AgendamentoExames c : exames){
            String key = c.getIdplano().getIdplano() + ": " + c.getIdplano().getNomePlano();
            if (resultado.containsKey(key)) {
                List<AgendamentoExames> temp = resultado.get(key);
                temp.add(c);
                
                resultado.put(key, temp);
            } else {
                List<AgendamentoExames> temp = new ArrayList();
                temp.add(c);
                
                resultado.put(key, temp);
            }
        }
        
        for (String s : resultado.keySet()) {
            List<AgendamentoExames> c = resultado.get(s);
            String nomePlano = c.get(0).getIdplano().getIdplano() + ": " + c.get(0).getIdplano().getNomePlano();
            dataSet.addValue(c.size(), nomePlano, "");
        }
        
        return dataSet;
    }
    //criar o gráfico de barras
    public JFreeChart createBarChart(CategoryDataset dataSet){
        JFreeChart graficoBarras = ChartFactory.createBarChart("Exames por Planos", "", "Exames", dataSet, PlotOrientation.VERTICAL, true, false, false);
        return graficoBarras;
    }
    //criar o gráfico completo
    public ChartPanel criarGrafico( List<AgendamentoExames> exames ){
        CategoryDataset dataset = this.createDataSet(exames);
        JFreeChart grafico = createBarChart(dataset);
        
        ChartPanel painel = new ChartPanel(grafico);
        //painel.setPreferredSize(new Dimension(500, 350));
        
        return painel;
    }
}
