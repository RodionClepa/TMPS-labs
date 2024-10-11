package Notification;

import User.User;

public class EmailNotification implements Notification{
    public void send(String message, User user) {
        System.out.println("A email notification was sent to " + user.getEmail());
        System.out.println("Content:");
        System.out.println(message);
    }
}
