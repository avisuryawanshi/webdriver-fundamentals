package testng.email;

import java.io.File;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendEmailReport {

    public static void sendReport() {
        
    	final String fromEmail = "your-email@gmail.com";        // 🔁 Update this
        final String password = "your-app-password";            // 🔁 Use App Password if 2FA is enabled
        final String toEmail = "recipient@example.com";         // 🔁 Update recipient

        // SMTP configuration
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");  // Gmail SMTP host
        props.put("mail.smtp.port", "587");              // TLS port
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");  // Enable TLS

        // Authentication
        Authenticator auth = new Authenticator() 
        {
            protected PasswordAuthentication getPasswordAuthentication() 
            {
                return new PasswordAuthentication(fromEmail, password);
            }
        };

        Session session = Session.getInstance(props, auth);

        try {
            // Compose the message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail, "Automation Report"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("📌 Automation Test Execution Report");

            // Email body
            MimeBodyPart bodyPart = new MimeBodyPart();
            bodyPart.setText("Hi Team,\n\nPlease find the attached automation execution report.\n\nThanks,\nQA Automation");

            // Attach the report
            MimeBodyPart attachment = new MimeBodyPart();
            String filePath = System.getProperty("user.dir") + "/reports/ExtentReport.html";
            File file = new File(filePath);
            
            if (!file.exists()) {
                System.out.println("[ERROR] Report file not found at: " + filePath);
                return;
            }

            attachment.attachFile(file);
            attachment.setFileName("ExtentReport.html");

            // Combine parts
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(bodyPart);
            multipart.addBodyPart(attachment);
            message.setContent(multipart);

            // Send email
            Transport.send(message);
            System.out.println("[INFO] Email sent successfully with report attachment!");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("[ERROR] Failed to send report via email: " + e.getMessage());
        }
    }
}
