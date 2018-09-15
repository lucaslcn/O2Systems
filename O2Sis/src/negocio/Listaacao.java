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
@Table(name = "listaacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Listaacao.findAll", query = "SELECT l FROM Listaacao l")
    , @NamedQuery(name = "Listaacao.findByIdlistaacao", query = "SELECT l FROM Listaacao l WHERE l.idlistaacao = :idlistaacao")})
public class Listaacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlistaacao")
    private Integer idlistaacao;
    @JoinColumn(name = "idacaotela", referencedColumnName = "idacaotela")
    @ManyToOne(optional = false)
    private Acaotela idacaotela;
    @JoinColumn(name = "idtela", referencedColumnName = "idtela")
    @ManyToOne(optional = false)
    private Tela idtela;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idlistaacao")
    private List<Listapermissao> listapermissaoList;

    public Listaacao() {
    }

    public Listaacao(Integer idlistaacao) {
        this.idlistaacao = idlistaacao;
    }

    public Integer getIdlistaacao() {
        return idlistaacao;
    }

    public void setIdlistaacao(Integer idlistaacao) {
        this.idlistaacao = idlistaacao;
    }

    public Acaotela getIdacaotela() {
        return idacaotela;
    }

    public void setIdacaotela(Acaotela idacaotela) {
        this.idacaotela = idacaotela;
    }

    public Tela getIdtela() {
        return idtela;
    }

    public void setIdtela(Tela idtela) {
        this.idtela = idtela;
    }

    @XmlTransient
    public List<Listapermissao> getListapermissaoList() {
        return listapermissaoList;
    }

    public void setListapermissaoList(List<Listapermissao> listapermissaoList) {
        this.listapermissaoList = listapermissaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlistaacao != null ? idlistaacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Listaacao)) {
            return false;
        }
        Listaacao other = (Listaacao) object;
        if ((this.idlistaacao == null && other.idlistaacao != null) || (this.idlistaacao != null && !this.idlistaacao.equals(other.idlistaacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "negocio.Listaacao[ idlistaacao=" + idlistaacao + " ]";
    }
    
}
