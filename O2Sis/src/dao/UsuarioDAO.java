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
import negocio.Listapermissao;
import negocio.Usuario;
import org.hibernate.HibernateException;

/**
 *
 * @author anderson.caye
 */
public class UsuarioDAO extends DAO implements IDAO_T<Usuario> {

    @Override
    public void preencherTabelaBusca(JTable tabela, String criterio) {
        List array = null;
//        Total de colunas
        int columAll = 3;
//        Definição do cabecalho.
        Object[] cabecalho = new Object[columAll];
        cabecalho[0] = "Código";
        cabecalho[1] = "Nome Usuário";
        cabecalho[2] = "Nome Pessoa";

//        Preencha com o nome da tabela.
        String table = "Usuario";

        //Executa a busca
        if (Gema.vazio(criterio, 1)) {
            array = this.selectWithJoin(table, "nome_exame ilike '%" + criterio + "%' and status = true order by nome_exame asc");
        } else {
            array = this.selectWithJoin(table, " status = true order by idusuario asc");
        }

        //Definição dos dados da tabela.
        Object[][] dadosTabela = new Object[array.size()][columAll];
        int i = 0;
        try {
            for (Object o : array) {
                Usuario k = (Usuario) o;
//              Definir os dados das colunas
                dadosTabela[i][0] = k.getIdusuario();
                dadosTabela[i][1] = k.getNick();
                dadosTabela[i][2] = k.getIdfuncionario().getIdpessoa().getNomePessoa();

                i++;
            }
        } catch (HibernateException he) {
            Mensagens.retornoAcao(
                    Mensagens.problemaPopularTabela("Usuario")
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
    public Usuario consultarId(int id) {
        Object o = this.selectWithJoin("Usuario", "idusuario = " + id).get(0);
        return (Usuario) o;
    }

    public void preencherTabelaPermissao(JTable tabela, Usuario usuarioHere) {
        List array = null;
//        Total de colunas
        int columAll = 5;
//        Definição do cabecalho.
        Object[] cabecalho = new Object[columAll];
        cabecalho[0] = "Nr Permissão";
        cabecalho[1] = "Nr Tela";
        cabecalho[2] = "Nr Ação";
        cabecalho[3] = "Permissão";
        cabecalho[4] = "Status";
        

//        Preencha com o nome da tabela.
        String table = "Listapermissao";

        //Executa a busca
        array = this.selectWithJoin(table, "idusuario = "+ usuarioHere.getIdusuario() +" order by idlistapermissao asc");

        //Definição dos dados da tabela.
        Object[][] dadosTabela = new Object[array.size()][columAll];
        int i = 0;
        try {
            for (Object o : array) {
                Listapermissao k = (Listapermissao) o;
//              Definir os dados das colunas
                dadosTabela[i][0] = k.getIdlistapermissao();
                dadosTabela[i][1] = k.getIdlistaacao().getIdtela().getIdtela();
                dadosTabela[i][2] = k.getIdlistaacao().getIdacaotela().getIdacaotela();
                dadosTabela[i][3] = k.getIdlistaacao().getIdlistaacao() + " - " + k.getIdlistaacao().getIdtela().getNomeTela() + " : " + k.getIdlistaacao().getIdacaotela().getNomeAcao();
                if(k.getPermissao()){
                    dadosTabela[i][4] = "Permitido";
                } else {
                    dadosTabela[i][4] = "Negado";
                }

                i++;
            }
        } catch (HibernateException he) {
            Mensagens.retornoAcao(
                    Mensagens.problemaPopularTabela("Lista de permissão do usuário")
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
                    column.setPreferredWidth(50);
                    break;
                case 1:
                    column.setPreferredWidth(50);
                    break;
                case 2:
                    column.setPreferredWidth(50);
                    break;
                case 3:
                    column.setPreferredWidth(458);
                    break;
                case 4:
                    column.setPreferredWidth(50);
                    break;
            }
        }
    }

}
