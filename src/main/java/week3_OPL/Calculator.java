package week3_OPL;

public class Calculator {
    int calculate(String expression) {
        if (expression == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        if (expression.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be empty");
        }
        int result = 0;
        char operation = '+';
        int currentNumber = 0;
        boolean modeOperation = false;

        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);

            if (Character.isDigit(currentChar)) {
                modeOperation = false;
                currentNumber = currentNumber * 10 + (currentChar - '0');
            } else if (currentChar == '+' || currentChar == '-') {
                if (modeOperation) {
                    throw new IllegalArgumentException("Invalid format in expression at position " + i);
                }
                modeOperation = true;
                if (operation == '+') {
                    result += currentNumber;
                } else {
                    result -= currentNumber;
                }
                operation = currentChar;
                currentNumber = 0;
            } else if (!Character.isWhitespace(currentChar)) {
                throw new IllegalArgumentException("Invalid character in expression: " + currentChar);
            }

        }

        if (modeOperation) {
            throw new IllegalArgumentException("Invalid format in expression at position " + expression.length());
        }

        if (operation == '+') {
            result += currentNumber;
        } else {
            result -= currentNumber;
        }
        return result;
    }
}
