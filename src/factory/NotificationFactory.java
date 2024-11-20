package src.factory;

import src.domain.Notification;
import src.domain.SmsNotification;
import src.handler.EmailRespectHandler;
import src.handler.EmailNotificationHandler;
import src.handler.NotificationHandler;
import src.proxy.NotificationProxy;
import src.singleton.LogSystem;
import src.types.NotificationType;

public class NotificationFactory {
    public static Notification createNotification(NotificationType type, String message, String recipient) {
        LogSystem logger = LogSystem.getInstance();
        Notification notification;
        switch (type) {
            case EMAIL:
                NotificationHandler emailHandler = new EmailNotificationHandler();
                NotificationHandler emailRespectHandler = new EmailRespectHandler();

                emailRespectHandler.setNext(emailHandler);

                notification = emailRespectHandler.handleNotification(type, message, recipient);

                if (notification == null) {
                    throw new IllegalArgumentException("Unknown notification type: " + type);
                }

                break;
            case SMS:
                notification = new SmsNotification(message, recipient);
                logger.log("Created Sms Notification");
                break;
            default:
                throw new IllegalArgumentException("Unknown notification type: " + type);
        }
        return new NotificationProxy(notification);
    }
}
