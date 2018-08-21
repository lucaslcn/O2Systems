/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registros;

import gema.Arquivo;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 *
 * @author XorNOTE
 */
public class Auditoria {

    public Auditoria() {
        resolve();
    }

    private static boolean existeArquivo() {
        File auditoria = new File("config.properties");
        return auditoria.exists();
    }

    private static void criarArquivo(boolean a) {
        Arquivo save = new Arquivo("config.properties");
        save.abrirEscrita();
        save.escreverLinha("audit=" + a);
        save.fecharArquivo();
    }

    private static void resolve() {
        if (!existeArquivo()) {
            criarArquivo(true);
        }
    }
    
    private static void alterarArquivo(boolean a) {
        File auditoria = new File("config.properties");
        auditoria.delete();
        
        Arquivo save = new Arquivo("config.properties");
        save.abrirEscrita();
        save.escreverLinha("audit=" + a);
        save.fecharArquivo();
    }
    
    public static boolean status() {
        boolean s = false;
        try {
            resolve();
            Properties prop = new Properties();
            prop.load(new FileInputStream("config.properties"));
            s = Boolean.parseBoolean(prop.getProperty("audit"));
        } catch (Exception e) {
            System.out.println("Erro ao verificar status da auditoria.");
        }

        return s;
    }

    public static String onOff(boolean status) {
        String s = null;
        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream("config.properties"));
            //boolean t = Boolean.parseBoolean(prop.getProperty("audit"));
            alterarArquivo(status);
        } catch (Exception e) {
            return s = e + "";
        }

        return s;
    }
}
