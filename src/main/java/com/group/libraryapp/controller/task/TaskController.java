package com.group.libraryapp.controller.task;


import com.group.libraryapp.dto.task.reqeust.CalculatorCompoundRequest;
import com.group.libraryapp.dto.task.reqeust.CalculatorSumRequest;
import com.group.libraryapp.dto.task.response.CalculatorCompoundResponse;
import com.group.libraryapp.dto.task.response.DayOfTheWeekResponse;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;


@RestController
public class TaskController {

    @GetMapping("/api/v1/calc")
    public CalculatorCompoundResponse getCalcCompound(CalculatorCompoundRequest request) {
        return new CalculatorCompoundResponse(request);
    }


    @GetMapping("/api/v1/day")
    public DayOfTheWeekResponse getDayOfTheWeek(@RequestParam String date) {
        return new DayOfTheWeekResponse(date);
    }

    @PostMapping("/api/v1/sum")
    public int getCalcSum(@RequestBody CalculatorSumRequest request) {
        return request.getNumbers().stream().reduce(0, (a, b) -> a + b);
    }
}
