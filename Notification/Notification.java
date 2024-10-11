package Notification;

import User.User;

//Dependency Inversion Principle

public interface Notification {
    void send(String message, User user);
}
