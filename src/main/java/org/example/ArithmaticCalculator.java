package org.example;

import java.util.ArrayDeque;
import java.util.InputMismatchException;
import java.util.Queue;

public class ArithmaticCalculator {
    private final Queue<Number> totalResults = new ArrayDeque<>();
    private static final String NOT_ALLOWED_ZERO_WHEN_DIVIDE = "나눗셈 연산에서 두 번째 숫자에 0이 입력될 수 없습니다.";
    private static final String LARGER_RESULTS = "더 큰 결과값: ";
    private static final String SEPERATOR = " ";

    public Number calculate(Operand<?> operand1, Operand<?> operand2, OperatorType operator) {
        double num1 = operand1.getNum().doubleValue();
        double num2 = operand2.getNum().doubleValue();
        double result = 0;

        switch (operator) {
            case PLUS -> result = num1 + num2;
            case MINUS -> result = num1 - num2;
            case DIVIDE -> {
                if (num2 == 0) {
                    throw new InputMismatchException(NOT_ALLOWED_ZERO_WHEN_DIVIDE);
                }
                result = num1 / num2;
            }
            case MULTIPLY -> result = num1 * num2;
        }

        totalResults.add(result);
        return result;
    }

    public void printPreviousResult(Number number) {
        System.out.print(LARGER_RESULTS);
        totalResults.stream()
                .filter(n -> n.doubleValue() > number.doubleValue())
                .forEach(n -> System.out.print(n + SEPERATOR));
        System.out.println();
    }
}