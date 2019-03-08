package edu.eci.libraryAPI.model;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class MyEmailer {

	private static final String SMTP_HOST_NAME = "smtp.sendgrid.net";
	private static final String SMTP_AUTH_USER = "CrkJohn";
    private static final String SMTP_AUTH_PWD = "Beverages17";


	public void sendMessage() throws MessagingException {
		Properties properties = new Properties();
		properties.put("mail.transport.protocol", "smtp");
		properties.put("mail.smtp.host", SMTP_HOST_NAME);
		properties.put("mail.smtp.port", 587);
		properties.put("mail.smtp.auth", "true");
		Authenticator auth = new SMTPAuthenticator();
		Session mailSession = Session.getDefaultInstance(properties, auth);
		MimeMessage message = new MimeMessage(mailSession);
		Multipart multipart = new MimeMultipart("alternative");
		BodyPart part1 = new MimeBodyPart();
		part1.setText("Hola, tu libro ha sido publicado correctamente");
		BodyPart part2 = new MimeBodyPart();
		part2.setContent("<p>Buenas noches </p>" + "<p></p>" + "<p>El libro de ha agregado.</p>" + "<p>Gracias</p>"
				+ "<p>John David Ibañez</p>" + "<p>Estudiante de ingenieria</p>", "text/html");
		multipart.addBodyPart(part1);
		multipart.addBodyPart(part2);
		message.setFrom(new InternetAddress("john.ibanez@mail.escuelaing.edu.co"));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress("jhonhrge@gmail.com"));
		message.setSubject("Solicitud hecha");
		message.setContent(multipart);
		Transport transport = mailSession.getTransport();
		transport.connect();
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();
	}

	private class SMTPAuthenticator extends javax.mail.Authenticator {
		public PasswordAuthentication getPasswordAuthentication() {
			String username = SMTP_AUTH_USER;
			String password = SMTP_AUTH_PWD;
			return new PasswordAuthentication(username, password);
		}
	}

}
