package week4.orderservice;

public class ProductNotAvailableException extends RuntimeException {
    private final Product product;

    public ProductNotAvailableException(Product product) {
        this.product = product;
    }

}
