package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example")
public class AppConfig {

    @Bean
    public Wheel wheel() {
        return new Wheel();
    }

    @Bean
    public Starter starter() {
        return new Starter();
    }

    @Bean
    public SparkPlug sparkPlug() {
        return new SparkPlug();
    }

    @Bean
    public Accumulator accumulator() {
        return new Accumulator();
    }

    @Bean
    public Hinge hinge() {
        return new Hinge();
    }

    @Bean
    public Differential differential() {
        return new Differential();
    }

    @Bean
    public Suspension suspension() {
        Suspension suspension = new Suspension();
        suspension.setHinge(hinge());
        return suspension;
    }

    @Bean
    public Engine engine() {
        Engine engine = new Engine();
        engine.setStarter(starter());
        engine.setSparkPlug(sparkPlug());
        return engine;
    }

    @Bean
    public Car car() {
        Car car = new Car();
        car.setWheel(wheel());
        car.setEngine(engine());
        car.setSuspension(suspension());
        car.setAccumulator(accumulator());
        return car;
    }
}