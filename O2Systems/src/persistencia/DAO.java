/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author anderson.caye
 */
public class DAO {

    public String insert(Object o) {
        String r = null;
        Session s = null;
        try {
            s = ConexaoDAO.iniciarSessão();
            s.save(o);

        } catch (HibernateException he) {
            System.out.println(he);
            r = he.toString();
            return r;
        } finally {
            s.close();
            return null;
        }
    }

    public List select(String table) {
        table = "from " + table;
        List o = null;
        Session s = null;
        List resultado = null;
        try {
            s = ConexaoDAO.iniciarSessão();
            org.hibernate.Query q = s.createQuery(table);
            o = q.list();
        } catch (HibernateException he) {
            System.out.println(he);
        } finally {
            s.close();
            return o;
        }
    }
    
    public List selectWithJoin(String table, String join) {
        return this.select(table + " where " + join);
    }

    public String delete() {
        return null;
    }

}
