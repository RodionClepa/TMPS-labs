import Notification.Notification;
import Notification.EmailNotification;
import Notification.SmsNotification;
import User.User;

public class Main {
    public static void main(String[] args) {
//        Notification emailService = new EmailNotification();
//        Library library = new Library(emailService);
//        User user = new User("Rodion", "rodion@gmail.com");
//        library.notifyUser("Return my books", user);

        Notification smsService = new SmsNotification();
        Library library = new Library(smsService);
        User user = new User("Rodion", "rodion@gmail.com", "124177481");
        library.notifyUser("Return my books or u will get spammed", user);
    }
}
