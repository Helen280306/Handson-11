package latihan5_dip.bad;

public class PaymentService {

    private final CardValidator cardValidator = new CardValidator();
    private final FraudDetector fraudDetector = new FraudDetector();
    private final PaymentGateway gateway = new PaymentGateway();
    private final TransactionLogger logger = new TransactionLogger();
    private final NotificationSender sender = new NotificationSender();

    public void processPayment(String cardNumber, double amount, String email) {
        cardValidator.validate(cardNumber);
        fraudDetector.checkFraud(amount);
        String id = gateway.charge(cardNumber, amount);
        logger.log(id, amount, "SUCCESS");
        sender.sendNotification(email, "Payment Successful");
    }
}
