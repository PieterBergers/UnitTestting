package week4.payment;

public interface AccountingService {
    String generateTransactionId(String fromUserId, String toUserId);
    boolean executePayment(String fromUserId, String toUserId, double amount, String transactionId);
    void sendMessage(String userId, String message);
}
