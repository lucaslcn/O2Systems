/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author XorNOTE
 */
@Entity
@Table(name = "consultas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consultas.findAll", query = "SELECT c FROM Consultas c")
    , @NamedQuery(name = "Consultas.findByIdconsultas", query = "SELECT c FROM Consultas c WHERE c.idconsultas = :idconsultas")
    , @NamedQuery(name = "Consultas.findByDataConsulta", query = "SELECT c FROM Consultas c WHERE c.dataConsulta = :dataConsulta")
    , @NamedQuery(name = "Consultas.findByHoraConsulta", query = "SELECT c FROM Consultas c WHERE c.horaConsulta = :horaConsulta")})
public class Consultas implements Serializable {

    @Basic(optional = false)
    @Column(name = "status")
    private boolean status;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idconsultas")
    private Integer idconsultas;
    @Basic(optional = false)
    @Column(name = "data_consulta")
    @Temporal(TemporalType.DATE)
    private Date dataConsulta;
    @Basic(optional = false)
    @Column(name = "hora_consulta")
    @Temporal(TemporalType.TIME)
    private Date horaConsulta;
    @JoinColumn(name = "idforma_pagamento", referencedColumnName = "idforma_pagamento")
    @ManyToOne(optional = false)
    private FormaPagamento idformaPagamento;
    @JoinColumn(name = "idfuncionario", referencedColumnName = "idfuncionario")
    @ManyToOne(optional = false)
    private Funcionario idfuncionario;
    @JoinColumn(name = "idpaciente", referencedColumnName = "idpaciente")
    @ManyToOne(optional = false)
    private Paciente idpaciente;
    @JoinColumn(name = "idplano", referencedColumnName = "idplano")
    @ManyToOne(optional = false)
    private Plano idplano;
    @JoinColumn(name = "idprontuario", referencedColumnName = "idprontuario")
    @ManyToOne(optional = false)
    private Prontuario idprontuario;

    public Consultas() {
    }

    public Consultas(Integer idconsultas) {
        this.idconsultas = idconsultas;
    }

    public Consultas(Integer idconsultas, Date dataConsulta, Date horaConsulta) {
        this.idconsultas = idconsultas;
        this.dataConsulta = dataConsulta;
        this.horaConsulta = horaConsulta;
    }

    public Integer getIdconsultas() {
        return idconsultas;
    }

    public void setIdconsultas(Integer idconsultas) {
        this.idconsultas = idconsultas;
    }

    public Date getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public Date getHoraConsulta() {
        return horaConsulta;
    }

    public void setHoraConsulta(Date horaConsulta) {
        this.horaConsulta = horaConsulta;
    }

    public FormaPagamento getIdformaPagamento() {
        return idformaPagamento;
    }

    public void setIdformaPagamento(FormaPagamento idformaPagamento) {
        this.idformaPagamento = idformaPagamento;
    }

    public Funcionario getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(Funcionario idfuncionario) {
        this.idfuncionario = idfuncionario;
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

    public Prontuario getIdprontuario() {
        return idprontuario;
    }

    public void setIdprontuario(Prontuario idprontuario) {
        this.idprontuario = idprontuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idconsultas != null ? idconsultas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consultas)) {
            return false;
        }
        Consultas other = (Consultas) object;
        if ((this.idconsultas == null && other.idconsultas != null) || (this.idconsultas != null && !this.idconsultas.equals(other.idconsultas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "negocio.Consultas[ idconsultas=" + idconsultas + " ]";
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}
