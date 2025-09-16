package design_patterns.creational_design_patterns.factory.simple_factory_example;

public class Bike implements Vehicle {
    @Override
    public void start() {
        System.out.println("bike started!");
    }

    @Override
    public void stop() {
        System.out.println("bike stopped!");
    }
}
