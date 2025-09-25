package week1_OPL;

public class Greetings {
    public String sayHello(String name) {
        return "Hello " + name + "!";
    }

    public String sayHello(String name, String language) {
        return switch (language) {
            case "English" -> "Hello " + name + "!";
            case "Spanish" -> "Hola " + name + "!";
            default -> "I don't know how to say hello to you, " + name;
        };
    }

}
