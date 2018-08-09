package dao;

import javax.swing.JTable;
import negocio.Pessoa;
import persistencia.IDAO_T;

/**
 *
 * @author elias.flach
 */
public class PlanoDAO implements IDAO_T<Pessoa>{

    @Override
    public void preencherTabelaBusca(JTable tabela, String criterio) {
    
    }

    @Override
    public Pessoa consultarId(int id) {
        return new Pessoa();
    }

}
