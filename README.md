# Notification System
### Overview
This project implements a notification system using SOLID principles in Java.

## SOLID Principles Implemented
### Dependency Inversion Principle
1. Software entities must depend on abstractions, not on concrete things. Separate modules, that are located on different levels must not depend directly on each other, but should rely on abstractions.

Implementation: The Notification interface serves as an abstraction for notification methods, allowing the Library class to use any notification service without knowing the specifics of each implementation.
``` java
public interface Notification {
void send(String message, User user);
}
```

### Single Responsibility Principle (SRP)

2. The Single Responsibility Principle states that a class should have one and only one reason to change.

Implementation: The User class is responsible solely for storing user information and providing access to that data, making it easy to maintain and modify without affecting other components.
```java
public class User {
private String name;
private String email;
private String phone;
// Constructor and getters
}
```

### Project Structure
- Notification package: Contains the Notification interface and its implementations (SmsNotification, EmailNotification).
- User package: Contains the User class.
- Library: Manages notifications and utilizes the Notification interface.
- Main: The entry point for testing different notification types.

### Usage Example
To use the system, create a User and pass a Notification implementation to the Library:

```java
Notification smsService = new SmsNotification();
Library library = new Library(smsService);
User user = new User("Rodion", "rodion@gmail.com", "124177481");
library.notifyUser("Return my books or you will get spammed", user);
```
## Conclusion
This project demonstrates a clean implementation of SOLID principles, resulting in a flexible and maintainable notification system. The design allows easy extension for new notification types in the future.



