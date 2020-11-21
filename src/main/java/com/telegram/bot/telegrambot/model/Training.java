package com.telegram.bot.telegrambot.model;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class Training {
    private final Chest chest;
    private final Back back;
    private final Legs legs;
    private final Biceps biceps;

    @Override
    public String toString() {
        return String.format("Упражнения: \n%s\n%s\n%s\n%s", chest, back, legs, biceps);
    }
}
