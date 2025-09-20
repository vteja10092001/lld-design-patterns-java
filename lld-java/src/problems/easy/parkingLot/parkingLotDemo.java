package problems.easy.parkingLot;

import problems.easy.parkingLot.entities.ParkingFloor;
import problems.easy.parkingLot.entities.ParkingSpot;
import problems.easy.parkingLot.entities.ParkingTicket;
import problems.easy.parkingLot.strategies.fee.VehicleBasedStrategy;
import problems.easy.parkingLot.vehicles.Bike;
import problems.easy.parkingLot.vehicles.Car;
import problems.easy.parkingLot.vehicles.Vehicle;
import problems.easy.parkingLot.vehicles.VehicleSize;

import java.util.Optional;

public class parkingLotDemo {

    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getInstance();

        // 1. Initialize the parking lot with floors and spots
        ParkingFloor floor1 = new ParkingFloor(1);
        floor1.addParkingSpot(new ParkingSpot("F1-S1", VehicleSize.SMALL));
        floor1.addParkingSpot(new ParkingSpot("F1-M1", VehicleSize.MEDIUM));
        floor1.addParkingSpot(new ParkingSpot("F1-L1", VehicleSize.LARGE));

        ParkingFloor floor2 = new ParkingFloor(2);
        floor2.addParkingSpot(new ParkingSpot("F2-M1", VehicleSize.MEDIUM));
        floor2.addParkingSpot(new ParkingSpot("F2-M2", VehicleSize.MEDIUM));

        parkingLot.addFloor(floor1);
        parkingLot.addFloor(floor2);

        parkingLot.setFeeStrategy(new VehicleBasedStrategy());

        // 2. Simulate vehicle entries
        System.out.println("\n--- Vehicle Entries ---");
        floor1.displayAvailability();
        floor2.displayAvailability();

        Vehicle bike = new Bike("B-123");
        Vehicle car = new Car("C-456");

        Optional<ParkingTicket> bikeTicketOpt = parkingLot.parkVehicle(bike);

        Optional<ParkingTicket> carTicketOpt = parkingLot.parkVehicle(car);


        System.out.println("\n--- Availability after parking ---");
        floor1.displayAvailability();
        floor2.displayAvailability();

        // 3. Simulate another car entry (should go to floor 2)
        Vehicle car2 = new Car("C-999");
        Optional<ParkingTicket> car2TicketOpt = parkingLot.parkVehicle(car2);

        // 4. Simulate a vehicle entry that fails (no available spots)
        Vehicle bike2 = new Bike("B-000");
        Optional<ParkingTicket> failedBikeTicketOpt = parkingLot.parkVehicle(bike2);

        // 5. Simulate vehicle exits and fee calculation
        System.out.println("\n--- Vehicle Exits ---");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (carTicketOpt.isPresent()) {
            Optional<Double> feeOpt = parkingLot.unParkVehicle(carTicketOpt.get().getTicketId());
            feeOpt.ifPresent(fee -> System.out.printf("Car C-456 unparked. Fee: $%.2f\n", fee));
        }

        System.out.println("\n--- Availability after one car leaves ---");
        floor1.displayAvailability();
        floor2.displayAvailability();
    }
}
