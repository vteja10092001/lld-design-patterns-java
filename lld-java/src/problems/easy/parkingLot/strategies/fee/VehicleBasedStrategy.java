package problems.easy.parkingLot.strategies.fee;

import problems.easy.parkingLot.entities.ParkingTicket;
import problems.easy.parkingLot.vehicles.VehicleSize;

import java.util.Map;

public class VehicleBasedStrategy implements FeeStrategy {

    private static final Map<VehicleSize, Double> HOURLY_RATES = Map.of(
            VehicleSize.SMALL, 5.0,
            VehicleSize.MEDIUM, 10.0,
            VehicleSize.LARGE, 15.0
    );

    @Override
    public double getFee(ParkingTicket parkingTicket) {
        double duration = parkingTicket.getExitTimeStamp() - parkingTicket.getEntryTimeStamp();
        double hours = duration / (1000.0 * 60.0 * 60.0);
        return HOURLY_RATES.get(parkingTicket.getVehicle().getVehicleSize()) * hours;
    }
}
