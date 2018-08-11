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
@Table(name = "listagem_funcao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ListagemFuncao.findAll", query = "SELECT l FROM ListagemFuncao l")
    , @NamedQuery(name = "ListagemFuncao.findByIdlistagemFuncao", query = "SELECT l FROM ListagemFuncao l WHERE l.idlistagemFuncao = :idlistagemFuncao")
    , @NamedQuery(name = "ListagemFuncao.findByValorConsulta", query = "SELECT l FROM ListagemFuncao l WHERE l.valorConsulta = :valorConsulta")})
public class ListagemFuncao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlistagem_funcao")
    private Integer idlistagemFuncao;
    @Column(name = "valor_consulta")
    private String valorConsulta;
    @JoinColumn(name = "idfuncao", referencedColumnName = "idfuncao")
    @ManyToOne(optional = false)
    private Funcao idfuncao;
    @JoinColumn(name = "idfuncionario", referencedColumnName = "idfuncionario")
    @ManyToOne(optional = false)
    private Funcionario idfuncionario;

    public ListagemFuncao() {
    }

    public ListagemFuncao(Integer idlistagemFuncao) {
        this.idlistagemFuncao = idlistagemFuncao;
    }

    public Integer getIdlistagemFuncao() {
        return idlistagemFuncao;
    }

    public void setIdlistagemFuncao(Integer idlistagemFuncao) {
        this.idlistagemFuncao = idlistagemFuncao;
    }

    public String getValorConsulta() {
        return valorConsulta;
    }

    public void setValorConsulta(String valorConsulta) {
        this.valorConsulta = valorConsulta;
    }

    public Funcao getIdfuncao() {
        return idfuncao;
    }

    public void setIdfuncao(Funcao idfuncao) {
        this.idfuncao = idfuncao;
    }

    public Funcionario getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(Funcionario idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlistagemFuncao != null ? idlistagemFuncao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListagemFuncao)) {
            return false;
        }
        ListagemFuncao other = (ListagemFuncao) object;
        if ((this.idlistagemFuncao == null && other.idlistagemFuncao != null) || (this.idlistagemFuncao != null && !this.idlistagemFuncao.equals(other.idlistagemFuncao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "negocio.ListagemFuncao[ idlistagemFuncao=" + idlistagemFuncao + " ]";
    }
    
}
