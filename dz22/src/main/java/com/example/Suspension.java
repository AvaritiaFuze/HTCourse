package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Suspension {
    private Hinge hinge;
    private Differential differential;

    @Autowired
    public void setHinge(Hinge hinge) {
        this.hinge = hinge;
    }

    @Autowired
    public void setDifferential(Differential differential) {
        this.differential = differential;
    }

    @Override
    public String toString() {
        return "Suspension";
    }
        public String getFullDescription() {
            return "Suspension = " + hinge + ", " + differential;
        }
    }