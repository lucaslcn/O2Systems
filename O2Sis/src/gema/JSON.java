package gema;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import static javafx.scene.input.KeyCode.T;
import negocio.*;

/* @author Lucas e andesoncaye(XorGamer)*/
public class JSON {

    public static String gerarJSON(Object o, Class valueType) {
        String codeJson = "";
        if (valueType != null) {
            ObjectMapper mapper = new ObjectMapper();
            try {
                
                if (valueType == AgendamentoExames.class) {
                    AgendamentoExames k = (AgendamentoExames) o;
                    codeJson = mapper.writeValueAsString(k);
                } else if (valueType == Consultas.class) {
                    Consultas k = (Consultas) o;
                    codeJson = mapper.writeValueAsString(k);
                }
                
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
        return codeJson;
    }
}
