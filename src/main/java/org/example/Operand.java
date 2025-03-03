package org.example;

public class Operand <T extends Number> {
    T num;

    public Operand(T num) {
        this.num = num;
    }

    public T getNum() {
        return num;
    }
}
