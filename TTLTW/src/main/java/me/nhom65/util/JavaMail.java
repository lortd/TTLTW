package me.nhom65.util;

import java.util.Properties;

public class JavaMail {
	
	
    
	public static Properties getMailProperties() {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        return props;
    }

    public static String getUsername() {
        return ContextServer.get("MAIL_USERNAME");
    }

    public static String getPassword() {
        return ContextServer.get("MAIL_PASSWORD"); 
    }
}
