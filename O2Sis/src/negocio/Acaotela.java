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
@Table(name = "acaotela")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acaotela.findAll", query = "SELECT a FROM Acaotela a")
    , @NamedQuery(name = "Acaotela.findByIdacaotela", query = "SELECT a FROM Acaotela a WHERE a.idacaotela = :idacaotela")
    , @NamedQuery(name = "Acaotela.findByNomeAcao", query = "SELECT a FROM Acaotela a WHERE a.nomeAcao = :nomeAcao")})
public class Acaotela implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idacaotela")
    private Integer idacaotela;
    @Column(name = "nome_acao")
    private String nomeAcao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idacaotela")
    private List<Listaacao> listaacaoList;

    public Acaotela() {
    }

    public Acaotela(Integer idacaotela) {
        this.idacaotela = idacaotela;
    }

    public Integer getIdacaotela() {
        return idacaotela;
    }

    public void setIdacaotela(Integer idacaotela) {
        this.idacaotela = idacaotela;
    }

    public String getNomeAcao() {
        return nomeAcao;
    }

    public void setNomeAcao(String nomeAcao) {
        this.nomeAcao = nomeAcao;
    }

    @XmlTransient
    public List<Listaacao> getListaacaoList() {
        return listaacaoList;
    }

    public void setListaacaoList(List<Listaacao> listaacaoList) {
        this.listaacaoList = listaacaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idacaotela != null ? idacaotela.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acaotela)) {
            return false;
        }
        Acaotela other = (Acaotela) object;
        if ((this.idacaotela == null && other.idacaotela != null) || (this.idacaotela != null && !this.idacaotela.equals(other.idacaotela))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "negocio.Acaotela[ idacaotela=" + idacaotela + " ]";
    }
    
}
