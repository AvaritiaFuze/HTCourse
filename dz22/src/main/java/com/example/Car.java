package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
    private Wheel wheel;
    private Engine engine;
    private Suspension suspension;
    private Accumulator accumulator;

    @Autowired
    public void setWheel(Wheel wheel) {
        this.wheel = wheel;
    }

    @Autowired
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Autowired
    public void setSuspension(Suspension suspension) {
        this.suspension = suspension;
    }

    @Autowired
    public void setAccumulator(Accumulator accumulator) {
        this.accumulator = accumulator;
    }

    @Override
    public String toString() {
        return "Car = " + wheel + ", " + accumulator + ", " + engine + ", " + suspension;
    }
}