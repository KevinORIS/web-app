package com.example.demowebapp.utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmailTLS {

    public static void main(String[] args) {

      MailUtils.sendHtmlMail("j1023john@gmail.com",
              "HTML", "<b>TEXT</b>", null, null);
    }

}
