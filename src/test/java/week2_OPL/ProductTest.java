package week2_OPL;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {
    @Test
    void productDescription_allNull() {
        Product p = new Product("productname", null, null);
        String result = p.productDescription();
        assertEquals(" • productname ", result);
    }

    @Test
    void productDescription_sizeSet_percentageNull() {
        Product p = new Product("productname", 25, null);
        String result = p.productDescription();
        assertEquals(" • productname 25CL", result);
    }

    @Test
    void productDescription_sizeNull_percentageSet() {
        Product p = new Product("productname", null, 8.0);
        String result = p.productDescription();
        assertEquals(" • productname 8%", result);
    }

    @Test
    void productDescription_allSet() {
        Product p = new Product("productname", 33, 6.0);
        String result = p.productDescription();
        assertEquals(" • productname 33CL 6%", result);
    }

    @Test
    void productDescription_percentageWithDecimal() {
        Product p = new Product("productname", 33, 6.3);
        String result = p.productDescription();
        assertEquals(" • productname 33CL 6.3%", result);
    }

    @Test
    void productDescription_percentageWithTooMuchDecimals() {
        Product p = new Product("productname", 33, 6.333);
        String result = p.productDescription();
        assertEquals(" • productname 33CL 6.3%", result);
    }
}
