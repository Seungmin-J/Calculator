package com.example.calculator.lv3;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator<T extends Number> {
    private List<Number> records = new ArrayList<>();

    public Double calculate(T a, T b, OperatorType operator) {
        Double result;
        switch (operator) {
            case ADD:
                result = a.doubleValue() + b.doubleValue();
                break;
            case SUBTRACT:
                result = a.doubleValue() - b.doubleValue();
                break;
            case MULTIPLY:
                result = a.doubleValue() * b.doubleValue();
                break;
            case DIVIDE:
                if (b.doubleValue() == 0) {
                    throw new ArithmeticException("0으로 나눌 수 없습니다");
                }
                result = a.doubleValue() / b.doubleValue();
                break;
            default:
                throw new IllegalArgumentException("연산자를 입력해주세요. 입력값: " + operator);
        }
        records.add(result);
        return result;
    }

    public List<Number> getRecords() {
        return records;
    }

    public void setRecords(List<Number> records) {
        this.records = records;
    }
}

