package com.example.calculator.lv2;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator2 {
    Scanner scanner = new Scanner(System.in);
    private List<Integer> records = new ArrayList<>();
    int lastNumber;

    public int calculate(int a, int b, String operator) {
        int result = 0;
        lastNumber = b;

        // operator 값 확인
            switch (operator) {
                case "+": result = a+b; break;
                case "-": result = a-b; break;
                case "*": result = a*b; break;
                case "/":
                    // 나누기 연산자일 때 0이거나 음수인지 확인
                    while (lastNumber <= 0) {
                        System.out.println("0 혹은 음의 정수로 나눌 수 없습니다. 다른 값을 입력해주세요");
                        lastNumber = Integer.parseInt(scanner.nextLine());
                    }
                    result = a / lastNumber;
                    records.add(result);
                    return result;
                default:
                    System.out.println("4개의 연산자중 입력해주세요");
                    operator = scanner.nextLine();
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
