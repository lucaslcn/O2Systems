/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import config.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author XorNOTE
 */
public class ConexaoDAO {
    
    public static Session iniciarSessão(){
        return HibernateUtil.getSessionFactory().openSession(); //getCurrentSession();
    }
        
}
