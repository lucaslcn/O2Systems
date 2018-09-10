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
import negocio.Prontuario;
import org.hibernate.HibernateException;

/**
 *
 * @author elias.flach
 */
public class ProntuarioDAO extends DAO implements IDAO_T<Prontuario> {

    @Override
    public void preencherTabelaBusca(JTable tabela, String criterio) {
        List array = null;
//        Total de colunas
        int columAll = 3;
//        Definição do cabecalho.
        Object[] cabecalho = new Object[columAll];
        cabecalho[0] = "Código Prontuário";
        cabecalho[1] = "Código Consulta";
        cabecalho[2] = "Nome Paciente";

//        Preencha com o nome da tabela.
        String table = "Prontuario";

        //Executa a busca
        if (Gema.vazio(criterio, 1)) {
            array = this.selectWithJoin(table, "nome_exame ilike '%" + criterio + "%' and status = true order by nome_exame asc");
        } else {
            array = this.select(table + " order by idprontuario asc");
        }

        //Definição dos dados da tabela.
        Object[][] dadosTabela = new Object[array.size()][columAll];
        int i = 0;
        try {
            for (Object o : array) {
                Prontuario k = (Prontuario) o;
//              Definir os dados das colunas
                dadosTabela[i][0] = k.getIdprontuario();
                dadosTabela[i][1] = k.getConsultasList().get(0).getIdconsultas();
                dadosTabela[i][2] = k.getConsultasList().get(0).getIdpaciente().getIdpessoa().getNomePessoa();

                i++;
            }
        } catch (HibernateException he) {
            Mensagens.retornoAcao(
                    Mensagens.problemaPopularTabela("Prontuarios")
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
                    column.setPreferredWidth(145);
                    break;
                case 2:
                    column.setPreferredWidth(290);
                    break;
            }
        }

    }

    @Override
    public Prontuario consultarId(int id) {
        Object o = this.selectWithJoin("Prontuario", "idprontiario = " + id).get(0);
        return (Prontuario) o;
    }

}
