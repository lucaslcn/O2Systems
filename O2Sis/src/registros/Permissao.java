/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registros;

/**
 *
 * @author anderson.caye
 */
public class Permissao {
    //Definição de valor minimo de permissao em ações.
    final public static Integer ACAO_EDITAR = 1;
    final public static Integer ACAO_INSERIR = 1;
    final public static Integer ACAO_VISUALIZAR = 1;
    final public static Integer ACAO_ARQUIVAR = 1;
    final public static Integer ACAO_DELETAR = 1;
    
    //Definição de valor minimo de permissao em acesso a telas.
    final public static Integer FROM_AUDITORIA = 1;
    final public static Integer FROM_ = 1;
    final public static Integer FROM_ = 1;
    final public static Integer FROM_ = 1;
    final public static Integer FROM_ = 1;
    
    public static boolean temPermissao(Integer nivelNecessario, Integer nivelPossui){
        if (nivelNecessario >= nivelPossui){
            return true;
        } else {
            return false;
        }
    }
    
}
