/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gema;

import dao.LicenseDAO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.PrivateKey;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Properties;
import javax.swing.JOptionPane;
import negocio.License;

/**
 *
 * @author XorNOTE
 */
public class VerificaLicenca {
    
    private static EncryptDecryptStringWithDES cripto = new EncryptDecryptStringWithDES();
    
    public static License verificaFile() throws IOException, FileNotFoundException, ClassNotFoundException{
        isCripto();
        FileInputStream file = new FileInputStream("license.properties");
        Properties properties = new Properties();
        properties.load (file);
        License licenca = new License();
        
        String data = CriptografiaRSA.decriptografa(properties.get("data").toString().getBytes(), (PrivateKey) CriptografiaRSA.chave());
        String key = CriptografiaRSA.decriptografa(properties.get("key").toString().getBytes(), (PrivateKey) CriptografiaRSA.chave());
        
        licenca.setData(data);
        licenca.setKey(key);
        licenca.setId(Integer.parseInt(properties.getProperty("id")));
        return licenca;
    }
    
    public static void isCripto() throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream file = new FileInputStream("license.properties");
        Properties properties = new Properties();
        properties.load (file);
        boolean cripto = Boolean.parseBoolean( properties.getProperty("cripto") );
        
        if(!cripto){
            escreveLicenca(properties.getProperty("key"), properties.getProperty("data"));
        }
    }
    
    public static void escreveLicenca(String key, String data) throws IOException, FileNotFoundException, ClassNotFoundException{
        
        if (!CriptografiaRSA.verificaSeExisteChavesNoSO()){
            CriptografiaRSA.geraChave();
        }
        
        FileOutputStream file = new FileOutputStream("license.properties");
        Properties properties = new Properties();
        byte[] cripto_data = CriptografiaRSA.criptografa(data, CriptografiaRSA.chave());
        byte[] cripto_key = CriptografiaRSA.criptografa(key, CriptografiaRSA.chave());
        properties.setProperty("data", cripto_data.toString()); 
        properties.setProperty("key", cripto_key.toString()); 
        properties.setProperty("cripto", "true"); 
        properties.store(file, "Licença");
        file.close();
       
        
    }
    
    public static boolean verificaNuvem() throws FileNotFoundException, IOException, ClassNotFoundException{
        License licencaFile = verificaFile();
        LicenseDAO licenseDAO = new LicenseDAO();
        License licencaNuvem = licenseDAO.consultarId(licencaFile.getId());
        
        LocalDate dataNuvem = LocalDate.parse(licencaNuvem.getData());
        LocalDate dataFile = LocalDate.parse(licencaFile.getData());
        LocalDate dataAtual = LocalDate.now();
        
        long daysNuvem = dataAtual.until(dataNuvem, ChronoUnit.DAYS);
        long daysFile = dataAtual.until(dataFile, ChronoUnit.DAYS);
        
        if (daysFile != daysNuvem){
            escreveLicenca(licencaNuvem.getKey(), licencaNuvem.getData());
        }

        if (daysNuvem < 0) {
            return false;
        }
        
        return true;
    }
}
