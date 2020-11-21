package com.telegram.bot.telegrambot.repository;

import com.telegram.bot.telegrambot.database.TrainingsDatabase;
import org.springframework.stereotype.Component;

@Component
public class TrainingRepository {

    public String findRandomTraining() {
        return TrainingsDatabase.TRAININGS.get(0).toString();
    }
}
