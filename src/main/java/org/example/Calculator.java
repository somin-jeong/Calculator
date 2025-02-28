package org.example;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String end = "";
        while (!Objects.equals(end, "exit")) {
            int num1 = 0;
            int num2 = 0;
            try {
                do {
                    System.out.print("첫 번째 숫자를 입력하세요: ");
                    num1 = sc.nextInt();
                } while(num1 < 0);

                do {
                    System.out.print("두 번째 숫자를 입력하세요: ");
                    num2 = sc.nextInt();
                } while(num2 < 0);
            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력해주세요.");
                return;
            }

            System.out.print("사칙연산 기호를 입력하세요: ");
            char operation = sc.next().charAt(0);

            int result = 0;
            try {
                if (operation == '+') {
                    result = num1 + num2;
                } else if (operation == '-'){
                    result = num1 - num2;
                } else if (operation == '*'){
                    result = num1 * num2;
                } else if (operation == '%'){
                    result = num1 % num2;
                } else {
                    throw new InputMismatchException();
                }
            } catch (ArithmeticException e) {
                if (Objects.equals(e.getMessage(), "/ by zero")) {
                    System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                    return;
                }
            } catch (InputMismatchException e) {
                System.out.println("올바른 연산 기호를 입력해주세요.");
                return;
            }

            System.out.println("결과: " + result);

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            end = sc.next();
        }
    }
}