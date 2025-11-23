package latihan5_dip.good;

public class StripePaymentGateway implements PaymentGateway {

    @Override
    public String charge(String cardNumber, double amount) {
        System.out.println("[StripePaymentGateway] Processing payment via Stripe");
        System.out.println("[StripePaymentGateway] Charging " + amount + " to card: " + cardNumber);
        System.out.println("[StripePaymentGateway] Payment successful - Transaction ID: STRIPE-TXN-12345");
        return "STRIPE-TXN-12345";
    }
}
