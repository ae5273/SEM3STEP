import java.util.Scanner;

abstract class Vehicle {
    protected final int hours;

    Vehicle(int hours) {
        this.hours = hours;
    }

    abstract double charge();

    abstract String type();
}

class Bike extends Vehicle {
    Bike(int hours) {
        super(hours);
    }

    double charge() {
        return 10.0 * hours;
    }

    String type() {
        return "BIKE";
    }
}

class Car extends Vehicle {
    Car(int hours) {
        super(hours);
    }

    double charge() {
        return 30 + 20.0 * (hours - 1);
    }

    String type() {
        return "CAR";
    }
}

class Truck extends Vehicle {
    Truck(int hours) {
        super(hours);
    }

    double charge() {
        return Math.max(50.0 * hours, 100);
    }

    String type() {
        return "TRUCK";
    }
}

public class CampusParkingCalculator {

    private static Vehicle createVehicle(String type, int hours) {
        switch (type) {
            case "BIKE":
                return new Bike(hours);
            case "CAR":
                return new Car(hours);
            default:
                return new Truck(hours);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();
            Vehicle vehicle = createVehicle(type, hours);
            double charge = vehicle.charge();
            total += charge;
            System.out.printf("%s: %.2f%n", vehicle.type(), charge);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
