package week4.orderservice;

public class OrderService {
    private final ProductService productService;
    private final ShoppingCart shoppingCart;

    public OrderService(ProductService productService, ShoppingCart shoppingCart) {
        this.productService = productService;
        this.shoppingCart = shoppingCart;
    }

    public void addToShoppingCart(Product product, int quantity) {
        throw new RuntimeException("Not implemented yet");
    }
}
