/**********************************************************************************
 * Contact class sends an email to user when the user creates an account.
 *********************************************************************************/
package ca.simpleweb.mvc.helpers;

import java.util.Properties;

import javax.mail.internet.*;
import javax.mail.*;

public class Contact {
	public void sendEmail(String sendTo, String subject, String emailBody) {
		String user = "team.eagleeyed@gmail.com";
		String password = "eagleeyed3095";
 
		// sets SMTP server properties
		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");

		Session session = Session.getInstance(properties,new javax.mail.Authenticator()
		{
			protected PasswordAuthentication getPasswordAuthentication() 
			{
				return new PasswordAuthentication(user, password);
			}
		});

		try {
			// Create an instance of MimeMessage which accepts MIME types 
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(sendTo));
			message.setSubject(subject);
			message.setContent(emailBody,"text/html");

			// sends the e-mail
			Transport.send(message);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
