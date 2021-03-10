package email.service;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import email.model.dto.EmailDTO;

public class EmailService {

	public void mailSender(EmailDTO dto) throws UnsupportedEncodingException, MessagingException {
		String host = "smtp.gmail.com";
		String username = "";
		String password = "";
		int port = 587;
		
		String fromName = dto.getFromName();
		String fromEmail = dto.getFromEmail();
		String[] toEmails = dto.getToEmails();
		String subject = dto.getSubject();
		String content = dto.getContent();
		
		Properties props = System.getProperties(); 
		
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth" , "true");
		
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.post", port);
		props.put("mail.transport.protocol", "smtp");
		
		Session session = Session.getInstance(props, new Authenticator() {
			String un = username;
			String pw = password;
			
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(un, pw);
			}
		});
		session.setDebug(true);
		Message mimeMessage = new MimeMessage(session);
		
		mimeMessage.addFrom(new InternetAddress[] {
				new InternetAddress(fromEmail, fromName)
		});
		
		InternetAddress[] toAddr = new InternetAddress[toEmails.length];
		for(int i=0; i<toEmails.length; i++) {
			toAddr[i] = new InternetAddress(toEmails[i]);
		}

		//수신자 .TO .CC(참조) .BCC(숨은참조)
		mimeMessage.setRecipients(Message.RecipientType.TO, toAddr);
		//mimeMessage.setRecipient(Message.RecipientType.CC, new InternetAddress(toEmail));
		//mimeMessage.setRecipient(Message.RecipientType.BCC, new InternetAddress(toEmail));
		mimeMessage.setSubject(subject);
		mimeMessage.setText(content);
		Transport.send(mimeMessage);
		
	}

}
