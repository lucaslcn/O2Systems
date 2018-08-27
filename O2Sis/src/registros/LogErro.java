package registros;

import dao.LogDAO;
import negocio.Log;

/**
 * @author XorNOTE
 */
public class LogErro {
    Log log;
    public LogErro(Log log) { this.log = log; }
    
    public String registrarErro(){ return new LogDAO().insert(log); }
}