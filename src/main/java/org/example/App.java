package org.example;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        Scanner sc = new Scanner(System.in);

        String end = "";
        while (!Objects.equals(end, "exit")) {
            int num1 = getNum("첫 번째 숫자를 입력하세요: ", sc);
            int num2 = getNum("두 번째 숫자를 입력하세요: ", sc);

            System.out.print("사칙연산 기호를 입력하세요: ");
            char operation = sc.next().charAt(0);

            calculateNums(calculator, num1, num2, operation);

            calculator.removeResult();

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            end = sc.next();
        }
    }

    private static int getNum(String s, Scanner sc) {
        int num = 0;
        while (true) {
            System.out.print(s);

            try {
                num = sc.nextInt();
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

    private static void calculateNums(Calculator calculator, int num1, int num2, char operation) {
        try {
            int result = calculator.calculate(num1, num2, operation);
            System.out.println(result);
        } catch (ArithmeticException e) {
            if (Objects.equals(e.getMessage(), "/ by zero")) {
                System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
            }
        } catch (InputMismatchException e) {
            System.out.println("올바른 연산 기호를 입력해주세요.");
        }
    }
}
