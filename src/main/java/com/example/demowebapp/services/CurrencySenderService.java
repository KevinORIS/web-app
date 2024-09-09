package com.example.demowebapp.services;

import com.example.demowebapp.HTMLTableBuilder;
import com.example.demowebapp.XMLCurrencyParser;
import com.example.demowebapp.dao.UserDAO;
import com.example.demowebapp.dao.UserDAOImpl;
import com.example.demowebapp.model.User;
import com.example.demowebapp.services.quartz.CreateQuartzJob;
import com.example.demowebapp.utils.MailUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.logging.Logger;

public class CurrencySenderService {



    public static void sendCurrencies(final Set<User> users) {

        HTMLTableBuilder currencies = new HTMLTableBuilder("Currencies", true, 3, 3, 10, 10, 10);
        currencies.addTableHeader("#", "ID", "Rate");
        currencies.addRowValues("1", "USD", com.example.demowebapp.XMLCurrencyParser.getCurrency("840"));
        currencies.addRowValues("2", "EUR", com.example.demowebapp.XMLCurrencyParser.getCurrency("978"));
        currencies.addRowValues("3", "RUB (100)", XMLCurrencyParser.getCurrency("643"));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
        String date = simpleDateFormat.format(new Date());

        users.forEach(user -> {
            MailUtils.sendHtmlMail(user.getEmail(),
                    "Today's Currencies. " + date, currencies.build(), null, null);
        });
    }
}
