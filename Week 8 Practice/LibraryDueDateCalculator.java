import java.time.LocalDate;
import java.util.Scanner;

abstract class LibraryItem {
    protected final String title;

    LibraryItem(String title) {
        this.title = title;
    }

    abstract int getLoanDays();
}

class BookItem extends LibraryItem {
    BookItem(String title) {
        super(title);
    }

    int getLoanDays() {
        return 14;
    }
}

class DvdItem extends LibraryItem {
    DvdItem(String title) {
        super(title);
    }

    int getLoanDays() {
        return 7;
    }
}

class MagazineItem extends LibraryItem {
    MagazineItem(String title) {
        super(title);
    }

    int getLoanDays() {
        return 3;
    }
}

public class LibraryDueDateCalculator {

    private static final LocalDate CURRENT_DATE = LocalDate.of(2023, 10, 26);

    private static LibraryItem createItem(String type, String title) {
        switch (type) {
            case "BOOK":
                return new BookItem(title);
            case "DVD":
                return new DvdItem(title);
            default:
                return new MagazineItem(title);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            int spaceIndex = line.indexOf(' ');
            String type = line.substring(0, spaceIndex);
            String title = line.substring(spaceIndex + 1).trim();

            if (title.startsWith("\"") && title.endsWith("\"")) {
                title = title.substring(1, title.length() - 1);
            }

            LibraryItem item = createItem(type, title);
            LocalDate dueDate = CURRENT_DATE.plusDays(item.getLoanDays());
            System.out.println(item.title + ": " + dueDate);
        }

        sc.close();
    }
}
