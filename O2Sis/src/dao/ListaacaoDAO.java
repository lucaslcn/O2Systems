package dao;

import javax.swing.JTable;
import persistencia.DAO;
import persistencia.IDAO_T;
import gema.Gema;
import gema.Mensagens;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import negocio.Listaacao;
import negocio.Tela;
import org.hibernate.HibernateException;

/**
 *
 * @author anderson.caye
 */
public class ListaacaoDAO extends DAO implements IDAO_T<Listaacao> {

    @Override
    public void preencherTabelaBusca(JTable tabela, String criterio) {
        List array = null;
//        Total de colunas
        int columAll = 3;
//        Definição do cabecalho.
        Object[] cabecalho = new Object[columAll];
        cabecalho[0] = "Código";
        cabecalho[1] = "Nome Tela";
        cabecalho[2] = "Nome Ação";

//        Preencha com o nome da tabela.
        String table = "Listaacao";

        //Executa a busca
        if (Gema.vazio(criterio, 1)) {
            array = this.selectWithJoin(table, "nome_exame ilike '%" + criterio + "%' and status = true order by nome_exame asc");
        } else {
            array = this.select(table + " order by idtela, idacaotela asc");
        }

        //Definição dos dados da tabela.
        Object[][] dadosTabela = new Object[array.size()][columAll];
        int i = 0;
        try {
            for (Object o : array) {
                Listaacao k = (Listaacao) o;
//              Definir os dados das colunas
                dadosTabela[i][0] = k.getIdlistaacao();
                dadosTabela[i][1] = k.getIdtela().getNomeTela();
                dadosTabela[i][2] = k.getIdacaotela().getNomeAcao();

                i++;
            }
        } catch (HibernateException he) {
            Mensagens.retornoAcao(
                    Mensagens.problemaPopularTabela("Lista Acão")
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
                    column.setPreferredWidth(57);
                    break;
                case 1:
                    column.setPreferredWidth(236);
                    break;
                case 2:
                    column.setPreferredWidth(236);
                    break;
            }
        }

    }

    @Override
    public Listaacao consultarId(int id) {
        Object o = this.selectWithJoin("Listaacao", "idlistaacao = " + id).get(0);
        return (Listaacao) o;
    }

}
