package src.domain;

public abstract class Notification {
    protected String message;
    protected String recipient;

    public Notification(String message, String recipient) {
        this.message = message;
        this.recipient = recipient;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public abstract void send();
}
