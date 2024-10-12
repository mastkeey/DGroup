package ru.mastkey.dgroup.bot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.HashSet;
import java.util.Set;

@Component
@Slf4j
public class NotifyBot extends TelegramLongPollingBot {
    private static final Set<Long> ADMIN_IDS = new HashSet<>();

    @Override
    public void onUpdateReceived(Update update) {
        var message = update.getMessage();
        var username = message.getFrom().getUserName();
        sendMessage(message.getChatId(), message.getText());
        log.info(username);
        if (
                username.equals("mastkeey")
                || username.equals("orhemy")
                || username.equals("khomyakov_a")
                || username.equals("RinatG86")
                || username.equals("brwski_junior")
        ) {
            ADMIN_IDS.add(update.getMessage().getChatId());
        }
    }

    public void sendMessage(Long chatId, String text) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(text);

        try {
            this.execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void sendMessageToAdmins(String text) {
        ADMIN_IDS.forEach(adminId ->
                this.sendMessage(adminId, text)
        );
    }

    @Override
    public String getBotUsername() {
        return "DGroupNotifyBot";
    }

    public String getBotToken() {
        return "8159835779:AAEWAOeQvVXKknUlnbQf6HLhu5UKDO7Sxac";
    }
}
