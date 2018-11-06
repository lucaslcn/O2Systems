/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import negocio.Auditoria;
import negocio.Log;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import registros.Atividade;
import registros.LogAuditoria;

/**
 *
 * @author anderson.caye
 */
public class DAO {

    public String insert(Object o, Atividade logAuditoria) {
        String r = null;
        Session s = null;
        logAuditoria.setAcao(Atividade.ACAO_INSERIDO); //Definir ação auditoria
        try {
            s = ConexaoDAO.iniciarSessão();
            Transaction t = s.beginTransaction();
            s.save(o);
            t.commit();
        } catch (HibernateException he) {
            he.printStackTrace();
            r = he.toString();
            return r;
        } finally {
            s.close();
            //Inicio Auditoria
            if (LogAuditoria.status()) {
                r = this.insertAuditoria( logAuditoria.registraAtividade() );
            }
            //Fim Auditoria
            return r;
        }
    }

    public List select(String table) {
        table = "from " + table;
        System.out.println(table);
        List o = null;
        Session s = null;
        try {
            s = ConexaoDAO.iniciarSessão();
            s.beginTransaction();
            org.hibernate.Query q = s.createQuery(table);
            o = q.list();
            s.close();
        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            return o;
        }
    }

    public List selectWithJoin(String table, String join) {
        return this.select(table + " where " + join);
    }

    public String update(Object o, Atividade logAuditoria) {
        String r = null;
        Session s = null;
       if(!Atividade.FROM_AUDITORIA.equals(logAuditoria.getOnde())){
            logAuditoria.setAcao(Atividade.ACAO_EDITADO); //Definir ação auditoria
        }
        try {
            s = ConexaoDAO.iniciarSessão();
            Transaction t = s.beginTransaction();
            s.update(o);
            t.commit();
        } catch (HibernateException he) {
            he.printStackTrace();
            r = he.toString();
            return r;
        } finally {
            s.close();
            //Inicio Auditoria
            if (LogAuditoria.status() || logAuditoria.getOnde().equals(Atividade.FROM_AUDITORIA)) {
                r = this.insertAuditoria( logAuditoria.registraAtividade() );
            }
            //Fim Auditoria
            return r;
        }
    }

    public String archived(Object o, Atividade logAuditoria) {
        String r = null;
        Session s = null;
        logAuditoria.setAcao(Atividade.ACAO_ARQUIVADO); //Definir ação auditoria
        try {
            s = ConexaoDAO.iniciarSessão();
            Transaction t = s.beginTransaction();
            s.update(o);
            t.commit();
        } catch (HibernateException he) {
            he.printStackTrace();
            r = he.toString();
            return r;
        } finally {
            s.close();
            //Inicio Auditoria
            if (LogAuditoria.status()) {
                r = this.insertAuditoria( logAuditoria.registraAtividade() );
            }
            //Fim Auditoria
            return r;
        }
    }
    
    

    public String delete(Object o, Atividade logAuditoria) {
        logAuditoria.setAcao(Atividade.ACAO_DELETADO); //Definir ação auditoria
        String r = null;
        try {
            
            
            
        } catch (HibernateException he) {
            r = he.toString();
            return r;
        } finally {
            //Inicio Auditoria
            if (LogAuditoria.status()) {
                r = this.insertAuditoria( logAuditoria.registraAtividade() );
            }
            //Fim Auditoria
            return r;
        }
    }
    
    public String insertAuditoria(Object o) {
        String r = null;
        Session s = null;
        try {
            s = ConexaoDAO.iniciarSessão();
            Transaction t = s.beginTransaction();
            s.save(o);
            t.commit();
        } catch (HibernateException he) {
            he.printStackTrace();
            r = he.toString();
            return r;
        } finally {
            s.close();
            return null;
        }
    }
    
    
    public String insertTest(Object o) {
        String r = null;
        Session s = null;
        try {
            s = ConexaoDAO.iniciarSessão();
            Transaction t = s.beginTransaction();
            s.save(o);
            t.commit();
        } catch (HibernateException he) {
            he.printStackTrace();
            r = he.toString();
            return r;
        } finally {
            s.close();
            return null;
        }
    }
    
    public String updateTest(Object o) {
        String r = null;
        Session s = null;
        try {
            s = ConexaoDAO.iniciarSessão();
            Transaction t = s.beginTransaction();
            s.update(o);
            t.commit();
        } catch (HibernateException he) {
            he.printStackTrace();
            r = he.toString();
            return r;
        } finally {
            s.close();
            return null;
        }
    }

}
