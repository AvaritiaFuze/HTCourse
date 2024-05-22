package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Engine {
    private Starter starter;
    private SparkPlug sparkPlug;
    private Accumulator accumulator;

    @Autowired
    public void setStarter(Starter starter) {
        this.starter = starter;
    }

    @Autowired
    public void setSparkPlug(SparkPlug sparkPlug) {
        this.sparkPlug = sparkPlug;
    }

    @Autowired
    public void setAccumulator(Accumulator accumulator) {
        this.accumulator = accumulator;
    }

    @Override
    public String toString() {
        return "Engine with " + starter + ", " + sparkPlug + " and " + accumulator;
    }
}