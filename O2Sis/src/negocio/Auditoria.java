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
@Table(name = "auditoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Auditoria.findAll", query = "SELECT a FROM Auditoria a")
    , @NamedQuery(name = "Auditoria.findByIdauditoria", query = "SELECT a FROM Auditoria a WHERE a.idauditoria = :idauditoria")
    , @NamedQuery(name = "Auditoria.findByInformacaoold", query = "SELECT a FROM Auditoria a WHERE a.informacaoold = :informacaoold")
    , @NamedQuery(name = "Auditoria.findByInformacaonew", query = "SELECT a FROM Auditoria a WHERE a.informacaonew = :informacaonew")
    , @NamedQuery(name = "Auditoria.findByOnde", query = "SELECT a FROM Auditoria a WHERE a.onde = :onde")
    , @NamedQuery(name = "Auditoria.findByAcao", query = "SELECT a FROM Auditoria a WHERE a.acao = :acao")
    , @NamedQuery(name = "Auditoria.findByData", query = "SELECT a FROM Auditoria a WHERE a.data = :data")
    , @NamedQuery(name = "Auditoria.findByHora", query = "SELECT a FROM Auditoria a WHERE a.hora = :hora")})
public class Auditoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idauditoria")
    private Integer idauditoria;
    @Basic(optional = false)
    @Column(name = "informacaoold")
    private String informacaoold;
    @Basic(optional = false)
    @Column(name = "informacaonew")
    private String informacaonew;
    @Basic(optional = false)
    @Column(name = "onde")
    private String onde;
    @Basic(optional = false)
    @Column(name = "acao")
    private String acao;
    @Basic(optional = false)
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Basic(optional = false)
    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idusuario;

    public Auditoria() {
    }

    public Auditoria(Integer idauditoria) {
        this.idauditoria = idauditoria;
    }

    public Auditoria(Integer idauditoria, String informacaoold, String informacaonew, String onde, String acao, Date data, Date hora) {
        this.idauditoria = idauditoria;
        this.informacaoold = informacaoold;
        this.informacaonew = informacaonew;
        this.onde = onde;
        this.acao = acao;
        this.data = data;
        this.hora = hora;
    }

    public Integer getIdauditoria() {
        return idauditoria;
    }

    public void setIdauditoria(Integer idauditoria) {
        this.idauditoria = idauditoria;
    }

    public String getInformacaoold() {
        return informacaoold;
    }

    public void setInformacaoold(String informacaoold) {
        this.informacaoold = informacaoold;
    }

    public String getInformacaonew() {
        return informacaonew;
    }

    public void setInformacaonew(String informacaonew) {
        this.informacaonew = informacaonew;
    }

    public String getOnde() {
        return onde;
    }

    public void setOnde(String onde) {
        this.onde = onde;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idauditoria != null ? idauditoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Auditoria)) {
            return false;
        }
        Auditoria other = (Auditoria) object;
        if ((this.idauditoria == null && other.idauditoria != null) || (this.idauditoria != null && !this.idauditoria.equals(other.idauditoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "negocio.Auditoria[ idauditoria=" + idauditoria + " ]";
    }
    
}
