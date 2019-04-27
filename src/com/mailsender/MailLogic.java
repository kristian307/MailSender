package com.mailsender;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailLogic {

    private String  username;
    private String  password;

    private Properties props;

    public void setProperties(String SMTPServer, int SMTPPort, boolean startTLSEnabled, boolean SMTPAuth) {
        props = new Properties();
        props.put("mail.smtp.auth", SMTPAuth);
        props.put("mail.smtp.starttls.enable", startTLSEnabled);
        props.put("mail.smtp.host", SMTPServer);
        props.put("mail.smtp.port", SMTPPort);
        props.put("mail.debug", "true");
    }

    public void setUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void sendEmail(String sendTo, String subject, String text) {
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);

            Address from = new InternetAddress(username);
            Address to   = new InternetAddress(sendTo);

            message.setFrom(from);
            message.setRecipient(Message.RecipientType.TO, to);
            message.setSubject(subject);
            message.setText(text);

            Transport.send(message);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
