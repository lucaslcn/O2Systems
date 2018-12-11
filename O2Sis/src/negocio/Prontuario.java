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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "prontuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prontuario.findAll", query = "SELECT p FROM Prontuario p")
    , @NamedQuery(name = "Prontuario.findByIdprontuario", query = "SELECT p FROM Prontuario p WHERE p.idprontuario = :idprontuario")
    , @NamedQuery(name = "Prontuario.findByTriagem", query = "SELECT p FROM Prontuario p WHERE p.triagem = :triagem")
    , @NamedQuery(name = "Prontuario.findByAtendimento", query = "SELECT p FROM Prontuario p WHERE p.atendimento = :atendimento")})
public class Prontuario implements Serializable {

    @Column(name = "receita")
    private String receita;
    @Column(name = "exames")
    private String exames;

    @OneToMany(mappedBy = "idprontuario")
    private List<Consultas> consultasList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idprontuario")
    private Integer idprontuario;
    @Basic(optional = false)
    @Column(name = "triagem")
    private String triagem;
    @Basic(optional = false)
    @Column(name = "atendimento")
    private String atendimento;
    @JoinColumn(name = "idreceita", referencedColumnName = "idreceita")
    @ManyToOne
    private Receita idreceita;
    @JoinColumn(name = "idrequisicao", referencedColumnName = "idrequisicao")
    @ManyToOne
    private Requisicao idrequisicao;

    public Prontuario() {
    }

    public Prontuario(Integer idprontuario) {
        this.idprontuario = idprontuario;
    }

    public Prontuario(Integer idprontuario, String triagem, String atendimento) {
        this.idprontuario = idprontuario;
        this.triagem = triagem;
        this.atendimento = atendimento;
    }

    public Integer getIdprontuario() {
        return idprontuario;
    }

    public void setIdprontuario(Integer idprontuario) {
        this.idprontuario = idprontuario;
    }

    public String getTriagem() {
        return triagem;
    }

    public void setTriagem(String triagem) {
        this.triagem = triagem;
    }

    public String getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(String atendimento) {
        this.atendimento = atendimento;
    }

    public Receita getIdreceita() {
        return idreceita;
    }

    public void setIdreceita(Receita idreceita) {
        this.idreceita = idreceita;
    }

    public Requisicao getIdrequisicao() {
        return idrequisicao;
    }

    public void setIdrequisicao(Requisicao idrequisicao) {
        this.idrequisicao = idrequisicao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprontuario != null ? idprontuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prontuario)) {
            return false;
        }
        Prontuario other = (Prontuario) object;
        if ((this.idprontuario == null && other.idprontuario != null) || (this.idprontuario != null && !this.idprontuario.equals(other.idprontuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "negocio.Prontuario[ idprontuario=" + idprontuario + " ]";
    }

    @XmlTransient
    @JsonIgnore
    public List<Consultas> getConsultasList() {
        return consultasList;
    }

    public void setConsultasList(List<Consultas> consultasList) {
        this.consultasList = consultasList;
    }

    public String getReceita() {
        return receita;
    }

    public void setReceita(String receita) {
        this.receita = receita;
    }

    public String getExames() {
        return exames;
    }

    public void setExames(String exames) {
        this.exames = exames;
    }
    
}
