package com.example.calculator.lv3;

public enum OperatorType {
    ADD("+") , SUBTRACT("-"), MULTIPLY("*") , DIVIDE("/");

    private String operator;

    OperatorType(String operator) {
        this.operator = operator;
    }

    // 연산자 입력값과 OperatorType 비교 후 일치하는 타입 리턴
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


}
