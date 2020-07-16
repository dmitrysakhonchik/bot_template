package by.sakhonchik.bot.handlers;

import by.sakhonchik.bot.services.CityServiceImpl;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class ResCityInfoBot extends TelegramLongPollingBot {

    private final CityServiceImpl cityService;

    @Autowired
    public ResCityInfoBot(CityServiceImpl cityService) {
        this.cityService = cityService;
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message messageFromUser = update.getMessage();
        if (doesTheCityExist(messageFromUser))
            sendInfoAboutCity(messageFromUser);
        else
            greeting(messageFromUser);
    }

    @SneakyThrows
    public void greeting(Message messageFromUser) {
        String greeting = String.format(
                "Привет, %s!\nСобираешься посетить какой-то город? Напиши мне его название," +
                        " и я посоветую, куда тебе заглянуть :) ", messageFromUser.getFrom().getFirstName());

        SendMessage messageForUser = new SendMessage();
        messageForUser.setChatId(messageFromUser.getChatId());
        messageForUser.setText(greeting);
        execute(messageForUser);
    }

    @SneakyThrows
    public void sendInfoAboutCity(Message messageFromUser) {
        String info = cityService.getInfoAboutCity(messageFromUser.getText());
        SendMessage messageForUser = new SendMessage();
        messageForUser.setChatId(messageFromUser.getChatId());
        messageForUser.setText(info);
        execute(messageForUser);
    }

    public boolean doesTheCityExist(Message messageFromUser) {
        return cityService.isExist(messageFromUser.getText());
    }


    @Override
    public String getBotUsername() {
        return "ResCityBot";
    }

    @Override
    public String getBotToken() {
        return "1306205345:AAHo1BgyqLMSNaWU4xzquFwM1oaGQQIYStI";
    }
}
