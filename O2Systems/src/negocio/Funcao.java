package negocio;
// Generated 08/08/2018 19:55:37 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Funcao generated by hbm2java
 */
public class Funcao  implements java.io.Serializable {


     private int idfuncao;
     private String descricaoFuncao;
     private Boolean booleanUser;
     private Boolean status;
     private Set<ListagemFuncao> listagemFuncaos = new HashSet<ListagemFuncao>(0);

    public Funcao() {
    }

	
    public Funcao(int idfuncao, String descricaoFuncao) {
        this.idfuncao = idfuncao;
        this.descricaoFuncao = descricaoFuncao;
    }
    public Funcao(int idfuncao, String descricaoFuncao, Boolean booleanUser, Boolean status, Set<ListagemFuncao> listagemFuncaos) {
       this.idfuncao = idfuncao;
       this.descricaoFuncao = descricaoFuncao;
       this.booleanUser = booleanUser;
       this.status = status;
       this.listagemFuncaos = listagemFuncaos;
    }
   
    public int getIdfuncao() {
        return this.idfuncao;
    }
    
    public void setIdfuncao(int idfuncao) {
        this.idfuncao = idfuncao;
    }
    public String getDescricaoFuncao() {
        return this.descricaoFuncao;
    }
    
    public void setDescricaoFuncao(String descricaoFuncao) {
        this.descricaoFuncao = descricaoFuncao;
    }
    public Boolean getBooleanUser() {
        return this.booleanUser;
    }
    
    public void setBooleanUser(Boolean booleanUser) {
        this.booleanUser = booleanUser;
    }
    public Boolean getStatus() {
        return this.status;
    }
    
    public void setStatus(Boolean status) {
        this.status = status;
    }
    public Set<ListagemFuncao> getListagemFuncaos() {
        return this.listagemFuncaos;
    }
    
    public void setListagemFuncaos(Set<ListagemFuncao> listagemFuncaos) {
        this.listagemFuncaos = listagemFuncaos;
    }




}


