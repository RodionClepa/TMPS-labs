package src.handler;

import src.domain.Notification;
import src.types.NotificationType;

public interface NotificationHandler {
    void setNext(NotificationHandler handler);
    Notification handleNotification(NotificationType type, String message, String recipient);
}
