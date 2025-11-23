package latihan5_dip;

// BAD
import latihan5_dip.bad.PaymentService;

// GOOD – import interface dan implementasinya
import latihan5_dip.good.CardValidator;
import latihan5_dip.good.FraudDetector;
import latihan5_dip.good.PaymentGateway;
import latihan5_dip.good.TransactionLogger;
import latihan5_dip.good.NotificationSender;

import latihan5_dip.good.LuhnCardValidator;
import latihan5_dip.good.RuleBasedFraudDetector;
import latihan5_dip.good.StripePaymentGateway;
import latihan5_dip.good.DatabaseTransactionLogger;
import latihan5_dip.good.EmailNotificationSender;

public class DIPPractice {

    public static void main(String[] args) {

        System.out.println("=== BAD PRACTICE: Melanggar DIP ===\n");

        // BAD SERVICE
        latihan5_dip.bad.PaymentService badService = new latihan5_dip.bad.PaymentService();
        badService.processPayment("4532-1234-5678-9010", 150000.0, "user@example.com");

        System.out.println("\n" + "=".repeat(70));
        System.out.println("\n=== GOOD PRACTICE: Mengikuti DIP ===\n");

        // GOOD SERVICE (Stripe)
        System.out.println("--- Setup: Stripe Payment Gateway ---");

        CardValidator validator = new LuhnCardValidator();
        FraudDetector fraudDetector = new RuleBasedFraudDetector();
        PaymentGateway gateway = new StripePaymentGateway();
        TransactionLogger logger = new DatabaseTransactionLogger();
        NotificationSender notifier = new EmailNotificationSender();

        latihan5_dip.good.PaymentService goodService =
                new latihan5_dip.good.PaymentService(
                        validator,
                        fraudDetector,
                        gateway,
                        logger,
                        notifier
                );

        goodService.processPayment("4532-1234-5678-9010", 150000.0, "user@example.com");

        System.out.println("\n" + "=".repeat(70));
        System.out.println("\n--- Summary ---");
        System.out.println("✓ Loose coupling");
        System.out.println("✓ Mudah ditest");
        System.out.println("✓ Follow DIP");
        System.out.println("✓ Open for extension");
    }
}
