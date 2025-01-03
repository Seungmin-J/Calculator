package com.example.calculator.lv1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator1 {
    public static void main(String[] args) {

        // 계산기 실행
        while(true) {
            // 메인메서드에서 실행 LEVEL 1
            List<String> operators= new ArrayList<>();
            boolean isOperator = false;
            String operator;

            System.out.println("계산기 실행 !");
            System.out.println();
            Scanner sc = new Scanner(System.in);

            // 첫 번째 값 입력
            System.out.println("첫 번째 값을 입력하세요");
            int firstNumber = Integer.parseInt(sc.nextLine());
            // 양수만 입력
            while (firstNumber < 0) {
                System.out.println("양수를 입력해주세요");
                System.out.println();
                firstNumber = Integer.parseInt(sc.nextLine());
            }

            do {
                // 연산자 입력
                System.out.println("4개의 연산자 중 선택하여 입력하세요");
                System.out.println("[+] / [-] / [*] / [/] ");
                operator = sc.nextLine();
                // 연산자인지 확인
                if(operators.contains(operator)) {
                    isOperator = true;
                }
            }while (!isOperator);

            // 두 번째 값 입력
            System.out.println("두 번째 값을 입력하세요");
            int lastNumber = Integer.parseInt(sc.nextLine());

            // 양수만 입력 and 0으로 나눌 시
            while((lastNumber == 0 && operator.equals("/")) || lastNumber < 0) {
                if(lastNumber == 0 && operator.equals("/")) {
                    System.out.println("나누는 값은 0 이상이어야 합니다");
                    lastNumber = Integer.parseInt(sc.nextLine());
                }else {
                    System.out.println("양수를 입력해주세요");
                    lastNumber = Integer.parseInt(sc.nextLine());
                }
            }

            // 연산자에 따른 연산 후 sum에 할당
            int sum = 0;
            switch(operator) {
                case "+": sum = firstNumber+lastNumber; break;
                case "-": sum = firstNumber-lastNumber; break;
                case "*": sum = firstNumber*lastNumber; break;
                case "/": sum = firstNumber/lastNumber; break;
            }
            System.out.println("결과 : " + sum);
            System.out.println("첫 번째 값 : " + firstNumber + " / "+ "두 번째 값 : " + lastNumber);

            System.out.println("계산을 계속 하시려면 아무 키를 입력하시고, 종료하시려면 'exit' 를 입력하세요");
            String exiting = sc.nextLine();
            if(exiting.equals("exit")) {
                break;
            }
        }
    }
}
