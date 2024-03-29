package by.sportliner.lk.core.service.telegram;

import by.sportliner.lk.core.model.BranchOffice;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class KeyboardFactory {

    public static ReplyKeyboard getSupportedOperations() {
        KeyboardRow row = new KeyboardRow();
        row.add("Записаться на пробное занятие");
        return new ReplyKeyboardMarkup(List.of(row));
    }

    public static ReplyKeyboard getSupportedBranchOffice(List<BranchOffice> branchOffices) {
        List<KeyboardRow> rows = new ArrayList<>();

        for (BranchOffice branchOffice : branchOffices) {
            KeyboardRow row = new KeyboardRow();
            row.add(branchOffice.getName());
            rows.add(row);
        }

        return new ReplyKeyboardMarkup(rows);
    }

    public static ReplyKeyboard renderCancelButton() {
        KeyboardRow row = new KeyboardRow();
        row.add("Вернуться к списку филиалов");
        return new ReplyKeyboardMarkup(List.of(row));
    }

}
