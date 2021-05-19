package org.siit;

import java.util.ArrayList;
import java.util.List;

public class StringExpression implements Expression {

    private List<Object> elements;

    public StringExpression(String expression) {
        elements = new ArrayList<>();

        // 1 + 2 -> {"1", "+", "2"} // 1 +; //empty_string // 1 * 5 // + 1 2
        String[] tokens = expression.split(" ");

        if (tokens.length % 2 == 0 || tokens[0].isEmpty()) {
            throw new ValidationException("Expression must have an odd number of tokens.");
        }

        elements.add(parseNumber(tokens[0]));

        for (int i = 1; i < tokens.length; i++) {
            if (i % 2 == 0) {
                elements.add(parseNumber(tokens[i]));
            } else {
                elements.add(parseOperator(tokens[i]));
            }
        }
        System.out.println(elements);
//		if (tokens.length == 3) {
//			elements.add(parseOperator(tokens[1]));
//			elements.add(parseNumber(tokens[2]));
//		}

        //TODO: implement case when you have more than 3 tokens: 1 + 1 * 2 / 4...
        //done :)

    }

    private BinaryOperator parseOperator(String token) {
        for (BinaryOperator operator : BinaryOperator.values()) {
            if (operator.getSymbol().equals(token)) {
                return operator;
            }
        }
        throw new ValidationException("Operator " + token + " not found.");
        //return null;
        //throw ValidationException
        //done :)
    }

    private Integer parseNumber(String number) {
        //TODO: verify if number is a number; if not -> throw validationException
        //done :)
        try {
            int nr = Integer.parseInt(number);
            return nr;
        } catch (NumberFormatException nfe) {
            throw new ValidationException("Token " + number + " is not a number.");
        }
    }

    public List<Object> getElements() {
        return elements;
    }
}
