package design_patterns.creational_design_patterns.factory.simple_factory_example;

public class Car implements Vehicle {

    @Override
    public void start() {
        System.out.println("car started!");
    }

    @Override
    public void stop() {
        System.out.println("car stopped!");
    }
}
