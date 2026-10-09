public class TrafficSignalStreakAnalyzer {

    public static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.isEmpty()) {
            System.out.println("No signal readings to analyze.");
            return;
        }

        char longestColor = signalLog.charAt(0);
        int longestLength = 0;
        char currentColor = signalLog.charAt(0);
        int currentLength = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == currentColor) {
                currentLength++;
            } else {
                if (currentLength > longestLength) {
                    longestLength = currentLength;
                    longestColor = currentColor;
                }
                currentColor = signalLog.charAt(i);
                currentLength = 1;
            }
        }

        if (currentLength > longestLength) {
            longestLength = currentLength;
            longestColor = currentColor;
        }

        System.out.println("Longest Streak: '" + longestColor + "' repeated " + longestLength + " times");
    }

    public static void main(String[] args) {
        findLongestStreak("RRGGGYRR");
        findLongestStreak("RRRRYYGG");
    }
}
