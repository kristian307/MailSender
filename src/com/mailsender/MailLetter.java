package com.mailsender;

public class MailLetter {
    private String subject;
    private String text;
    private MailUser emailSender;
    private String emailRecipient;

    public MailLetter(String subject, String text, MailUser emailSender, String emailRecipient) {
        this.subject = subject;
        this.text = text;
        this.emailSender = emailSender;
        this.emailRecipient = emailRecipient;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public MailUser getEmailSender() {
        return emailSender;
    }

    public void setEmailSender(MailUser emailSender) {
        this.emailSender = emailSender;
    }

    public String getEmailRecipient() {
        return emailRecipient;
    }

    public void setEmailRecipient(String emailRecipient) {
        this.emailRecipient = emailRecipient;
    }
}
