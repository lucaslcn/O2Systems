///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package dao;
//
//import java.sql.ResultSet;
//import javax.swing.JComboBox;
//import gema.ComboItens;
//import gema.Formatacao;
//import java.util.Date;
//
//
///**
// *
// * @author pretto
// */
//public class CombosDAO {
//
//    ResultSet resultado = null;
//    
//    public void popularComboUserDate(int idfuncionario, JComboBox combo, Date data)
//    {
//        ComboItens item = new ComboItens();
//        item.setCodigo(0);
//        item.setDescricao("Horário");
//        combo.addItem(item);
//
//        
//         try {
//            resultado = new ConexaoBD().getConnection().createStatement().executeQuery(
//                    "SELECT u.id,r.data from resumo_dia r, usuario u WHERE r.usuario_id = "+ id_usuario+""
//                            + " AND r.usuario_id = u.id");
//
//            if (resultado.isBeforeFirst()) {
//                while (resultado.next()) {
//                    item = new ComboItens();
//                    item.setCodigo(resultado.getInt(1));
//                    item.setDescricao(Formatacao.ajustaDataDMA(resultado.getString(2)));
//
//                    combo.addItem(item);
//                }
//            }
//        } catch (Exception e) {
//            System.out.println("Erro ao popular Combo = " + e.toString());
//        }
//    }
//
//    public void popularCombo(String tabela, JComboBox combo) {
//
//        ComboItens item = new ComboItens();
//        item.setCodigo(0);
//        item.setDescricao("Selecione");
//        combo.addItem(item);
//
//        try {
//            resultado = new ConexaoBD().getConnection().createStatement().executeQuery("select * from " + tabela + " WHERE DELETE = TRUE");
//
//            if (resultado.isBeforeFirst()) {
//                while (resultado.next()) {
//                    item = new ComboItens();
//                    item.setCodigo(resultado.getInt(1));
//                    item.setDescricao(resultado.getString(2));
//
//                    combo.addItem(item);
//                }
//            }
//        } catch (Exception e) {
//            System.out.println("Erro ao popular Combo = " + e.toString());
//        }
//    }
//    
//    public void definirItemCombo (JComboBox combo, ComboItens item) {
//        for (int i = 0; i < combo.getItemCount(); i++) {
//            if ( ((ComboItens) combo.getItemAt(i)).getCodigo() == (item.getCodigo() ) ) {
//                combo.setSelectedIndex(i);
//                return;
//            }
//        }
//    }
//}
