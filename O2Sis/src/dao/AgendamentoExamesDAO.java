package dao;

import gema.Formatacao;
import javax.swing.JTable;
import negocio.Pessoa;
import persistencia.DAO;
import persistencia.IDAO_T;
import gema.Gema;
import gema.Mensagens;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import negocio.AgendamentoExames;
import negocio.Exames;
import negocio.Plano;
import org.hibernate.HibernateException;

/**
 *
 * @author elias.flach
 */
public class AgendamentoExamesDAO extends DAO implements IDAO_T<AgendamentoExames> {

    @Override
    public void preencherTabelaBusca(JTable tabela, String criterio) {
        List array = null;
//        Total de colunas
        int columAll = 5;
//        Definição do cabecalho.
        Object[] cabecalho = new Object[columAll];
        cabecalho[0] = "Código";
        cabecalho[1] = "Nome do Paciente";
        cabecalho[2] = "Nome do Exame";
        cabecalho[3] = "Data";
        cabecalho[4] = "Hora";

//        Preencha com o nome da tabela.
        String table = "AgendamentoExames";

        //Executa a busca
        if (Gema.vazio(criterio, 1)) {
            array = this.selectWithJoin(table, "nome_exame ilike '%" + criterio + "%' and status = true order by nome_exame asc");
        } else {
            array = this.selectWithJoin(table, " status = true order by idagendamento_exames ASC");
        }

        //Definição dos dados da tabela.
        Object[][] dadosTabela = new Object[array.size()][columAll];
        int i = 0;
        try {
            for (Object o : array) {
                AgendamentoExames k = (AgendamentoExames) o;
//              Definir os dados das colunas
                dadosTabela[i][0] = k.getIdagendamentoExames();
                dadosTabela[i][1] = k.getIdpaciente().getIdpessoa().getNomePessoa();
                dadosTabela[i][2] = k.getIdexame().getNomeExame();
                dadosTabela[i][3] = Formatacao.ajustaDataDMA(k.getDataExame().toString());
                dadosTabela[i][4] = k.getHoraExame();

                i++;
            }
        } catch (HibernateException he) {
            Mensagens.retornoAcao(
                    Mensagens.problemaPopularTabela("Agendamento Exames")
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
                    column.setPreferredWidth(290);
                    break;
                case 2:
                    column.setPreferredWidth(145);
                    break;
            }
        }

    }

    @Override
    public AgendamentoExames consultarId(int id) {
        Object o = this.selectWithJoin("AgendamentoExames", "idagendamento_exames = " + id).get(0);
        return (AgendamentoExames) o;
    }

    public void preencherTabelaBuscaNomeCliente(JTable tabela, String criterio) {
        List array = null;
//        Total de colunas
        int columAll = 3;
//        Definição do cabecalho.
        Object[] cabecalho = new Object[columAll];
        cabecalho[0] = "Nome";
        cabecalho[1] = "CPF";

//        Preencha com o nome da tabela.
        String table = "Pessoa";

        //Executa a busca
        if (Gema.vazio(criterio, 1)) {
            array = this.selectWithJoin(table, "nome_pessoa ilike '%" + criterio + "%' order by nome_pessoa asc");
        } else {
            array = this.selectWithJoin(table, "order by nome_pessoa asc");
        }

        //Definição dos dados da tabela.
        Object[][] dadosTabela = new Object[array.size()][columAll];
        int i = 0;
        try {
            for (Object o : array) {
                Pessoa k = (Pessoa) o;
//              Definir os dados das colunas
                dadosTabela[i][0] = k.getIdpessoa();
                dadosTabela[i][1] = k.getNomePessoa();

                i++;
            }
        } catch (HibernateException he) {
            Mensagens.retornoAcao(
                    Mensagens.problemaPopularTabela("Exames")
                    + Mensagens.mensagemTecnica(he.toString())
            );
        }

    }
    
    public void preencherTabelaBuscaExame(JTable tabela, String criterio) {
        List array = null;
//        Total de colunas
        int columAll = 3;
//        Definição do cabecalho.
        Object[] cabecalho = new Object[columAll];
        cabecalho[0] = "Descrição";

//        Preencha com o nome da tabela.
        String table = "Exames";

        //Executa a busca
        if (Gema.vazio(criterio, 1)) {
            array = this.selectWithJoin(table, "nome_exame ilike '%" + criterio + "%' and status = true order by nome_exame asc");
        } else {
            array = this.selectWithJoin(table, "order by nome_exame asc");
        }

        //Definição dos dados da tabela.
        Object[][] dadosTabela = new Object[array.size()][columAll];
        int i = 0;
        try {
            for (Object o : array) {
                Exames k = (Exames) o;
//              Definir os dados das colunas
                dadosTabela[i][0] = k.getNomeExame();
                i++;
            }
        } catch (HibernateException he) {
            Mensagens.retornoAcao(
                    Mensagens.problemaPopularTabela("Exames")
                    + Mensagens.mensagemTecnica(he.toString())
            );
        }

    }
    
    public void preencherTabelaBuscaPlano(JTable tabela, String criterio) {
        List array = null;
//        Total de colunas
        int columAll = 3;
//        Definição do cabecalho.
        Object[] cabecalho = new Object[columAll];
        cabecalho[1] = "Descrição";

//        Preencha com o nome da tabela.
        String table = "Plano";

        //Executa a busca
        if (Gema.vazio(criterio, 1)) {
            array = this.selectWithJoin(table, "nome_plano ilike '%" + criterio + "%' and status = true order by nome_plano asc");
        } else {
            array = this.selectWithJoin(table, "order by nome_plano asc");
        }

        //Definição dos dados da tabela.
        Object[][] dadosTabela = new Object[array.size()][columAll];
        int i = 0;
        try {
            for (Object o : array) {
                Plano k = (Plano) o;
//              Definir os dados das colunas
                dadosTabela[i][0] = k.getNomePlano();

                i++;
            }
        } catch (HibernateException he) {
            Mensagens.retornoAcao(
                    Mensagens.problemaPopularTabela("Exames")
                    + Mensagens.mensagemTecnica(he.toString())
            );
        }

    }
}
