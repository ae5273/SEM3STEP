public class Scorecard {
    private final boolean[] results;
    private int recorded;

    public Scorecard(int totalQuestions) {
        this.results = new boolean[totalQuestions];
        this.recorded = 0;
    }

    public void recordAnswer(boolean correct) {
        if (recorded < results.length) {
            results[recorded] = correct;
            recorded++;
        } else {
            System.out.println("No more answers can be recorded");
        }
    }

    public int getScore() {
        int score = 0;
        for (int i = 0; i < recorded; i++) {
            if (results[i]) {
                score++;
            }
        }
        return score;
    }

    public int getTotalQuestions() {
        return results.length;
    }

    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);

        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("Score: " + sc.getScore() + " out of " + sc.getTotalQuestions());
    }
}
