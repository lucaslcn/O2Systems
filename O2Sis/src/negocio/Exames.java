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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author XorNOTE
 */
@Entity
@Table(name = "exames")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Exames.findAll", query = "SELECT e FROM Exames e")
    , @NamedQuery(name = "Exames.findByIdexame", query = "SELECT e FROM Exames e WHERE e.idexame = :idexame")
    , @NamedQuery(name = "Exames.findByNomeExame", query = "SELECT e FROM Exames e WHERE e.nomeExame = :nomeExame")
    , @NamedQuery(name = "Exames.findByPrazoRetirada", query = "SELECT e FROM Exames e WHERE e.prazoRetirada = :prazoRetirada")
    , @NamedQuery(name = "Exames.findByValor", query = "SELECT e FROM Exames e WHERE e.valor = :valor")
    , @NamedQuery(name = "Exames.findByStatus", query = "SELECT e FROM Exames e WHERE e.status = :status")
    , @NamedQuery(name = "Exames.findByDuracao", query = "SELECT e FROM Exames e WHERE e.duracao = :duracao")})
public class Exames implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idexame")
    private Integer idexame;
    @Basic(optional = false)
    @Column(name = "nome_exame")
    private String nomeExame;
    @Basic(optional = false)
    @Column(name = "prazo_retirada")
    private int prazoRetirada;
    @Basic(optional = false)
    @Column(name = "valor")
    private BigInteger valor;
    @Basic(optional = false)
    @Column(name = "status")
    private boolean status;
    @Basic(optional = false)
    @Column(name = "duracao")
    private int duracao;

    public Exames() {
    }

    public Exames(Integer idexame) {
        this.idexame = idexame;
    }

    public Exames(Integer idexame, String nomeExame, int prazoRetirada, BigInteger valor, boolean status, int duracao) {
        this.idexame = idexame;
        this.nomeExame = nomeExame;
        this.prazoRetirada = prazoRetirada;
        this.valor = valor;
        this.status = status;
        this.duracao = duracao;
    }

    public Integer getIdexame() {
        return idexame;
    }

    public void setIdexame(Integer idexame) {
        this.idexame = idexame;
    }

    public String getNomeExame() {
        return nomeExame;
    }

    public void setNomeExame(String nomeExame) {
        this.nomeExame = nomeExame;
    }

    public int getPrazoRetirada() {
        return prazoRetirada;
    }

    public void setPrazoRetirada(int prazoRetirada) {
        this.prazoRetirada = prazoRetirada;
    }

    public BigInteger getValor() {
        return valor;
    }

    public void setValor(BigInteger valor) {
        this.valor = valor;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idexame != null ? idexame.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Exames)) {
            return false;
        }
        Exames other = (Exames) object;
        if ((this.idexame == null && other.idexame != null) || (this.idexame != null && !this.idexame.equals(other.idexame))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "negocio.Exames[ idexame=" + idexame + " ]";
    }
    
}
