package src.Decorator;

import src.domain.EmailNotification;

public abstract class EmailDecorator extends EmailNotification {
    protected EmailNotification emailNotification;

    public EmailDecorator(EmailNotification emailNotification) {
        super(emailNotification.getMessage(), emailNotification.getRecipient());
        this.emailNotification = emailNotification;
    }

    @Override
    public void send() {
        emailNotification.send();
    }
}
