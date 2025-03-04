package org.example;

import java.util.Arrays;
import java.util.InputMismatchException;

public enum OperatorType {
    PLUS('+'),
    MINUS('-'),
    DIVIDE('%'),
    MULTIPLY('*');

    private final char symbol;

    OperatorType(char s) {
        this.symbol = s;
    }

    public static OperatorType fromChar(char symbol) {
        return Arrays.stream(values())
                .filter(operatorType -> operatorType.symbol == symbol)
                .findFirst()
                .orElseThrow(() -> new InputMismatchException("올바른 연산 기호를 입력해주세요."));
    }
}
