package src.Adapter;

import src.domain.Notification;

public class JsonNotificationAdapter extends Notification {
    private final Notification notification;

    public JsonNotificationAdapter(Notification notification) {
        super(notification.getMessage(), notification.getRecipient());
        this.notification = notification;
    }

    @Override
    public void send() {
        String json = String.format("{\"message\":\"%s\", \"recipient\":\"%s\"}", message, recipient);
        System.out.println("Sending JSON notification: " + json);
    }
}
