/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author XorNOTE
 */
@Entity
@Table(name = "funcao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcao.findAll", query = "SELECT f FROM Funcao f")
    , @NamedQuery(name = "Funcao.findByIdfuncao", query = "SELECT f FROM Funcao f WHERE f.idfuncao = :idfuncao")
    , @NamedQuery(name = "Funcao.findByDescricaoFuncao", query = "SELECT f FROM Funcao f WHERE f.descricaoFuncao = :descricaoFuncao")
    , @NamedQuery(name = "Funcao.findByBooleanUser", query = "SELECT f FROM Funcao f WHERE f.booleanUser = :booleanUser")
    , @NamedQuery(name = "Funcao.findByStatus", query = "SELECT f FROM Funcao f WHERE f.status = :status")})
public class Funcao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfuncao")
    private Integer idfuncao;
    @Basic(optional = false)
    @Column(name = "descricao_funcao")
    private String descricaoFuncao;
    @Column(name = "boolean_user")
    private Boolean booleanUser;
    @Column(name = "status")
    private Boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idfuncao")
    private List<ListagemFuncao> listagemFuncaoList;

    public Funcao() {
    }

    public Funcao(Integer idfuncao) {
        this.idfuncao = idfuncao;
    }

    public Funcao(Integer idfuncao, String descricaoFuncao) {
        this.idfuncao = idfuncao;
        this.descricaoFuncao = descricaoFuncao;
    }

    public Integer getIdfuncao() {
        return idfuncao;
    }

    public void setIdfuncao(Integer idfuncao) {
        this.idfuncao = idfuncao;
    }

    public String getDescricaoFuncao() {
        return descricaoFuncao;
    }

    public void setDescricaoFuncao(String descricaoFuncao) {
        this.descricaoFuncao = descricaoFuncao;
    }

    public Boolean getBooleanUser() {
        return booleanUser;
    }

    public void setBooleanUser(Boolean booleanUser) {
        this.booleanUser = booleanUser;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @XmlTransient
    public List<ListagemFuncao> getListagemFuncaoList() {
        return listagemFuncaoList;
    }

    public void setListagemFuncaoList(List<ListagemFuncao> listagemFuncaoList) {
        this.listagemFuncaoList = listagemFuncaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfuncao != null ? idfuncao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcao)) {
            return false;
        }
        Funcao other = (Funcao) object;
        if ((this.idfuncao == null && other.idfuncao != null) || (this.idfuncao != null && !this.idfuncao.equals(other.idfuncao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "negocio.Funcao[ idfuncao=" + idfuncao + " ]";
    }
    
}
