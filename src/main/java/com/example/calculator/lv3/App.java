package com.example.calculator.lv3;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArithmeticCalculator<Number> cal = new ArithmeticCalculator<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("계산기 실행 !\n");
            // 작업 선택
            System.out.println("1. 계산하기");
            System.out.println("2. 계산기록 확인");
            int mode = Integer.parseInt(sc.nextLine());
            // 계산하기
            switch (mode) {
                case 1:
                    //첫 번째 값 입력
                    System.out.println("첫 번째 값을 입력하세요");
                    double firstNumber = Double.parseDouble(sc.nextLine());
                    // 양수만 입력
                    while (firstNumber <= 0) {
                        System.out.println("양수를 입력해주세요\n");
                    }
                    // 입력값이 연산자가 아니면 다시 입력 반복
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
                        lastNumber = Double.parseDouble(sc.nextLine());
                        // calculate() 메서드 실행
                        try {
                            result = cal.calculate(firstNumber, lastNumber, operator);
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
                case 2:
                    // 기록 확인하기
                    System.out.println("1. 기록 확인하기");
                    System.out.println("2. 기록 삭제하기(가장 먼저 계산된 기록부터)");

                    mode = Integer.parseInt(sc.nextLine());
                    // 기록 확인
                    switch (mode) {
                        case 1:
                            if (cal.getRecords().isEmpty()) {
                                System.out.println("계산 기록이 없습니다");
                                break;
                            }
                            System.out.println("계산 기록 순서 :");
                            for (int i = 0; i < cal.getRecords().size(); i++) {
                                System.out.println(i + 1 + ". " + cal.getRecords().get(i));
                            }
                            break;
                        case 2:
                            if (cal.getRecords().isEmpty()) {
                                System.out.println("계산 기록이 없습니다");
                                break;
                            } else {
                                cal.getRecords().remove(cal.getRecords().get(0));
                                System.out.println("삭제되었습니다");
                                break;
                            }
                        default:
                            System.out.println("1번과 2번 중에 선택하세요");
                            break;
                    }
                    break;
                default:
                    System.out.println("1번과 2번 중에 선택하세요");
                    break;
            }
        }
    }
}
