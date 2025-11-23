package latihan5_dip.bad;

public class NotificationSender {
    public void sendNotification(String email, String subject) {
        System.out.println("[NotificationSender] Sending notification to: " + email);
        System.out.println("[NotificationSender] Subject: " + subject);
    }
}
