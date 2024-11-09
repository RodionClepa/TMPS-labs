# Structural Design Patterns


## Author: Clepa Rodion

----

## Objectives:

* Get familiar with the Structural Design Patterns;
* Reminding domain;
* Implement at least 3 SDPs for the specific domain;

## Reminding domain
- Notification System

## Used Design Patterns:
- Adapter
- Decorator
- Proxy


## Implementation
### Adapter
* Adapter is a design pattern that allows objects with incompatible interfaces to interact. I decided to make an JSON notification adapter which transform notifications to JSON format.

```java
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
```

Result
```
Sending JSON notification: {"message":"Your book is ready to pick up!", "recipient":"john@gmail.com"}
```

### Decorator
* Decorator allows to add new behavior to object placing them inside other object that contains new behavior.
* In my implementation, I am adding the functionality of email notifications by creating a GmailDecorator that applies Gmail-specific settings before sending the notification.
* In the GmailDecorator class, I extend the EmailDecorator to create a decorator that prints a message indicating the use of Gmail settings before call to the original email notification send() method.

```java
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
```

* EmailDecorator hold a reference to an EmailNotification object. The constructor initializes the base class with the message and recipient, where the decorator send() method calls the send() method of the encapsulated notification.
```java
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
```

Result
```
Using Gmail settings...
Email sent to john@gmail.com: An angry email for John Doe
```

### Proxy
* For Proxy design pattern I created a NotificaitonProxy that wraps a Notification object. This proxy adds logging whenever a notification is sent. Proxy is used in factory class
```java
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
```

## Conclusions
In this laboratory work I have utilized three patterns Adapter, Decorator and Proxy within a notifcation system. The use of each pattern has increased the flexibility of my code, also bold the importance of utilizing design patterns in software development.  