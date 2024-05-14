package com.example.maga4.services;

import com.example.maga4.models.Function;

public interface FunctionService {
    Function getFunction(Double aDouble, Double bDouble, Double cDouble);
    Function refresh(Function function);
}
