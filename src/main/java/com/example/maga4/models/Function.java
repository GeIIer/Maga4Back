package com.example.maga4.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
public class Function {
    private double aDouble;
    private double bDouble;
    private double cDouble;
    private List<Dot> dots;

    public Function(Double aDouble, Double bDouble, Double cDouble) {
        this.aDouble = aDouble;
        this.bDouble = bDouble;
        this.cDouble = cDouble;
        initializationDots(-25, 25);
    }

    public Function(Double aDouble, Double bDouble, Double cDouble, List<Dot> dotList) {
        this.aDouble = aDouble;
        this.bDouble = bDouble;
        this.cDouble = cDouble;
        initializationDots(dotList);
    }

    private void initializationDots(int leftBound, int rightBound) {
        this.dots = new ArrayList<>();
        if (leftBound > rightBound) {
            int temp = rightBound;
            rightBound = leftBound;
            leftBound = temp;
        }
        for (int x = leftBound; x < rightBound; x++) {
            double y = aDouble * Math.pow(x, 2) + bDouble * x + cDouble;
            dots.add(new Dot(x, y));
        }
    }

    private void initializationDots(List<Dot> dotList) {
        this.dots = new ArrayList<>();
        for (int i = 0; i < dotList.size(); i++) {
            double x = dotList.get(i).getX();
            double y = aDouble * Math.pow(x, 2) + bDouble * x + cDouble;
            dots.add(new Dot(x, y));
        }
    }
}
