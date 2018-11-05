/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gema;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author elias
 */
public class XML {

    public static void GeraXML(String codigo, String paciente, String triagem, String atendimento) throws ParserConfigurationException, TransformerConfigurationException, TransformerException {

        try {
            DocumentBuilderFactory documentoBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentoBuilderFactory.newDocumentBuilder();

            Document documentoXML = documentBuilder.newDocument();

            Element root = documentoXML.createElement("root");
            documentoXML.appendChild(root);

            
            Element prontuario = documentoXML.createElement("prontuario");
            Attr id = documentoXML.createAttribute("codigo");
            id.setValue(codigo);
            
            prontuario.setAttributeNode(id);
            root.appendChild(prontuario);
            
             Element codig = documentoXML.createElement("codigo");
            codig.appendChild(documentoXML.createTextNode(codigo));
            prontuario.appendChild(codig);

            Element pacient = documentoXML.createElement("paciente");
            pacient.appendChild(documentoXML.createTextNode(paciente));
            prontuario.appendChild(pacient);

            Element triage = documentoXML.createElement("triagem");
            triage.appendChild(documentoXML.createTextNode(triagem));
            prontuario.appendChild(triage);

            Element atendiment = documentoXML.createElement("atendimento");
            atendiment.appendChild(documentoXML.createTextNode(atendimento));
            prontuario.appendChild(atendiment);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            DOMSource documentoFonte = new DOMSource(documentoXML);

            StreamResult documentoFinal = new StreamResult(new File(paciente + ".xml"));

            transformer.transform(documentoFonte, documentoFinal);

        } catch (ParserConfigurationException ex) {

        }
    }

}
