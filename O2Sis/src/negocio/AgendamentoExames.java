/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "agendamento_exames")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AgendamentoExames.findAll", query = "SELECT a FROM AgendamentoExames a")
    , @NamedQuery(name = "AgendamentoExames.findByIdagendamentoExames", query = "SELECT a FROM AgendamentoExames a WHERE a.idagendamentoExames = :idagendamentoExames")
    , @NamedQuery(name = "AgendamentoExames.findByDataExame", query = "SELECT a FROM AgendamentoExames a WHERE a.dataExame = :dataExame")
    , @NamedQuery(name = "AgendamentoExames.findByHoraExame", query = "SELECT a FROM AgendamentoExames a WHERE a.horaExame = :horaExame")
    , @NamedQuery(name = "AgendamentoExames.findByDataEntrega", query = "SELECT a FROM AgendamentoExames a WHERE a.dataEntrega = :dataEntrega")})
public class AgendamentoExames implements Serializable {

    @Basic(optional = false)
    @Column(name = "status")
    private boolean status;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idagendamento_exames")
    private Integer idagendamentoExames;
    @Basic(optional = false)
    @Column(name = "data_exame")
    @Temporal(TemporalType.DATE)
    private Date dataExame;
    @Basic(optional = false)
    @Column(name = "hora_exame")
    @Temporal(TemporalType.TIME)
    private Date horaExame;
    @Column(name = "data_entrega")
    @Temporal(TemporalType.DATE)
    private Date dataEntrega;
    @JoinColumn(name = "idexame", referencedColumnName = "idexame")
    @ManyToOne(optional = false)
    @JsonIgnore
    private Exames idexame;
    @JoinColumn(name = "idforma_pagamento", referencedColumnName = "idforma_pagamento")
    @ManyToOne(optional = false)
    @JsonIgnore
    private FormaPagamento idformaPagamento;
    @JoinColumn(name = "idpaciente", referencedColumnName = "idpaciente")
    @ManyToOne(optional = false)
    @JsonIgnore
    private Paciente idpaciente;
    @JoinColumn(name = "idplano", referencedColumnName = "idplano")
    @ManyToOne(optional = false)
    @JsonIgnore
    private Plano idplano;

    public AgendamentoExames() {
    }

    public AgendamentoExames(Integer idagendamentoExames) {
        this.idagendamentoExames = idagendamentoExames;
    }

    public AgendamentoExames(Integer idagendamentoExames, Date dataExame, Date horaExame) {
        this.idagendamentoExames = idagendamentoExames;
        this.dataExame = dataExame;
        this.horaExame = horaExame;
    }

    public Integer getIdagendamentoExames() {
        return idagendamentoExames;
    }

    public void setIdagendamentoExames(Integer idagendamentoExames) {
        this.idagendamentoExames = idagendamentoExames;
    }

    public Date getDataExame() {
        return dataExame;
    }

    public void setDataExame(Date dataExame) {
        this.dataExame = dataExame;
    }

    public Date getHoraExame() {
        return horaExame;
    }

    public void setHoraExame(Date horaExame) {
        this.horaExame = horaExame;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public Exames getIdexame() {
        return idexame;
    }

    public void setIdexame(Exames idexame) {
        this.idexame = idexame;
    }

    public FormaPagamento getIdformaPagamento() {
        return idformaPagamento;
    }

    public void setIdformaPagamento(FormaPagamento idformaPagamento) {
        this.idformaPagamento = idformaPagamento;
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
        hash += (idagendamentoExames != null ? idagendamentoExames.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AgendamentoExames)) {
            return false;
        }
        AgendamentoExames other = (AgendamentoExames) object;
        if ((this.idagendamentoExames == null && other.idagendamentoExames != null) || (this.idagendamentoExames != null && !this.idagendamentoExames.equals(other.idagendamentoExames))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "negocio.AgendamentoExames[ idagendamentoExames=" + idagendamentoExames + " ]";
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}
