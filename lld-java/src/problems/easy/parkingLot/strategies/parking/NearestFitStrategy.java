package problems.easy.parkingLot.strategies.parking;

import problems.easy.parkingLot.entities.ParkingFloor;
import problems.easy.parkingLot.entities.ParkingSpot;
import problems.easy.parkingLot.vehicles.Vehicle;

import java.util.List;
import java.util.Optional;

public class NearestFitStrategy implements ParkingStrategy {
    @Override
    public Optional<ParkingSpot> getParkingSpot(List<ParkingFloor> parkingFloors, Vehicle vehicle) {
        for (ParkingFloor parkingFloor : parkingFloors) {
            Optional<ParkingSpot> parkingSpot = parkingFloor.findAvailableSpot(vehicle);
            if (parkingSpot.isPresent()) {
                return parkingSpot;
            }
        }
        return Optional.empty();
    }
}
