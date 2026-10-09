public class MatchDayGridAnalyzer {

    static double rowAverage(int[] row) {
        int sum = 0;
        for (int runs : row) {
            sum += runs;
        }
        return (double) sum / row.length;
    }

    static String classifyMatches(int[][] runsPerOver, int threshold) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < runsPerOver.length; i++) {
            if (i > 0) {
                result.append(" | ");
            }
            String label = rowAverage(runsPerOver[i]) >= threshold ? "Power Surge" : "Normal";
            result.append("Match ").append(i).append(": ").append(label);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int[][] grid = {
                {4, 6, 8},
                {10, 12, 14},
                {2, 3, 1}
        };
        System.out.println(classifyMatches(grid, 8));
    }
}
