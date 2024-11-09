package src.Decorator;

import src.domain.Notification;

public class NotificationDecorator extends Notification {
    protected Notification notification;

    public NotificationDecorator(Notification notification) {
        super(notification.getMessage(), notification.getRecipient());
        this.notification = notification;
    }

    @Override
    public void send() {
        notification.send(); // Delegates to the wrapped notification
    }
}
