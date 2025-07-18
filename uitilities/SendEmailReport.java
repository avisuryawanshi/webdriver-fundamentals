package testng.email;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import jakarta.activation.DataHandler;
import jakarta.activation.FileDataSource;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

public class SendEmailReport {

	public static void main(String[] args) throws IOException {

// Sender's email credentials (Use App Password for Gmail)
// ----------------------------------------------------------------------------------
		final String fromEmail = "avisurya291193@gmail.com"; // your Gmail
		final String password = "wisw dxiu hnrv mudi"; // Gmail App Password

// ---- Recipient's email ID
		final String toEmail = "avisurya291193@gmail.com";

// Setting up mail server properties for Gmail SMTP
// ----------------------------------------------------------------------------------
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");   // SMTP Host
		props.put("mail.smtp.port", "587");              // TLS Port
		props.put("mail.smtp.auth", "true");             // Enable authentication
		props.put("mail.smtp.starttls.enable", "true");  // Enable STARTTLS

// ---- Create the session with Authentication -----------------------------------------
		
		Session session = Session.getInstance(props, new jakarta.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		});
		// Enable session debugging (optional)
		session.setDebug(true);
// ----------------------------------------------------------------------------------
		try {
			System.out.println("Preparing the email message...");
			
			// Creating a MimeMessage object
			Message message = new MimeMessage(session);

			// Setting From, To, and Subject fields
			message.setFrom(new InternetAddress(fromEmail));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
			message.setSubject("Automation Test Report - HTML Report");
			
			// Creating body part for email message text
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("Hello,\n\nPlease find the attached test report.\n\nRegards,\nQA Team");
            
            // Creating body part for attachment
            MimeBodyPart attachmentPart = new MimeBodyPart();
            String filePath = System.getProperty("user.dir") + "/reports/MyReport.html";
            System.out.println("Attachment path is: " + filePath);

            File file = new File(filePath);
            if (!file.exists()) {
                System.out.println("Report file not found at: " + filePath);
                return;
            }

            FileDataSource source = new FileDataSource(file);
            attachmentPart.setDataHandler(new DataHandler(source));
            attachmentPart.setFileName(file.getName());

            // Creating multipart and adding both parts
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(attachmentPart);

            // Setting the content of the message
            message.setContent(multipart);

            // Sending the email
            Transport.send(message);
            System.out.println("✅ Email Sent Successfully with HTML report attached!");

        } catch (MessagingException e) {
            System.out.println("❌ Failed to send the email.");
            e.printStackTrace();
        }
    }

}
