/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gema;

import dao.LicenseDAO;
import static gema.CriptografiaRSA.PATH_CHAVE_PUBLICA;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.security.PrivateKey;
import java.security.PublicKey;
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
        FileInputStream file = new FileInputStream("license.properties");
        Properties properties = new Properties();
        properties.load (file);
        isCripto();
        License licenca = new License();
        
        byte[]t=properties.getProperty("data").getBytes();
        for (byte a : t){
            System.out.print(a);
        }
        System.out.println(t.toString());
        
        byte[] dataB = CriptografiaRSA.converteStringToArrayByte(properties.getProperty("data"));
        byte[] keyB = CriptografiaRSA.converteStringToArrayByte(properties.getProperty("key"));
        
        String data = CriptografiaRSA.decriptografa(dataB, CriptografiaRSA.chavePrivate());
        String key = CriptografiaRSA.decriptografa(keyB, CriptografiaRSA.chavePrivate());
        
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
        
        String id = lerKey("id");
        String code = lerKey("code");
        
        FileOutputStream file = new FileOutputStream("license.properties");
        Properties properties = new Properties();
        byte[] cripto_data = CriptografiaRSA.criptografa(data, CriptografiaRSA.chavePublic());
        byte[] cripto_key = CriptografiaRSA.criptografa(key, CriptografiaRSA.chavePublic());
        properties.setProperty("id", id);
        properties.setProperty("code", code);
        properties.setProperty("data", CriptografiaRSA.converteByteToArrayString(cripto_data)); 
        properties.setProperty("key", CriptografiaRSA.converteByteToArrayString(cripto_key)); 
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
    
    public static String lerKey(String key) throws IOException{
        FileInputStream file = new FileInputStream("license.properties");
        Properties properties = new Properties();
        properties.load (file);
        return properties.getProperty(key);
    }
}
