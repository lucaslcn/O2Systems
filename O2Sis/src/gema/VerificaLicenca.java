/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gema;

import dao.LicenseDAO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author XorNOTE
 */
public class VerificaLicenca {
    
    private static EncryptDecryptStringWithDES cripto = new EncryptDecryptStringWithDES();
    
    public static boolean verificaFile(){
            return true;
    }
    
    public static void escreveLicenca(){
        File licencaFile = new File("license.properties");
        
        Properties licenca = new Properties();
        licenca.l
        
    }
    
    public static boolean verificaNuvem() throws FileNotFoundException{
        LicenseDAO licenseDAO = new LicenseDAO();
        String key = licenseDAO.consultarId(1).getKey();
        String data = licenseDAO.consultarId(1).getData();
        System.out.println("key: " + key);
        System.out.println("data: " + data);
        String encrypted_key = EncryptDecryptStringWithDES.encrypt(key, cripto.getEcipher());
        String encrypted_data = EncryptDecryptStringWithDES.encrypt(data, cripto.getDcipher());
        
        
        
        PrintWriter out = new PrintWriter("license.txt");
        System.out.println("encrypted key: " + key);
        System.out.println("encrypted data: " + data);
        
        out.println(key);
        out.println(data);
        out.close();
        
        LocalDate dataParsed = LocalDate.parse(data);
        System.out.println("Tempo em dias até expirar a licença: " + dataAtual.until(dataParsed, ChronoUnit.DAYS));
        System.out.println("Data que a licença irá expirar: " + Formatacao.ajustaDataDMA(data));

        long daysToExpire = dataAtual.until(dataParsed, ChronoUnit.DAYS);

        if (daysToExpire <= 5 && daysToExpire >= 0) {
            JOptionPane.showMessageDialog(this, "ATENÇÃO! A licença do produto irá expirar em " + daysToExpire + " dias. Renove-a para manter o acesso ao programa!");
        }
        if (daysToExpire < 0) {
            JOptionPane.showMessageDialog(this, "Sua licença ao produto expirou em " + Formatacao.ajustaDataDMA(data) + ". Renove-a para continuar acessando o programa.");
            dispose();
            System.exit(0);
        }
        
        return true;
    }
}
