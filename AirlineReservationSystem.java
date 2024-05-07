import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class AirlineReservationSystem {

    static class Passenger {
        String name;

        public Passenger(String name) {
            this.name = name;
        }
    }

    static class Flight {
        String flightNumber;
        LinkedList<Passenger> passengers;

        public Flight(String flightNumber) {
            this.flightNumber = flightNumber;
            this.passengers = new LinkedList<>();
        }

        // Adds a passenger in alphabetical order
        void addPassenger(String name) {
            ListIterator<Passenger> iterator = passengers.listIterator();
            while (iterator.hasNext()) {
                if (iterator.next().name.compareToIgnoreCase(name) > 0) {
                    iterator.previous();
                    break;
                }
            }
            iterator.add(new Passenger(name));
        }

        // Removes a passenger
        boolean removePassenger(String name) {
            return passengers.removeIf(p -> p.name.equalsIgnoreCase(name));
        }

        // Checks if a passenger is on this flight
        boolean hasPassenger(String name) {
            return passengers.stream().anyMatch(p -> p.name.equalsIgnoreCase(name));
        }

        // Displays all passengers
        void displayPassengers() {
            if (passengers.isEmpty()) {
                System.out.println("No passengers on flight " + flightNumber);
            } else {
                System.out.println("Passengers on flight " + flightNumber + ":");
                passengers.forEach(p -> System.out.println(p.name));
            }
        }
    }

    private LinkedList<Flight> flights = new LinkedList<>();

    // Adds a flight
    public void addFlight(String flightNumber) {
        flights.add(new Flight(flightNumber));
    }

    // Finds a flight by its number
    private Flight findFlight(String flightNumber) {
        for (Flight flight : flights) {
            if (flight.flightNumber.equalsIgnoreCase(flightNumber)) {
                return flight;
            }
        }
        return null;
    }

    public void reserveTicket(String flightNumber, String passengerName) {
        Flight flight = findFlight(flightNumber);
        if (flight == null) {
            System.out.println("Flight not found.");
        } else {
            flight.addPassenger(passengerName);
            System.out.println("Reservation successful.");
        }
    }

    public void cancelTicket(String flightNumber, String passengerName) {
        Flight flight = findFlight(flightNumber);
        if (flight == null) {
            System.out.println("Flight not found.");
        } else if (flight.removePassenger(passengerName)) {
            System.out.println("Cancellation successful.");
        } else {
            System.out.println("Passenger not found.");
        }
    }

    public void checkReservation(String flightNumber, String passengerName) {
        Flight flight = findFlight(flightNumber);
        if (flight == null) {
            System.out.println("Flight not found.");
        } else if (flight.hasPassenger(passengerName)) {
            System.out.println("Passenger " + passengerName + " is reserved on flight " + flightNumber);
        } else {
            System.out.println("No reservation for " + passengerName + " on flight " + flightNumber);
        }
    }

    public void displayPassengers(String flightNumber) {
        Flight flight = findFlight(flightNumber);
        if (flight == null) {
            System.out.println("Flight not found.");
        } else {
            flight.displayPassengers();
        }
    }

    public static void main(String[] args) {
        AirlineReservationSystem system = new AirlineReservationSystem();
        system.addFlight("AA123");
        system.addFlight("BB456");

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Reserve a ticket");
            System.out.println("2. Cancel a ticket");
            System.out.println("3. Check reservation");
            System.out.println("4. Display passengers");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline left-over

            switch (choice) {
                case 1:
                    System.out.print("Enter flight number: ");
                    String flightNumber = scanner.nextLine();
                    System.out.print("Enter passenger name: ");
                    String passengerName = scanner.nextLine();
                    system.reserveTicket(flightNumber, passengerName);
                    break;
                case 2:
                    System.out.print("Enter flight number: ");
                    flightNumber = scanner.nextLine();
                    System.out.print("Enter passenger name: ");
                    passengerName = scanner.nextLine();
                    system.cancelTicket(flightNumber, passengerName);
                    break;
                case 3:
                    System.out.print("Enter flight number: ");
                    flightNumber = scanner.nextLine();
                    System.out.print("Enter passenger name: ");
                    passengerName = scanner.nextLine();
                    system.checkReservation(flightNumber, passengerName);
                    break;
                case 4:
                    System.out.print("Enter flight number: ");
                    flightNumber = scanner.nextLine();
                    system.displayPassengers(flightNumber);
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }

        scanner.close();
    }
}
