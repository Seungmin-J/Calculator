package com.example.calculator.lv3;

import java.util.List;
import java.util.Scanner;

import static java.lang.Double.parseDouble;

public class App {
    public static void main(String[] args) {
        ArithmeticCalculator calculator = new ArithmeticCalculator();
        Scanner sc = new Scanner(System.in);

        // 계산기 앱 실행
        while (true) {
            System.out.println("계산기 실행 !\n");
            // 작업 선택
            System.out.println("1. 계산하기");
            System.out.println("2. 계산기록 확인");
            System.out.println("3. 기록 삭제하기(가장 먼저 계산된 기록부터)");
            // 계산하기
            switch (Integer.parseInt(sc.nextLine())) {
                case 1:
                    //첫 번째 값 입력
                    System.out.println("첫 번째 값을 입력하세요");
                    double firstNumber = parseDouble(sc.nextLine());
                    // 양수만 입력
                    while (firstNumber <= 0) {
                        System.out.println("양수를 입력해주세요\n");
                    }
                    // 입력값이 연산자가 아니면 예외처리 후 다시 입력 반복
                    OperatorType operator = null;
                    while (operator == null) {
                        try {
                            // 연산자 입력
                            System.out.println("4개의 연산자 중 선택하여 입력하세요");
                            System.out.println("[+] / [-] / [*] / [/] ");
                            String operatorInput = sc.nextLine();
                            operator = OperatorType.getOperatorType(operatorInput);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    // 두 번째 값 입력
                    double lastNumber;
                    while (true) {
                        Double result;
                        System.out.println("두 번째 값을 입력하세요");
                        lastNumber = parseDouble(sc.nextLine());
                        // calculate() 메서드 실행  /  0으로 나눌 때 예외 처리
                        try {
                            result = calculator.calculate(firstNumber, lastNumber, operator);
                            System.out.println("결과 : " + result);
                            System.out.println("첫 번째 값 : " + firstNumber + " / " + "두 번째 값 : " + lastNumber + "\n");
                            break;
                        } catch (ArithmeticException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    // 메서드 실행 후 계속하기 or 끝내기
                    System.out.println("계산을 계속 하시려면 아무 키를 입력하시고, 종료하시려면 'exit' 를 입력하세요");
                    if ("exit".equals(sc.nextLine())) {
                        return;
                    }
                    break;
                // 기록 확인/삭제
                case 2:
                    // 기록 확인
                    System.out.println("1. 전체 기록 확인하기");
                    System.out.println("2. 입력한 값보다 큰 값의 기록 확인하기");
                    switch (Integer.parseInt(sc.nextLine())) {
                        // 전체 기록 출력
                        case 1:
                            // 기록 없으면 break
                            if (calculator.getRecords().isEmpty()) {
                                System.out.println("계산 기록이 없습니다");
                                break;
                            }
                            System.out.println("계산 기록 순서 :");
                            for (int i = 0; i < calculator.getRecords().size(); i++) {
                                System.out.println(i + 1 + ". " + calculator.getRecords().get(i));
                            }
                            break;
                        case 2:
                            // 입력 값보다 큰 값의 기록 출력
                            // 기록 없으면 break
                            if (calculator.getRecords().isEmpty()) {
                                System.out.println("계산 기록이 없습니다");
                                break;
                            }
                            System.out.println("값을 입력하세요");
                            double input = Double.parseDouble(sc.nextLine());
                            List<Number> records = calculator.getGreaterRecordsThanInput(input);
                            if(!records.isEmpty()) {
                                System.out.println("계산 기록 순서 :");
                                for (int i = 0; i < records.size(); i++) {
                                    System.out.println(i + 1 + ". " + records.get(i));
                                }
                            }else {
                                System.out.println("입력값보다 큰 값이 없습니다");
                            }
                            break;
                        default:
                            System.out.println("보기의 숫자중에서 하나를 입력하세요");
                            break;
                    }
                    break;
                case 3:
                    // 기록 없으면 break
                    if (calculator.getRecords().isEmpty()) {
                        System.out.println("계산 기록이 없습니다");
                        break;
                    }
                    calculator.getRecords().remove(calculator.getRecords().get(0));
                    System.out.println("삭제되었습니다");
                    break;
                default:
                    System.out.println("보기의 숫자중에서 하나를 입력하세요");
                    break;
            }
        }
    }
}
