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
import javax.persistence.FetchType;
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
@Table(name = "forma_pagamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FormaPagamento.findAll", query = "SELECT f FROM FormaPagamento f")
    , @NamedQuery(name = "FormaPagamento.findByIdformaPagamento", query = "SELECT f FROM FormaPagamento f WHERE f.idformaPagamento = :idformaPagamento")
    , @NamedQuery(name = "FormaPagamento.findByDescricaoFormaPagamento", query = "SELECT f FROM FormaPagamento f WHERE f.descricaoFormaPagamento = :descricaoFormaPagamento")})
public class FormaPagamento implements Serializable {

    @Basic(optional = false)
    @Column(name = "status")
    private boolean status;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idforma_pagamento")
    private Integer idformaPagamento;
    @Basic(optional = false)
    @Column(name = "descricao_forma_pagamento")
    private String descricaoFormaPagamento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idformaPagamento")
    private List<AgendamentoExames> agendamentoExamesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idformaPagamento")
    private List<Consultas> consultasList;

    public FormaPagamento() {
    }

    public FormaPagamento(Integer idformaPagamento) {
        this.idformaPagamento = idformaPagamento;
    }

    public FormaPagamento(Integer idformaPagamento, String descricaoFormaPagamento) {
        this.idformaPagamento = idformaPagamento;
        this.descricaoFormaPagamento = descricaoFormaPagamento;
    }

    public Integer getIdformaPagamento() {
        return idformaPagamento;
    }

    public void setIdformaPagamento(Integer idformaPagamento) {
        this.idformaPagamento = idformaPagamento;
    }

    public String getDescricaoFormaPagamento() {
        return descricaoFormaPagamento;
    }

    public void setDescricaoFormaPagamento(String descricaoFormaPagamento) {
        this.descricaoFormaPagamento = descricaoFormaPagamento;
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
        hash += (idformaPagamento != null ? idformaPagamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FormaPagamento)) {
            return false;
        }
        FormaPagamento other = (FormaPagamento) object;
        if ((this.idformaPagamento == null && other.idformaPagamento != null) || (this.idformaPagamento != null && !this.idformaPagamento.equals(other.idformaPagamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "negocio.FormaPagamento[ idformaPagamento=" + idformaPagamento + " ]";
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}
