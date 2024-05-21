package com.group.libraryapp.controller.fruit;


import com.group.libraryapp.dto.fruit.request.FruitAddRequest;
import com.group.libraryapp.dto.fruit.request.FruitEditRequest;
import com.group.libraryapp.dto.fruit.response.FruitCountResponse;
import com.group.libraryapp.dto.fruit.response.FruitListResponse;
import com.group.libraryapp.dto.fruit.response.FruitStatResponse;
import com.group.libraryapp.service.fruit.FruitServiceV2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class FruitController {

    private final FruitServiceV2 fruitService;


    public FruitController(FruitServiceV2 fruitService) {
        this.fruitService = fruitService;
    }

    @PostMapping("/fruit")
    public void saveFruit(@RequestBody FruitAddRequest request) {
        fruitService.saveFruit(request);
    }

    @PutMapping("/fruit")
    public void updateFruit(@RequestBody FruitEditRequest request)  {
        fruitService.updateFruit(request);
    }

    @GetMapping("/fruit/stat")
    public FruitStatResponse getFruitStat(@RequestParam String name) {
        return fruitService.getFruitStatV1(name);
    }


    @GetMapping("/fruit/count")
    public FruitCountResponse getFruitCount(@RequestParam String name) {
        return fruitService.getFruitCount(name);
    }

    @GetMapping("/fruit/list")
    public List<FruitListResponse> getFruitList(@RequestParam String option, @RequestParam long price) {
        return fruitService.getFruitList(option, price);
    }
}
