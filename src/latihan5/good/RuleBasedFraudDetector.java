package latihan5_dip.good;

public class RuleBasedFraudDetector implements FraudDetector {

    @Override
    public boolean checkFraud(String cardNumber, double amount) {
        System.out.println("[RuleBasedFraudDetector] Checking fraud with rules for amount: " + amount);
        System.out.println("[RuleBasedFraudDetector] No fraud detected ✓");
        return true;
    }
}
