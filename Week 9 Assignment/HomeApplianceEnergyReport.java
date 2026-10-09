import java.util.Scanner;

interface SaverMode {
}

abstract class Appliance {
    protected final int hours;

    Appliance(int hours) {
        this.hours = hours;
    }

    abstract int powerWatts();

    abstract String type();

    boolean supportsSaver() {
        return this instanceof SaverMode;
    }

    double units(boolean saver) {
        double units = powerWatts() * hours / 1000.0;
        if (saver) {
            units *= 0.75;
        }
        return units;
    }
}

class Fridge extends Appliance {
    Fridge(int hours) {
        super(hours);
    }

    int powerWatts() {
        return 150;
    }

    String type() {
        return "FRIDGE";
    }
}

class AirConditioner extends Appliance implements SaverMode {
    AirConditioner(int hours) {
        super(hours);
    }

    int powerWatts() {
        return 1500;
    }

    String type() {
        return "AC";
    }
}

class Television extends Appliance {
    Television(int hours) {
        super(hours);
    }

    int powerWatts() {
        return 100;
    }

    String type() {
        return "TV";
    }
}

class WashingMachine extends Appliance implements SaverMode {
    WashingMachine(int hours) {
        super(hours);
    }

    int powerWatts() {
        return 500;
    }

    String type() {
        return "WASHER";
    }
}

public class HomeApplianceEnergyReport {

    private static final double RATE_PER_UNIT = 8;

    private static Appliance createAppliance(String type, int hours) {
        switch (type) {
            case "FRIDGE":
                return new Fridge(hours);
            case "AC":
                return new AirConditioner(hours);
            case "TV":
                return new Television(hours);
            default:
                return new WashingMachine(hours);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();
            boolean saver = sc.hasNext("SAVER");
            if (saver) {
                sc.next();
            }

            Appliance appliance = createAppliance(type, hours);

            if (saver && !appliance.supportsSaver()) {
                System.out.println(appliance.type() + ": saver mode not supported");
                continue;
            }

            double units = appliance.units(saver);
            double cost = units * RATE_PER_UNIT;
            totalCost += cost;
            System.out.printf("%s: Units=%.2f Cost=%.2f%n", appliance.type(), units, cost);
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}
