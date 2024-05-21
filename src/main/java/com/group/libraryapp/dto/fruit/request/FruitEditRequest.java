package com.group.libraryapp.dto.fruit.request;

public class FruitEditRequest {

    private Long id;

    protected FruitEditRequest() { }

    public FruitEditRequest(Long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
