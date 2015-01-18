package com.Utilities;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailingHelper {

	private static final String HOST = "smtp.gmail.com";
	private static final String CREDENTIALS_USER = "sic.grupo5@gmail.com";
	private static final String CREDENTIALS_PSSWD = "123456_78";
	private Session _session; 
	
	public MailingHelper(){
	        Properties props = System.getProperties();
	      
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.host", HOST);
	        props.put("mail.smtp.user", CREDENTIALS_USER);
	        props.put("mail.smtp.password", CREDENTIALS_PSSWD);
	        props.put("mail.smtp.port", "587");
	        props.put("mail.smtp.auth", "true");
	        
	      _session = Session.getDefaultInstance(props);
	}
	
	public boolean SendSimpleEmail(String from, List<String> to, String subject, String body){

		try {
		
			 MimeMessage message = new MimeMessage(_session);
			 message.setFrom(new InternetAddress(from));
			 
			 Address[] listAdd = new Address[to.size()];
			 for (int i = 0; i < to.size(); i++) {
				listAdd[i] = new InternetAddress(to.get(i));
			 }
			
			 message.addRecipients(Message.RecipientType.TO, listAdd);
			 
			 message.setText(body);
			 message.setSubject(subject);
			 
			 Transport transport = _session.getTransport("smtp");
	         transport.connect(HOST, CREDENTIALS_USER, CREDENTIALS_PSSWD);
	         transport.sendMessage(message, message.getAllRecipients());
	         transport.close();
	            
			// Transport.send(message);
			 return true;
		}
		catch (MessagingException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean SendHtmlEmail(String from, List<String> to, String subject, String body){
		try {
			
			 MimeMessage message = new MimeMessage(_session);
			 message.setFrom(new InternetAddress(from));
			 
			 Address[] listAdd = new Address[to.size()];
			 for (int i = 0; i < to.size(); i++) {
				listAdd[i] = new InternetAddress(to.get(i));
			 }
			
			 message.addRecipients(Message.RecipientType.TO, listAdd);
			 
			 message.setContent(body,  "text/html");
			 message.setSubject(subject);
			 //Transport.send(message);
			 Transport transport = _session.getTransport("smtp");
	         transport.connect(HOST, CREDENTIALS_USER, CREDENTIALS_PSSWD);
	         transport.sendMessage(message, message.getAllRecipients());
	         transport.close();
			 return true;
		}
		catch (MessagingException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	public boolean SendAttachmentEmail(String from, List<String> to, String subject, String body, List<String> attachObj){
		try {
			
			 MimeMessage message = new MimeMessage(_session);
			 message.setFrom(new InternetAddress(from));
			 
			 Address[] listAdd = new Address[to.size()];
			 for (int i = 0; i < to.size(); i++) {
				listAdd[i] = new InternetAddress(to.get(i));
			 }
			
			 message.addRecipients(Message.RecipientType.TO, listAdd);
			
			 message.setSubject(subject);
	         BodyPart messageBodyPart = new MimeBodyPart();
	         messageBodyPart.setContent(body,  "text/html");
	         Multipart multipart = new MimeMultipart();
	         multipart.addBodyPart(messageBodyPart);
	         
	         for (String attFile : attachObj) {
	        	 messageBodyPart = new MimeBodyPart();
		         DataSource source = new FileDataSource(attFile);
		         messageBodyPart.setDataHandler(new DataHandler(source));
		         messageBodyPart.setFileName(attFile);
		         multipart.addBodyPart(messageBodyPart);
				
			}
	        
	         message.setContent(multipart );
			
	         Transport transport = _session.getTransport("smtp");
	         transport.connect(HOST, CREDENTIALS_USER, CREDENTIALS_PSSWD);
	         transport.sendMessage(message, message.getAllRecipients());
	         transport.close();
	         
			 return true;
		}
		catch (MessagingException e) {
			e.printStackTrace();
		}
		return false;
	}
}
