package org.example;

import java.util.*;

public class Calculator {
    private Queue<Integer> totalResults = new ArrayDeque<>();

    public int calculate(int num1, int num2, char op) {
        int result = 0;

        if (op == '+') {
            result = num1 + num2;
        } else if (op == '-'){
            result = num1 - num2;
        } else if (op == '*'){
            result = num1 * num2;
        } else if (op == '%'){
            result = num1 % num2;
        } else {
            throw new InputMismatchException();
        }

        totalResults.add(result);
        return result;
    }

    public void removeResult() {
        totalResults.poll();
    }

    public Queue<Integer> getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(ArrayDeque<Integer> totalResults) {
        this.totalResults = totalResults;
    }
}