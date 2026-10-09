public class PalindromeChecker {

    public static boolean isPalindromeIterative(String text) {
        String s = normalize(text);
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        return checkRecursive(normalize(text), 0, normalize(text).length() - 1);
    }

    private static boolean checkRecursive(String s, int left, int right) {
        if (left >= right) {
            return true;
        }
        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }
        return checkRecursive(s, left + 1, right - 1);
    }

    public static boolean isPalindromeArrayReversal(String text) {
        String s = normalize(text);
        char[] chars = s.toCharArray();
        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        String reversed = new String(chars);
        return s.equals(reversed);
    }

    private static String normalize(String text) {
        return text.toLowerCase().replaceAll("[^a-z0-9]", "");
    }

    public static void main(String[] args) {
        String[] tests = {"madam", "hello", "A man a plan a canal Panama"};
        for (String t : tests) {
            boolean iter = isPalindromeIterative(t);
            boolean rec = isPalindromeRecursive(t);
            boolean arr = isPalindromeArrayReversal(t);
            System.out.println("\"" + t + "\"");
            System.out.println("Iterative: " + (iter ? "Palindrome" : "Not Palindrome")
                    + " | Recursive: " + (rec ? "Palindrome" : "Not Palindrome")
                    + " | Array Reversal: " + (arr ? "Palindrome" : "Not Palindrome"));
        }
    }
}
