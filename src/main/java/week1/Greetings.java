package week1;

public class Greetings {
    public String sayHello(String name) {
        if (name == null || name.isEmpty()) {
            return "Hello there!";
        }
        return "Hello " + name + "!";
    }

    public String sayHello(String name, String language) {
        return switch (language) {
            case "English" -> "Hello " + name + "!";
            case "Spanish" -> "Hola " + name + "!";
            case "German" -> "Guten Tag " + name + "!";
            default -> "I don't know how to say hello to you, " + name;
        };
    }

}
