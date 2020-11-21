package com.telegram.bot.telegrambot.util;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.telegram.bot.telegrambot.TrainingType.FULLBODY;
import static com.telegram.bot.telegrambot.TrainingType.SPLIT;

@Component
public class InlineKeyboardDrawer {

    public static InlineKeyboardMarkup getKeyboardMarkup() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(buildRow(buildButtonsForTrainings()));
        return inlineKeyboardMarkup;
    }

    private static List<InlineKeyboardButton> buildButtonsForTrainings() {
        InlineKeyboardButton splitKeyboardButton = new InlineKeyboardButton();
        InlineKeyboardButton fullBodyKeyboardButton = new InlineKeyboardButton();
        splitKeyboardButton.setText(SPLIT.getTrainingName());
        fullBodyKeyboardButton.setText(FULLBODY.getTrainingName());
        splitKeyboardButton.setCallbackData(SPLIT.name());
        fullBodyKeyboardButton.setCallbackData(FULLBODY.name());
        return Arrays.asList(splitKeyboardButton, fullBodyKeyboardButton);
    }

    private static List<List<InlineKeyboardButton>> buildRow(List<InlineKeyboardButton> buttons) {
        List<List<InlineKeyboardButton>> row = new ArrayList<>();
        row.add(buttons);
        return row;
    }
}
