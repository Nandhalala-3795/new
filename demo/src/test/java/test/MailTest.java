package test;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.testng.annotations.Test;

public class MailTest {
	
	@Test
	public void test4() throws EmailException, MessagingException {
		
		  final String username = "mailtestmytest@gmail.com";
	      final String password = "onttuvnvuhxajalg";
	      final String host = "smtp.gmail.com";
	      final String port = "587";
	      final String toAddress="nandhalalal354@gmail.com";
	      
	      Properties properties = new Properties();
	      properties.put("mail.smtp.host", host);
	      properties.put("mail.smtp.port", port);
	      properties.put("mail.smtp.auth", "true");
	      properties.put("mail.smtp.starttls.enable", "true");

	      // creates a new session with an authenticator
	      Authenticator auth = new Authenticator() {
	          public PasswordAuthentication getPasswordAuthentication() {
	              return new PasswordAuthentication(username, password);
	          }
	      };

	      Session session = Session.getInstance(properties, auth);

	      // creates a new e-mail message
	      Message msg = new MimeMessage(session);

	      msg.setFrom(new InternetAddress(username));
	      
		InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
	      msg.setRecipients(Message.RecipientType.TO, toAddresses);
	      msg.setSubject("sub");
	      msg.setSentDate(new Date());
	      // set plain text message
	      msg.setText("test message");
	      System.out.println("message set");

	      // sends the e-mail
	      Transport.send(msg);
	      System.out.println("Mail sent");

	    
	}

	@Test
	public void test5() throws EmailException {
		
		  final String username = "mailtestmytest@gmail.com";
	      final String password = "onttuvnvuhxajalg";

	      Email mail = new SimpleEmail();
	      mail.setSmtpPort(587);
	      mail.setHostName("smtp.gmail.com");
	      
	      System.out.println(mail.getSmtpPort());
	      mail.setSSLOnConnect(true);
	      mail.setAuthenticator(new DefaultAuthenticator(username, password));
	      
	      mail.setFrom(username);
	      System.out.println("from set");
	      mail.setSubject("automation test");
	      mail.addTo("lala.ece.3795@gmail.com");
	      System.out.println("to set");
	      mail.send();
	      System.out.println("Mail sent");
	      
		
	}

	
}
