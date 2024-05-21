package com.group.libraryapp.repository.fruit;

import com.group.libraryapp.dto.fruit.response.FruitStatResponse;

import java.time.LocalDate;

public interface FruitRepository {

    void saveFruit(String name, LocalDate warehousingDate, long price);
    void updateFruit(long id);
    FruitStatResponse getFruitStat(String name);


}
