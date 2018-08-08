package negocio;
// Generated 08/08/2018 19:55:37 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Remedio generated by hbm2java
 */
public class Remedio  implements java.io.Serializable {


     private int idremedio;
     private String nomeRemedio;
     private Boolean controlado;
     private Set<ListagemRemedios> listagemRemedioses = new HashSet<ListagemRemedios>(0);

    public Remedio() {
    }

	
    public Remedio(int idremedio, String nomeRemedio) {
        this.idremedio = idremedio;
        this.nomeRemedio = nomeRemedio;
    }
    public Remedio(int idremedio, String nomeRemedio, Boolean controlado, Set<ListagemRemedios> listagemRemedioses) {
       this.idremedio = idremedio;
       this.nomeRemedio = nomeRemedio;
       this.controlado = controlado;
       this.listagemRemedioses = listagemRemedioses;
    }
   
    public int getIdremedio() {
        return this.idremedio;
    }
    
    public void setIdremedio(int idremedio) {
        this.idremedio = idremedio;
    }
    public String getNomeRemedio() {
        return this.nomeRemedio;
    }
    
    public void setNomeRemedio(String nomeRemedio) {
        this.nomeRemedio = nomeRemedio;
    }
    public Boolean getControlado() {
        return this.controlado;
    }
    
    public void setControlado(Boolean controlado) {
        this.controlado = controlado;
    }
    public Set<ListagemRemedios> getListagemRemedioses() {
        return this.listagemRemedioses;
    }
    
    public void setListagemRemedioses(Set<ListagemRemedios> listagemRemedioses) {
        this.listagemRemedioses = listagemRemedioses;
    }




}

