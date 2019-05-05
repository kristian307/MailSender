package com.mailsender;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailLogic {

    private MailUser mailUser;

    private MailConnection connection;

    public void setConnection(MailUser user) {
        this.mailUser = user;
        connection = new MailConnection(user);
    }

    public void sendEmail(String sendTo, String subject, String text) {
        Session session = setSession();

        try {

            MailLetter email = new MailLetter(subject, text, mailUser, sendTo);

            Message message = new MimeMessage(session);

            Address from = new InternetAddress(mailUser.getUsername());
            Address to   = new InternetAddress(email.getEmailRecipient());

            message.setFrom(from);
            message.setRecipient(Message.RecipientType.TO, to);
            message.setSubject(email.getSubject());
            message.setText(email.getText());

            Transport.send(message);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // TODO: 05.05.2019 избавиться от этой хрени, перенести в другой класс, возможно, в MailConnection 
    public Session setSession() {
        Session session = Session.getInstance(connection.getProperties(),
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(mailUser.getUsername(), mailUser.getPassword());
                    }
                });

        return session;
    }

}
