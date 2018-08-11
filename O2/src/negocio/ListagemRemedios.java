/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "listagem_remedios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ListagemRemedios.findAll", query = "SELECT l FROM ListagemRemedios l")
    , @NamedQuery(name = "ListagemRemedios.findByIdlistagemRemedios", query = "SELECT l FROM ListagemRemedios l WHERE l.idlistagemRemedios = :idlistagemRemedios")
    , @NamedQuery(name = "ListagemRemedios.findByQuantidade", query = "SELECT l FROM ListagemRemedios l WHERE l.quantidade = :quantidade")
    , @NamedQuery(name = "ListagemRemedios.findByUnidade", query = "SELECT l FROM ListagemRemedios l WHERE l.unidade = :unidade")
    , @NamedQuery(name = "ListagemRemedios.findByFrequencia", query = "SELECT l FROM ListagemRemedios l WHERE l.frequencia = :frequencia")
    , @NamedQuery(name = "ListagemRemedios.findByDuracao", query = "SELECT l FROM ListagemRemedios l WHERE l.duracao = :duracao")
    , @NamedQuery(name = "ListagemRemedios.findByComposicao", query = "SELECT l FROM ListagemRemedios l WHERE l.composicao = :composicao")})
public class ListagemRemedios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlistagem_remedios")
    private Integer idlistagemRemedios;
    @Basic(optional = false)
    @Column(name = "quantidade")
    private BigInteger quantidade;
    @Basic(optional = false)
    @Column(name = "unidade")
    private String unidade;
    @Basic(optional = false)
    @Column(name = "frequencia")
    private String frequencia;
    @Basic(optional = false)
    @Column(name = "duracao")
    private String duracao;
    @Column(name = "composicao")
    private String composicao;
    @JoinColumn(name = "idreceita", referencedColumnName = "idreceita")
    @ManyToOne(optional = false)
    private Receita idreceita;
    @JoinColumn(name = "idremedio", referencedColumnName = "idremedio")
    @ManyToOne(optional = false)
    private Remedio idremedio;

    public ListagemRemedios() {
    }

    public ListagemRemedios(Integer idlistagemRemedios) {
        this.idlistagemRemedios = idlistagemRemedios;
    }

    public ListagemRemedios(Integer idlistagemRemedios, BigInteger quantidade, String unidade, String frequencia, String duracao) {
        this.idlistagemRemedios = idlistagemRemedios;
        this.quantidade = quantidade;
        this.unidade = unidade;
        this.frequencia = frequencia;
        this.duracao = duracao;
    }

    public Integer getIdlistagemRemedios() {
        return idlistagemRemedios;
    }

    public void setIdlistagemRemedios(Integer idlistagemRemedios) {
        this.idlistagemRemedios = idlistagemRemedios;
    }

    public BigInteger getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigInteger quantidade) {
        this.quantidade = quantidade;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(String frequencia) {
        this.frequencia = frequencia;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getComposicao() {
        return composicao;
    }

    public void setComposicao(String composicao) {
        this.composicao = composicao;
    }

    public Receita getIdreceita() {
        return idreceita;
    }

    public void setIdreceita(Receita idreceita) {
        this.idreceita = idreceita;
    }

    public Remedio getIdremedio() {
        return idremedio;
    }

    public void setIdremedio(Remedio idremedio) {
        this.idremedio = idremedio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlistagemRemedios != null ? idlistagemRemedios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListagemRemedios)) {
            return false;
        }
        ListagemRemedios other = (ListagemRemedios) object;
        if ((this.idlistagemRemedios == null && other.idlistagemRemedios != null) || (this.idlistagemRemedios != null && !this.idlistagemRemedios.equals(other.idlistagemRemedios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "negocio.ListagemRemedios[ idlistagemRemedios=" + idlistagemRemedios + " ]";
    }
    
}
