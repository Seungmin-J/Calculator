package com.example.calculator.lv1;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // 계산기 실행
        while(true) {
            // 메인메서드에서 실행 LEVEL 1
            List<String> operators = Arrays.asList("+", "-", "*", "/");
            String operator;

            System.out.println("계산기 실행 !\n");
            Scanner sc = new Scanner(System.in);

            // 첫 번째 값 입력
            System.out.println("첫 번째 값을 입력하세요");
            int firstNumber = Integer.parseInt(sc.nextLine());
            // 양수만 입력
            while (firstNumber < 0) {
                System.out.println("양수를 입력해주세요\n");
                firstNumber = Integer.parseInt(sc.nextLine());
            }
            do {
                // 연산자 입력
                System.out.println("4개의 연산자 중 선택하여 입력하세요");
                System.out.println("[+] / [-] / [*] / [/] ");
                operator = sc.nextLine();
                // 연산자 아니면 반복
            }while (!operators.contains(operator));

            // 두 번째 값 입력
            System.out.println("두 번째 값을 입력하세요");
            int lastNumber = Integer.parseInt(sc.nextLine());

            // 연산자에 따른 연산 후 sum에 할당
            int sum = 0;
            switch(operator) {
                case "+": sum = firstNumber+lastNumber; break;
                case "-": sum = firstNumber-lastNumber; break;
                case "*": sum = firstNumber*lastNumber; break;
                case "/":
                    // 나누기 연산자일 때 0이거나 음수인지 확인
                    while (lastNumber <= 0) {
                        System.out.println("0 혹은 음의 정수로 나눌 수 없습니다. 다른 값을 입력해주세요");
                        lastNumber = Integer.parseInt(sc.nextLine());
                    }
                    sum = firstNumber / lastNumber;
                    break;
            }
            System.out.println("결과 : " + sum);
            System.out.println("첫 번째 값 : " + firstNumber + " / "+ "두 번째 값 : " + lastNumber + "\n");
            System.out.println("계산을 계속 하시려면 아무 키를 입력하시고, 종료하시려면 'exit' 를 입력하세요");
            String exiting = sc.nextLine();
            if(exiting.equals("exit")) {
                break;
            }
        }
    }
}
