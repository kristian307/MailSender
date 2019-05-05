package com.mailsender;

public class MailUser {

    private String username;
    private String password;

    private String SMTPServer;
    private int SMTPPort;

    public MailUser(String username, String password) {
        this.username = username;
        this.password = password;

        setSMTPServer();
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSMTPServer() {
        return SMTPServer;
    }

    // TODO: стоит сделать map SMTP-серверов
    public void setSMTPServer() {
        SMTPPort = 587;

        if (username.endsWith("gmail.com"))
            SMTPServer = "smtp.gmail.com";
    }

    public int getSMTPPort() {
        return SMTPPort;
    }

}
