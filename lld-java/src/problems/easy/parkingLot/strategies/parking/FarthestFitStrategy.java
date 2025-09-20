package problems.easy.parkingLot.strategies.parking;


import problems.easy.parkingLot.entities.ParkingFloor;
import problems.easy.parkingLot.entities.ParkingSpot;
import problems.easy.parkingLot.vehicles.Vehicle;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class FarthestFitStrategy implements ParkingStrategy {
    @Override
    public Optional<ParkingSpot> getParkingSpot(List<ParkingFloor> parkingFloors, Vehicle vehicle) {

        Collections.reverse(parkingFloors);

        for (ParkingFloor floor : parkingFloors) {
            Optional<ParkingSpot> parkingSpot = floor.findAvailableSpot(vehicle);
            if (parkingSpot.isPresent()) {
                return parkingSpot;
            }
        }
        return Optional.empty();
    }
}
