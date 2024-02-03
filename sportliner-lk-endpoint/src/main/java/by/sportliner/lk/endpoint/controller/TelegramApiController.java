package by.sportliner.lk.endpoint.controller;

import by.sportliner.lk.core.model.TelegramChat;
import by.sportliner.lk.core.service.telegram.TelegramService;
import by.sportliner.lk.endpoint.api.BranchOfficeItemDto;
import by.sportliner.lk.endpoint.api.TelegramApi;
import by.sportliner.lk.endpoint.api.TelegramBotApplicationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TelegramApiController implements TelegramApi {

    @Autowired
    private TelegramService telegramService;

    @Override
    public ResponseEntity<List<TelegramBotApplicationDto>> getTelegramApplications() {
        return ResponseEntity.ok(telegramService.findAll().stream()
            .sorted(Comparator.comparing(TelegramChat::getCreateTimestamp).reversed())
            .map(it -> convert(it)
            )
            .collect(Collectors.toList())
        );
    }

    @Override
    public ResponseEntity<TelegramBotApplicationDto> getTelegramApplicationById(String telegramBotApplicationId) {
        TelegramChat telegramChat = telegramService.getById(telegramBotApplicationId);

        return ResponseEntity.ok(convert(telegramChat));
    }

    private TelegramBotApplicationDto convert(TelegramChat telegramChat) {
        return new TelegramBotApplicationDto()
            .id(telegramChat.getId())
            .telegramUsername(telegramChat.getUsername())
            .createTimestamp(telegramChat.getCreateTimestamp())
            .branchOffice(new BranchOfficeItemDto()
                .id(telegramChat.getBranchOffice().getId())
                .address(telegramChat.getBranchOffice().getAddress().getFullAddress())
            )
            .phone(telegramChat.getPhone());
    }
}
