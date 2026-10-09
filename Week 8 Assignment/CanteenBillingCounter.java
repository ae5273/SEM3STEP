import java.util.Scanner;

abstract class Customer {
    protected final double billAmount;

    Customer(double billAmount) {
        this.billAmount = billAmount;
    }

    abstract double finalAmount();

    abstract String type();
}

class Student extends Customer {
    Student(double billAmount) {
        super(billAmount);
    }

    double finalAmount() {
        return billAmount * 0.90;
    }

    String type() {
        return "STUDENT";
    }
}

class Staff extends Customer {
    Staff(double billAmount) {
        super(billAmount);
    }

    double finalAmount() {
        return billAmount * 0.95;
    }

    String type() {
        return "STAFF";
    }
}

class Guest extends Customer {
    Guest(double billAmount) {
        super(billAmount);
    }

    double finalAmount() {
        return billAmount + 10;
    }

    String type() {
        return "GUEST";
    }
}

public class CanteenBillingCounter {

    private static Customer createCustomer(String type, double amount) {
        switch (type) {
            case "STUDENT":
                return new Student(amount);
            case "STAFF":
                return new Staff(amount);
            default:
                return new Guest(amount);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            Customer customer = createCustomer(type, amount);
            double finalAmount = customer.finalAmount();
            total += finalAmount;
            System.out.printf("%s: %.2f%n", customer.type(), finalAmount);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
