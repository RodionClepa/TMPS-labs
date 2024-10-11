import Notification.Notification;
import User.User;

public class Library {
//    Liskov Substitution Principle
    private Notification notificationService;

    public Library(Notification notificationService) {
        this.notificationService = notificationService;
    }

    public void notifyUser(String message, User user) {
        notificationService.send(message, user);
    }
}
