package pro.sky.telegrambot.listener;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import pro.sky.telegrambot.service.BotService;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
public class NotificationScheduler {

    @Autowired
    private TelegramBotUpdatesListener telegramBotUpdatesListener;

    public NotificationScheduler(BotService botService, TelegramBot telegramBot) {
        this.botService = botService;
        this.telegramBot = telegramBot;
    }

    @Autowired
    private BotService botService;
    @Autowired
    private TelegramBot telegramBot;

    @Scheduled(cron = "0 0/1 * * * *")
    public void doScheduling() {
        LocalDateTime localDateTime = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
        botService.getNotifications(localDateTime).forEach(notificationTask -> {
            long chatId = notificationTask.getChat_id();
            String message = notificationTask.getNotification_task();
            telegramBot.execute(new SendMessage(chatId, message));
        });
    }
}