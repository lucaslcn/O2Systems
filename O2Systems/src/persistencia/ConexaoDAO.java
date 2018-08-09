/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import net.sf.ehcache.hibernate.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author XorNOTE
 */
public class ConexaoDAO {
    
    public static Session iniciarSessão(){
        Session sessao = NewHibernateUtil.getSessionFactory().openSession();
        sessao.beginTransaction();
        return sessao;
    }
        
}
