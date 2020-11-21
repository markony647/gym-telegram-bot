package com.telegram.bot.telegrambot.database;

import com.telegram.bot.telegrambot.model.*;

import java.util.Arrays;
import java.util.List;

public class TrainingsDatabase {

    private static Chest benchPressHorizontal = new Chest("Жим лежа на горизонтальной скамье");
    private static Back pullUps = new Back("Подтягивания");
    private static Legs squats = new Legs("Приседания");
    private static Biceps barbell = new Biceps("Подъем штанги с ровным грифом на бицепс");

    public final static List<Training> TRAININGS = Arrays.asList(
        Training.builder()
            .chest(benchPressHorizontal)
            .back(pullUps)
            .legs(squats)
            .biceps(barbell)
            .build(),
            Training.builder()
                    .chest(benchPressHorizontal)
                    .back(pullUps)
                    .legs(squats)
                    .build()
    );
}
