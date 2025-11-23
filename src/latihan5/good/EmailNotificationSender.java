package latihan5_dip.good;

public class EmailNotificationSender implements NotificationSender {

    @Override
    public void sendNotification(String email, String message) {
        System.out.println("[EmailNotificationSender] Sending email to: " + email);
        System.out.println("[EmailNotificationSender] Subject: " + message);
    }
}
