package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Engine {
    private Starter starter;
    private SparkPlug sparkPlug;

    @Autowired
    public void setStarter(Starter starter) {
        this.starter = starter;
    }

    @Autowired
    public void setSparkPlug(SparkPlug sparkPlug) {
        this.sparkPlug = sparkPlug;
    }

    @Override
    public String toString() {
        return "Engine";
    }
    public String getFullDescription() {
        return "Engine = " + starter + ", " + sparkPlug;
    }
}