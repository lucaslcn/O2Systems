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
 * @author elias.flach
 */
@Entity
@Table(name = "usuarios_versoes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuariosVersoes.findAll", query = "SELECT u FROM UsuariosVersoes u")
    , @NamedQuery(name = "UsuariosVersoes.findById", query = "SELECT u FROM UsuariosVersoes u WHERE u.id = :id")})
public class UsuariosVersoes implements Serializable {

    @Column(name = "lido")
    private Boolean lido;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "id_versao", referencedColumnName = "id")
    @ManyToOne
    private Notasversoes idVersao;
    @JoinColumn(name = "id_usuario", referencedColumnName = "idusuario")
    @ManyToOne
    private Usuario idUsuario;

    public UsuariosVersoes() {
    }

    public UsuariosVersoes(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Notasversoes getIdVersao() {
        return idVersao;
    }

    public void setIdVersao(Notasversoes idVersao) {
        this.idVersao = idVersao;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
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
        if (!(object instanceof UsuariosVersoes)) {
            return false;
        }
        UsuariosVersoes other = (UsuariosVersoes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "negocio.UsuariosVersoes[ id=" + id + " ]";
    }

    public Boolean getLido() {
        return lido;
    }

    public void setLido(Boolean lido) {
        this.lido = lido;
    }
    
}
