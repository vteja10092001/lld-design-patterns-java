package problems.easy.parkingLot.entities;

import problems.easy.parkingLot.vehicles.Vehicle;
import problems.easy.parkingLot.vehicles.VehicleSize;

public class ParkingSpot {
    private final String spotId;
    private final VehicleSize vehicleSize;
    private boolean isOccupied;
    private Vehicle parkedVehicle;

    public ParkingSpot(String spotId, VehicleSize vehicleSize) {
        this.spotId = spotId;
        this.vehicleSize = vehicleSize;
        isOccupied = false;
        parkedVehicle = null;
    }

    public VehicleSize getVehicleSize() {
        return vehicleSize;
    }

    public String getSpotId() {
        return spotId;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public boolean canFitVehicle(Vehicle vehicle) {
        return vehicle != null && vehicle.getVehicleSize() == getVehicleSize();
    }

    public synchronized void parkVehicle(Vehicle vehicle) {
        parkedVehicle = vehicle;
        isOccupied = true;
    }

    public synchronized void unparkVehicle() {
        parkedVehicle = null;
        isOccupied = false;
    }
}
