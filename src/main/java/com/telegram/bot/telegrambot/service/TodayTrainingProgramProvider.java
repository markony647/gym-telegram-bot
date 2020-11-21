package com.telegram.bot.telegrambot.service;

import com.telegram.bot.telegrambot.repository.TrainingRepository;
import org.springframework.stereotype.Component;

import static com.telegram.bot.telegrambot.TrainingType.SPLIT;

@Component
public class TodayTrainingProgramProvider {

    final TrainingRepository trainingRepository;

    public TodayTrainingProgramProvider(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    public String getTrainingProgram(String userTrainingProgramSelection) {
        if (SPLIT.name().equals(userTrainingProgramSelection)) {
            return "Неправильный выбор! Подумай еще";
        } else {
            return trainingRepository.findRandomTraining();
        }
    }
}
