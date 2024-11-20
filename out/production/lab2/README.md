# Behavioral Design Patterns


## Author: Clepa Rodion

----

## Objectives:

* Study and understand the Behavioral Design Patterns.
* As a continuation of the previous laboratory work, think about what communication between software entities might be involed in my system.
* Implement some additional functionalities using behavioral design patterns.

## Reminding domain
- Notification System

## Used Design Patterns:
- Chain of Responsibility


## Implementation
### Chain of Responsibility
* Chain of Responsibility is a design pattern that allow to pass a data through a chain of handler, each handler have possibility to process or to pass data to the next handler.

For start, I create an interface for all other handlers
```java
public interface NotificationHandler {
    void setNext(NotificationHandler handler);
    Notification handleNotification(NotificationType type, String message, String recipient);
}
```
Method `setNext` - is used to link one handler to another in a chain
Method `handleNotification` - where will be implemented data processing.


The EmailNotificationHandler is responsible for handling email notifications. When it receives a notification data, it does a few thing.
- It checks if the notification is an email.
- It creates a basic email notification.
- It applies decorator to the notification based on the recipient's email domain.
- It logs the creation of the email notification.

```java
public class EmailNotificationHandler implements NotificationHandler {
    private NotificationHandler next;

    @Override
    public void setNext(NotificationHandler handler) {
        this.next = handler;
    }

    @Override
    public Notification handleNotification(NotificationType type, String message, String recipient) {
        if (type == NotificationType.EMAIL) {
            LogSystem logger = LogSystem.getInstance();
            EmailNotification notification = new EmailNotification(message, recipient);

            if (recipient.endsWith("@gmail.com")) {
                notification = new GmailDecorator(notification);
            } else if (recipient.endsWith("@outlook.com")) {
                notification = new OutlookDecorator(notification);
            }

            logger.log("Created Email Notification");
            return notification;
        }
        return next != null ? next.handleNotification(type, message, recipient) : null;
    }
}
```

Other handler is just adding a message to the end of the message
```java

```



Result
```
Sending JSON notification: {"message":"Your book is ready to pick up!", "recipient":"john@gmail.com"}
```

## Conclusions
In this laboratory work I have utilized three patterns Adapter, Decorator and Proxy within a notifcation system. The use of each pattern has increased the flexibility of my code, also bold the importance of utilizing design patterns in software development.  