package negocio;
// Generated 08/08/2018 19:55:37 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Cidade generated by hbm2java
 */
public class Cidade  implements java.io.Serializable {


     private int idcidade;
     private Estado estado;
     private String nomeCidade;
     private Set<Pessoa> pessoas = new HashSet<Pessoa>(0);

    public Cidade() {
    }

	
    public Cidade(int idcidade, Estado estado, String nomeCidade) {
        this.idcidade = idcidade;
        this.estado = estado;
        this.nomeCidade = nomeCidade;
    }
    public Cidade(int idcidade, Estado estado, String nomeCidade, Set<Pessoa> pessoas) {
       this.idcidade = idcidade;
       this.estado = estado;
       this.nomeCidade = nomeCidade;
       this.pessoas = pessoas;
    }
   
    public int getIdcidade() {
        return this.idcidade;
    }
    
    public void setIdcidade(int idcidade) {
        this.idcidade = idcidade;
    }
    public Estado getEstado() {
        return this.estado;
    }
    
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    public String getNomeCidade() {
        return this.nomeCidade;
    }
    
    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }
    public Set<Pessoa> getPessoas() {
        return this.pessoas;
    }
    
    public void setPessoas(Set<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }




}


