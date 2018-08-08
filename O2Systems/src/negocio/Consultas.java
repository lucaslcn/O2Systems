package negocio;
// Generated 08/08/2018 19:55:37 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Consultas generated by hbm2java
 */
public class Consultas  implements java.io.Serializable {


     private int idconsultas;
     private FormaPagamento formaPagamento;
     private Funcionario funcionario;
     private Paciente paciente;
     private Plano plano;
     private Prontuario prontuario;
     private Date dataConsulta;
     private Date horaConsulta;

    public Consultas() {
    }

    public Consultas(int idconsultas, FormaPagamento formaPagamento, Funcionario funcionario, Paciente paciente, Plano plano, Prontuario prontuario, Date dataConsulta, Date horaConsulta) {
       this.idconsultas = idconsultas;
       this.formaPagamento = formaPagamento;
       this.funcionario = funcionario;
       this.paciente = paciente;
       this.plano = plano;
       this.prontuario = prontuario;
       this.dataConsulta = dataConsulta;
       this.horaConsulta = horaConsulta;
    }
   
    public int getIdconsultas() {
        return this.idconsultas;
    }
    
    public void setIdconsultas(int idconsultas) {
        this.idconsultas = idconsultas;
    }
    public FormaPagamento getFormaPagamento() {
        return this.formaPagamento;
    }
    
    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
    public Funcionario getFuncionario() {
        return this.funcionario;
    }
    
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
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
    public Prontuario getProntuario() {
        return this.prontuario;
    }
    
    public void setProntuario(Prontuario prontuario) {
        this.prontuario = prontuario;
    }
    public Date getDataConsulta() {
        return this.dataConsulta;
    }
    
    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }
    public Date getHoraConsulta() {
        return this.horaConsulta;
    }
    
    public void setHoraConsulta(Date horaConsulta) {
        this.horaConsulta = horaConsulta;
    }




}

