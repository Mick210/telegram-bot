package pro.sky.telegrambot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "tasks")
public class NotificationTask {

    @Id
    @GeneratedValue
    private int id;
    private int chat_id;
    private String notification_task;
    private LocalDateTime dateTime;

    public NotificationTask() {
    }

    public NotificationTask(int id, int chat_id, String notification_task, LocalDateTime dateTime) {
        this.id = id;
        this.chat_id = chat_id;
        this.notification_task = notification_task;
        this.dateTime = dateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getChat_id() {
        return chat_id;
    }

    public void setChat_id(int chat_id) {
        this.chat_id = chat_id;
    }

    public String getNotification_task() {
        return notification_task;
    }

    public void setNotification_task(String notification_task) {
        this.notification_task = notification_task;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        NotificationTask that = (NotificationTask) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
