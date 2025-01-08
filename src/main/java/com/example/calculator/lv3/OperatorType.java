package com.example.calculator.lv3;

public enum OperatorType {
    ADD("+") , SUBTRACT("-"), MULTIPLY("*") , DIVIDE("/");

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


}
