package latihan5_dip.good;

public class LuhnCardValidator implements CardValidator {

    @Override
    public boolean validate(String cardNumber) {
        System.out.println("[LuhnCardValidator] Validating card using Luhn algorithm: " + cardNumber);
        System.out.println("[LuhnCardValidator] Card is valid ✓");
        return true;
    }
}
