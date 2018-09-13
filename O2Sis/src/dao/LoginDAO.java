package dao;

import java.util.List;
import negocio.Usuario;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import persistencia.ConexaoDAO;
import persistencia.DAO;

/**
 *
 * @author elias.flach
 */
public class LoginDAO extends DAO {

    public boolean login(String nick, String pass) {
        String sql = "select fun_valida_login('" + nick + "','" + pass + "')";
        System.out.println(sql);
//        List o = null;
//        Session s = null;
//        try {
//            s = ConexaoDAO.iniciarSessão();
//            s.beginTransaction();
//            org.hibernate.Query q = s.createQuery(sql);
//            o = q.list();
//            s.close();
//        } catch (HibernateException he) {
//            he.printStackTrace();
//        } finally {
//            return (boolean) o.get(0);
//        }
        return true;
    }

    public Usuario acessar(String nick, String pass) {
        if (new UsuarioDAO().selectWithJoin("Usuario", "nick = '" + nick + "' AND senha = '" + pass + "' AND status = true").size() == 1) {
            return (Usuario) new UsuarioDAO().selectWithJoin("Usuario", "nick = '" + nick + "' AND senha = '" + pass + "' AND status = true").get(0);
        } else {
            return null;
        }
    }

}
