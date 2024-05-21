package com.group.libraryapp.service.fruit;

import com.group.libraryapp.dto.fruit.request.FruitAddRequest;
import com.group.libraryapp.dto.fruit.request.FruitEditRequest;
import com.group.libraryapp.dto.fruit.response.FruitStatResponse;
import com.group.libraryapp.repository.fruit.FruitRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FruitServiceV1 {

    private final FruitRepository fruitRepository;

    public FruitServiceV1(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Transactional
    public void saveFruit(FruitAddRequest request) {
        fruitRepository.saveFruit(request.getName(), request.getWarehousingDate(), request.getPrice());
    }

    @Transactional
    public void updateFruit(FruitEditRequest request) {
        fruitRepository.updateFruit(request.getId());
    }

    @Transactional(readOnly = true)
    public FruitStatResponse getFruitStatV1(String name) {
        return fruitRepository.getFruitStat(name);
    }

}
