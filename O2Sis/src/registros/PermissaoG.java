/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registros;

import java.awt.Component;
import java.util.TreeMap;

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
    
    public static void myCan(TreeMap<Integer, Boolean> can, Component[] comp){
        //for(Component c : comp){
        System.out.println("Tamanho aqui: " + comp.length);
        for(int i = 0; i < comp.length; i++) {
            System.out.println(comp[i].getName());
            if (comp[i].getName() != null) {
                int key = Integer.parseInt(comp[i].getName());
                System.out.println("Entro");
                if(comp[i].isEnabled()){
                    comp[i].setEnabled(can.get(key));
                }
            } //else {
              //  System.out.println("Erro no botão! ");
              //}
        }
    }
}
