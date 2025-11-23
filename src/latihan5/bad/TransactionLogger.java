package latihan5_dip.bad;

public class TransactionLogger {
    public void log(String id, double amount, String status) {
        System.out.println("[TransactionLogger] Logging transaction: " + id
                + ", Amount: " + amount + ", Status: " + status);
    }
}
