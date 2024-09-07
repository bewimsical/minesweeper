import java.util.Random;
public class Minesweeper {

    // Data members
    private int[][] board;   // The game board where cells will be displayed
    private boolean[][] mines; // Array to track the locations of mines
    private boolean[][] revealed; // Array to track which cells have been revealed
    private boolean[][] flagged; // Array to track which cells have been flagged
    private int rows; // Number of rows in the board
    private int cols; // Number of columns in the board
    private int numMines; // Number of mines in the game
    private boolean gameOver; // Boolean to check if the game is over

    // Constructor to initialize the board with the specified dimensions and number of mines
    public Minesweeper(int rows, int cols, int numMines) {
        this.rows = rows;
        this.cols = cols;
        this.numMines = numMines;
        this.board = new int[rows][cols];
        this.mines = new boolean[rows][cols];
        this.revealed = new boolean[rows][cols];
        this.flagged = new boolean[rows][cols];
        this.gameOver = false;

        // Call methods to initialize the board and place mines
        initializeBoard();
    }
    public boolean getGameOver(){
        return this.gameOver;
    }
    public void setGameOver(boolean status)
    {
        this.gameOver = status;

    }
    // Method to initialize the game board with empty values
    private void initializeBoard() {
        // TODO: Implement this method
        // set all revealed to false

        placeMines();
        calculateNumbers();
    }

    // Method to randomly place mines on the board
    private void placeMines() {
        // TODO: Implement this method
        for(int i = 0; i < this.numMines; i++ ){
            Random rn = new Random();
            int mineRow = rn.nextInt(this.rows);
            int mineCol = rn.nextInt(this.cols);
            boolean assigning = true;
            while (assigning){
                if (!this.mines[mineRow][mineCol]){
                    this.mines[mineRow][mineCol] = true;
                    assigning = false;
                }
                else{
                    mineRow = rn.nextInt(this.rows);
                    mineCol = rn.nextInt(this.cols);
                }
            }
        }

    }

    // Method to calculate numbers on the board for non-mine cells
    private void calculateNumbers() {
        // TODO: Implement this method
        for(int i = 0; i < this.rows; i++){
            int up = i - 1;
            int down = i + 1;
            for(int j = 0; j < this.cols; j++){
                int count = 0;
                int left = j - 1;
                int right = j + 1;

                for (int y = up; y <= down; y++){
                    for(int x = left; x <= right; x++){
                        if (y >= 0 && y < this.rows && x >= 0 && x < this.cols && !(y==i && x==j) && this.mines[y][x]){
//                            if (x >= 0 && x < this.cols){
//                                if(!(y==i && x==j)){
//                                    if(this.mines[y][x]){
                                        count += 1;
//                                    }
//                                }
//                            }
                        }
                    }
                }
                this.board[i][j] = count;

            }
        }
    }

    // Method to display the current state of the board
    public void displayBoard() {
        // TODO: Implement this method
        for(int i = 0; i < this.rows; i++) {
            String line = "";
            line += "(" + i + ")   ";
            for (int j = 0; j < this.cols; j++) {
                if (this.revealed[i][j]) {
                    line += (this.board[i][j] > 0 ? this.board[i][j] : " ") + "   ";
                }
                else{
                    if (this.flagged[i][j]){
                        line += "⚑   ";
                    }
                    else{
                        line += "-   ";
                    }
                }
            }
            // TODO: REMOVE THIS
            line += "   ";
            for (int j = 0; j < this.cols; j++) {
                line += this.board[i][j] + " ";
            }
            line += "   ";
            for (int j = 0; j < this.cols; j++) {
                line += (this.mines[i][j]?"⚑":"-") + " ";
            }
            // Keep this
            System.out.println(line);
        }
        System.out.print("     ");
        for (int i = 0; i < this.cols; i++){
            System.out.print("(" + i + ") ");
        }
    }

    // Method to handle a player's move (reveal a cell or place a flag)
    public void playerMove(int row, int col, String action) {
        // TODO: Implement this method
        this.revealCell(row,col);
    }

    // Method to check if the player has won the game
    public boolean checkWin() {
        // TODO: Implement this method
        return false;
    }

    // Method to check if the player has lost the game
    public boolean checkLoss(int row, int col) {
        // TODO: Implement this method
        return false;
    }

    // Method to reveal a cell (and adjacent cells if necessary)
    private void revealCell(int row, int col) {
        // TODO: Implement this method
        int up = row - 1;
        int down = row + 1;
        int left = col - 1;
        int right = col + 1;
        if (this.revealed[row][col]){
            return;
        }
        if (this.board[row][col] != 0 ){
            this.revealed[row][col] = true;
            return;
        }
        this.revealed[row][col] = true;
        for (int y = up; y <= down; y++){
            for(int x = left; x <= right; x++){
                if (y >= 0 && y < this.rows && x >= 0 && x < this.cols && !(y==row && x==col) && !this.mines[y][x]){
                    this.revealCell(y,x);
                }
            }
        }
    }

    // Method to flag a cell as containing a mine
    private void flagCell(int row, int col) {
        this.flagged[row][col] = true;
    }

    // Method to unflag a cell
    private void unflagCell(int row, int col) {
        this.flagged[row][col] = false;
        // TODO: Implement this method
    }
}
