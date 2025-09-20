package problems.easy.parkingLot.entities;

import problems.easy.parkingLot.vehicles.Vehicle;
import problems.easy.parkingLot.vehicles.VehicleSize;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class ParkingFloor {
    private final int floorNumber;
    Map<String, ParkingSpot> parkingSpots;

    public ParkingFloor(int floorNumber) {
        this.floorNumber = floorNumber;
        parkingSpots = new ConcurrentHashMap<>();
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void addParkingSpot(ParkingSpot parkingSpot) {
        if (parkingSpot == null) {
            return;
        }

        parkingSpots.put(parkingSpot.getSpotId(), parkingSpot);
    }

    public synchronized Optional<ParkingSpot> findAvailableSpot(Vehicle vehicle) {
        return parkingSpots.values().stream()
                .filter(spot -> !spot.isOccupied() && spot.canFitVehicle(vehicle))
                .min(Comparator.comparing(ParkingSpot::getVehicleSize));
    }

    public void displayAvailability() {
        System.out.printf("--- Floor %d Availability ---\n", floorNumber);
        Map<VehicleSize, Long> availableCounts = parkingSpots.values().stream()
                .filter(spot -> !spot.isOccupied())
                .collect(Collectors.groupingBy(ParkingSpot::getVehicleSize, Collectors.counting()));

        for (VehicleSize size : VehicleSize.values()) {
            System.out.printf("  %s spots: %d\n", size, availableCounts.getOrDefault(size, 0L));
        }
    }
}
