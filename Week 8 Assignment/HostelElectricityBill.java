import java.util.Scanner;

abstract class Room {
    protected final int units;

    Room(int units) {
        this.units = units;
    }

    abstract double bill();

    abstract String type();
}

class SingleRoom extends Room {
    SingleRoom(int units) {
        super(units);
    }

    double bill() {
        return 8.0 * units;
    }

    String type() {
        return "SINGLE";
    }
}

class SharedRoom extends Room {
    private final int occupants;

    SharedRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    double bill() {
        return 6.0 * units / occupants;
    }

    String type() {
        return "SHARED";
    }
}

class AcRoom extends Room {
    AcRoom(int units) {
        super(units);
    }

    double bill() {
        return 10.0 * units + 200;
    }

    String type() {
        return "AC";
    }
}

public class HostelElectricityBill {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();

            Room room;
            if (type.equals("SINGLE")) {
                room = new SingleRoom(units);
            } else if (type.equals("SHARED")) {
                int occupants = sc.nextInt();
                room = new SharedRoom(units, occupants);
            } else {
                room = new AcRoom(units);
            }

            double bill = room.bill();
            total += bill;
            System.out.printf("%s: %.2f%n", room.type(), bill);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
