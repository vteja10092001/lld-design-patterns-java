package problems.easy.parkingLot.strategies.fee;

import problems.easy.parkingLot.entities.ParkingTicket;

public class FlatRateStrategy implements FeeStrategy {

    private static final double RATE_PER_HOUR = 10.0;

    @Override
    public double getFee(ParkingTicket parkingTicket) {
        double hours = (parkingTicket.getExitTimeStamp() - parkingTicket.getEntryTimeStamp()) / (1000 * 60.0 * 60.0);
        return hours * RATE_PER_HOUR;
    }
}
