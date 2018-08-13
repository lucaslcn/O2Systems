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
@Table(name = "receita")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Receita.findAll", query = "SELECT r FROM Receita r")
    , @NamedQuery(name = "Receita.findByIdreceita", query = "SELECT r FROM Receita r WHERE r.idreceita = :idreceita")})
public class Receita implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idreceita")
    private Integer idreceita;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idreceita")
    private List<Prontuario> prontuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idreceita")
    private List<ListagemRemedios> listagemRemediosList;

    public Receita() {
    }

    public Receita(Integer idreceita) {
        this.idreceita = idreceita;
    }

    public Integer getIdreceita() {
        return idreceita;
    }

    public void setIdreceita(Integer idreceita) {
        this.idreceita = idreceita;
    }

    @XmlTransient
    public List<Prontuario> getProntuarioList() {
        return prontuarioList;
    }

    public void setProntuarioList(List<Prontuario> prontuarioList) {
        this.prontuarioList = prontuarioList;
    }

    @XmlTransient
    public List<ListagemRemedios> getListagemRemediosList() {
        return listagemRemediosList;
    }

    public void setListagemRemediosList(List<ListagemRemedios> listagemRemediosList) {
        this.listagemRemediosList = listagemRemediosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idreceita != null ? idreceita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Receita)) {
            return false;
        }
        Receita other = (Receita) object;
        if ((this.idreceita == null && other.idreceita != null) || (this.idreceita != null && !this.idreceita.equals(other.idreceita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "negocio.Receita[ idreceita=" + idreceita + " ]";
    }
    
}
