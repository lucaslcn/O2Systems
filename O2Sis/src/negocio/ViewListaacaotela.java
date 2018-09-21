/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author XorNOTE
 */
@Entity
@Table(name = "view_listaacaotela")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ViewListaacaotela.findAll", query = "SELECT v FROM ViewListaacaotela v")
    , @NamedQuery(name = "ViewListaacaotela.findByCodigo", query = "SELECT v FROM ViewListaacaotela v WHERE v.codigo = :codigo")
    , @NamedQuery(name = "ViewListaacaotela.findByIdtela", query = "SELECT v FROM ViewListaacaotela v WHERE v.idtela = :idtela")
    , @NamedQuery(name = "ViewListaacaotela.findByNomeTela", query = "SELECT v FROM ViewListaacaotela v WHERE v.nomeTela = :nomeTela")
    , @NamedQuery(name = "ViewListaacaotela.findByIdacaotela", query = "SELECT v FROM ViewListaacaotela v WHERE v.idacaotela = :idacaotela")
    , @NamedQuery(name = "ViewListaacaotela.findByNomeAcao", query = "SELECT v FROM ViewListaacaotela v WHERE v.nomeAcao = :nomeAcao")})
public class ViewListaacaotela implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "codigo")
    private Integer codigo;
    @Column(name = "idtela")
    private Integer idtela;
    @Column(name = "nome_tela")
    private String nomeTela;
    @Column(name = "idacaotela")
    private Integer idacaotela;
    @Column(name = "nome_acao")
    private String nomeAcao;

    public ViewListaacaotela() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getIdtela() {
        return idtela;
    }

    public void setIdtela(Integer idtela) {
        this.idtela = idtela;
    }

    public String getNomeTela() {
        return nomeTela;
    }

    public void setNomeTela(String nomeTela) {
        this.nomeTela = nomeTela;
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
    
}
