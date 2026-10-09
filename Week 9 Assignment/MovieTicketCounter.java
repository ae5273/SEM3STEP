import java.util.Scanner;

abstract class Ticket {
    static final double CONVENIENCE_FEE = 20;

    protected final int count;

    Ticket(int count) {
        this.count = count;
    }

    abstract double seatPrice();

    abstract String type();

    double amount() {
        return (seatPrice() + CONVENIENCE_FEE) * count;
    }
}

class RegularTicket extends Ticket {
    RegularTicket(int count) {
        super(count);
    }

    double seatPrice() {
        return 150;
    }

    String type() {
        return "REGULAR";
    }
}

class PremiumTicket extends Ticket {
    PremiumTicket(int count) {
        super(count);
    }

    double seatPrice() {
        return 250;
    }

    String type() {
        return "PREMIUM";
    }
}

class ReclinerTicket extends Ticket {
    ReclinerTicket(int count) {
        super(count);
    }

    double seatPrice() {
        return 400;
    }

    String type() {
        return "RECLINER";
    }
}

public class MovieTicketCounter {

    private static Ticket createTicket(String type, int count) {
        switch (type) {
            case "REGULAR":
                return new RegularTicket(count);
            case "PREMIUM":
                return new PremiumTicket(count);
            default:
                return new ReclinerTicket(count);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int count = sc.nextInt();
            Ticket ticket = createTicket(type, count);
            double amount = ticket.amount();
            total += amount;
            System.out.printf("%s: %.2f%n", ticket.type(), amount);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
