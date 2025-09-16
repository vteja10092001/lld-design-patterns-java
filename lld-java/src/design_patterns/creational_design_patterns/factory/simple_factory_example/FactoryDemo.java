package design_patterns.creational_design_patterns.factory.simple_factory_example;

public class FactoryDemo {
    public static void main(String[] args) {
        Vehicle car = VehicleFactory.getVehicle(VehicleType.CAR);
        car.start();
        car.stop();

        Vehicle bike = VehicleFactory.getVehicle(VehicleType.BIKE);
        bike.start();
        bike.stop();
    }
}