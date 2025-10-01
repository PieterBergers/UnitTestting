package week2;

public class Product {
    private String name;
    private Integer size;
    private Double percentage;


    public String productDescription(String name, Integer size, Double percentage) {
        String description = "• "+name;
        if (size!=null) description += " "+size+"CL";
        if (percentage!=null) description += " "+percentage+"%";
        return description;
    }
}
