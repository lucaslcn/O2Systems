/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.swing.JTable;

/**
 *
 * @author XorNOTE
 */
public interface IDAO_T <T> {
    public void preencherTabelaBusca(JTable tabela, String criterio);
}
