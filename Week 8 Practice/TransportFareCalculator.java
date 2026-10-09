import java.util.Scanner;

abstract class Transport {
    protected final double distance;

    Transport(double distance) {
        this.distance = distance;
    }

    abstract double calculateFare();

    abstract String label();
}

class Bus extends Transport {
    Bus(double distance) {
        super(distance);
    }

    double calculateFare() {
        double fare = 2 + 0.10 * distance;
        return Math.min(fare, 10);
    }

    String label() {
        return "BUS";
    }
}

class Train extends Transport {
    Train(double distance) {
        super(distance);
    }

    double calculateFare() {
        return 3 + 0.15 * distance;
    }

    String label() {
        return "TRAIN";
    }
}

class Metro extends Transport {
    private final double peakHourFactor;

    Metro(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    double calculateFare() {
        return (1.50 + 0.20 * distance) * peakHourFactor;
    }

    String label() {
        return "METRO";
    }
}

public class TransportFareCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();

            Transport transport;
            if (type.equals("BUS")) {
                transport = new Bus(distance);
            } else if (type.equals("TRAIN")) {
                transport = new Train(distance);
            } else {
                double factor = sc.nextDouble();
                transport = new Metro(distance, factor);
            }

            double fare = transport.calculateFare();
            total += fare;
            System.out.printf("%s: %.2f%n", transport.label(), fare);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
