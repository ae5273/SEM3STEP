import java.util.Scanner;

abstract class Employee {
    protected final String name;
    protected final double monthlySalary;

    Employee(String name, double monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    abstract double bonus();
}

class FullTimeEmployee extends Employee {
    FullTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    double bonus() {
        return monthlySalary * 0.10;
    }
}

class PartTimeEmployee extends Employee {
    PartTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    double bonus() {
        return monthlySalary * 0.05;
    }
}

class Intern extends Employee {
    Intern(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    double bonus() {
        return 2000;
    }
}

public class FestivalBonusCalculator {

    private static Employee createEmployee(String type, String name, double salary) {
        switch (type) {
            case "FULLTIME":
                return new FullTimeEmployee(name, salary);
            case "PARTTIME":
                return new PartTimeEmployee(name, salary);
            default:
                return new Intern(name, salary);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double totalBonus = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            Employee employee = createEmployee(type, name, salary);
            double bonus = employee.bonus();
            totalBonus += bonus;
            System.out.printf("%s: %.2f%n", employee.name, bonus);
        }

        System.out.printf("Total Bonus: %.2f%n", totalBonus);
        sc.close();
    }
}
