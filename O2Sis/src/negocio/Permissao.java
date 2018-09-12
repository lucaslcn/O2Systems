/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "permissao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permissao.findAll", query = "SELECT p FROM Permissao p")
    , @NamedQuery(name = "Permissao.findByIdpermissao", query = "SELECT p FROM Permissao p WHERE p.idpermissao = :idpermissao")
    , @NamedQuery(name = "Permissao.findByNomepermissao", query = "SELECT p FROM Permissao p WHERE p.nomepermissao = :nomepermissao")
    , @NamedQuery(name = "Permissao.findByValorpermissao", query = "SELECT p FROM Permissao p WHERE p.valorpermissao = :valorpermissao")
    , @NamedQuery(name = "Permissao.findByStatus", query = "SELECT p FROM Permissao p WHERE p.status = :status")})
public class Permissao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpermissao")
    private Integer idpermissao;
    @Basic(optional = false)
    @Column(name = "nomepermissao")
    private String nomepermissao;
    @Basic(optional = false)
    @Column(name = "valorpermissao")
    private int valorpermissao;
    @Basic(optional = false)
    @Column(name = "status")
    private boolean status;
    @OneToMany(mappedBy = "idpermissao")
    private List<Usuario> usuarioList;

    public Permissao() {
    }

    public Permissao(Integer idpermissao) {
        this.idpermissao = idpermissao;
    }

    public Permissao(Integer idpermissao, String nomepermissao, int valorpermissao, boolean status) {
        this.idpermissao = idpermissao;
        this.nomepermissao = nomepermissao;
        this.valorpermissao = valorpermissao;
        this.status = status;
    }

    public Integer getIdpermissao() {
        return idpermissao;
    }

    public void setIdpermissao(Integer idpermissao) {
        this.idpermissao = idpermissao;
    }

    public String getNomepermissao() {
        return nomepermissao;
    }

    public void setNomepermissao(String nomepermissao) {
        this.nomepermissao = nomepermissao;
    }

    public int getValorpermissao() {
        return valorpermissao;
    }

    public void setValorpermissao(int valorpermissao) {
        this.valorpermissao = valorpermissao;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpermissao != null ? idpermissao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permissao)) {
            return false;
        }
        Permissao other = (Permissao) object;
        if ((this.idpermissao == null && other.idpermissao != null) || (this.idpermissao != null && !this.idpermissao.equals(other.idpermissao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "negocio.Permissao[ idpermissao=" + idpermissao + " ]";
    }
    
}
