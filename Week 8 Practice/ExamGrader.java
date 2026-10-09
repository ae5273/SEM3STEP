import java.util.Scanner;

abstract class Question {
    protected final String questionText;
    protected final String correctAnswer;
    protected final double points;

    Question(String questionText, String correctAnswer, double points) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.points = points;
    }

    abstract double grade(String studentAnswer);

    abstract String label();
}

class McqQuestion extends Question {
    McqQuestion(String questionText, String correctAnswer, double points) {
        super(questionText, correctAnswer, points);
    }

    double grade(String studentAnswer) {
        return studentAnswer.equals(correctAnswer) ? points : 0;
    }

    String label() {
        return "MCQ";
    }
}

class TrueFalseQuestion extends Question {
    TrueFalseQuestion(String questionText, String correctAnswer, double points) {
        super(questionText, correctAnswer, points);
    }

    double grade(String studentAnswer) {
        return studentAnswer.equals(correctAnswer) ? points : 0;
    }

    String label() {
        return "TF";
    }
}

class EssayQuestion extends Question {
    EssayQuestion(String questionText, String correctAnswer, double points) {
        super(questionText, correctAnswer, points);
    }

    double grade(String studentAnswer) {
        String[] keywords = correctAnswer.split(",");
        String lowerAnswer = studentAnswer.toLowerCase();
        int matched = 0;

        for (String keyword : keywords) {
            String cleaned = keyword.trim().toLowerCase();
            if (!cleaned.isEmpty() && lowerAnswer.contains(cleaned)) {
                matched++;
            }
        }

        if (matched >= 2) {
            return points * 0.75;
        } else if (matched == 1) {
            return points * 0.50;
        }
        return 0;
    }

    String label() {
        return "ESSAY";
    }
}

public class ExamGrader {

    private static Question createQuestion(String type, String text, String correct, double points) {
        switch (type) {
            case "MCQ":
                return new McqQuestion(text, correct, points);
            case "TF":
                return new TrueFalseQuestion(text, correct, points);
            default:
                return new EssayQuestion(text, correct, points);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        double totalScore = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            int firstQuote = line.indexOf('"');
            String type = line.substring(0, firstQuote).trim();

            java.util.List<String> quoted = new java.util.ArrayList<>();
            java.util.regex.Matcher matcher =
                    java.util.regex.Pattern.compile("\"([^\"]*)\"").matcher(line);
            while (matcher.find()) {
                quoted.add(matcher.group(1));
            }

            String trailing = line.substring(line.lastIndexOf('"') + 1).trim();
            double points = Double.parseDouble(trailing);

            String questionText = quoted.get(0);
            String correctAnswer = quoted.get(1);
            String studentAnswer = quoted.get(2);

            Question question = createQuestion(type, questionText, correctAnswer, points);
            double score = question.grade(studentAnswer);
            totalScore += score;
            System.out.printf("%s: %.2f%n", question.label(), score);
        }

        System.out.printf("Total Score: %.2f%n", totalScore);
        sc.close();
    }
}
