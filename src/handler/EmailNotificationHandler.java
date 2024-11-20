package src.handler;

import src.Decorator.GmailDecorator;
import src.Decorator.OutlookDecorator;
import src.domain.EmailNotification;
import src.domain.Notification;
import src.singleton.LogSystem;
import src.types.NotificationType;

public class EmailNotificationHandler implements NotificationHandler {
    private NotificationHandler next;

    @Override
    public void setNext(NotificationHandler handler) {
        this.next = handler;
    }

    @Override
    public Notification handleNotification(NotificationType type, String message, String recipient) {
        if (type == NotificationType.EMAIL) {
            LogSystem logger = LogSystem.getInstance();
            EmailNotification notification = new EmailNotification(message, recipient);

            if (recipient.endsWith("@gmail.com")) {
                notification = new GmailDecorator(notification);
            } else if (recipient.endsWith("@outlook.com")) {
                notification = new OutlookDecorator(notification);
            }

            logger.log("Created Email Notification");
            return notification;
        }
        return next != null ? next.handleNotification(type, message, recipient) : null;
    }
}