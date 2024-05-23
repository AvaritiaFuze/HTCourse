package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAnnotationConfig {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Car car = context.getBean(Car.class);
        System.out.println(car);

        Engine engine = context.getBean(Engine.class);
        System.out.println(engine.getFullDescription());

        Suspension suspension = context.getBean(Suspension.class);
        System.out.println(suspension.getFullDescription());
    }
}