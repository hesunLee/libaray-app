package com.group.libraryapp.service.fruit;

import com.group.libraryapp.domain.fruit.Fruit;
import com.group.libraryapp.domain.fruit.FruitRepository;
import com.group.libraryapp.dto.fruit.request.FruitAddRequest;
import com.group.libraryapp.dto.fruit.request.FruitEditRequest;
import com.group.libraryapp.dto.fruit.response.FruitCountResponse;
import com.group.libraryapp.dto.fruit.response.FruitListResponse;
import com.group.libraryapp.dto.fruit.response.FruitStatList;
import com.group.libraryapp.dto.fruit.response.FruitStatResponse;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FruitServiceV2 {

    private final FruitRepository fruitRepository;

    public FruitServiceV2(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Transactional
    public void saveFruit(FruitAddRequest request) {
        Fruit fruit = fruitRepository.save(new Fruit(request));
        fruit.getId();
    }

    @Transactional
    public void updateFruit(FruitEditRequest request) {
        Fruit fruit = fruitRepository.findById(request.getId())
                .orElseThrow(IllegalAccessError::new);

        fruit.updateStatus(2);
    }

    @Transactional(readOnly = true)
    public FruitStatResponse getFruitStatV1(String name) {
        List<FruitStatList> datas = fruitRepository.findByName(name)
                .parallelStream()
                .map(fruit -> new FruitStatList(fruit.getName(), fruit.getPrice(), fruit.getStatus()))
                .collect(Collectors.toList());

        return new FruitStatResponse(datas);
    }

    @Transactional(readOnly = true)
    public FruitCountResponse getFruitCount(String name) {
        return new FruitCountResponse(fruitRepository.countByName(name));
    }

    @Transactional(readOnly = true)
    public List<FruitListResponse> getFruitList(String option, long price) {
        List<Fruit> fruits;

        if (option.equals("GTE")) {
            fruits = fruitRepository.findByPriceGreaterThanEqualAndStatus(price, 2);
        } else if (option.equals("LTE")) {
            fruits = fruitRepository.findByPriceLessThanEqualAndStatus(price, 2);
        } else {
            throw new IllegalArgumentException();
        }

        return fruits.parallelStream().map(f -> new FruitListResponse(f)).collect(Collectors.toList());


    }
}
