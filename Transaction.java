import java.util.Date;

public class Transaction {

    private String transactionId;
    private String type;
    private double amount;
    private String status;
    private Date timestamp;

    public Transaction(String transactionId, String type, double amount, String status) {
        this.transactionId = transactionId;
        this.type = type;
        this.amount = amount;
        this.status = status;
        this.timestamp = new Date();
    }

    public String getStatus() {
        return status;
    }
}
