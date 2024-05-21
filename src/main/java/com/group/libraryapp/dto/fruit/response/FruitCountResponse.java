package com.group.libraryapp.dto.fruit.response;

public class FruitCountResponse {
    private Long count;

    public FruitCountResponse(Long count) {
        this.count = count;
    }

    public Long getCount() {
        return count;
    }
}
