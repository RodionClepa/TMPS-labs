package src.domain;

public class NotificationBuilder {
    private String message;
    private String recipient;
    private Notification notification;

    public NotificationBuilder message(String message) {
        this.message = message;
        return this;
    }

    public NotificationBuilder recipient(String recipient) {
        this.recipient = recipient;
        return this;
    }

    public NotificationBuilder notificationType(Notification notification) {
        this.notification = notification;
        return this;
    }

    public Notification build() {
        this.notification.setMessage(this.message);
        this.notification.setRecipient(this.recipient);
        return notification;
    }
}
