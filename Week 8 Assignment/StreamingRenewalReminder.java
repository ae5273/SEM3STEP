import java.time.LocalDate;
import java.util.Scanner;

abstract class Plan {
    protected final LocalDate startDate;

    Plan(LocalDate startDate) {
        this.startDate = startDate;
    }

    abstract int validityDays();
}

class BasicPlan extends Plan {
    BasicPlan(LocalDate startDate) {
        super(startDate);
    }

    int validityDays() {
        return 30;
    }
}

class StandardPlan extends Plan {
    StandardPlan(LocalDate startDate) {
        super(startDate);
    }

    int validityDays() {
        return 90;
    }
}

class PremiumPlan extends Plan {
    PremiumPlan(LocalDate startDate) {
        super(startDate);
    }

    int validityDays() {
        return 365;
    }
}

public class StreamingRenewalReminder {

    private static Plan createPlan(String type, LocalDate startDate) {
        switch (type) {
            case "BASIC":
                return new BasicPlan(startDate);
            case "STANDARD":
                return new StandardPlan(startDate);
            default:
                return new PremiumPlan(startDate);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate startDate = LocalDate.parse(sc.next());

            Plan plan = createPlan(type, startDate);
            LocalDate renewalDate = startDate.plusDays(plan.validityDays());
            System.out.println(name + ": " + renewalDate);
        }

        sc.close();
    }
}
