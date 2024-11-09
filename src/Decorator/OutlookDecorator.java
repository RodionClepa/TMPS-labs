package src.Decorator;

import src.domain.EmailNotification;

public class OutlookDecorator extends EmailDecorator{
    public OutlookDecorator(EmailNotification emailNotification) {
        super(emailNotification);
    }

    @Override
    public void send() {
        System.out.println("Using Outlook settings...");
        super.send();
    }
}
