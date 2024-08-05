package com.group.library_app.controller.calculator;

import com.group.library_app.dto.calculator.request.CalculatorAddRequest;
import com.group.library_app.dto.calculator.request.CalculatorMulti;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {
    @GetMapping("/add")
    public int addToNumbers(CalculatorAddRequest request) {
        return  request.getNumber1() + request.getNumber2();
    }

    @PostMapping("/multi")
    public int multi(@RequestBody CalculatorMulti request) {
        return request.getNumber1() * request.getNumber2();
    }


}
