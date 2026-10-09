public class BankReferenceValidator {

    public static String normalizeReference(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    public static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: reference must be exactly 14 characters";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: body must be 11 digits";
            }
        }

        String bankCode = reference.substring(0, 3);
        String date = reference.substring(3, 9);
        String sequence = reference.substring(9, 14);
        String formattedDate = date.substring(0, 2) + "/" + date.substring(2, 4) + "/" + date.substring(4, 6);

        StringBuilder display = new StringBuilder();
        display.append("[").append(bankCode).append("]")
                .append(" DATE: ").append(formattedDate)
                .append(" | SEQ: ").append(sequence);
        return display.toString();
    }

    public static void main(String[] args) {
        String[] rawReferences = {
                "  hdf03022600042  ",
                "12F03022600042"
        };

        for (String raw : rawReferences) {
            String normalized = normalizeReference(raw);
            System.out.println(validateAndFormat(normalized));
        }
    }
}
