package com.example.calculator.lv2;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator2 {
    Scanner scanner = new Scanner(System.in);
    private List<Integer> records = new ArrayList<>();

    public int calculate(int a, int b, String operator) {
        boolean isZero = true;
        int result = 0;

        // 연산자가 나누기 이고 b 의 값이 0 이면 다시 입력
        if(!operator.equals("/") && b == 0) {
            switch (operator) {
                case "+": result = a+b; break;
                case "-": result = a-b; break;
                case "*": result = a*b; break;
                case "/": result = a/b; break;
            }
            records.add(result);
            return result;
        }else {
            while (isZero) {
                if(b == 0) {
                    System.out.println("0으로 나눌 수 없습니다. 다른 값을 입력해주세요");
                    b = Integer.parseInt(scanner.nextLine());
                }else {
                    isZero = false;
                    switch (operator) {
                        case "+": result = a+b; break;
                        case "-": result = a-b; break;
                        case "*": result = a*b; break;
                        case "/": result = a/b; break;
                    }
                    records.add(result);
                    return result;
                }
            }
        }
        return result;
    }

    public List<Integer> getRecords() {
        return records;
    }

    public void setRecords(List<Integer> records) {
        this.records = records;
    }
}
