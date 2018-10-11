/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mballem.app.service;

import com.mballem.app.Mensagem;
import com.mballem.app.bean.ChatMessage;
import com.mballem.app.bean.MensagemCadastro;
import com.mballem.app.frame.MensagemFrame;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author elias
 */
public class MensagemService {
    
    private Socket socket;
    private ObjectOutputStream output;
    
    public Socket connect() {
        try {
            this.socket = new Socket("localhost", 5555);
            this.output = new ObjectOutputStream(socket.getOutputStream());
        } catch (UnknownHostException ex) {
            Logger.getLogger(MensagemService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MensagemService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return socket;
    }
    
    public void send(MensagemCadastro message) {
        MensagemFrame msg = new MensagemFrame();
        try {
            output.writeObject(msg);
        } catch (IOException ex) {
            Logger.getLogger(MensagemService.class.getName()).log(Level.SEVERE, null, ex);
        }
        msg.setVisible(true);
    }
}
