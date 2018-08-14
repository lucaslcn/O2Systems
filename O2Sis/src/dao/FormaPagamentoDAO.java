/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import javax.swing.JTable;
import persistencia.DAO;
import persistencia.IDAO_T;
import gema.Gema;
import gema.Mensagens;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import negocio.FormaPagamento;
import org.hibernate.HibernateException;
/**
 *
 * @author Lucas
 */
public class FormaPagamentoDAO extends DAO implements IDAO_T<FormaPagamento> {

    @Override
    public void preencherTabelaBusca(JTable tabela, String criterio) {
        List array = null;
//        Total de colunas
        int columAll = 2;
//        Definição do cabecalho.
        Object[] cabecalho = new Object[columAll];
        cabecalho[0] = "Codigo";
        cabecalho[1] = "Nome da Forma de Pagamento";

//        Preencha com o nome da tabela.
        String table = "FormaPagamento";

        //Executa a busca
        if (Gema.vazio(criterio, 1)) {
            array = this.selectWithJoin(table, "descricao_forma_pagamento ilike '%" + criterio + "%' order by descricao_forma_pagamento asc");
        } else {
            array = this.select(table + " order by descricao_forma_pagamento asc");
        }

        //Definicao dos dados da tabela.
        Object[][] dadosTabela = new Object[array.size()][columAll];
        int i = 0;
        try {
            for (Object o : array) {
                FormaPagamento k = (FormaPagamento) o;
//              Definir os dados das colunas
                dadosTabela[i][0] = k.getIdformaPagamento();
                dadosTabela[i][1] = k.getDescricaoFormaPagamento();

                i++;
            }
        } catch (HibernateException he) {
            Mensagens.retornoAcao(
                    Mensagens.problemaPopularTabela("Formas de pagamento")
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
    public FormaPagamento consultarId(int id) {
        Object o = this.selectWithJoin("Forma_pagamento", "idforma_pagamento = " + id).get(0);
        return (FormaPagamento) o;
    }
    
}
