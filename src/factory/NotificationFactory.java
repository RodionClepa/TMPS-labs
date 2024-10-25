package src.factory;

import src.domain.EmailNotification;
import src.domain.Notification;
import src.domain.SmsNotification;
import src.singleton.LogSystem;
import src.types.NotificationType;

public class NotificationFactory {
    public static Notification createNotification(NotificationType type, String message, String recipient) {
        LogSystem logger = LogSystem.getInstance();
        Notification notification;
        switch (type) {
            case EMAIL:
                notification = new EmailNotification(message, recipient);
                logger.log("Created Email Notification");
                break;
            case SMS:
                notification = new SmsNotification(message, recipient);
                logger.log("Created Sms Notification");
                break;
            default:
                throw new IllegalArgumentException("Unknown notification type: " + type);
        }
        return notification;
    }
}
