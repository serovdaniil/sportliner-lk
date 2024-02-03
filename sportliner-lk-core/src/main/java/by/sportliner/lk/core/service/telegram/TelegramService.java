package by.sportliner.lk.core.service.telegram;

import by.sportliner.lk.core.model.TelegramChat;

import java.util.List;

public interface TelegramService {

    TelegramChat getById(String id);

    List<TelegramChat> findAll();

}
