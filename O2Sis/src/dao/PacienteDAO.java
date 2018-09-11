package dao;

import javax.swing.JTable;
import negocio.Pessoa;
import persistencia.DAO;
import persistencia.IDAO_T;
import gema.Gema;
import gema.Mensagens;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import negocio.Exames;
import negocio.Paciente;
import org.hibernate.HibernateException;

/**
 *
 * @author elias.flach
 */
public class PacienteDAO extends DAO implements IDAO_T<Paciente> {

    @Override
    public void preencherTabelaBusca(JTable tabela, String criterio) {
        List array = null;
//        Total de colunas
        int columAll = 2;
//        Definição do cabecalho.
        Object[] cabecalho = new Object[columAll];
        cabecalho[0] = "Código Paciente";
        cabecalho[1] = "Nome Paciente";

//        Preencha com o nome da tabela.
        String table = "Paciente";

        //Executa a busca
        if (Gema.vazio(criterio, 1)) {
            array = this.selectWithJoin(table, "nome_pessoa ilike '%" + criterio + "%' order by nome_pessoa asc");
        } else {
            array = this.select(table+ " order by idpaciente asc");
        }

        //Definição dos dados da tabela.
        Object[][] dadosTabela = new Object[array.size()][columAll];
        int i = 0;
        try {
            for (Object o : array) {
                Paciente k = (Paciente) o;
//              Definir os dados das colunas
                dadosTabela[i][0] = k.getIdpaciente();
                dadosTabela[i][1] = k.getIdpessoa().getNomePessoa();

                i++;
            }
        } catch (HibernateException he) {
            Mensagens.retornoAcao(
                    Mensagens.problemaPopularTabela("Paciente")
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
                case 2:
                    column.setPreferredWidth(145);
                    break;
            }
        }

    }

    @Override
    public Paciente consultarId(int id) {
        Object o = this.selectWithJoin("Paciente", "idpaciente = " + id).get(0);
        return (Paciente) o;
    }

}
