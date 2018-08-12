/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gema;

import javax.swing.JOptionPane;

/**
 *
 * @author XorNOTE
 */
public class Mensagens {
    
    public static void retornoAcao (String oQue){
        JOptionPane.showMessageDialog(null, oQue);
    }
    
    public static int questionarAcao(){
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente cancelar a operação?", "Alerta!", JOptionPane.YES_NO_OPTION);
        return resposta;
    }
    
    public static String erroSalvar (String onde){
        return "Erro ao salvar: " +  onde;
    }
    
    public static String salvo(String oQue){
        return oQue + " salvo com sucesso.";
    }
    
    public static String erroDeletado (String onde){
        return "Erro ao deletar: " +  onde;
    }
    
    public static String deletado(String oQue){
        return oQue + " deletado com sucesso.";
    }
    
    public static String problemaPopularTabela(String onde){
        return "Problemas ao popular a tabela: " + onde;
    }
    
    public static String mensagemTecnica(String exception){
        return "\nMensagem técnica:\n" + exception;
    }
    
}
