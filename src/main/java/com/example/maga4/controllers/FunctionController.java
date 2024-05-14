package com.example.maga4.controllers;

import com.example.maga4.models.Function;
import com.example.maga4.services.FunctionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/function")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200/")
public class FunctionController {
    private final FunctionService functionService;

    @GetMapping()
    public Function getFunction(@RequestParam(required = false) Double aDouble,
                                @RequestParam(required = false) Double bDouble,
                                @RequestParam(required = false) Double cDouble) {
        return functionService.getFunction(aDouble, bDouble, cDouble);
    }

    @PostMapping()
    public Function refresh(@RequestBody Function function) {
        return functionService.refresh(function);
    }
}
