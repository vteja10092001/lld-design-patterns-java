package design_patterns.creational_design_patterns.factory.simple_factory_example;

public class VehicleFactory {

    public static Vehicle getVehicle(VehicleType vehicleType)
    {
        return switch (vehicleType) {
            case BIKE -> new Bike();
            case CAR -> new Car();
        };
    }
}
