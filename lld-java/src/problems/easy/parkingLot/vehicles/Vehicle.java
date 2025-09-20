package problems.easy.parkingLot.vehicles;

public abstract class Vehicle {
    private final VehicleSize vehicleSize;
    private final String licenseNumber;

    public Vehicle(VehicleSize size, String licenseNumber) {
        this.vehicleSize = size;
        this.licenseNumber = licenseNumber;
    }


    public VehicleSize getVehicleSize() {
        return vehicleSize;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }
}
