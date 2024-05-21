package com.group.libraryapp.dto.fruit.request;

import java.time.LocalDate;

public class FruitAddRequest {

    private String name;
    private LocalDate warehousingDate;
    private long price;

    public FruitAddRequest(String name, LocalDate warehousingDate, long price) {
        this.name = name;
        this.warehousingDate = warehousingDate;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public LocalDate getWarehousingDate() {
        return warehousingDate;
    }

    public long getPrice() {
        return price;
    }
}
