/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author XorNOTE
 */
@Entity
@Table(name = "view_auditoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ViewAuditoria.findAll", query = "SELECT v FROM ViewAuditoria v")
    , @NamedQuery(name = "ViewAuditoria.findByUsu\u00e1rio", query = "SELECT v FROM ViewAuditoria v WHERE v.usu\u00e1rio = :usu\u00e1rio")
    , @NamedQuery(name = "ViewAuditoria.findByInforma\u00e7\u00e3oAntiga", query = "SELECT v FROM ViewAuditoria v WHERE v.informa\u00e7\u00e3oAntiga = :informa\u00e7\u00e3oAntiga")
    , @NamedQuery(name = "ViewAuditoria.findByInforma\u00e7\u00e3oNova", query = "SELECT v FROM ViewAuditoria v WHERE v.informa\u00e7\u00e3oNova = :informa\u00e7\u00e3oNova")
    , @NamedQuery(name = "ViewAuditoria.findByLocalOpera\u00e7\u00e3o", query = "SELECT v FROM ViewAuditoria v WHERE v.localOpera\u00e7\u00e3o = :localOpera\u00e7\u00e3o")
    , @NamedQuery(name = "ViewAuditoria.findByTipoA\u00e7\u00e3o", query = "SELECT v FROM ViewAuditoria v WHERE v.tipoA\u00e7\u00e3o = :tipoA\u00e7\u00e3o")
    , @NamedQuery(name = "ViewAuditoria.findByDataOpera\u00e7\u00e3o", query = "SELECT v FROM ViewAuditoria v WHERE v.dataOpera\u00e7\u00e3o = :dataOpera\u00e7\u00e3o")
    , @NamedQuery(name = "ViewAuditoria.findByHoraOpera\u00e7\u00e3o", query = "SELECT v FROM ViewAuditoria v WHERE v.horaOpera\u00e7\u00e3o = :horaOpera\u00e7\u00e3o")})
public class ViewAuditoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "usu\u00e1rio")
    private String usuário;
    @Column(name = "informa\u00e7\u00e3o_antiga")
    private String informaçãoAntiga;
    @Column(name = "informa\u00e7\u00e3o_nova")
    private String informaçãoNova;
    @Column(name = "local_opera\u00e7\u00e3o")
    private String localOperação;
    @Column(name = "tipo_a\u00e7\u00e3o")
    private String tipoAção;
    @Column(name = "data_opera\u00e7\u00e3o")
    @Temporal(TemporalType.DATE)
    private Date dataOperação;
    @Column(name = "hora_opera\u00e7\u00e3o")
    @Temporal(TemporalType.TIME)
    private Date horaOperação;

    public ViewAuditoria() {
    }

    public String getUsuário() {
        return usuário;
    }

    public void setUsuário(String usuário) {
        this.usuário = usuário;
    }

    public String getInformaçãoAntiga() {
        return informaçãoAntiga;
    }

    public void setInformaçãoAntiga(String informaçãoAntiga) {
        this.informaçãoAntiga = informaçãoAntiga;
    }

    public String getInformaçãoNova() {
        return informaçãoNova;
    }

    public void setInformaçãoNova(String informaçãoNova) {
        this.informaçãoNova = informaçãoNova;
    }

    public String getLocalOperação() {
        return localOperação;
    }

    public void setLocalOperação(String localOperação) {
        this.localOperação = localOperação;
    }

    public String getTipoAção() {
        return tipoAção;
    }

    public void setTipoAção(String tipoAção) {
        this.tipoAção = tipoAção;
    }

    public Date getDataOperação() {
        return dataOperação;
    }

    public void setDataOperação(Date dataOperação) {
        this.dataOperação = dataOperação;
    }

    public Date getHoraOperação() {
        return horaOperação;
    }

    public void setHoraOperação(Date horaOperação) {
        this.horaOperação = horaOperação;
    }
    
}
