package src.domain;

public class EmailNotification extends Notification{
    public EmailNotification(String message, String recipient) {
        super(message, recipient);
    }

    @Override
    public void send() {
        System.out.println("Email sent to " + recipient + ": " + message);
    }
}
