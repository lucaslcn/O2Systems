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
@Table(name = "listagem_exames")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ListagemExames.findAll", query = "SELECT l FROM ListagemExames l")
    , @NamedQuery(name = "ListagemExames.findByIdlistagemExames", query = "SELECT l FROM ListagemExames l WHERE l.idlistagemExames = :idlistagemExames")
    , @NamedQuery(name = "ListagemExames.findByObservacao", query = "SELECT l FROM ListagemExames l WHERE l.observacao = :observacao")})
public class ListagemExames implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlistagem_exames")
    private Integer idlistagemExames;
    @Basic(optional = false)
    @Column(name = "observacao")
    private String observacao;
    @JoinColumn(name = "idexames", referencedColumnName = "idexame")
    @ManyToOne(optional = false)
    private Exames idexames;
    @JoinColumn(name = "idrequisicao", referencedColumnName = "idrequisicao")
    @ManyToOne(optional = false)
    private Requisicao idrequisicao;

    public ListagemExames() {
    }

    public ListagemExames(Integer idlistagemExames) {
        this.idlistagemExames = idlistagemExames;
    }

    public ListagemExames(Integer idlistagemExames, String observacao) {
        this.idlistagemExames = idlistagemExames;
        this.observacao = observacao;
    }

    public Integer getIdlistagemExames() {
        return idlistagemExames;
    }

    public void setIdlistagemExames(Integer idlistagemExames) {
        this.idlistagemExames = idlistagemExames;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Exames getIdexames() {
        return idexames;
    }

    public void setIdexames(Exames idexames) {
        this.idexames = idexames;
    }

    public Requisicao getIdrequisicao() {
        return idrequisicao;
    }

    public void setIdrequisicao(Requisicao idrequisicao) {
        this.idrequisicao = idrequisicao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlistagemExames != null ? idlistagemExames.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListagemExames)) {
            return false;
        }
        ListagemExames other = (ListagemExames) object;
        if ((this.idlistagemExames == null && other.idlistagemExames != null) || (this.idlistagemExames != null && !this.idlistagemExames.equals(other.idlistagemExames))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "negocio.ListagemExames[ idlistagemExames=" + idlistagemExames + " ]";
    }
    
}
