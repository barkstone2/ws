package email.model.dto;

public class EmailDTO {
	private String fromName;
	private String fromEmail;
	private String[] toEmails;
	private String subject;
	private String content;
	
	public EmailDTO() {
	}

	public EmailDTO(String fromName, String fromEmail, String[] toEmails, String subject, String content) {
		super();
		this.fromName = fromName;
		this.fromEmail = fromEmail;
		this.toEmails = toEmails;
		this.subject = subject;
		this.content = content;
	}

	public String getFromName() {
		return fromName;
	}

	public void setFromName(String fromName) {
		this.fromName = fromName;
	}

	public String getFromEmail() {
		return fromEmail;
	}

	public void setFromEmail(String fromEmail) {
		this.fromEmail = fromEmail;
	}

	public String[] getToEmails() {
		return toEmails;
	}

	public void setToEmail(String[] toEmails) {
		this.toEmails = toEmails;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
	
	
}
