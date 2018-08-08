package negocio;
// Generated 08/08/2018 19:55:37 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * AgendamentoExames generated by hbm2java
 */
public class AgendamentoExames  implements java.io.Serializable {


     private int idagendamentoExames;
     private Exames exames;
     private FormaPagamento formaPagamento;
     private Paciente paciente;
     private Plano plano;
     private Date dataExame;
     private Date horaExame;
     private Date dataEntrega;

    public AgendamentoExames() {
    }

	
    public AgendamentoExames(int idagendamentoExames, Exames exames, FormaPagamento formaPagamento, Paciente paciente, Plano plano, Date dataExame, Date horaExame) {
        this.idagendamentoExames = idagendamentoExames;
        this.exames = exames;
        this.formaPagamento = formaPagamento;
        this.paciente = paciente;
        this.plano = plano;
        this.dataExame = dataExame;
        this.horaExame = horaExame;
    }
    public AgendamentoExames(int idagendamentoExames, Exames exames, FormaPagamento formaPagamento, Paciente paciente, Plano plano, Date dataExame, Date horaExame, Date dataEntrega) {
       this.idagendamentoExames = idagendamentoExames;
       this.exames = exames;
       this.formaPagamento = formaPagamento;
       this.paciente = paciente;
       this.plano = plano;
       this.dataExame = dataExame;
       this.horaExame = horaExame;
       this.dataEntrega = dataEntrega;
    }
   
    public int getIdagendamentoExames() {
        return this.idagendamentoExames;
    }
    
    public void setIdagendamentoExames(int idagendamentoExames) {
        this.idagendamentoExames = idagendamentoExames;
    }
    public Exames getExames() {
        return this.exames;
    }
    
    public void setExames(Exames exames) {
        this.exames = exames;
    }
    public FormaPagamento getFormaPagamento() {
        return this.formaPagamento;
    }
    
    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
    public Paciente getPaciente() {
        return this.paciente;
    }
    
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    public Plano getPlano() {
        return this.plano;
    }
    
    public void setPlano(Plano plano) {
        this.plano = plano;
    }
    public Date getDataExame() {
        return this.dataExame;
    }
    
    public void setDataExame(Date dataExame) {
        this.dataExame = dataExame;
    }
    public Date getHoraExame() {
        return this.horaExame;
    }
    
    public void setHoraExame(Date horaExame) {
        this.horaExame = horaExame;
    }
    public Date getDataEntrega() {
        return this.dataEntrega;
    }
    
    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }




}

