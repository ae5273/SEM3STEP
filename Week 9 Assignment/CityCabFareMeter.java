import java.util.Scanner;

interface NightService {
}

abstract class Cab {
    static final double MINIMUM_FARE = 100;

    protected final double km;

    Cab(double km) {
        this.km = km;
    }

    abstract double rate();

    abstract String type();

    double baseFare() {
        return Math.max(km * rate(), MINIMUM_FARE);
    }

    boolean supportsNight() {
        return this instanceof NightService;
    }
}

class MiniCab extends Cab {
    MiniCab(double km) {
        super(km);
    }

    double rate() {
        return 10;
    }

    String type() {
        return "MINI";
    }
}

class SedanCab extends Cab implements NightService {
    SedanCab(double km) {
        super(km);
    }

    double rate() {
        return 14;
    }

    String type() {
        return "SEDAN";
    }
}

class SuvCab extends Cab implements NightService {
    SuvCab(double km) {
        super(km);
    }

    double rate() {
        return 18;
    }

    String type() {
        return "SUV";
    }
}

public class CityCabFareMeter {

    private static Cab createCab(String type, double km) {
        switch (type) {
            case "MINI":
                return new MiniCab(km);
            case "SEDAN":
                return new SedanCab(km);
            default:
                return new SuvCab(km);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            Cab cab = createCab(type, km);
            boolean night = time.equals("NIGHT");

            if (night && !cab.supportsNight()) {
                System.out.println(cab.type() + ": night service not available");
                continue;
            }

            double fare = cab.baseFare();
            if (night) {
                fare *= 1.20;
            }

            total += fare;
            System.out.printf("%s: %.2f%n", cab.type(), fare);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
