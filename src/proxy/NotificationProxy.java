package src.proxy;

import src.domain.Notification;
import src.singleton.LogSystem;

public class NotificationProxy extends Notification {
    private Notification realNotification;

    public NotificationProxy(Notification realNotification) {
        super(realNotification.getMessage(), realNotification.getRecipient());
        this.realNotification = realNotification;
    }

    @Override
    public void send() {
        // Addiing additional behavior
        LogSystem logger = LogSystem.getInstance();
        logger.log("Proxy is called");
        logger.log("Preparing to send notification to " + recipient);

        // Call the actual send method
        realNotification.send();

        logger.log("Notification sent to " + recipient);
    }
}
