package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import persistencia.ConexaoDAO;
import persistencia.DAO;

/**
 *
 * @author elias.flach
 */
public class LoginDAO extends DAO {

    public boolean login(String nick, String pass){
        String sql = "select fun_valida_login('"+ nick + "','"+ pass +"')";
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

}
