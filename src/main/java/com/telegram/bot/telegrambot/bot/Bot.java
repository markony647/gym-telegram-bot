package com.telegram.bot.telegrambot.bot;

import com.telegram.bot.telegrambot.handlers.ButtonSelectionHandler;
import com.telegram.bot.telegrambot.handlers.TextHandler;
import com.telegram.bot.telegrambot.handlers.UserInputHandler;
import com.telegram.bot.telegrambot.service.TodayTrainingProgramProvider;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class Bot extends TelegramLongPollingBot {

    @Value("${bot.name}")
    private String botName;

    @Value("${bot.token}")
    private String botToken;

    private UserInputHandler userInputHandler;
    private TodayTrainingProgramProvider trainingProgramProvider;

    @Autowired
    public Bot(TodayTrainingProgramProvider trainingProgramProvider) {
        this.trainingProgramProvider = trainingProgramProvider;
    }

    @Override
    public String getBotUsername() {
        return botName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        if (update.getMessage() != null) {
            userInputHandler = new TextHandler();
        } else if (update.hasCallbackQuery()) {
            userInputHandler = new ButtonSelectionHandler(trainingProgramProvider);
        }
        SendMessage message = userInputHandler.handle(update);
        execute(message);
    }
}
