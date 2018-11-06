/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "plano")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plano.findAll", query = "SELECT p FROM Plano p")
    , @NamedQuery(name = "Plano.findByIdplano", query = "SELECT p FROM Plano p WHERE p.idplano = :idplano")
    , @NamedQuery(name = "Plano.findByNomePlano", query = "SELECT p FROM Plano p WHERE p.nomePlano = :nomePlano")
    , @NamedQuery(name = "Plano.findByStatus", query = "SELECT p FROM Plano p WHERE p.status = :status")})
public class Plano implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idplano")
    private List<AgendamentoExames> agendamentoExamesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idplano")
    private List<ListagemPlanos> listagemPlanosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idplano")
    private List<Consultas> consultasList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idplano")
    private Integer idplano;
    @Basic(optional = false)
    @Column(name = "nome_plano")
    private String nomePlano;
    @Basic(optional = false)
    @Column(name = "status")
    private boolean status;

    public Plano() {
    }

    public Plano(Integer idplano) {
        this.idplano = idplano;
    }

    public Plano(Integer idplano, String nomePlano, boolean status) {
        this.idplano = idplano;
        this.nomePlano = nomePlano;
        this.status = status;
    }

    public Integer getIdplano() {
        return idplano;
    }

    public void setIdplano(Integer idplano) {
        this.idplano = idplano;
    }

    public String getNomePlano() {
        return nomePlano;
    }

    public void setNomePlano(String nomePlano) {
        this.nomePlano = nomePlano;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idplano != null ? idplano.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plano)) {
            return false;
        }
        Plano other = (Plano) object;
        if ((this.idplano == null && other.idplano != null) || (this.idplano != null && !this.idplano.equals(other.idplano))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "negocio.Plano[ idplano=" + idplano + " ]";
    }

    @XmlTransient
    @JsonIgnore
    public List<AgendamentoExames> getAgendamentoExamesList() {
        return agendamentoExamesList;
    }

    public void setAgendamentoExamesList(List<AgendamentoExames> agendamentoExamesList) {
        this.agendamentoExamesList = agendamentoExamesList;
    }

    @XmlTransient
    @JsonIgnore
    public List<ListagemPlanos> getListagemPlanosList() {
        return listagemPlanosList;
    }

    public void setListagemPlanosList(List<ListagemPlanos> listagemPlanosList) {
        this.listagemPlanosList = listagemPlanosList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Consultas> getConsultasList() {
        return consultasList;
    }

    public void setConsultasList(List<Consultas> consultasList) {
        this.consultasList = consultasList;
    }
    
}
