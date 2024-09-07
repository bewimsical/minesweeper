import java.util.Scanner;

public class Main {
    // Main method to start the game
    public static void main(String[] args) {
        // Create a Minesweeper game with specific dimensions and number of mines
        Minesweeper game = new Minesweeper(10, 10, 10);
        System.out.println("\nWelcome to MINESWEEPER\n");
        // Game loop
        while (!game.getGameOver()) {
            game.displayBoard();
            // Get player input for row, col, and action (reveal or flag)
            // For now, just simulate a move (to be replaced with real player input logic)
            Scanner sc = new Scanner(System.in);
            String action = "";
            System.out.println("\n\nChoose your action. Enter the number of your choice:\n(1) reveal cell \n(2) flag cell");
            int actionChoice = sc.nextInt();
            action += (actionChoice == 1) ? "reveal" : "flag";
            System.out.println("Choose your cell.");
            System.out.println("Enter your y value:");
            int row = sc.nextInt();
            System.out.println("Enter your x value:");
            int col = sc.nextInt();

            game.playerMove(row, col, action);

            // Check for win or loss conditions
            if (game.checkWin()) {
                System.out.println("Congratulations! You've won the game.");
                break;
            }
            if (game.checkLoss(row, col)) {
                System.out.println("Game Over! You hit a mine.");
                game.setGameOver(true);
            }
        }
    }
}