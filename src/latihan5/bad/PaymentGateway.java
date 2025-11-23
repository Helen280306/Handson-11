package latihan5_dip.bad;

public class PaymentGateway {
    public String charge(String cardNumber, double amount) {
        System.out.println("[PaymentGateway] Charging " + amount + " to card: " + cardNumber);
        System.out.println("[PaymentGateway] Payment successful - Transaction ID: TXN-12345");
        return "TXN-12345";
    }
}
