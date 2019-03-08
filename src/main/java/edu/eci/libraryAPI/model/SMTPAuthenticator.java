package edu.eci.libraryAPI.model;


import javax.mail.PasswordAuthentication;

public class SMTPAuthenticator extends javax.mail.Authenticator {
		
	 	private static final String SMTP_AUTH_USER = "CrkJohn";
	    private static final String SMTP_AUTH_PWD = "Beverages1";
	
		public SMTPAuthenticator() {
			
		}
	
	
    	public PasswordAuthentication getPasswordAuthentication() {
    		String username = SMTP_AUTH_USER;
    		String password = SMTP_AUTH_PWD;
    		return new PasswordAuthentication(username, password);
    	}
}