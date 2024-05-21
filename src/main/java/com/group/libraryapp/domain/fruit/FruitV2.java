package com.group.libraryapp.domain.fruit;

import java.time.LocalDate;

public class FruitV2 {

    private long id;
    private String name;
    private LocalDate warehousingDate;
    private long price;
    private int status;


    public FruitV2(String name, LocalDate warehousingDate, long price) {
        this.name = name;
        this.warehousingDate = warehousingDate;
        this.price = price;
        this.status = 1;
    }

    public long getId() {
        return id;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
