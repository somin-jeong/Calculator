package org.example;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class App {
    private static final Scanner sc = new Scanner(System.in);
    private static final ArithmaticCalculator arithmaticCalculator = new ArithmaticCalculator();

    public static void main(String[] args) {
        String end = "";
        while (!Objects.equals(end, "exit")) {
            Operand<?> num1 = getOperand("첫 번째 숫자를 입력하세요: ");
            Operand<?> num2 = getOperand("두 번째 숫자를 입력하세요: ");
            OperatorType operation = getOperation();

            try {
                Number result = calculateNums(num1, num2, operation);
                arithmaticCalculator.printPreviousResult(result);
            } catch (InputMismatchException e) {
                if (Objects.equals(e.getMessage(), "나눗셈 연산에서 두 번째 숫자에 0이 입력될 수 없습니다.")) {
                    System.out.println("나눗셈 연산에서 두번째 정수에 0이 입력될 수 없습니다.");
                }
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            end = sc.next();
        }
    }

    private static Operand<?> getOperand(String s) {
        while (true) {
            try {
                System.out.print(s);
                return new Operand<>(sc.nextInt());
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

    private static OperatorType getOperation() {
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

    private static Number calculateNums(Operand<?> num1, Operand<?> num2, OperatorType operation) {
        Number result = arithmaticCalculator.calculate(num1, num2, operation);
        System.out.println(result);
        return result;
    }
}
