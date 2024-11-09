import src.Adapter.JsonNotificationAdapter;
import src.domain.EmailNotification;
import src.domain.Notification;
import src.domain.NotificationBuilder;
import src.domain.User;
import src.factory.NotificationFactory;
import src.singleton.LogSystem;
import src.types.NotificationType;

public class Main {

    public static void main(String[] args) {

        LogSystem logger = LogSystem.getInstance();
        logger.log("Application started");

        User user = new User("John Doe", "john@gmail.com");

        Notification buildedEmailNotification = new NotificationBuilder()
                .notificationType(new EmailNotification("", ""))
                .message("Your book is ready to pick up!")
                .recipient(user.getEmail())
                .build();
//        LAB 1
//        buildedEmailNotification.send();

//        Notification emailNotification = NotificationFactory.createNotification(NotificationType.EMAIL, "An angry email for " + user.getName(), user.getEmail());
//        emailNotification.send();
//
//        Notification smsNotification = NotificationFactory.createNotification(NotificationType.SMS, "Hello via SMS", "1234567890");
//        smsNotification.send();

//        LAB 2
//        ADAPTER
        Notification jsonEmailNotification = new JsonNotificationAdapter(buildedEmailNotification);
        jsonEmailNotification.send();

//        Decorator
        Notification emailNotification = NotificationFactory.createNotification(NotificationType.EMAIL, "An angry email for " + user.getName(), user.getEmail());
        emailNotification.send();


        logger.log("Application Finished");
    }
}
