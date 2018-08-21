/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registros;

import negocio.Usuario;

/**
 *
 * @author XorNOTE
 */
public class Atividade {
    Usuario usuario;
    
    String informacaoOld;
    String informacaoNew;
    
    String onde;
    String acao;
    String data;
    String hora;
    
    //Definição de nome para os locais. Vulgo ONDE.
    final public static String FROM_AUDITORIA = "Auditoria";
    final public static String FROM_ESTADO = "Cadastro Estado";
    final public static String FROM_PLANO = "Cadastro de Plano de Saúde";
    final public static String FROM_REMEDIO = "Cadastro de Remédio";
    final public static String FROM_EXAME = "Cadastro de Exame";
    final public static String FROM_FORMA_PGTO = "Cadastro de Forma de Pagamento";
    final public static String FROM_FUNCAO = "Cadastro de Função";
    
    //Definição de nome para as ações.
    final public static String ACAO_DELETADO = "Deletado";
    final public static String ACAO_ARQUIVADO = "Arquivado";
    final public static String ACAO_INSERIDO = "Inserido";
    final public static String ACAO_EDITADO = "Editado";
}
