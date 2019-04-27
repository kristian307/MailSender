package com.mailsender;

public class Main {

    public static void main(String[] args) {
        MailLogic mailLogic = new MailLogic();
        mailLogic.setProperties("smtp.gmail.com", 587,true,true);
        mailLogic.setUser("sdikansky96@gmail.com", "super12307");
        mailLogic.sendEmail("sam.distortion@gmail.com", "SSSUBJECT", "another test");
    }
}
