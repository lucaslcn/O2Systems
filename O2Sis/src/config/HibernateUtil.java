/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import negocio.Acaotela;
import negocio.AgendamentoExames;
import negocio.Auditoria;
import negocio.Auditoriainfoold;
import negocio.Cidade;
import negocio.Consultas;
import negocio.Estado;
import negocio.Exames;
import negocio.FormaPagamento;
import negocio.Funcao;
import negocio.Funcionario;
import negocio.License;
import negocio.Listaacao;
import negocio.ListagemExames;
import negocio.ListagemFuncao;
import negocio.ListagemPlanos;
import negocio.ListagemRemedios;
import negocio.Listapermissao;
import negocio.Notasversoes;
import negocio.Paciente;
import negocio.Parametros;
import negocio.Permissao;
import negocio.Pessoa;
import negocio.Plano;
import negocio.Prontuario;
import negocio.Receita;
import negocio.Remedio;
import negocio.Requisicao;
import negocio.Tela;
import negocio.Usuario;
import negocio.UsuariosVersoes;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author fabricio.pretto
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            AnnotationConfiguration cfg = new AnnotationConfiguration();

//            cfg.addAnnotatedClass(Acaotela.class);
//            cfg.addAnnotatedClass(AgendamentoExames.class);
//            cfg.addAnnotatedClass(Auditoria.class);
//            cfg.addAnnotatedClass(Auditoriainfoold.class);
//            cfg.addAnnotatedClass(Cidade.class);
//            cfg.addAnnotatedClass(Consultas.class);
//            cfg.addAnnotatedClass(Estado.class);
//            cfg.addAnnotatedClass(Exames.class);
//            cfg.addAnnotatedClass(FormaPagamento.class);
//            cfg.addAnnotatedClass(Funcao.class);
//            cfg.addAnnotatedClass(Funcionario.class);
//            cfg.addAnnotatedClass(License.class);
//            cfg.addAnnotatedClass(Listaacao.class);
//            cfg.addAnnotatedClass(ListagemExames.class);
//            cfg.addAnnotatedClass(ListagemFuncao.class);
//            cfg.addAnnotatedClass(ListagemPlanos.class);
//            cfg.addAnnotatedClass(ListagemRemedios.class);
//            cfg.addAnnotatedClass(Listapermissao.class);
//            cfg.addAnnotatedClass(Notasversoes.class);
//            cfg.addAnnotatedClass(Paciente.class);
//            cfg.addAnnotatedClass(Parametros.class);
//            cfg.addAnnotatedClass(Permissao.class);
//            cfg.addAnnotatedClass(Pessoa.class);
//            cfg.addAnnotatedClass(Plano.class);
//            cfg.addAnnotatedClass(Prontuario.class);
//            cfg.addAnnotatedClass(Receita.class);
//            cfg.addAnnotatedClass(Remedio.class);
//            cfg.addAnnotatedClass(Requisicao.class);
//            cfg.addAnnotatedClass(Tela.class);
//            cfg.addAnnotatedClass(Usuario.class);
//            cfg.addAnnotatedClass(UsuariosVersoes.class);

            sessionFactory = cfg.configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
