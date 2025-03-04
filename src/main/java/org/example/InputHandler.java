package org.example;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class InputHandler {
    private static final String NOT_ALLOWED_NUMBER = "0 또는 양수를 입력해주세요.";
    private static final String INPUT_NUMBER = "숫자를 입력해주세요";
    private static final String NOT_ALLOWED_OPERATION = "올바른 연산 기호를 입력해주세요.";
    private static final String INPUT_OPERATION = "사칙연산 기호를 입력하세요: ";
    private static final String INPUT_EXIT = "더 계산하시겠습니까? (exit 입력 시 종료)";

    private static final Scanner sc = new Scanner(System.in);

    public static Operand<?> getOperand(String s) {
        while (true) {
            try {
                System.out.print(s);
                return new Operand<>(sc.nextDouble());
            } catch (InputMismatchException e) {
                if (Objects.equals(e.getMessage(), NOT_ALLOWED_NUMBER)) {
                    System.out.println(NOT_ALLOWED_NUMBER);
                    continue;
                }

                System.out.println(INPUT_NUMBER);
                sc.nextLine();
            }
        }
    }

    public static OperatorType getOperation() {
        while (true) {
            System.out.print(INPUT_OPERATION);
            char operation = sc.next().charAt(0);

            try {
                return OperatorType.fromChar(operation);
            } catch (InputMismatchException e) {
                if (Objects.equals(e.getMessage(), NOT_ALLOWED_OPERATION)) {
                    System.out.println(NOT_ALLOWED_OPERATION);
                }
            }
        }
    }

    public static String getIsEnd() {
        System.out.println(INPUT_EXIT);
        return sc.next();
    }
}

