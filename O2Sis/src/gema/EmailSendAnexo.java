/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * https://www.google.com/settings/security/lesssecureapps
 */

package gema;


/**
 *
 * @author Naveen
 */
import java.io.File;
import java.util.*;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
public class EmailSendAnexo {
    
    public static void SendEmail(String remetente, String destinatario, String titulo, String mensagem, File[] anexo) {
        
        try {

            //usuario e senha do seu gmail
            final String usuario = "o2sys.contato@gmail.com";
            final String senha = "marina2018b";

            //config. do gmail
            Properties mailProps = new Properties();
            mailProps.put("mail.transport.protocol", "smtp");
            mailProps.put("mail.smtp.starttls.enable", "true");
            mailProps.put("mail.smtp.host", "smtp.gmail.com");
            mailProps.put("mail.smtp.auth", "true");
            mailProps.put("mail.smtp.user", usuario);
            mailProps.put("mail.debug", "true");
            mailProps.put("mail.smtp.port", "465");
            mailProps.put("mail.smtp.socketFactory.port", "465");
            mailProps.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            mailProps.put("mail.smtp.socketFactory.fallback", "false");

            //eh necessario autenticar
            Session mailSession = Session.getInstance(mailProps, new Authenticator() {

                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(usuario, senha);
                }
            });
            mailSession.setDebug(false);

            //config. da mensagem
            Message mailMessage = new MimeMessage(mailSession);

            //remetente
            mailMessage.setFrom(new InternetAddress("o2sys.contato@gmail.com", remetente));

            //destinatario
            mailMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));

            //mensagem que vai no corpo do email
            MimeBodyPart mbpMensagem = new MimeBodyPart();
            mbpMensagem.setText(mensagem);

//			partes do email
            Multipart mp = new MimeMultipart();
            mp.addBodyPart(mbpMensagem);
            
            String Endereco_Anexo = "";
            if (anexo != null) { // se tiver alguma coisa anexada ela inicializar o comando abaixo
                for (File element : anexo) {

                    Endereco_Anexo = element.getPath();
                    String imagem = Endereco_Anexo;
                    File Arquivo = new File(imagem);
                    //setando o anexo
                    MimeBodyPart mbpAnexo = new MimeBodyPart();
                    mbpAnexo.setDataHandler(new DataHandler(new FileDataSource(Arquivo)));
                    mbpAnexo.setFileName(Arquivo.getName());
                    mp.addBodyPart(mbpAnexo);
                }
            }

            //assunto do email
            mailMessage.setSubject(titulo);

            //seleciona o conteudo 
            mailMessage.setContent(mp);

            //envia o email
            Transport.send(mailMessage);
            JOptionPane.showMessageDialog(null, "Email Enviado com Sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Houve um erro no Envio !\n"+e);
        }
    }
}
