package com.example.calculator.lv3;

public enum OperatorType {
    ADD("+") {
        public int operate(int a, int b) {
            return a + b;
        }
    }, SUBTRACT("-") {
        public int operate(int a, int b) {
            return a - b;
        }
    }, MULTIPLY("*") {
        public int operate(int a, int b) {
            return a * b;
        }
    }, DIVIDE("/") {
        public int operate(int a, int b) {
            if(b == 0) {
                throw new ArithmeticException("0으로 나눌 수 없습니다");
            }
            return a / b;
        }
    };

    private String operator;

    OperatorType(String operator) {
        this.operator = operator;
    }

    public static OperatorType getOperatorType(String operator) {
        for(OperatorType type : values()) {
            if(type.getOperator().equals(operator)) {
                return type;
            }
        }
        throw new IllegalArgumentException("입력값이 유효하지 않습니다. 연산자를 입력해주세요");
    }

    public String getOperator() {
        return operator;
    }

    public abstract int operate(int a, int b);
}
