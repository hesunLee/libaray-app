package com.group.libraryapp.dto.fruit.response;


public class FruitStatList {
    private String name;
    private long price;
    private long status;

    public FruitStatList(String name, long price, long status) {
        this.name = name;
        this.price = price;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public long getPrice() {
        return price;
    }

    public long getStatus() {
        return status;
    }

}
