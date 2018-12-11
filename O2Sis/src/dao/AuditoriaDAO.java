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
import negocio.Auditoria;
import negocio.Auditoriainfoold;
import negocio.Exames;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import persistencia.ConexaoDAO;
import registros.Atividade;
import registros.LogAuditoria;

/**
 *
 * @author elias.flach
 */
public class AuditoriaDAO extends DAO implements IDAO_T<Auditoria> {

    @Override
    public void preencherTabelaBusca(JTable tabela, String criterio) {
        List array = null;
//        Total de colunas
        int columAll = 3;
//        Definição do cabecalho.
        Object[] cabecalho = new Object[columAll];
        cabecalho[0] = "Código";
        cabecalho[1] = "Nome do Exame";
        cabecalho[2] = "Valor";

//        Preencha com o nome da tabela.
        String table = "Auditoria";

        //Executa a busca
        if (Gema.vazio(criterio, 1)) {
            array = this.selectWithJoin(table, "nome_exame ilike '%" + criterio + "%' and status = true order by nome_exame asc");
        } else {
            array = this.selectWithJoin(table, " status = true order by nome_exame asc");
        }

        //Definição dos dados da tabela.
        Object[][] dadosTabela = new Object[array.size()][columAll];
        int i = 0;
        try {
            for (Object o : array) {
                Exames k = (Exames) o;
//              Definir os dados das colunas
                dadosTabela[i][0] = k.getIdexame();
                dadosTabela[i][1] = k.getNomeExame();
                dadosTabela[i][2] = k.getValor();

                i++;
            }
        } catch (HibernateException he) {
            Mensagens.retornoAcao(
                    Mensagens.problemaPopularTabela("Exames")
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
    public Auditoria consultarId(int id) {
        Object o = this.selectWithJoin("Auditoria", "idauditoria = " + id).get(0);
        return (Auditoria) o;
    }
    
    public String archivedAuditoria(Object o) {
        Auditoria a = (Auditoria) o;
        Auditoriainfoold ao = new Auditoriainfoold();
        
        ao.setAcao(a.getAcao());
        ao.setData(a.getData());
        ao.setHora(a.getHora());
        ao.setIdauditoria(a.getIdauditoria());
        ao.setIdusuario(a.getIdusuario());
        ao.setInformacaonew(a.getInformacaonew());
        ao.setInformacaoold(a.getInformacaoold());
        ao.setOnde(a.getOnde());
        
        String s = null;
        
        s = this.insertAuditoriaArquived(ao);
        s =  this.deleteAuditoria(a);
        
        return s;
    }
    
    public String insertAuditoriaArquived(Object o) {
        String r = null;
        Session s = null;
        try {
            s = ConexaoDAO.iniciarSessão();
            Transaction t = s.beginTransaction();
            s.save(o);
            t.commit();
        } catch (HibernateException he) {
            he.printStackTrace();
            r = he.toString();
            return r;
        } finally {
            s.close();
            return r;
        }
    }
    
    public String deleteAuditoria(Object o) {
        String r = null;
        Session s = null;
        try {
            s = ConexaoDAO.iniciarSessão();
            Transaction t = s.beginTransaction();
            s.delete(o);
            t.commit();
        } catch (HibernateException he) {
            he.printStackTrace();
            r = he.toString();
            return r;
        } finally {
            s.close();
            return r;
        }
    }

}
