package week2_OPL;

import java.util.Locale;

public class Product {
    public static final String NO_DECIMAL_NUMBER = "%.0f%%";
    private String name;
    private Integer size;
    private Double percentage;

    public Product(String name, Integer size, Double percentage) {
        this.name = name;
        this.size = size;
        this.percentage = percentage;
    }

    public String productDescription() {
        String result = " • %s ".formatted(name);
        if (size != null) {
            result += size + "CL";
        }
        if (percentage != null) {
            String format = IsFractionNumber(percentage) ? NO_DECIMAL_NUMBER : "%.1f%%";
            if (size != null) result += " ";
            result += String.format(Locale.ROOT, format, percentage);
        }
        return result;
    }

    private boolean IsFractionNumber(Double p) {
        return p % 1 == 0;
    }
}
