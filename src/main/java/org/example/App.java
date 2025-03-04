package org.example;

import java.util.InputMismatchException;
import java.util.Objects;

public class App {
    private static final ArithmaticCalculator arithmaticCalculator = new ArithmaticCalculator();
    private static final String INPUT_FIRST_NUMBER = "첫 번째 숫자를 입력하세요: ";
    private static final String INPUT_SECOND_NUMBER = "두 번째 숫자를 입력하세요: ";
    private static final String EXIT = "exit";
    private static final String NOT_ALLOWED_ZERO_WHEN_DIVIDE = "나눗셈 연산에서 두 번째 숫자에 0이 입력될 수 없습니다.";

    public static void main(String[] args) {
        do {
            Operand<?> num1 = InputHandler.getOperand(INPUT_FIRST_NUMBER);
            Operand<?> num2 = InputHandler.getOperand(INPUT_SECOND_NUMBER);
            OperatorType operation = InputHandler.getOperation();
            calculateNums(num1, num2, operation);
        } while (!Objects.equals(InputHandler.getIsEnd(), EXIT));
    }

    private static void calculateNums(Operand<?> num1, Operand<?> num2, OperatorType operation) {
        try {
            Number result = arithmaticCalculator.calculate(num1, num2, operation);
            System.out.println(result);
            arithmaticCalculator.printPreviousResult(result);
        } catch (InputMismatchException e) {
            if (Objects.equals(e.getMessage(), NOT_ALLOWED_ZERO_WHEN_DIVIDE)) {
                System.out.println(NOT_ALLOWED_ZERO_WHEN_DIVIDE);
            }
        }
    }
}
