/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avisos;

import telas.PainelAvisosJIF;

/**
 *
 * @author elias
 */
public class painelAvisos {

    private String aviso;
    private String text;
    private Action action;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    
    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public String getAviso() {
        return aviso;
    }

    public void setAviso(String aviso) {
        this.aviso = aviso;
    }

    public enum Action {
        SEND_ALL
    }
}
