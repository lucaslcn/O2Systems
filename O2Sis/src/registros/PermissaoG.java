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
public class PermissaoG {
    public static boolean canUse(boolean isEnable, boolean permissao){
        boolean r = false;
        if(isEnable){
            if(permissao){
                r = true;
            }else{
                r = false;
            }
        } else {
            r = false;
        }
        return r;
    }
}