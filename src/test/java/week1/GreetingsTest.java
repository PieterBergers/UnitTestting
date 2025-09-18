package week1;

import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;

import static org.junit.jupiter.api.Assertions.*;

class GreetingsTest {

    @Test
    void sayHello() {
        Greetings greetings = new Greetings();
        assertEquals("Hello World!", greetings.sayHello("World"));
    }

    @Test
    void sayHello_nameHasEmptyValue_returnsHelloThere() {
        Greetings greetings = new Greetings();
        assertEquals("Hello there!", greetings.sayHello(""));
    }

    @Test
    void sayHello_nameHasNull_returnsHelloThere() {
        Greetings greetings = new Greetings();
        assertEquals("Hello there!", greetings.sayHello(null));
    }

    @Test
    void sayHello_languageIsEnglish_returnsHelloPeter() {
        Greetings greetings = new Greetings();
        assertEquals("Hello Peter!", greetings.sayHello("Peter", "English"));
    }

    @Test
    void sayHello_languageIsSpanish_returnsHelloPedro() {
        Greetings greetings = new Greetings();
        assertEquals("Hola Pedro!", greetings.sayHello("Pedro", "Spanish"));
    }

    @Test
    void sayHello_languageIsGerman_returnsHelloPeta() {
        Greetings greetings = new Greetings();
        assertEquals("Guten Tag Peta!", greetings.sayHello("Peta", "German"));
    }

    @Test
    void sayHello_languageHasEmptyValue_returnsIDontKnow() {
        Greetings greetings = new Greetings();
        assertEquals("I don't know how to say hello to you, Peter", greetings.sayHello("Peter", ""));
    }

    @Test
    void sayHello_languageHasNullValue_returnsIDontKnow() {
        Greetings greetings = new Greetings();
        assertEquals("I don't know how to say hello to you, Peter", greetings.sayHello("Peter", ""));

    }

}