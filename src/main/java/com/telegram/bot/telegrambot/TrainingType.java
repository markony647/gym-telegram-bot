package com.telegram.bot.telegrambot;

public enum TrainingType {
    SPLIT("СПЛИТ"),
    FULLBODY("ФУЛЛ БОДИ");

    public final String trainingName;

    TrainingType(String trainingName) {
        this.trainingName = trainingName;
    }

    public String getTrainingName() {
        return trainingName;
    }
}
