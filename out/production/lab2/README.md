# Report on Implementation of Creational Design Patterns
### Clepa Rodion FAF 221

## Overview
This project demonstrates the implementation of three creational design patterns: Builder, Factory, and Singleton. The system revolves around a notification mechanism that can send different types of notifications (for now Email, SMS), and also logs the actions with a logging system.

## Builder Design Pattern
#### Fields
- `String message` Holds the message content for the notification
- `String recipient` Stores the recipient information for the notification.
- `Notification notification` An instance of Notification (an abstract class) that will represent the specific type of notification, such as EmailNotification or SmsNotification

#### Builder Methods

- `message(String message)` Sets the message field to the provided value. This method returns the NotificationBuilder instance, enabling method chaining.
- `recipient(String recipient)` Sets the recipient field to the provided value and also returns the NotificationBuilder instance.
- `notificationType(Notification notification)` Sets the notification field with the specific Notification type passed as an argument. This could be an instance of any subclass of Notification, like EmailNotification or SmsNotification.

#### `build()` Method

- This method finalizes the configuration of the `Notification` object by setting the `message` and `recipient` on the specified `Notification` type. It calls the `setMessage` and `setRecipient` methods on notification to pass these values.
- Finally, it returns the fully configured `Notification` instance.


## Factory Method Design Pattern
#### Static Factory Method:
```java
public static Notification createNotification(NotificationType type, String message, String recipient) {
        LogSystem logger = LogSystem.getInstance();
        Notification notification;
        switch (type) {
            case EMAIL:
                notification = new EmailNotification(message, recipient);
                logger.log("Created Email Notification");
                break;
            case SMS:
                /** **/
            default:
                throw new IllegalArgumentException("Unknown notification type: " + type);
        }
        return notification;
    }
```
`createNotification(NotificationType type, String message, String recipient)` This static method is responsible for generating `Notification` objects. It takes in a `NotificationType` enum (either EMAIL or SMS), a `message`, and a `recipient`.

## Singleton Design Pattern
The `LogSystem` class implements the Singleton design pattern, ensuring there is only one instance of `LogSystem` throughout the application.

#### Private Static Instance
`private static LogSystem instance` This holds the single instance of `LogSystem`. It is static, ensuring that the same instance can be accessed globally across the application.
#### Private Constructor
`private LogSystem() {}` The private constructor prevents direct instantiation of the `LogSystem` class from outside, enforcing the Singleton pattern by restricting instantiation.

#### `getInstance` Method:
`public static LogSystem getInstance()` This method checks if an instance of `LogSystem` already exists. If not, it creates one. This instance is then returned, providing a single point of access to the logger.

