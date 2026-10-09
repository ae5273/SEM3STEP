import java.util.Scanner;

interface BusUser {
}

abstract class Student {
    protected final String name;

    Student(String name) {
        this.name = name;
    }

    abstract double tuition();
}

class DayScholar extends Student implements BusUser {
    DayScholar(String name) {
        super(name);
    }

    double tuition() {
        return 40000;
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }

    double tuition() {
        return 40000 + 60000;
    }
}

class Scholar extends Student implements BusUser {
    Scholar(String name) {
        super(name);
    }

    double tuition() {
        return 20000;
    }
}

public class CollegeFeeCounter {

    private static final double TRANSPORT_FEE = 12000;

    private static Student createStudent(String type, String name) {
        switch (type) {
            case "DAY_SCHOLAR":
                return new DayScholar(name);
            case "HOSTELLER":
                return new Hosteller(name);
            default:
                return new Scholar(name);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double totalCollected = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            Student student = createStudent(type, name);

            double fee = student.tuition();
            if (student instanceof BusUser) {
                fee += TRANSPORT_FEE;
            }

            totalCollected += fee;
            System.out.printf("%s: %.2f%n", student.name, fee);
        }

        System.out.printf("Total Collected: %.2f%n", totalCollected);
        sc.close();
    }
}
