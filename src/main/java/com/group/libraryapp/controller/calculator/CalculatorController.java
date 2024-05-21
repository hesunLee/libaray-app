package com.group.libraryapp.controller.calculator;


import com.group.libraryapp.dto.calculator.request.CalculatorAddRequest;
import com.group.libraryapp.dto.calculator.request.CalculatorMultiplyRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {


    //Use @RequestParam
    @GetMapping("/add") //GET /add
    public int addToNumbers(@RequestParam int number1, @RequestParam  int number2) {
        return number1 + number2;
    }

    //Use Class
    @GetMapping("/add2") //GET /add
    public int addToNumbers2(CalculatorAddRequest request) {
        return request.getNumber1() + request.getNumber2();
    }


    @PostMapping("/multiply")//POST /multiply
    public int multiplyToNumbers(@RequestBody CalculatorMultiplyRequest request) {
        return request.getNumber1() * request.getNumber2();
    }
}
