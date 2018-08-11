/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gema;

import java.io.FileInputStream;
import java.util.Properties;

/**
 *
 * @author XorNOTE
 */
public class Auditoria {
    
    public static boolean status(){
        boolean s = false;
        try{
            Properties prop = new Properties();
            prop.load(new FileInputStream("config.properties"));
            s = Boolean.parseBoolean(prop.getProperty("audit"));
        } catch (Exception e) {
            System.out.println("Erro ao verificar status da auditoria.");
        }
        
        return s;
    }
    
    public static boolean onOff(){
        boolean s = false;
        try{
            Properties prop = new Properties();
            prop.load(new FileInputStream("config.properties"));
            boolean t = Boolean.parseBoolean(prop.getProperty("audit"));
            
            if (t) prop.setProperty("audit", "false"); 
            else prop.setProperty("audit", "true");
            
        } catch (Exception e) {
            System.out.println("Erro ao verificar status da auditoria.");
        }
        
        return s;
    }
}
