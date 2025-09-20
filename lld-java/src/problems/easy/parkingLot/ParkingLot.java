package problems.easy.parkingLot;

import problems.easy.parkingLot.entities.ParkingFloor;
import problems.easy.parkingLot.entities.ParkingSpot;
import problems.easy.parkingLot.entities.ParkingTicket;
import problems.easy.parkingLot.strategies.fee.FeeStrategy;
import problems.easy.parkingLot.strategies.fee.FlatRateStrategy;
import problems.easy.parkingLot.strategies.parking.NearestFitStrategy;
import problems.easy.parkingLot.strategies.parking.ParkingStrategy;
import problems.easy.parkingLot.vehicles.Vehicle;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingLot {

    private static ParkingLot instance;

    private FeeStrategy feeStrategy;
    private ParkingStrategy parkingStrategy;

    List<ParkingFloor> parkingFloors;
    Map<String, ParkingTicket> activeTickets;


    private ParkingLot() {
        feeStrategy = new FlatRateStrategy();
        parkingStrategy = new NearestFitStrategy();

        parkingFloors = new ArrayList<>();
        activeTickets = new ConcurrentHashMap<>();

    }

    public static ParkingLot getInstance() {
        synchronized (ParkingLot.class) {
            if (instance == null) {
                instance = new ParkingLot();
            }
        }

        return instance;
    }

    public void setParkingStrategy(ParkingStrategy parkingStrategy) {
        this.parkingStrategy = parkingStrategy;
    }

    public void setFeeStrategy(FeeStrategy feeStrategy) {
        this.feeStrategy = feeStrategy;
    }

    public void addFloor(ParkingFloor parkingFloor) {
        parkingFloors.add(parkingFloor);
    }

    public Optional<ParkingTicket> parkVehicle(Vehicle vehicle) {

        Optional<ParkingSpot> parkingSpot = parkingStrategy.getParkingSpot(parkingFloors, vehicle);

        if (parkingSpot.isPresent()) {
            ParkingTicket parkingTicket = new ParkingTicket(vehicle, parkingSpot.get());
            activeTickets.put(parkingTicket.getTicketId(), parkingTicket);

            parkingSpot.get().parkVehicle(vehicle);

            return Optional.of(parkingTicket);
        }

        System.out.println("No available spot for " + vehicle.getLicenseNumber());
        return Optional.empty();
    }

    public Optional<Double> unParkVehicle(String ticketId) {
        ParkingTicket parkingTicket = activeTickets.get(ticketId);

        if (parkingTicket == null) {
            System.out.println("Ticket not found.");
            return Optional.empty();
        }

        parkingTicket.setExitTimeStamp();
        parkingTicket.getParkingSpot().unparkVehicle();
        activeTickets.remove(ticketId);

        Double feeDouble = feeStrategy.getFee(parkingTicket);
        return Optional.of(feeDouble);
    }
}
