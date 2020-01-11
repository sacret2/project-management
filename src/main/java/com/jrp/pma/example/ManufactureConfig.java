package com.jrp.pma.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ManufactureConfig {
    @Bean
    public Car newCar(){
        Engine e = new Engine();
        Doors d = new Doors();

        return new Car(e,d);
    }
}
