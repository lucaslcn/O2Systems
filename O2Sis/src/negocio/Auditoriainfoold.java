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
@Table(name = "auditoriainfoold")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Auditoriainfoold.findAll", query = "SELECT a FROM Auditoriainfoold a")
    , @NamedQuery(name = "Auditoriainfoold.findByIdauditoria", query = "SELECT a FROM Auditoriainfoold a WHERE a.idauditoria = :idauditoria")
    , @NamedQuery(name = "Auditoriainfoold.findByInformacaoold", query = "SELECT a FROM Auditoriainfoold a WHERE a.informacaoold = :informacaoold")
    , @NamedQuery(name = "Auditoriainfoold.findByInformacaonew", query = "SELECT a FROM Auditoriainfoold a WHERE a.informacaonew = :informacaonew")
    , @NamedQuery(name = "Auditoriainfoold.findByOnde", query = "SELECT a FROM Auditoriainfoold a WHERE a.onde = :onde")
    , @NamedQuery(name = "Auditoriainfoold.findByAcao", query = "SELECT a FROM Auditoriainfoold a WHERE a.acao = :acao")
    , @NamedQuery(name = "Auditoriainfoold.findByData", query = "SELECT a FROM Auditoriainfoold a WHERE a.data = :data")
    , @NamedQuery(name = "Auditoriainfoold.findByHora", query = "SELECT a FROM Auditoriainfoold a WHERE a.hora = :hora")})
public class Auditoriainfoold implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idauditoria")
    private Integer idauditoria;
    @Column(name = "informacaoold")
    private String informacaoold;
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

    public Auditoriainfoold() {
    }

    public Auditoriainfoold(Integer idauditoria) {
        this.idauditoria = idauditoria;
    }

    public Auditoriainfoold(Integer idauditoria, String onde, String acao, Date data, Date hora) {
        this.idauditoria = idauditoria;
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
        if (!(object instanceof Auditoriainfoold)) {
            return false;
        }
        Auditoriainfoold other = (Auditoriainfoold) object;
        if ((this.idauditoria == null && other.idauditoria != null) || (this.idauditoria != null && !this.idauditoria.equals(other.idauditoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "negocio.Auditoriainfoold[ idauditoria=" + idauditoria + " ]";
    }
    
}
