package com.mailsender;

import java.util.Properties;

public class MailConnection {

    private Properties properties;

    private String SMTPServer;
    private int SMTPPort;
    private boolean startTLSEnabled;
    private boolean SMTPAuth;

    public MailConnection(MailUser user) {
        startTLSEnabled = true;
        SMTPAuth = true;
        SMTPServer = user.getSMTPServer();
        SMTPPort = user.getSMTPPort();

        setProperties();
    }

    public MailConnection(String SMTPServer, int SMTPPort, boolean startTLSEnabled, boolean SMTPAuth) {
        this.SMTPServer = SMTPServer;
        this.SMTPPort = SMTPPort;
        this.startTLSEnabled = startTLSEnabled;
        this.SMTPAuth = SMTPAuth;

        setProperties();
    }

    private void setProperties()
    {
        properties = new Properties();
        properties.put("mail.smtp.auth", SMTPAuth);
        properties.put("mail.smtp.starttls.enable", startTLSEnabled);
        properties.put("mail.smtp.host", SMTPServer);
        properties.put("mail.smtp.port", SMTPPort);
        properties.put("mail.debug", "true");
    }

    public Properties getProperties() {
        return properties;
    }

}
