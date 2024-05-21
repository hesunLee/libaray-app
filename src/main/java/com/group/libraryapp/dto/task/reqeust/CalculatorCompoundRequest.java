package com.group.libraryapp.dto.task.reqeust;

public class CalculatorCompoundRequest {

    private final long num1;
    private final long num2;

    public CalculatorCompoundRequest(long num1, long num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public long getNum1() {
        return num1;
    }

    public long getNum2() {
        return num2;
    }
}
