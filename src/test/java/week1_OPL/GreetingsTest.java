package week1_OPL;

import org.junit.jupiter.api.Test;

public class GreetingsTest {
    @Test
    public void sayHello_nameHasValue_returnsHello() {
        Greetings greetings = new Greetings();
        assertEquals("Hello World!", greetings.sayHello("World"));
        assertEquals("Hello Kitty!", greetings.sayHello("Kitty"));
    }

    @Test
    public void sayHello_nameHasNoValue_returnsJustHello() {
        Greetings greetings = new Greetings();
        assertEquals("Hello there!", greetings.sayHello(""));
        assertEquals("Hello there!", greetings.sayHello("\t\n "));
        assertEquals("Hello there!", greetings.sayHello(null));
    }

    @Test
    public void sayHello_LanguageIsNull_returnsErrorMessage() {
        Greetings greetings = new Greetings();
        assertEquals("I don't know how to say hello to you", greetings.sayHello("World", null));
        assertEquals("I don't know how to say hello to you", greetings.sayHello("World", "\n \t"));
    }

    @Test
    public void sayHello_LanguageIsUnknown_returnsErrorMessage() {
        Greetings greetings = new Greetings();
        assertEquals("I don't know how to say hello to you, World", greetings.sayHello("World", "Italian"));
    }

    @Test
    public void sayHello_nameAndLanguage_returnsCorrectLanguage() {
        Greetings greetings = new Greetings();
        assertEquals("Hello Jack!", greetings.sayHello("Jack", "English"));
        assertEquals("Hola Antonia!", greetings.sayHello("Antonia", "Spanish"));
        assertEquals("Bonjour Jean-Claude!", greetings.sayHello("Jean-Claude", "French"));
    }

    @Test
    public void sayHello_nameEmpty_returnsCorrectLanguageWithoutName() {
        Greetings greetings = new Greetings();
        assertEquals("Hello there!", greetings.sayHello(null, "English"));
        assertEquals("Hello there!", greetings.sayHello("", "English"));
        assertEquals("Hello there!", greetings.sayHello("\n\t ", "English"));
        assertEquals("Hola! ¿Que tal?", greetings.sayHello(null, "Spanish"));
        assertEquals("Hola! ¿Que tal?", greetings.sayHello("", "Spanish"));
        assertEquals("Hola! ¿Que tal?", greetings.sayHello(" \t\n", "Spanish"));
        assertEquals("Bonjour! Tu vas bien?", greetings.sayHello(null, "French"));
        assertEquals("Bonjour! Tu vas bien?", greetings.sayHello("", "French"));
        assertEquals("Bonjour! Tu vas bien?", greetings.sayHello(" \t\n", "French"));
    }
}
