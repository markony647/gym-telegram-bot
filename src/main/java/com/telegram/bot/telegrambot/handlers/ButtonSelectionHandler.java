package com.telegram.bot.telegrambot.handlers;

import com.telegram.bot.telegrambot.service.TodayTrainingProgramProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class ButtonSelectionHandler implements UserInputHandler {

    private Update update;
    private TodayTrainingProgramProvider trainingProgramProvider;

    @Autowired
    public ButtonSelectionHandler(TodayTrainingProgramProvider trainingProgramProvider) {
        this.trainingProgramProvider = trainingProgramProvider;
    }

    @Override
    public SendMessage handle(Update update) {
        this.update = update;
        String todayTraining = trainingProgramProvider.getTrainingProgram(userTrainingProgramSelection());
        SendMessage message = new SendMessage();
        message.setText(todayTraining);
        message.setChatId(getChatId());
        return message;
    }

    @Override
    public String getChatId() {
        return String.valueOf(update.getCallbackQuery().getMessage().getChatId());
    }

    private String userTrainingProgramSelection() {
        return update.getCallbackQuery().getData();
    }
}
