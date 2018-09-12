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
    final public static Integer[] ACAO_EDITAR = {4, 0};
    final public static Integer[] ACAO_INSERIR = {4, 0};
    final public static Integer[] ACAO_VISUALIZAR = {2, 0};
    final public static Integer[] ACAO_ARQUIVAR = {4, 0};
    final public static Integer[] ACAO_DELETAR = {4, 0};

    //Definição de valor minimo de permissao em acesso a telas.
    final public static Integer[] FROM_AUDITORIA = {9, 0};
    final public static Integer[] FROM_AGEN_CONSULTA = {2, 0};
    final public static Integer[] FROM_AGEN_EXAME = {2, 0};
    final public static Integer[] FROM_CAD_ESTADO = {2, 0};
    final public static Integer[] FROM_CAD_EXAME = {4, 0};
    final public static Integer[] FROM_CAD_FORMA_PGTO = {4, 0};
    final public static Integer[] FROM_CAD_FUNCAO = {7, 0};
    final public static Integer[] FROM_CAD_FUNCIONARIO = {7, 0};
    final public static Integer[] FROM_CAD_PACIENTE = {2, 0};
    final public static Integer[] FROM_CAD_PALANO_SAUDE = {2, 0};
    final public static Integer[] FROM_CAD_REMEDIO = {4, 0};
    final public static Integer[] FROM_PRONTUARIO = {5, 0};

    /**
     * verifica a permissão para a utilização de recursos do sistema
     *
     * @param level : vetor de duas posições com o nivel minimo e maximo
     * necessario para utilização do recusro, caso nao haja nivel maximo, deixar
     * a segunda posição do vetor com o valor 0 (zero).
     * 
     * @param userLevel : nivel que o usuario possui.
     * 
     * @param status : recebe a atual situação do recurso, se o sistema em geral
     * informar que ele já esta desabilitado este tende a permanecer
     * desabilitado, vice versa.
     * 
     * @return retorna TRUE caso este usuario possua permissão para utilização
     * do recurso, ou FALSE caso não possua permissão ou o sistema ja tenha
     * desabilitado o recurso.
     */
    public static boolean canUse(Integer[] level, Integer userLevel, boolean status) {
        boolean r = false;
        if (status) {
            if (level[1] == 0) {
                if (level[0] >= userLevel) { r = true;
                } else { r = false; }
            } else if (level[1] > 0) {
                if (level[0] >= userLevel && level[1] <= userLevel) { r = true;
                } else { r = false; }
            } else {
                r = false;   
            }
        } else {
            return false;
        }
        return r;
    }

}
