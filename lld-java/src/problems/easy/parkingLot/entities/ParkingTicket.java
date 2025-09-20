package problems.easy.parkingLot.entities;

import problems.easy.parkingLot.vehicles.Vehicle;

import java.util.Date;
import java.util.UUID;

public class ParkingTicket {
    private final String ticketId;
    private final ParkingSpot parkingSpot;
    private final Vehicle vehicle;

    private final long entryTimeStamp;
    private long exitTimeStamp;

    public ParkingTicket(Vehicle vehicle, ParkingSpot parkingSpot) {
        ticketId = UUID.randomUUID().toString();
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;

        entryTimeStamp = new Date().getTime();
    }


    public String getTicketId() {
        return ticketId;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public long getEntryTimeStamp() {
        return entryTimeStamp;
    }

    public long getExitTimeStamp() {
        return exitTimeStamp;
    }

    public void setExitTimeStamp() {
        this.exitTimeStamp = new Date().getTime();
    }
}
