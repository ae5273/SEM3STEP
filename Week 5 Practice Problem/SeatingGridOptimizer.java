public class SeatingGridOptimizer {

    static double rowAverage(int[] row) {
        int sum = 0;
        for (int value : row) {
            sum += value;
        }
        return (double) sum / row.length;
    }

    static String classifyRows(int[][] seatingScores, int threshold) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < seatingScores.length; i++) {
            if (i > 0) {
                result.append(" | ");
            }
            String zone = rowAverage(seatingScores[i]) < threshold ? "Quiet Zone" : "Buzzing Zone";
            result.append("Row ").append(i).append(": ").append(zone);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int[][] grid = {
                {40, 50, 45},
                {85, 90, 95},
                {30, 20, 25}
        };
        System.out.println(classifyRows(grid, 60));
    }
}
