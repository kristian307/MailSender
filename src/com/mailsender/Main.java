package com.mailsender;

public class Main {

    public static void main(String[] args) {
        MailLogic mailLogic = new MailLogic();

        MailUser user = new MailUser("", "");

        mailLogic.setConnection(user);
        mailLogic.sendEmail("sam.distortion@gmail.com", "SSSUBJECT", "another test");
    }
}
