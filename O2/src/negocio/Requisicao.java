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
@Table(name = "requisicao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Requisicao.findAll", query = "SELECT r FROM Requisicao r")
    , @NamedQuery(name = "Requisicao.findByIdrequisicao", query = "SELECT r FROM Requisicao r WHERE r.idrequisicao = :idrequisicao")})
public class Requisicao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrequisicao")
    private Integer idrequisicao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idrequisicao")
    private List<Prontuario> prontuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idrequisicao")
    private List<ListagemExames> listagemExamesList;

    public Requisicao() {
    }

    public Requisicao(Integer idrequisicao) {
        this.idrequisicao = idrequisicao;
    }

    public Integer getIdrequisicao() {
        return idrequisicao;
    }

    public void setIdrequisicao(Integer idrequisicao) {
        this.idrequisicao = idrequisicao;
    }

    @XmlTransient
    public List<Prontuario> getProntuarioList() {
        return prontuarioList;
    }

    public void setProntuarioList(List<Prontuario> prontuarioList) {
        this.prontuarioList = prontuarioList;
    }

    @XmlTransient
    public List<ListagemExames> getListagemExamesList() {
        return listagemExamesList;
    }

    public void setListagemExamesList(List<ListagemExames> listagemExamesList) {
        this.listagemExamesList = listagemExamesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrequisicao != null ? idrequisicao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Requisicao)) {
            return false;
        }
        Requisicao other = (Requisicao) object;
        if ((this.idrequisicao == null && other.idrequisicao != null) || (this.idrequisicao != null && !this.idrequisicao.equals(other.idrequisicao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "negocio.Requisicao[ idrequisicao=" + idrequisicao + " ]";
    }
    
}
