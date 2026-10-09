import java.util.Scanner;

interface Insurable {
    double insurance();
}

abstract class Parcel {
    protected final double weightKg;
    protected final double declaredValue;

    Parcel(double weightKg, double declaredValue) {
        this.weightKg = weightKg;
        this.declaredValue = declaredValue;
    }

    abstract double charge();

    abstract String type();
}

class StandardParcel extends Parcel {
    StandardParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    double charge() {
        return 40 + 10 * weightKg;
    }

    String type() {
        return "STANDARD";
    }
}

class ExpressParcel extends Parcel implements Insurable {
    ExpressParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    double charge() {
        return 80 + 15 * weightKg;
    }

    public double insurance() {
        return 0.02 * declaredValue;
    }

    String type() {
        return "EXPRESS";
    }
}

class FragileParcel extends Parcel implements Insurable {
    FragileParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    double charge() {
        return 40 + 10 * weightKg + 50;
    }

    public double insurance() {
        return 0.02 * declaredValue;
    }

    String type() {
        return "FRAGILE";
    }
}

public class ParcelShippingDesk {

    private static Parcel createParcel(String type, double weight, double value) {
        switch (type) {
            case "STANDARD":
                return new StandardParcel(weight, value);
            case "EXPRESS":
                return new ExpressParcel(weight, value);
            default:
                return new FragileParcel(weight, value);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();

            Parcel parcel = createParcel(type, weight, value);
            double charge = parcel.charge();
            double insurance = (parcel instanceof Insurable)
                    ? ((Insurable) parcel).insurance()
                    : 0;
            double total = charge + insurance;
            grandTotal += total;

            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    parcel.type(), charge, insurance, total);
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);
        sc.close();
    }
}
