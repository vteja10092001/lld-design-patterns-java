package problems.easy.parkingLot.strategies.fee;

import problems.easy.parkingLot.entities.ParkingTicket;
import problems.easy.parkingLot.vehicles.Vehicle;

public interface FeeStrategy {
    double getFee(ParkingTicket parkingTicket);
}
