/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author XorNOTE
 */
@Entity
@Table(name = "parametros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parametros.findAll", query = "SELECT p FROM Parametros p")
    , @NamedQuery(name = "Parametros.findByIdparametro", query = "SELECT p FROM Parametros p WHERE p.idparametro = :idparametro")
    , @NamedQuery(name = "Parametros.findByKeyparametro", query = "SELECT p FROM Parametros p WHERE p.keyparametro = :keyparametro")
    , @NamedQuery(name = "Parametros.findByValueparametro", query = "SELECT p FROM Parametros p WHERE p.valueparametro = :valueparametro")})
public class Parametros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idparametro")
    private Integer idparametro;
    @Basic(optional = false)
    @Column(name = "keyparametro")
    private String keyparametro;
    @Basic(optional = false)
    @Column(name = "valueparametro")
    private String valueparametro;

    public Parametros() {
    }

    public Parametros(Integer idparametro) {
        this.idparametro = idparametro;
    }

    public Parametros(Integer idparametro, String keyparametro, String valueparametro) {
        this.idparametro = idparametro;
        this.keyparametro = keyparametro;
        this.valueparametro = valueparametro;
    }

    public Integer getIdparametro() {
        return idparametro;
    }

    public void setIdparametro(Integer idparametro) {
        this.idparametro = idparametro;
    }

    public String getKeyparametro() {
        return keyparametro;
    }

    public void setKeyparametro(String keyparametro) {
        this.keyparametro = keyparametro;
    }

    public String getValueparametro() {
        return valueparametro;
    }

    public void setValueparametro(String valueparametro) {
        this.valueparametro = valueparametro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idparametro != null ? idparametro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parametros)) {
            return false;
        }
        Parametros other = (Parametros) object;
        if ((this.idparametro == null && other.idparametro != null) || (this.idparametro != null && !this.idparametro.equals(other.idparametro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "negocio.Parametros[ idparametro=" + idparametro + " ]";
    }
    
}
