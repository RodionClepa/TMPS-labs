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

        User user = new User("John Doe", "john@example.com");

        Notification buildedEmailNotification = new NotificationBuilder()
                .notificationType(new EmailNotification("", ""))
                .message("Your book is ready to pick up!")
                .recipient(user.getEmail())
                .build();

        buildedEmailNotification.send();

        Notification emailNotification = NotificationFactory.createNotification(NotificationType.EMAIL, "An angry email for " + user.getName(), user.getEmail());
        emailNotification.send();

        Notification smsNotification = NotificationFactory.createNotification(NotificationType.SMS, "Hello via SMS", "1234567890");
        smsNotification.send();

        logger.log("Application Finished");
    }
}
