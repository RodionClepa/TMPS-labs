package src.handler;

import src.domain.Notification;
import src.types.NotificationType;

public class EmailRespectHandler implements NotificationHandler {
    private NotificationHandler next;

    @Override
    public void setNext(NotificationHandler handler) {
        this.next = handler;
    }

    @Override
    public Notification handleNotification(NotificationType type, String message, String recipient) {
        message += "\nWith Respect Your creditor";
        return next != null ? next.handleNotification(type, message, recipient) : null;
    }
}
