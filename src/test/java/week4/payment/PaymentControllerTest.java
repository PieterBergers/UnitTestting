package week4.payment;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class PaymentControllerTest {

    @Test
    void testProcessPayment_Success() {

        AccountingService accountingService = mock(AccountingService.class);
        PaymentController controller = new PaymentController(accountingService);

        when(accountingService.generateTransactionId("A", "B")).thenReturn("T1");
        when(accountingService.executePayment("A", "B", 50.0, "T1")).thenReturn(true);

        String transactionId = controller.processPayment("A", "B", 50.0);

        assertEquals("T1", transactionId);
        verify(accountingService).generateTransactionId("A", "B");
        verify(accountingService).executePayment("A", "B", 50.0, "T1");
        verify(accountingService).sendMessage("B", "Payment transaction T1 from A succeeded for 50,00 €");
        verifyNoMoreInteractions(accountingService);
    }

    @Test
    void testProcessPayment_Failure() {

        AccountingService accountingService = mock(AccountingService.class);
        PaymentController controller = new PaymentController(accountingService);

        when(accountingService.generateTransactionId("A", "B")).thenReturn("T2");
        when(accountingService.executePayment("A", "B", 75.0, "T2")).thenReturn(false);

        String transactionId = controller.processPayment("A", "B", 75.0);

        assertEquals("T2", transactionId);
        verify(accountingService).generateTransactionId("A", "B");
        verify(accountingService).executePayment("A", "B", 75.0, "T2");
        verify(accountingService).sendMessage("A", "Payment transaction T2 to B failed");
        verifyNoMoreInteractions(accountingService);
    }
}
