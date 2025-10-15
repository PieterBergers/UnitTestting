package week4.payment;

public class PaymentController {
    private final AccountingService accountingService;

    public PaymentController(AccountingService accountingService) {
        this.accountingService = accountingService;
    }

    public String processPayment(String fromUserId, String toUserId, double amount) {
        String transactionId = accountingService.generateTransactionId(fromUserId, toUserId);

        boolean success = accountingService.executePayment(fromUserId, toUserId, amount, transactionId);

        if (success) {
            String message = String.format(
                    "Payment transaction %s from %s succeeded for %.2f €",
                    transactionId, fromUserId, amount
            );
            accountingService.sendMessage(toUserId, message);
        } else {
            String message = String.format(
                    "Payment transaction %s to %s failed",
                    transactionId, toUserId
            );
            accountingService.sendMessage(fromUserId, message);
        }

        return transactionId;
    }
}