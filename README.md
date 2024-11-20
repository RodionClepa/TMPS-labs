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
public class EmailRespectHandler implements NotificationHandler {
    private NotificationHandler next;

    @Override
    public void setNext(NotificationHandler handler) {
        this.next = handler;
    }

    @Override
    public Notification handleNotification(NotificationType type, String message, String recipient) {
        message += "\nWith Respect Your creditor";
        return next != null ? next.handleNotification(type, message, recipient) : null;
    }
}
```

Below is how I implemented handlers in factory

```
NotificationHandler emailHandler = new EmailNotificationHandler();
NotificationHandler emailRespectHandler = new EmailRespectHandler();

emailRespectHandler.setNext(emailHandler);

notification = emailRespectHandler.handleNotification(type, message, recipient);

if (notification == null) {
    throw new IllegalArgumentException("Unknown notification type: " + type);
}

break;
```


Result
```
[2024-11-20 15:38:38] Log message: Application started
[2024-11-20 15:38:38] Log message: Created Email Notification
[2024-11-20 15:38:38] Log message: Proxy is called
[2024-11-20 15:38:38] Log message: Preparing to send notification to john@gmail.com
Using Gmail settings...
Email sent to john@gmail.com: An angry email for John Doe
With Respect Your creditor
[2024-11-20 15:38:38] Log message: Notification sent to john@gmail.com
[2024-11-20 15:38:38] Log message: Application Finished
```

## Conclusions
In this laboratory work, I explored and implemented the Chain of Responsibility design pattern as a part of a notification system. The key goal was to enhance the system by utilizing behavioral design patterns