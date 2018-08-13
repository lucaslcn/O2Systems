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
@Table(name = "remedio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Remedio.findAll", query = "SELECT r FROM Remedio r")
    , @NamedQuery(name = "Remedio.findByIdremedio", query = "SELECT r FROM Remedio r WHERE r.idremedio = :idremedio")
    , @NamedQuery(name = "Remedio.findByNomeRemedio", query = "SELECT r FROM Remedio r WHERE r.nomeRemedio = :nomeRemedio")
    , @NamedQuery(name = "Remedio.findByControlado", query = "SELECT r FROM Remedio r WHERE r.controlado = :controlado")})
public class Remedio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idremedio")
    private Integer idremedio;
    @Basic(optional = false)
    @Column(name = "nome_remedio")
    private String nomeRemedio;
    @Column(name = "controlado")
    private Boolean controlado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idremedio")
    private List<ListagemRemedios> listagemRemediosList;

    public Remedio() {
    }

    public Remedio(Integer idremedio) {
        this.idremedio = idremedio;
    }

    public Remedio(Integer idremedio, String nomeRemedio) {
        this.idremedio = idremedio;
        this.nomeRemedio = nomeRemedio;
    }

    public Integer getIdremedio() {
        return idremedio;
    }

    public void setIdremedio(Integer idremedio) {
        this.idremedio = idremedio;
    }

    public String getNomeRemedio() {
        return nomeRemedio;
    }

    public void setNomeRemedio(String nomeRemedio) {
        this.nomeRemedio = nomeRemedio;
    }

    public Boolean getControlado() {
        return controlado;
    }

    public void setControlado(Boolean controlado) {
        this.controlado = controlado;
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
        hash += (idremedio != null ? idremedio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Remedio)) {
            return false;
        }
        Remedio other = (Remedio) object;
        if ((this.idremedio == null && other.idremedio != null) || (this.idremedio != null && !this.idremedio.equals(other.idremedio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "negocio.Remedio[ idremedio=" + idremedio + " ]";
    }
    
}
