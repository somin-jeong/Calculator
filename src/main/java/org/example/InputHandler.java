package org.example;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class InputHandler {
    private static final Scanner sc = new Scanner(System.in);

    public static Operand<?> getOperand(String s) {
        while (true) {
            try {
                System.out.print(s);
                return new Operand<>(sc.nextDouble());
            } catch (InputMismatchException e) {
                if (Objects.equals(e.getMessage(), "0 또는 양수를 입력해주세요.")) {
                    System.out.println("0 또는 양수를 입력해주세요.");
                    continue;
                }

                System.out.println("숫자를 입력해주세요");
                sc.nextLine();
            }
        }
    }

    public static OperatorType getOperation() {
        while (true) {
            System.out.print("사칙연산 기호를 입력하세요: ");
            char operation = sc.next().charAt(0);

            try {
                return OperatorType.fromChar(operation);
            } catch (InputMismatchException e) {
                if (Objects.equals(e.getMessage(), "올바른 연산 기호를 입력해주세요.")) {
                    System.out.println("올바른 연산 기호를 입력해주세요.");
                }
            }
        }
    }

    public static String getIsEnd() {
        System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
        return sc.next();
    }
}

