package week3_OPL;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PasswordValidatorTest {

    @Test
    void validate_passwordsAreOK() {
        PasswordValidator pv = new PasswordValidator();
        assertEquals("OK", pv.validate("abcdefg", "1Ac[abcd"));
    }

    @Test
    void validate_lessThan7Characters_ReturnsError() {
        PasswordValidator pv = new PasswordValidator();

        assertEquals("TOOSHORT", pv.validate("abcdefg", "1Ac[bcd"));
    }

    @Test
    void validate_noCapital_ReturnsError() {
        PasswordValidator pv = new PasswordValidator();

        assertEquals("NOCAPITAL", pv.validate("abcdefg", "1ac[bcde"));
    }

    @Test
    void validate_noLowerCase_ReturnsError() {
        PasswordValidator pv = new PasswordValidator();

        assertEquals("NOLOWER", pv.validate("abcdefg", "1AC[BCDE"));
    }

    @Test
    void validate_noDigit_ReturnsError() {
        PasswordValidator pv = new PasswordValidator();

        assertEquals("NODIGIT", pv.validate("abcdefg", "IaC[BCDE"));
    }

    @Test
    void validate_noSymbol_ReturnsError() {
        PasswordValidator pv = new PasswordValidator();

        assertEquals("NOSYMBOL", pv.validate("abcdefg", "IaCBm1CDE"));
    }

    @Test
    void validate_containsUsername_ReturnsError() {
        PasswordValidator pv = new PasswordValidator();

        assertEquals("HASUSERNAME", pv.validate("abcdefg", "IaCBabcdefg$m1CDE"));
    }
}