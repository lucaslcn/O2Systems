/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.swing.JTable;
import negocio.License;
import persistencia.DAO;
import persistencia.IDAO_T;

/**
 *
 * @author Lucas
 */
public class LicenseDAO extends DAO implements IDAO_T<License>{

    @Override
    public void preencherTabelaBusca(JTable tabela, String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public License consultarId(int id) {
        Object o = this.selectWithJoin("license", "id = " + id).get(0);
        return (License) o;
    }
    
}
