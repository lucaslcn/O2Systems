/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author anderson.caye
 */
public class DAO {

    protected EntityManager entityManager;

    public String insert(Object o) {
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
    
    public String update(Object o) {
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

    public String delete() {
        return null;
    }

}
