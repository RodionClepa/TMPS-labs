package src.domain;

public class SmsNotification extends Notification{
    public SmsNotification(String message, String recipient){
        super(message, recipient);
    }

    @Override
    public void send() {
        System.out.println("SMS sent to " + recipient + ": " + message);
    }
}
