package org.example;

import java.util.InputMismatchException;

public class Operand <T extends Number> {
    private final T num;

    public Operand(T num) {
        this.num = num;
        validatePositive();
    }

    private void validatePositive() {
        if (num.doubleValue() < 0) {
            throw new InputMismatchException("0 또는 양수를 입력해주세요.");
        }
    }

    public T getNum() {
        return num;
    }
}
