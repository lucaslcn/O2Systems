/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registros;

import dao.AuditoriaDAO;
import java.util.Date;
import negocio.Auditoria;
import negocio.Usuario;

/**
 *
 * @author XorNOTE
 */
public class Atividade {

    private Usuario usuario;

    private String[] informacaoOld;
    private String[] informacaoNew;

    private String onde;
    private String acao;

    private Date dataEhora;

    public Atividade() {
        dataEhora = new Date();
    }

    public Atividade(Usuario usuario, String[] informacaoOld, String[] informacaoNew, String onde, String acao, Date dataEhora) {
        this.usuario = usuario;
        this.informacaoOld = informacaoOld;
        this.informacaoNew = informacaoNew;
        this.onde = onde;
        this.acao = acao;
        this.dataEhora = dataEhora;
    }
    
    public Atividade(Usuario usuario, String[] informacaoOld, String[] informacaoNew, String onde, String acao) {
        this.usuario = usuario;
        this.informacaoOld = informacaoOld;
        this.informacaoNew = informacaoNew;
        this.onde = onde;
        this.acao = acao;
        this.dataEhora =  new Date();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getInformacaoOld() {
        String r = "";
        for (int i = 0; i < this.informacaoOld.length; i++) {
            if ( i != 0){
                r += " | " + this.informacaoOld[i];
            } else {
                r = this.informacaoOld[i];
            }
        }
        return r;
    }

    public void setInformacaoOld(String[] informacaoOld) {
        this.informacaoOld = informacaoOld;
    }

    public String getInformacaoNew() {
        String r = "";
        for (int i = 0; i < this.informacaoNew.length; i++) {
            if ( i != 0){
                r += " | " + this.informacaoNew[i];
            } else {
                r = this.informacaoNew[i];
            }
        }
        return r;
    }

    public void setInformacaoNew(String[] informacaoNew) {
        this.informacaoNew = informacaoNew;
    }

    public String getOnde() {
        return onde;
    }

    public void setOnde(String onde) {
        this.onde = onde;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public Date getDataEhora() {
        return dataEhora;
    }

    public void setDataEhora(Date dataEhora) {
        this.dataEhora = dataEhora;
    }

    public Auditoria registraAtividade(){
        Auditoria a = new Auditoria();
        
        a.setAcao(acao);
        a.setData(dataEhora);
        a.setHora(dataEhora);
        a.setIdusuario(usuario);
        
        if (acao == ACAO_DELETADO){
            a.setInformacaonew("Registro deletado.");
        } else if(acao == ACAO_ARQUIVADO){
            a.setInformacaonew("Registro aquivado.");
        } else {
            a.setInformacaonew(this.getInformacaoNew());
        }
        
        if (acao != ACAO_INSERIDO){
            a.setInformacaoold(this.getInformacaoOld());
        } else {
            a.setInformacaoold("Registro novo.");
        }
        
        a.setOnde(onde);
        
        return a;
    }
    
    //Definição de nome para os locais. Vulgo ONDE.
    final public static String FROM_AUDITORIA = "Auditoria";
    final public static String FROM_ESTADO = "Cadastro Estado";
    final public static String FROM_PLANO = "Cadastro de Plano de Saúde";
    final public static String FROM_REMEDIO = "Cadastro de Remédio";
    final public static String FROM_EXAME = "Cadastro de Exame";
    final public static String FROM_FORMA_PGTO = "Cadastro de Forma de Pagamento";
    final public static String FROM_FUNCAO = "Cadastro de Função";

    //Definição de nome para as ações.
    final public static String ACAO_DELETADO = "Deletado";
    final public static String ACAO_ARQUIVADO = "Arquivado";
    final public static String ACAO_INSERIDO = "Inserido";
    final public static String ACAO_EDITADO = "Editado";
}
