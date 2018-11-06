package gema;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import static javafx.scene.input.KeyCode.T;
import javax.swing.JOptionPane;
import negocio.*;

/* @author Lucas e andesoncaye(XorGamer)*/
public class JSON {
    
    static int contador = 0;

    public static String gerarJSON(Object o, Class valueType) {
        String codeJson = "";
        if (valueType != null) {
            ObjectMapper mapper = new ObjectMapper();
            try {

                if (valueType == AgendamentoExames.class) {
                    AgendamentoExames k = (AgendamentoExames) o;
                    String nome = k.getClass().toString();
                    File json = new File(nome + contador + ".json");
                    String name = nome + contador + ".json";
                    mapper.writeValue(json, k);
                    System.out.println("Java object converted to JSON String, written to file");
                    System.out.println(mapper.writeValueAsString(k));
                    JOptionPane.showMessageDialog(null, "Item " + name + " exportado com sucesso!");
                    contador++;
                } else if (valueType == Consultas.class) {
                    Consultas k = (Consultas) o;
                    String nome = k.getClass().toString();
                    File json = new File(nome + contador + ".json");
                    String name = nome + contador + ".json";
                    mapper.writeValue(json, k);
                    System.out.println("Java object converted to JSON String, written to file");
                    System.out.println(mapper.writeValueAsString(k));
                    JOptionPane.showMessageDialog(null, "Item " + name + " exportado com sucesso!");
                    contador++;
                    
                }

            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
        return codeJson;
    }
}
