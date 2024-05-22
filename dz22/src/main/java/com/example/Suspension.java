package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Suspension {
    private Hinge hinge;

    @Autowired
    public void setHinge(Hinge hinge) {
        this.hinge = hinge;
    }

    @Override
    public String toString() {
        return "Suspension with " + hinge;
    }
}