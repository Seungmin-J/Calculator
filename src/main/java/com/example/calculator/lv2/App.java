package com.example.calculator.lv2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Calculator2 cal = new Calculator2();
        Scanner sc = new Scanner(System.in);
        List<String> operators = Arrays.asList("+", "-", "*", "/");

        while (true) {
            System.out.println("계산기 실행 !");
            System.out.println();

            // 작업 선택
            System.out.println("1. 계산하기");
            System.out.println("2. 계산기록 확인");
            int mode = Integer.parseInt(sc.nextLine());

            // 계산하기
            if (mode == 1) {
                // 첫 번째 값 입력
                System.out.println("첫 번째 값을 입력하세요");
                int firstNumber = Integer.parseInt(sc.nextLine());
                // 양수만 입력
                while (firstNumber <= 0) {
                    System.out.println("양수를 입력해주세요");
                    System.out.println();
                }
                // 연산자 입력
                System.out.println("4개의 연산자 중 선택하여 입력하세요");
                System.out.println("[+] / [-] / [*] / [/] ");
                String operator = sc.nextLine();

                // 입력값이 연산자가 아니면 다시 입력 반복
                boolean isOperator = false;
                while (!isOperator) {
                    if (operators.contains(operator)) {
                        isOperator = true;
                    } else {
                        System.out.println("4개의 연산자 중 선택하여 입력하세요");
                        System.out.println("[+] / [-] / [*] / [/] ");
                        operator = sc.nextLine();
                    }
                }

                // 두 번째 값 입력
                System.out.println("두 번째 값을 입력하세요");
                int lastNumber = Integer.parseInt(sc.nextLine());

                // calculate() 메서드 실행
                int result = cal.calculate(firstNumber, lastNumber, operator);
                System.out.println("결과 : " + result);
                System.out.println("첫 번째 값 : " + firstNumber + " / " + "두 번째 값 : " + cal.lastNumber);
                System.out.println();

                // 메서드 실행 후 계속하기 or 끝내기
                System.out.println("계산을 계속 하시려면 아무 키를 입력하시고, 종료하시려면 'exit' 를 입력하세요");
                String exiting = sc.nextLine();
                if (exiting.equals("exit")) {
                    break;
                }

                // 기록 확인하기
            } else if (mode == 2) {
                System.out.println("1. 기록 확인하기");
                System.out.println("2. 기록 삭제하기(가장 먼저 계산된 기록부터)");

                int num = Integer.parseInt(sc.nextLine());
                // 기록 확인
                if (num == 1) {
                    if (cal.getRecords().isEmpty()) {
                        System.out.println("계산 기록이 없습니다");
                        continue;
                    }
                    System.out.println("계산 기록 순서 :");
                    for (int i = 0; i < cal.getRecords().size(); i++) {
                        System.out.println(i + 1 + ". " + cal.getRecords().get(i));
                    }
                    // 기록 삭제
                } else if (num == 2) {
                    if (cal.getRecords().isEmpty()) {
                        System.out.println("계산 기록이 없습니다");
                    } else {
                        cal.getRecords().remove(cal.getRecords().get(0));
                        System.out.println("삭제되었습니다");
                    }
                } else {
                    System.out.println("1번과 2번 중에 선택하세요");
                }
            } else {
                System.out.println("1번과 2번 중에 선택하세요");
            }
        }
    }
}
