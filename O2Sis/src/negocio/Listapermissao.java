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
@Table(name = "listapermissao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Listapermissao.findAll", query = "SELECT l FROM Listapermissao l")
    , @NamedQuery(name = "Listapermissao.findByIdlistapermissao", query = "SELECT l FROM Listapermissao l WHERE l.idlistapermissao = :idlistapermissao")
    , @NamedQuery(name = "Listapermissao.findByPermissao", query = "SELECT l FROM Listapermissao l WHERE l.permissao = :permissao")})
public class Listapermissao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlistapermissao")
    private Integer idlistapermissao;
    @Basic(optional = false)
    @Column(name = "permissao")
    private boolean permissao;
    @JoinColumn(name = "idlistaacao", referencedColumnName = "idlistaacao")
    @ManyToOne(optional = false)
    private Listaacao idlistaacao;
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idusuario;

    public Listapermissao() {
    }

    public Listapermissao(Integer idlistapermissao) {
        this.idlistapermissao = idlistapermissao;
    }

    public Listapermissao(Integer idlistapermissao, boolean permissao) {
        this.idlistapermissao = idlistapermissao;
        this.permissao = permissao;
    }

    public Integer getIdlistapermissao() {
        return idlistapermissao;
    }

    public void setIdlistapermissao(Integer idlistapermissao) {
        this.idlistapermissao = idlistapermissao;
    }

    public boolean getPermissao() {
        return permissao;
    }

    public void setPermissao(boolean permissao) {
        this.permissao = permissao;
    }

    public Listaacao getIdlistaacao() {
        return idlistaacao;
    }

    public void setIdlistaacao(Listaacao idlistaacao) {
        this.idlistaacao = idlistaacao;
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
        hash += (idlistapermissao != null ? idlistapermissao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Listapermissao)) {
            return false;
        }
        Listapermissao other = (Listapermissao) object;
        if ((this.idlistapermissao == null && other.idlistapermissao != null) || (this.idlistapermissao != null && !this.idlistapermissao.equals(other.idlistapermissao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "negocio.Listapermissao[ idlistapermissao=" + idlistapermissao + " ]";
    }
    
}
