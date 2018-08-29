/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registros;

import dao.ParametrosDAO;
import gema.Arquivo;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import negocio.Parametros;
import negocio.Usuario;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import persistencia.ConexaoDAO;

/**
 *
 * @author XorNOTE
 */
public class LogAuditoria {

    public LogAuditoria() {
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
        Parametros p = new ParametrosDAO().consultarId(2);
        return Boolean.parseBoolean(p.getValueparametro());
    }

    public static String onOff(Usuario u) {
        Parametros p = new ParametrosDAO().consultarId(2);
        Boolean s = Boolean.parseBoolean(p.getValueparametro());
        p.setValueparametro((!s) + "");
        
        Atividade logAuditoria = new Atividade();
        if(s){
            logAuditoria.setInformacaoNew(new String[] {"Auditoria desligada"});
            logAuditoria.setInformacaoOld(new String[] {"Auditoria ligada"});
        } else {
            logAuditoria.setInformacaoNew(new String[] {"Auditoria ligada"});
            logAuditoria.setInformacaoOld(new String[] {"Auditoria desligada"});
        }
        logAuditoria.setAcao(Atividade.ACAO_ALTERADO);
        logAuditoria.setOnde(Atividade.FROM_AUDITORIA);
        logAuditoria.setUsuario(u);
        
        return new ParametrosDAO().update(p, logAuditoria);
    }
}
