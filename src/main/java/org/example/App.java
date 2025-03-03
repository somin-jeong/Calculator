package org.example;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArithmaticCalculator arithmaticCalculator = new ArithmaticCalculator();

        Scanner sc = new Scanner(System.in);

        String end = "";
        while (!Objects.equals(end, "exit")) {
            double num1 = getOperand("첫 번째 숫자를 입력하세요: ", sc);
            double num2 = getOperand("두 번째 숫자를 입력하세요: ", sc);

            System.out.print("사칙연산 기호를 입력하세요: ");
            char operation = sc.next().charAt(0);

            Number number = calculateNums(arithmaticCalculator, new Operand<>(num1), new Operand<>(num2), operation);

            arithmaticCalculator.printPreviousResult(number);

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            end = sc.next();
        }
    }

    private static double getOperand(String s, Scanner sc) {
        double num;
        while (true) {
            System.out.print(s);

            try {
                num = sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력해주세요");
                sc.nextLine();
                continue;
            }

            if (num < 0) {
                System.out.println("0 또는 양수를 입력해주세요.");
                continue;
            }

            break;
        }
        return num;
    }

    private static <T extends Number> Number calculateNums(ArithmaticCalculator arithmaticCalculator, Operand<T> num1, Operand<T> num2, char operation) {
        Number result = 0;
        try {
            OperatorType operatorType = OperatorType.fromChar(operation);
            result = arithmaticCalculator.calculate(num1, num2, operatorType);
            System.out.println(result);
        } catch (ArithmeticException e) {
            if (Objects.equals(e.getMessage(), "/ by zero")) {
                System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
            }
        } catch (InputMismatchException e) {
            System.out.println("올바른 연산 기호를 입력해주세요.");
        }
        return result;
    }
}
