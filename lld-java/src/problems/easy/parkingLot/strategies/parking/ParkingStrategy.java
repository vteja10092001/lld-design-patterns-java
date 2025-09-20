package problems.easy.parkingLot.strategies.parking;

import problems.easy.parkingLot.entities.ParkingFloor;
import problems.easy.parkingLot.entities.ParkingSpot;
import problems.easy.parkingLot.vehicles.Vehicle;

import java.util.List;
import java.util.Optional;

public interface ParkingStrategy {
    Optional<ParkingSpot> getParkingSpot(List<ParkingFloor> parkingFloors, Vehicle vehicle);
}
