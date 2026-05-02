import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Bingo {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char choice;
        do {
            System.out.println("Type 'Start' to generate the Bingo card");
            String start = in.next();

            if (start.equalsIgnoreCase("Start")) {
                playBingo(in);
            } else {
                System.out.println("Try Again");
            }

            System.out.print("\nWant to play again? (Yes(Y) | No(N)): ");
            choice = in.next().charAt(0);
        } while (choice == 'Y' || choice == 'y');
        System.out.println("Thanks for playing!");
        in.close();
    }

    public static void playBingo(Scanner in) {
        int[][] card = generateBingoCard();
        boolean[][] marked = new boolean[5][5];
        marked[2][2] = true; // FREE space

        List<Integer> pool = new ArrayList<>();
        for (int i = 1; i <= 75; i++) {
            pool.add(i);
        }
        Collections.shuffle(pool);

        int drawIndex = 0;
        boolean hasWon = false;

        printCard(card, marked);

        while (!hasWon && drawIndex < pool.size()) {
            System.out.println("\nPress '1' to draw a number, or any other key to quit this game:");
            String key = in.next();
            if (!key.equals("1")) break;

            int drawn = pool.get(drawIndex++);
            char letter = getBingoLetter(drawn);
            System.out.println("\n----------------------------");
            System.out.println("Drawn number: " + letter + "-" + drawn);
            System.out.println("----------------------------");

            // Mark the card if the number exists
            markCard(card, marked, drawn);
            printCard(card, marked);

            if (checkWin(marked)) {
                System.out.println("\n****************************");
                System.out.println("*         BINGO!           *");
                System.out.println("*      YOU WON THE GAME    *");
                System.out.println("****************************");
                hasWon = true;
            }
        }

        if (!hasWon && drawIndex >= pool.size()) {
            System.out.println("All numbers have been drawn. No more moves!");
        }
    }

    public static int[][] generateBingoCard() {
        int[][] card = new int[5][5];
        int[][] ranges = {{1, 15}, {16, 30}, {31, 45}, {46, 60}, {61, 75}};

        for (int col = 0; col < 5; col++) {
            List<Integer> columnNumbers = new ArrayList<>();
            for (int i = ranges[col][0]; i <= ranges[col][1]; i++) {
                columnNumbers.add(i);
            }
            Collections.shuffle(columnNumbers);
            for (int row = 0; row < 5; row++) {
                card[row][col] = columnNumbers.get(row);
            }
        }
        return card;
    }

    public static void markCard(int[][] card, boolean[][] marked, int drawn) {
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                if (card[row][col] == drawn) {
                    marked[row][col] = true;
                }
            }
        }
    }

    public static void printCard(int[][] card, boolean[][] marked) {
        System.out.println("\nB\tI\tN\tG\tO");
        System.out.println("____________________________");
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                if (row == 2 && col == 2) {
                    System.out.print("FREE\t");
                } else if (marked[row][col]) {
                    System.out.print("X\t");
                } else {
                    System.out.print(card[row][col] + "\t");
                }
            }
            System.out.println();
            System.out.println("____________________________");
        }
    }

    public static char getBingoLetter(int num) {
        if (num <= 15) return 'B';
        if (num <= 30) return 'I';
        if (num <= 45) return 'N';
        if (num <= 60) return 'G';
        return 'O';
    }

    public static boolean checkWin(boolean[][] marked) {
        // Check rows
        for (int i = 0; i < 5; i++) {
            if (marked[i][0] && marked[i][1] && marked[i][2] && marked[i][3] && marked[i][4]) return true;
        }
        // Check columns
        for (int i = 0; i < 5; i++) {
            if (marked[0][i] && marked[1][i] && marked[2][i] && marked[3][i] && marked[4][i]) return true;
        }
        // Check diagonals
        if (marked[0][0] && marked[1][1] && marked[2][2] && marked[3][3] && marked[4][4]) return true;
        if (marked[0][4] && marked[1][3] && marked[2][2] && marked[3][1] && marked[4][0]) return true;

        return false;
    }
}