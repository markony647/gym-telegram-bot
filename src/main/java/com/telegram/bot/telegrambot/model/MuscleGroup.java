package com.telegram.bot.telegrambot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class MuscleGroup {
    private final String exercise;

    @Override
    public String toString() {
        return String.format("%s\n", exercise);
    }
}
