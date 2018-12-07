/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.swing.JTable;
import negocio.UsuariosVersoes;
import persistencia.DAO;
import persistencia.IDAO_T;

/**
 *
 * @author elias.flach
 */
public class VersoesUsuariosDAO extends DAO implements IDAO_T<UsuariosVersoes>{

    @Override
    public void preencherTabelaBusca(JTable tabela, String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UsuariosVersoes consultarId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
