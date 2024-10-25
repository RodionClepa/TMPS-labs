package src.singleton;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogSystem {
    private static LogSystem instance;

    private LogSystem() {

    }

    public static LogSystem getInstance() {
        if (instance == null) {
            instance = new LogSystem();
        }
        return instance;
    }

    public void log(String message) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("[" + timestamp + "] Log message: " + message);
    }
}
