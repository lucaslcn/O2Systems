/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class PostgresBackup {
  
  public PostgresBackup()
  {
  }
  
  public static void realizaBackup() throws IOException, InterruptedException{
    final List<String> comandos = new ArrayList<String>();
    String dir = "C:\\backup";
    List<String> lista = new ArrayList<String>(9);
    File diretorio = new File(dir);
    File fList[] = diretorio.listFiles();
    if (fList != null)
               {
               
               comandos.add("C:\\Arquivos de Programas\\PostGreSQL\\10\\bin\\pg_dump.exe");
               comandos.add("-h");
               comandos.add("pgsql03-farm76.kinghost.net");
               comandos.add("-p");
               comandos.add("5432");
               comandos.add("-U");
               comandos.add("syscoffe");
               comandos.add("-Fc");
//               comandos.add("c");
//               comandos.add("-b");
//               comandos.add("-v");
               comandos.add("-f");
               comandos.add("C:\\backup\\pgsql_dump_"+GetDateTime()+".backup");
               comandos.add("syscoffe");
               
               String dump_name = "pgsql_dump_"+GetDateTime();
               
               ProcessBuilder pb = new ProcessBuilder(comandos);
               pb.environment().put("PGPASSWORD","marinab");
               
               try{
                   final Process process = pb.start();
                   
                   final BufferedReader r = new BufferedReader(new InputStreamReader(process.getErrorStream()));
                   String line = r.readLine();
               while(line != null){
                System.err.println(line);
               }
               r.close();
               
               process.waitFor();
               process.destroy();
               JOptionPane.showMessageDialog(null, "backup realizado com sucesso! Nome do arquivo: " + dump_name);
               System.out.println("backup realizado com sucesso!" + dump_name);
               }
               
               catch (IOException e){
               e.printStackTrace();
               JOptionPane.showMessageDialog(null, "Erro ao realizar backup!");
               } catch (InterruptedException ie){
               ie.printStackTrace();
               JOptionPane.showMessageDialog(null, "Erro ao realizar backup!");

               }
               
               }
               }
               
     public static void main (String args[]) throws IOException, InterruptedException
     {
       PostgresBackup b = new PostgresBackup();
       b.realizaBackup();
     }
    
    private static String GetDateTime(){
      DateFormat dateformat = new SimpleDateFormat("ddMMyyyy HHmm");
      Date date = new Date();
      return dateformat.format(date);
    }
    
           
}             
