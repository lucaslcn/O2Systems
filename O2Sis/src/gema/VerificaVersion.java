package gema;

import dao.ParametrosDAO;
import javax.swing.JOptionPane;
import negocio.Parametros;

/* @author XorNOTE */
public class VerificaVersion {
    private boolean executando;
    
    
    
    public static void verificaVersao() {
        if(runVersion()){
            int i = Mensagens.questionarAcao("Seu sistema está executando uma versão antiga. \nDeseja continuar?");
            if(i == JOptionPane.NO_OPTION){
                System.exit(0);
            }
        }
    }
    
    public static boolean runVersion(){
        Parametros version = new ParametrosDAO().consultarId(3);
        return !FileConfig.FileConfig().equals(version.getValueparametro());
    }
}
