package org.siit;


import java.util.ArrayList;
import java.util.List;

public class ExpressionEvaluator {

    public static int evaluate(Expression expression) {
        List<Object> elem = expression.getElements();
        ArrayList<Object> elem2 = new ArrayList<>();

        if (elem.size() == 1) {
            return (int) elem.get(0);
        }

        if (elem.size() == 3) {
            return evalBinary((int) elem.get(0), (int) elem.get(2),
                    (BinaryOperator) elem.get(1));
        }

        for (int i = 1; i < elem.size(); i += 2) {
            if (elem.get(i).equals(BinaryOperator.MULTIPLY) ||
                    elem.get(i).equals(BinaryOperator.DIVIDE) ||
                    elem.get(i).equals(BinaryOperator.MODULUS)) {
                int eval = evalBinary((int) elem.get(i - 1), (int) elem.get(i + 1),
                        (BinaryOperator) elem.get(i));
                elem2.add(eval);
            } else {
                if (elem.get(i + 2).equals(BinaryOperator.MULTIPLY) ||
                        elem.get(i + 2).equals(BinaryOperator.DIVIDE) ||
                        elem.get(i + 2).equals(BinaryOperator.MODULUS)) {
                    elem2.add(elem.get(i));
                } else {
                    elem2.add(elem.get(i));
                    elem2.add(elem.get(i + 1));
                }
            }
        }
        System.out.println(elem2);

        int eval = evalBinary((int) elem2.get(0), (int) elem2.get(2),
                (BinaryOperator) elem2.get(1));
        for (int i = 3; i < elem2.size() - 1; i += 2) {
            eval = evalBinary(eval, (int) elem2.get(i + 1),
                    (BinaryOperator) elem2.get(i));
        }
        return eval;

//        return evalBinary((int) elem.get(0), (int) elem.get(2),
//                (BinaryOperator) elem.get(1));

        //TODO: implement case when elem has more than 3 elements
        //done :)
    }

    private static int evalBinary(int op1, int op2, BinaryOperator op) {
        switch (op) {
            case ADD:
                return op1 + op2;
            case SUBTRACT:
                return op1 - op2;
            case MULTIPLY:
                return op1 * op2;
            case DIVIDE:
                return op1 / op2;
            case MODULUS:
                return op1 % op2;
            default:
                throw new ValidationException("Unknown operator: " + op);
        }
    }

}
