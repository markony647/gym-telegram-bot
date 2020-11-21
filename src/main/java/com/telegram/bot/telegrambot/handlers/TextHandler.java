package com.telegram.bot.telegrambot.handlers;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Arrays;
import java.util.List;

import static com.telegram.bot.telegrambot.util.InlineKeyboardDrawer.getKeyboardMarkup;

@Component
public class TextHandler implements UserInputHandler {

    private Update update;

    @Override
    public SendMessage handle(Update update) {
        this.update = update;
        return determineMessageType();
    }

    private SendMessage determineMessageType() {
        if (userSaidHello()) {
            var greeting = greetMessage();
            greeting.setReplyMarkup(getKeyboardMarkup());
            return greeting;
        }
        return askUserGreetBot();
    }

    @Override
    public String getChatId() {
        return String.valueOf(update.getMessage().getChatId());
    }

    private boolean userSaidHello() {
        String text = update.getMessage().getText().toLowerCase();
        List<String> allowedGreetings = Arrays.asList("hi","привет");
        return update.getMessage().hasText() && allowedGreetings.contains(text);
    }

    private SendMessage greetMessage() {
        SendMessage message = new SendMessage();
        message.setChatId(getChatId());
        message.setText("Вечер в хату, " + update.getMessage().getFrom().getFirstName() + "!\n Выбери тип тренировки");
        return message;
    }

    private SendMessage askUserGreetBot() {
        SendMessage message = new SendMessage();
        message.setChatId(getChatId());
        message.setText("Ты че, пес? Поздоровайся сначала");
        return message;
    }
}
