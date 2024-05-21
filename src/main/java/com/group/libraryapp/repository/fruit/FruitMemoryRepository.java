package com.group.libraryapp.repository.fruit;

import com.group.libraryapp.domain.fruit.FruitV2;
import com.group.libraryapp.dto.fruit.response.FruitStatList;
import com.group.libraryapp.dto.fruit.response.FruitStatResponse;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Primary
@Repository
public class FruitMemoryRepository implements FruitRepository {

    private List<FruitV2> fruits = new ArrayList<>();

    public FruitMemoryRepository() {
    }

    @Override
    public void saveFruit(String name, LocalDate warehousingDate, long price) {
        fruits.add(new FruitV2(name, warehousingDate, price));
    }

    @Override
    public void updateFruit(long id) {
        int index = Integer.parseInt(String.valueOf(id));
        FruitV2 f = fruits.get(index);
        f.setStatus(2);
        fruits.add(index, f);
    }

    @Override
    public FruitStatResponse getFruitStat(String name) {
        List<FruitStatList> fruitStatLists = new ArrayList<>();
        for (FruitV2 f : fruits) {
            if (f.getName().equals(name)) {
                fruitStatLists.add(new FruitStatList(f.getName(), f.getPrice(), f.getStatus()));
            }
        }

        return new FruitStatResponse(fruitStatLists);
    }

}
