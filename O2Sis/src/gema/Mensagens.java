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
    
    public static int confirmarexclusao(){
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente arquivar?", "Alerta!", JOptionPane.YES_NO_OPTION);
        return resposta;
    }
    
    public static String erroSalvar (String onde){
        return "Erro ao salvar: " +  onde;
    }
    
    public static String salvo(String oQue){
        return oQue + " salvo(a) com sucesso.";
    }
    
    public static String erroDeletado (String onde){
        return "Erro ao deletar: " +  onde;
    }
    
    public static String deletado(String oQue){
        return oQue + " deletado(a) com sucesso.";
    }
    
    public static String problemaPopularTabela(String onde){
        return "Problemas ao popular a tabela: " + onde;
    }
    
    public static String tivemosProblemas(String paraQue){
        return "Desculpe, houve algum problema para " + paraQue;
    }
    
    public static String mensagemTecnica(String exception){
        return "\nMensagem técnica:\n" + exception;
    }
    
    public static String preenchaOsCampos(){
        return "Preencha todos os campos obrigatórios!";
    }
    
    public static String selecioneAlgumItem(){
        return "Por favor, selecione um algum item!";
    }
    
    public static String preenchaOsCampos(String texto){
        return "Preencha todos os campos obrigatórios!\n" + texto;
    }
    
    public static String arquivado(String oQue){
        return oQue + " arquivado(a) com sucesso.";
    }
    
    public static String erroArquivado (String onde){
        return "Erro ao arquivar: " +  onde;
    }
    
}
