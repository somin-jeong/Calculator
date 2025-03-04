package org.example;

import java.util.InputMismatchException;
import java.util.Objects;

public class App {
    private static final ArithmaticCalculator arithmaticCalculator = new ArithmaticCalculator();

    public static void main(String[] args) {
        do {
            Operand<?> num1 = InputHandler.getOperand("첫 번째 숫자를 입력하세요: ");
            Operand<?> num2 = InputHandler.getOperand("두 번째 숫자를 입력하세요: ");
            OperatorType operation = InputHandler.getOperation();
            calculateNums(num1, num2, operation);
        } while (!Objects.equals(InputHandler.getIsEnd(), "exit"));
    }

    private static void calculateNums(Operand<?> num1, Operand<?> num2, OperatorType operation) {
        try {
            Number result = arithmaticCalculator.calculate(num1, num2, operation);
            System.out.println(result);
            arithmaticCalculator.printPreviousResult(result);
        } catch (InputMismatchException e) {
            if (Objects.equals(e.getMessage(), "나눗셈 연산에서 두 번째 숫자에 0이 입력될 수 없습니다.")) {
                System.out.println("나눗셈 연산에서 두번째 정수에 0이 입력될 수 없습니다.");
            }
        }
    }
}
