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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author XorNOTE
 */
@Entity
@Table(name = "listagem_planos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ListagemPlanos.findAll", query = "SELECT l FROM ListagemPlanos l")
    , @NamedQuery(name = "ListagemPlanos.findByIdlistagemPlano", query = "SELECT l FROM ListagemPlanos l WHERE l.idlistagemPlano = :idlistagemPlano")
    , @NamedQuery(name = "ListagemPlanos.findByCodigoPlano", query = "SELECT l FROM ListagemPlanos l WHERE l.codigoPlano = :codigoPlano")})
public class ListagemPlanos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlistagem_plano")
    private Integer idlistagemPlano;
    @Basic(optional = false)
    @Column(name = "codigo_plano")
    private String codigoPlano;
    @JoinColumn(name = "idpaciente", referencedColumnName = "idpaciente")
    @ManyToOne(optional = false)
    private Paciente idpaciente;
    @JoinColumn(name = "idplano", referencedColumnName = "idplano")
    @ManyToOne(optional = false)
    private Plano idplano;

    public ListagemPlanos() {
    }

    public ListagemPlanos(Integer idlistagemPlano) {
        this.idlistagemPlano = idlistagemPlano;
    }

    public ListagemPlanos(Integer idlistagemPlano, String codigoPlano) {
        this.idlistagemPlano = idlistagemPlano;
        this.codigoPlano = codigoPlano;
    }

    public Integer getIdlistagemPlano() {
        return idlistagemPlano;
    }

    public void setIdlistagemPlano(Integer idlistagemPlano) {
        this.idlistagemPlano = idlistagemPlano;
    }

    public String getCodigoPlano() {
        return codigoPlano;
    }

    public void setCodigoPlano(String codigoPlano) {
        this.codigoPlano = codigoPlano;
    }

    public Paciente getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(Paciente idpaciente) {
        this.idpaciente = idpaciente;
    }

    public Plano getIdplano() {
        return idplano;
    }

    public void setIdplano(Plano idplano) {
        this.idplano = idplano;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlistagemPlano != null ? idlistagemPlano.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListagemPlanos)) {
            return false;
        }
        ListagemPlanos other = (ListagemPlanos) object;
        if ((this.idlistagemPlano == null && other.idlistagemPlano != null) || (this.idlistagemPlano != null && !this.idlistagemPlano.equals(other.idlistagemPlano))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "negocio.ListagemPlanos[ idlistagemPlano=" + idlistagemPlano + " ]";
    }
    
}
