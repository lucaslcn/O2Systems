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
@Table(name = "funcionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f")
    , @NamedQuery(name = "Funcionario.findByIdfuncionario", query = "SELECT f FROM Funcionario f WHERE f.idfuncionario = :idfuncionario")
    , @NamedQuery(name = "Funcionario.findByMedico", query = "SELECT f FROM Funcionario f WHERE f.medico = :medico")})
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfuncionario")
    private Integer idfuncionario;
    @Column(name = "medico")
    private Boolean medico;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idfuncionario")
    private List<Consultas> consultasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idfuncionario")
    private List<Usuario> usuarioList;
    @JoinColumn(name = "idpessoa", referencedColumnName = "idpessoa")
    @ManyToOne(optional = false)
    private Pessoa idpessoa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idfuncionario")
    private List<ListagemFuncao> listagemFuncaoList;

    public Funcionario() {
    }

    public Funcionario(Integer idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    public Integer getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(Integer idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    public Boolean getMedico() {
        return medico;
    }

    public void setMedico(Boolean medico) {
        this.medico = medico;
    }

    @XmlTransient
    public List<Consultas> getConsultasList() {
        return consultasList;
    }

    public void setConsultasList(List<Consultas> consultasList) {
        this.consultasList = consultasList;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public Pessoa getIdpessoa() {
        return idpessoa;
    }

    public void setIdpessoa(Pessoa idpessoa) {
        this.idpessoa = idpessoa;
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
        hash += (idfuncionario != null ? idfuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.idfuncionario == null && other.idfuncionario != null) || (this.idfuncionario != null && !this.idfuncionario.equals(other.idfuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "negocio.Funcionario[ idfuncionario=" + idfuncionario + " ]";
    }
    
}
