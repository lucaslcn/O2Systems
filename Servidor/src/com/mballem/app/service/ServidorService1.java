/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mballem.app.service;

import com.mballem.app.bean.ChatMessage;
import com.mballem.app.bean.ChatMessage.Action;
import com.mballem.app.bean.PainelAvisos;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import sun.awt.windows.ThemeReader;

/**
 * @author Marcio Ballem
 */
public class ServidorService1 {

    private ServerSocket serverSocket;
    private Socket socket;
    private Map<String, ObjectOutputStream> mapOnlines = new HashMap<String, ObjectOutputStream>();

    public ServidorService1() {
        try {
            serverSocket = new ServerSocket(5555);

            System.out.println("Servidor on!");

            while (true) {
                socket = serverSocket.accept();

                new Thread(new ListenerSocket(socket)).start();
            }

        } catch (IOException ex) {
            Logger.getLogger(ServidorService1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private class ListenerSocket implements Runnable {

        private ObjectOutputStream output;
        private ObjectInputStream input;

        public ListenerSocket(Socket socket) {
            try {
                this.output = new ObjectOutputStream(socket.getOutputStream());
                this.input = new ObjectInputStream(socket.getInputStream());
            } catch (IOException ex) {
                Logger.getLogger(ServidorService1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void run() {
            PainelAvisos avisos = null;
            try {
                while ((avisos = (PainelAvisos) input.readObject()) != null) {
                    PainelAvisos.Action action = avisos.getAction();

                    if (action.equals(Action.SEND_ALL)) {
                        sendAll(avisos);
                    }
                }
            } catch (IOException ex) {

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ServidorService1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void sendAll(PainelAvisos avisos) {
        for (Map.Entry<String, ObjectOutputStream> kv : mapOnlines.entrySet()) {
            try {
                kv.getValue().writeObject(avisos);
            } catch (IOException ex) {
                Logger.getLogger(ServidorService1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
