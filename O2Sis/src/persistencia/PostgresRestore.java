/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PostgresRestore {

    public static void realizaRestore(String file_path) throws IOException, InterruptedException {
        final List<String> comandos = new ArrayList<String>();
        comandos.add("C:\\Arquivos de programas\\PostgreSQL\\10\\bin\\pg_restore.exe"); //testado no windows xp
//        comandos.add("-i");
        comandos.add("-h");
        comandos.add("pgsql03-farm76.kinghost.net");    //ou   comandos.add("192.168.0.1"); 
        comandos.add("-p");
        comandos.add("5432");
        comandos.add("-U");
        comandos.add("syscoffe");
        comandos.add("-d");
        comandos.add("syscoffe");
        comandos.add("-a");
        comandos.add("-v");
        comandos.add(file_path);   // eu utilizei meu C:\ e D:\ para os testes e gravei o backup com sucesso.  
        ProcessBuilder pb = new ProcessBuilder(comandos);
        pb.environment().put("PGPASSWORD", "marinab");     //Somente coloque sua senha         
        try {
            final Process process = pb.start();
            final BufferedReader r = new BufferedReader(
                    new InputStreamReader(process.getErrorStream()));
            String line = r.readLine();
            while (line != null) {
                System.err.println(line);
                line = r.readLine();
            }
            r.close();
            process.waitFor();
            process.destroy();
            System.out.println("Restore realizado com sucesso!");
            JOptionPane.showMessageDialog(null, "Restore realizado com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}
    

//    public static void main(String[] args) {
//        try {
//            PostgresRestore.realizaRestore();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//}
