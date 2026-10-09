import java.util.Scanner;

abstract class Payment {
    protected final double amount;

    Payment(double amount) {
        this.amount = amount;
    }

    abstract double calculateFinalAmount();

    abstract String label();
}

class CardPayment extends Payment {
    CardPayment(double amount) {
        super(amount);
    }

    double calculateFinalAmount() {
        return amount * 1.02;
    }

    String label() {
        return "CARD";
    }
}

class WalletPayment extends Payment {
    WalletPayment(double amount) {
        super(amount);
    }

    double calculateFinalAmount() {
        return amount * 1.01;
    }

    String label() {
        return "WALLET";
    }
}

class BankTransferPayment extends Payment {
    BankTransferPayment(double amount) {
        super(amount);
    }

    double calculateFinalAmount() {
        return amount;
    }

    String label() {
        return "BANKTRANSFER";
    }
}

public class PaymentSystem {

    private static Payment createPayment(String type, double amount) {
        switch (type) {
            case "CARD":
                return new CardPayment(amount);
            case "WALLET":
                return new WalletPayment(amount);
            default:
                return new BankTransferPayment(amount);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            Payment payment = createPayment(type, amount);
            double adjusted = payment.calculateFinalAmount();
            total += adjusted;
            System.out.printf("%s: %.2f%n", payment.label(), adjusted);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
