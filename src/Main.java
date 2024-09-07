import java.util.Scanner;

public class Main {
    // Main method to start the game
    public static void main(String[] args) {
        // Create a Minesweeper game with specific dimensions and number of mines
        Minesweeper game = new Minesweeper(10, 10, 15);

        // Game loop
        while (!game.getGameOver()) {
            game.displayBoard();
            //game.setGameOver(true); // TODO: Remove
            // Get player input for row, col, and action (reveal or flag)
            // For now, just simulate a move (to be replaced with real player input logic)
            Scanner sc = new Scanner(System.in);
            System.out.println("\n\nChoose your y value");
            int y = sc.nextInt();
            System.out.println("Choose your x value");
            int x = sc.nextInt();
            game.playerMove(y, x, "reveal");

            // Check for win or loss conditions
            if (game.checkWin()) {
                System.out.println("Congratulations! You've won the game.");
                break;
            }
            if (game.checkLoss(0, 0)) {
                System.out.println("Game Over! You hit a mine.");
                game.setGameOver(true);
            }
        }
    }
}