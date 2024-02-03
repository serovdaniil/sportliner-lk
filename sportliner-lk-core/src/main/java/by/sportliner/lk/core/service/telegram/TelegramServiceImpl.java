package by.sportliner.lk.core.service.telegram;

import by.sportliner.lk.core.model.TelegramChat;
import by.sportliner.lk.core.repository.TelegramChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelegramServiceImpl implements TelegramService {

    @Autowired
    private TelegramChatRepository telegramChatRepository;

    @Override
    public TelegramChat getById(String id) {
        return telegramChatRepository.getReferenceById(id);
    }

    @Override
    public List<TelegramChat> findAll() {
        return telegramChatRepository.findAll();
    }
}
