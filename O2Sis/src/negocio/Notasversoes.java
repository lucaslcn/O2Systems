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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author elias.flach
 */
@Entity
@Table(name = "notasversoes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notasversoes.findAll", query = "SELECT n FROM Notasversoes n")
    , @NamedQuery(name = "Notasversoes.findById", query = "SELECT n FROM Notasversoes n WHERE n.id = :id")
    , @NamedQuery(name = "Notasversoes.findByVersao", query = "SELECT n FROM Notasversoes n WHERE n.versao = :versao")
    , @NamedQuery(name = "Notasversoes.findByDescricao", query = "SELECT n FROM Notasversoes n WHERE n.descricao = :descricao")
    , @NamedQuery(name = "Notasversoes.findByLido", query = "SELECT n FROM Notasversoes n WHERE n.lido = :lido")})
public class Notasversoes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "versao")
    private String versao;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "lido")
    private Boolean lido;
    @OneToMany(mappedBy = "idVersao")
    private List<UsuariosVersoes> usuariosVersoesList;

    public Notasversoes() {
    }

    public Notasversoes(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getLido() {
        return lido;
    }

    public void setLido(Boolean lido) {
        this.lido = lido;
    }

    @XmlTransient
    public List<UsuariosVersoes> getUsuariosVersoesList() {
        return usuariosVersoesList;
    }

    public void setUsuariosVersoesList(List<UsuariosVersoes> usuariosVersoesList) {
        this.usuariosVersoesList = usuariosVersoesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notasversoes)) {
            return false;
        }
        Notasversoes other = (Notasversoes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "negocio.Notasversoes[ id=" + id + " ]";
    }
    
}
