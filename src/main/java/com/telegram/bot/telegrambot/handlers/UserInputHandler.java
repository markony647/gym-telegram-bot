package com.telegram.bot.telegrambot.handlers;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface UserInputHandler {

    SendMessage handle(Update update);
    String getChatId();
}
