/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gema;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author XorNOTE
 */
public class FileConfig {

    public static String FileConfig() {
        String s = null;
        try {
            s = resolve();
        } catch (IOException ex) {
            Logger.getLogger(FileConfig.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }

//    private static boolean existeArquivo() {
//        File config = new File("config.properties");
//        return config.exists();
//    }
    
    private static String resolve() throws IOException {
        String s = null;
//        if (!existeArquivo()) {
                
            try {
                Properties config = new Properties ();
                FileInputStream file = new FileInputStream("config.properties");
                config.load(file);
                s = config.getProperty("version");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FileConfig.class.getName()).log(Level.SEVERE, null, ex);
            }

//        } else {
//            Mensagens.retornoAcao("Não foi possível verificar a versão do sistema.");
//        }
        
        return s;
    }
}
