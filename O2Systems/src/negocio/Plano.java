/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

<<<<<<< HEAD
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
=======

import java.util.HashSet;
import java.util.Set;
>>>>>>> 15ef7ece8f3ff87f140ea4fdaf4ef92d360a5016
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
<<<<<<< HEAD
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
=======
import javax.persistence.Table;
>>>>>>> 15ef7ece8f3ff87f140ea4fdaf4ef92d360a5016

/**
 *
 * @author XorNOTE
 */
<<<<<<< HEAD
@Entity
@Table(name = "plano")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plano.findAll", query = "SELECT p FROM Plano p")
    , @NamedQuery(name = "Plano.findByIdplano", query = "SELECT p FROM Plano p WHERE p.idplano = :idplano")
    , @NamedQuery(name = "Plano.findByNomePlano", query = "SELECT p FROM Plano p WHERE p.nomePlano = :nomePlano")})
public class Plano implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idplano")
    private Integer idplano;
    @Basic(optional = false)
    @Column(name = "nome_plano")
    private String nomePlano;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idplano")
    private List<ListagemPlanos> listagemPlanosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idplano")
    private List<AgendamentoExames> agendamentoExamesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idplano")
    private List<Consultas> consultasList;
=======

@Entity
@Table (name = "plano")

public class Plano  implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idplano", updatable = false, nullable = false)
     private int idplano;
     private String nomePlano;
     private Set<AgendamentoExames> agendamentoExameses = new HashSet<AgendamentoExames>(0);
     private Set<Consultas> consultases = new HashSet<Consultas>(0);
     private Set<ListagemPlanos> listagemPlanoses = new HashSet<ListagemPlanos>(0);
>>>>>>> 15ef7ece8f3ff87f140ea4fdaf4ef92d360a5016

    public Plano() {
    }

<<<<<<< HEAD
    public Plano(Integer idplano) {
=======
	
    public Plano(int idplano, String nomePlano) {
>>>>>>> 15ef7ece8f3ff87f140ea4fdaf4ef92d360a5016
        this.idplano = idplano;
    }
<<<<<<< HEAD

    public Plano(Integer idplano, String nomePlano) {
        this.idplano = idplano;
        this.nomePlano = nomePlano;
    }

    public Integer getIdplano() {
        return idplano;
    }

    public void setIdplano(Integer idplano) {
=======
    public Plano(int idplano, String nomePlano, Set<AgendamentoExames> agendamentoExameses, Set<Consultas> consultases, Set<ListagemPlanos> listagemPlanoses) {
       this.idplano = idplano;
       this.nomePlano = nomePlano;
       this.agendamentoExameses = agendamentoExameses;
       this.consultases = consultases;
       this.listagemPlanoses = listagemPlanoses;
    }
   
    public int getIdplano() {
        return this.idplano;
    }
    
    public void setIdplano(int idplano) {
>>>>>>> 15ef7ece8f3ff87f140ea4fdaf4ef92d360a5016
        this.idplano = idplano;
    }
    public String getNomePlano() {
        return nomePlano;
    }
    
    public void setNomePlano(String nomePlano) {
        this.nomePlano = nomePlano;
    }
<<<<<<< HEAD

    @XmlTransient
    public List<ListagemPlanos> getListagemPlanosList() {
        return listagemPlanosList;
    }

    public void setListagemPlanosList(List<ListagemPlanos> listagemPlanosList) {
        this.listagemPlanosList = listagemPlanosList;
    }

    @XmlTransient
    public List<AgendamentoExames> getAgendamentoExamesList() {
        return agendamentoExamesList;
    }

    public void setAgendamentoExamesList(List<AgendamentoExames> agendamentoExamesList) {
        this.agendamentoExamesList = agendamentoExamesList;
    }

    @XmlTransient
    public List<Consultas> getConsultasList() {
        return consultasList;
    }

    public void setConsultasList(List<Consultas> consultasList) {
        this.consultasList = consultasList;
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
    
=======
    public Set<AgendamentoExames> getAgendamentoExameses() {
        return this.agendamentoExameses;
    }
    
    public void setAgendamentoExameses(Set<AgendamentoExames> agendamentoExameses) {
        this.agendamentoExameses = agendamentoExameses;
    }
    public Set<Consultas> getConsultases() {
        return this.consultases;
    }
    
    public void setConsultases(Set<Consultas> consultases) {
        this.consultases = consultases;
    }
    public Set<ListagemPlanos> getListagemPlanoses() {
        return this.listagemPlanoses;
    }
    
    public void setListagemPlanoses(Set<ListagemPlanos> listagemPlanoses) {
        this.listagemPlanoses = listagemPlanoses;
    }




>>>>>>> 15ef7ece8f3ff87f140ea4fdaf4ef92d360a5016
}


