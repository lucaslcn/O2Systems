/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gema;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.boot.registry.classloading.internal.ClassLoaderServiceImpl.Work;
import persistencia.ConexaoDAO;

/**
 *
 * @author XorNOTE
 */
public class FuncoesPostgres {
    private void chamarFuncaoSemParametro() {
        try {
            Session sessao = ConexaoDAO.iniciarSessão();
            sessao.beginTransaction();

            sessao.doWork(new org.hibernate.jdbc.Work() {
                public void execute(Connection connection) throws SQLException {
                    CallableStatement call = connection.prepareCall("{ call fazerAlgo() }");
                    call.execute();
                }
            });

            sessao.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("erro da função: " + e);
        }
    }
    
    private static boolean chamarFuncaoComParametro(String login, String pass) {
        boolean l = true;
        try {
            Session sessao = ConexaoDAO.iniciarSessão();
            sessao.beginTransaction();

            sessao.doWork(new org.hibernate.jdbc.Work() {
                public void execute(Connection connection) throws SQLException {
                    CallableStatement call = connection.prepareCall("fun_valida_login()");
                    call.setString(1, login); // 1 é o 1º parametro, 10 é o valor
                    call.setString(2, pass); 
                    call.execute();
                }
            });

            sessao.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("erro da função: " + e);
        }
        return l;
    }
    
    private List chamarView(String nomeView) {
        List resultado = null;
        try {
            Session sessao = ConexaoDAO.iniciarSessão();
            sessao.beginTransaction();

            resultado = sessao.createSQLQuery("select * from "+nomeView).list();
//
//            for (Object o : resultado) {
//                System.out.println("nome: " + o.toString());
//            }
            sessao.getTransaction().commit();
            
        } catch (Exception e) {
            System.out.println("erro ao chamar view: " + e);
        }
        return resultado;
    }
}
