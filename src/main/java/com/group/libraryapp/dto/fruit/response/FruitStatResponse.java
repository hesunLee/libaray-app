package com.group.libraryapp.dto.fruit.response;

import java.util.List;

public class FruitStatResponse {
    private long salesAmount;
    private long notSalesAmount;

    public FruitStatResponse(long salesAmount, long notSalesAmount) {
        this.salesAmount = salesAmount;
        this.notSalesAmount = notSalesAmount;
    }

    public FruitStatResponse(List<FruitStatList> fruitStatList) {

        for (FruitStatList fruit : fruitStatList) {
            if (fruit.getStatus() == 1) {
                this.notSalesAmount += fruit.getPrice();
            } else {
                this.salesAmount += fruit.getPrice();
            }
        }
    }

    public long getSalesAmount() {
        return salesAmount;
    }

    public long getNotSalesAmount() {
        return notSalesAmount;
    }
}
