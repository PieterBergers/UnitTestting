package week2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest {
    Product product = new Product();

    @Test
    void productDescription_onlyName_returnsName() {
        assertEquals("• pils", product.productDescription("pils", null, null));
    }

    @Test
    void productDescription_normalInput_returnsFromattedInput() {
        assertEquals("• Moore Pils 33CL 6.3%", product.productDescription("Moore Pils", 33, 6.3));
    }

    @Test
    void productDescription_noSize_returnsWithoutSize() {
        assertEquals("• stella 5.2%", product.productDescription("stella", null, 5.2));
    }

    @Test
    void productDescription_noPercentage_returnsWithoutPercentage() {
        assertEquals("• kriek 50CL", product.productDescription("kriek", 50, null));
    }
}



//Scenario                     Name_input      size_input      percentage_input       result
//only name                    pils            null            null                   • pils
//normal input                 Moore Pils      33              6.3                    • Moore Pils 33CL 6.3%
//no size                      stella          null            5.2                    • stella 5.2%
//no percentage                kriek           50              null                   • kriek 50CL
//0cl input                    biertje         0               null                   IAExc. "size cannot be null."
//0% input                     alcholvrij bier null            0                      • bier 0.0%