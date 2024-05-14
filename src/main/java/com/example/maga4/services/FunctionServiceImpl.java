package com.example.maga4.services;

import com.example.maga4.models.Function;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class FunctionServiceImpl implements FunctionService {
    @Override
    public Function getFunction(Double aDouble, Double bDouble, Double cDouble) {
        this.validate(aDouble, bDouble, cDouble);
        return new Function(aDouble, bDouble, cDouble);
    }

    @Override
    public Function refresh(Function function) {
        if(function != null && function.getDots() != null && !function.getDots().isEmpty()) {
            return new Function(function.getADouble(), function.getBDouble(), function.getCDouble(), function.getDots());
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ошибка");
    }

    private void validate(Double aDouble, Double bDouble, Double cDouble) {
        if (aDouble == null) {
            aDouble = 1.0;
        }
        if (bDouble == null) {
            bDouble = 1.0;
        }
        if (cDouble == null) {
            cDouble = 1.0;
        }
    }
}
