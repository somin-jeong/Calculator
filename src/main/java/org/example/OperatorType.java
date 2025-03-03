package org.example;

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
        for (OperatorType op : values()) {
            if (op.symbol == symbol) {
                return op;
            }
        }
        throw new InputMismatchException("Invalid operator: " + symbol);
    }
}
