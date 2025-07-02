package utils;

import java.util.Properties;
import jakarta.mail.*;
import jakarta.mail.internet.*;


/**
 *
 * @author Asus
 */

public class EmailUtils {

    public static void sendReistrationEmail(String recipientEmail, String fullName, String password) throws MessagingException {
        final String fromEmail = "";
         final String appPassword = "";  
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, appPassword);
            }
        });
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(fromEmail));
        message.setRecipients(
                Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
        message.setSubject("Registration Confirmation");

    }
}
