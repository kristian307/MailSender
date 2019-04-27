package com.mailsender;

public class Main {

    public static void main(String[] args) {
        MailLogic mailLogic = new MailLogic();

        MailUser user = new MailUser("sdikansky96@gmail.com", "super12307");

        mailLogic.setProperties("smtp.gmail.com", 587,true,true);
        mailLogic.setUser(user);
        mailLogic.sendEmail("sam.distortion@gmail.com", "SSSUBJECT", "another test");
    }
}
