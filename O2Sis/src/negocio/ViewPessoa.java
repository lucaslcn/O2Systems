/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author XorNOTE
 */
@Entity
@Table(name = "view_pessoa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ViewPessoa.findAll", query = "SELECT v FROM ViewPessoa v")
    , @NamedQuery(name = "ViewPessoa.findByNome", query = "SELECT v FROM ViewPessoa v WHERE v.nome = :nome")
    , @NamedQuery(name = "ViewPessoa.findBySobrenome", query = "SELECT v FROM ViewPessoa v WHERE v.sobrenome = :sobrenome")
    , @NamedQuery(name = "ViewPessoa.findByCpf", query = "SELECT v FROM ViewPessoa v WHERE v.cpf = :cpf")
    , @NamedQuery(name = "ViewPessoa.findBySexo", query = "SELECT v FROM ViewPessoa v WHERE v.sexo = :sexo")
    , @NamedQuery(name = "ViewPessoa.findByDataNascimento", query = "SELECT v FROM ViewPessoa v WHERE v.dataNascimento = :dataNascimento")
    , @NamedQuery(name = "ViewPessoa.findByLogradouro", query = "SELECT v FROM ViewPessoa v WHERE v.logradouro = :logradouro")
    , @NamedQuery(name = "ViewPessoa.findByNomeCidade", query = "SELECT v FROM ViewPessoa v WHERE v.nomeCidade = :nomeCidade")
    , @NamedQuery(name = "ViewPessoa.findByNomeEstado", query = "SELECT v FROM ViewPessoa v WHERE v.nomeEstado = :nomeEstado")})
public class ViewPessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "nome")
    private String nome;
    @Column(name = "sobrenome")
    private String sobrenome;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "data_nascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @Column(name = "logradouro")
    private String logradouro;
    @Column(name = "nome_cidade")
    private String nomeCidade;
    @Column(name = "nome_estado")
    private String nomeEstado;

    public ViewPessoa() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public String getNomeEstado() {
        return nomeEstado;
    }

    public void setNomeEstado(String nomeEstado) {
        this.nomeEstado = nomeEstado;
    }
    
}
