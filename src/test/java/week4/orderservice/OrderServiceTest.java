package week4.orderservice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class OrderServiceTest {

    @Test
    void testAddToShoppingCart_Success() {
        ProductService productService = mock(ProductService.class);
        ShoppingCart shoppingCart = mock(ShoppingCart.class);
        OrderService orderService = new OrderService(productService, shoppingCart);

        Product p = new Product("p1", 50.0);

        when(productService.productIsAvailable(p , 5)).thenReturn(true);

        orderService.addToShoppingCart(p, 5);

        verify(productService).productIsAvailable(p, 5);
        verify(shoppingCart).add(p, 5);
        verifyNoMoreInteractions(productService, shoppingCart);
    }

    @Test
    void testAddToShoppingCart_Fail() {
        ProductService productService = mock(ProductService.class);
        ShoppingCart shoppingCart = mock(ShoppingCart.class);
        OrderService orderService = new OrderService(productService, shoppingCart);

        Product p = new Product("p2", 50.0);

        when(productService.productIsAvailable(p , 5)).thenReturn(false);

        assertThrows(ProductNotAvailableException.class, () ->
                orderService.addToShoppingCart(p, 5));

        verify(productService).productIsAvailable(p, 5);
        verifyNoMoreInteractions(productService);
    }

}