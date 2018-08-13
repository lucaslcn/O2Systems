/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

/**
 *
 * @author XorNOTE
 */
public interface BasicScreen {
    
    /**
     * Usado para preencher os campos na tela de acordo com o conteudo da classe.
     */
    public void preencher();
    
    /**
     * Usado para limpar os campos da tela, deixando-os vazios.
     */
    public void limpar();
    
    /**
     * Usado para pegar todos os dados dos campos em tela e inseri-los em suas respectivas classes.
     */
    public void popular();
    
    /**
     * Usado para ativar/desativar botões em tela se a situação for Criar Novo Cadastro.
     */
    public void situacaoNovo();
    
    /**
     * Usado para ativar/desativar botões em tela se a situação for editar Cadastro.
     */
    public void situacaoEditar();
    
     /**
     * Usado para ativar/desativar botões em tela se a situação for Visualizacao.
     */
    public void situacaoVisualizacao();
    
    /**
     * Usado para aplicar o controle de permissao.
     */
    public void permissao();
    
}
