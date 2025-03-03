package org.example;

import java.util.ArrayDeque;
import java.util.Queue;

public class ArithmaticCalculator {
    private final Queue<Number> totalResults = new ArrayDeque<>();

    public <T extends Number> Number calculate(Operand<T> operand1, Operand<T> operand2, OperatorType operator) {
        double num1 = operand1.num().doubleValue();
        double num2 = operand2.num().doubleValue();
        double result = 0;

        switch (operator) {
            case PLUS -> result = num1 + num2;
            case MINUS -> result = num1 - num2;
            case DIVIDE -> result = num1 / num2;
            case MULTIPLY -> result = num1 * num2;
        }

        totalResults.add(result);
        return result;
    }

    public void printPreviousResult(Number number) {
        System.out.print("더 큰 결과값: ");
        totalResults.stream().filter(n -> n.doubleValue() > number.doubleValue()).forEach(n -> System.out.print(n + " "));
        System.out.println();
    }
}