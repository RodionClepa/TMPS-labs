package src.Decorator;

import src.domain.EmailNotification;

public class GmailDecorator extends EmailDecorator {
    public GmailDecorator(EmailNotification emailNotification) {
        super(emailNotification);
    }

    @Override
    public void send() {
        System.out.println("Using Gmail settings...");
        super.send();
    }
}
