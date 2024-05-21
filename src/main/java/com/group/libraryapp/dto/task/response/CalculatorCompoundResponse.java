package com.group.libraryapp.dto.task.response;

import com.group.libraryapp.dto.task.reqeust.CalculatorCompoundRequest;

public class CalculatorCompoundResponse {
    private long add;
    private long minus;
    private long multiply;

    public CalculatorCompoundResponse(CalculatorCompoundRequest request) {
        this.add = request.getNum1() + request.getNum2();
        this.minus = request.getNum1() - request.getNum2();
        this.multiply = request.getNum1() * request.getNum2();
    }

    public long getAdd() {
        return add;
    }

    public long getMinus() {
        return minus;
    }

    public long getMultiply() {
        return multiply;
    }
}
