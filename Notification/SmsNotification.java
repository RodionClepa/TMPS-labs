package Notification;

import User.User;

public class SmsNotification implements Notification{
    public void send(String message, User user) {
        System.out.println(user.getName() + " got SMS message on " + user.getPhone());
        System.out.println("Content:");
        System.out.println(message);
    }
}
