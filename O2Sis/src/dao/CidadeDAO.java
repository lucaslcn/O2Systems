/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import gema.Gema;
import gema.Mensagens;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import negocio.Cidade;
import negocio.Estado;
import org.hibernate.HibernateException;
import persistencia.DAO;
import persistencia.IDAO_T;

/**
 *
 * @author lucas.lucian
 */
public class CidadeDAO extends DAO implements IDAO_T<Cidade>{

    @Override
    public void preencherTabelaBusca(JTable tabela, String criterio) {
        List array = null;
//        Total de colunas
        int columAll = 3;
//        Definição do cabecalho.
        Object[] cabecalho = new Object[columAll];
        cabecalho[0] = "Codigo";
        cabecalho[1] = "Cidade";
        cabecalho[2] = "Estado";

//        Preencha com o nome da tabela.
        String table = "Cidade";

        //Executa a busca
        if (Gema.vazio(criterio, 1)) {
            array = this.selectWithJoin(table, "nome_cidade ilike '%" + criterio + "%' order by nome_cidade asc");
        } else {
            array = this.select(table + " order by nome_cidade asc");
        }

        //Definicao dos dados da tabela.
        Object[][] dadosTabela = new Object[array.size()][columAll];
        int i = 0;
        try {
            for (Object o : array) {
                Cidade k = (Cidade) o;
//              Definir os dados das colunas
                dadosTabela[i][0] = k.getIdcidade();
                dadosTabela[i][1] = k.getNomeCidade();
                dadosTabela[i][2] = k.getIdestado().getUf();

                i++;
            }
        } catch (HibernateException he) {
            Mensagens.retornoAcao(
                    Mensagens.problemaPopularTabela("Cidade")
                    + Mensagens.mensagemTecnica(he.toString())
            );
        }
        
        
        tabela.setModel(new DefaultTableModel(dadosTabela, cabecalho) {
            @Override
            // quando retorno for FALSE, a tabela nao é editavel
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            // alteracao no metodo que determina a coluna em que o objeto ImageIcon devera aparecer
            @Override
            public Class getColumnClass(int column) {

                if (column == 2) {
//                    return ImageIcon.class;
                }
                return Object.class;
            }
        });

        // permite seleção de apenas uma linha da tabela
        tabela.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
//        580px tamanho da tabela
        TableColumn column = null;
        for (int j = 0; j < tabela.getColumnCount(); j++) {
            column = tabela.getColumnModel().getColumn(j);
            switch (j) {
                case 0:
                    column.setPreferredWidth(145);
                    break;
                case 1:
                    column.setPreferredWidth(435);
                    break;
            }
        }

    }

    @Override
    public Cidade consultarId(int id) {
        Object o = this.selectWithJoin("Cidade", "idcidade = " + id).get(0);
        return (Cidade) o;
    }
    
    
    
}
