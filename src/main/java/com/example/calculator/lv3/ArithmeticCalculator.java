package com.example.calculator.lv3;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator {
    private List<Integer> records = new ArrayList<>();

    public int calculate(int a, int b, OperatorType operator) {
        int result = operator.operate(a, b);
        // 결과값 add
        records.add(result);
        return result;
    }

    public List<Integer> getRecords() {
        return records;
    }

    public void setRecords(List<Integer> records) {
        this.records = records;
    }
}
