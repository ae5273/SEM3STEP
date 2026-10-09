import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static String playRound(String playerMove, String computerMove) {
        playerMove = playerMove.toLowerCase();
        computerMove = computerMove.toLowerCase();

        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        boolean playerWins =
                (playerMove.equals("rock") && computerMove.equals("scissors")) ||
                (playerMove.equals("paper") && computerMove.equals("rock")) ||
                (playerMove.equals("scissors") && computerMove.equals("paper"));

        return playerWins ? "Player Wins" : "Computer Wins";
    }

    public static void main(String[] args) {
        String[] moves = {"Rock", "Paper", "Scissors"};
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Play interactively? (y/n): ");
        String mode = scanner.nextLine().trim();

        final int N = 5;
        String[][] roundTable = new String[N][4];
        int wins = 0, losses = 0, draws = 0;

        for (int i = 0; i < N; i++) {
            String playerMove;
            if (mode.equalsIgnoreCase("y")) {
                while (true) {
                    System.out.print("Round " + (i + 1) + " - Enter Rock/Paper/Scissors: ");
                    playerMove = scanner.nextLine().trim();
                    if (playerMove.equalsIgnoreCase("Rock")
                            || playerMove.equalsIgnoreCase("Paper")
                            || playerMove.equalsIgnoreCase("Scissors")) {
                        break;
                    }
                    System.out.println("Invalid move. Try again.");
                }
            } else {
                playerMove = moves[random.nextInt(3)];
            }

            String computerMove = moves[random.nextInt(3)];
            String result = playRound(playerMove, computerMove);

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }

            roundTable[i][0] = String.valueOf(i + 1);
            roundTable[i][1] = playerMove;
            roundTable[i][2] = computerMove;
            roundTable[i][3] = result;

            System.out.println("Round " + (i + 1) + " - Player: " + playerMove
                    + ", Computer: " + computerMove + " -> " + result);
        }

        System.out.println();
        System.out.println("Round | Player Move | Computer Move | Result");
        System.out.println("------+--------------+----------------+--------------");
        for (int i = 0; i < N; i++) {
            System.out.printf("%-5s | %-12s | %-14s | %s%n",
                    roundTable[i][0], roundTable[i][1], roundTable[i][2], roundTable[i][3]);
        }

        double winPercentage = (wins * 100.0) / N;
        System.out.println();
        System.out.println("Final Summary (after " + N + " rounds)");
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n",
                wins, losses, draws, winPercentage);

        scanner.close();
    }
}
