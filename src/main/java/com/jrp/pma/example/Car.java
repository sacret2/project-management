package com.jrp.pma.example;

public class Car {
    private Engine engine;
    private Doors doors;

    public Car(Engine engine, Doors doors) {
        this.engine = engine;
        this.doors = doors;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Doors getDoors() {
        return doors;
    }

    public void setDoors(Doors doors) {
        this.doors = doors;
    }
}
