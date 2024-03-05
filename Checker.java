//Task 1
import java.util.*;

public class Checkers {

    /**
     * Represents the game board as a 2D array.
     * 'b' for Black pieces, 'w' for White pieces, ' ' for Empty spaces, 'B' for
     * Black Kings, and 'W' for White Kings.
     */
    private static String[][] board = new String[8][8];
    private static String turn = " ";

    /**
     * Initialises the board with pieces in their starting positions.
     */
    private static void initialiseBoard() {
        // Implement this method to fill the board array with pieces in their starting
        // positions.
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = " ";
            }
        }
        for (int i = 0; i < 8; i++) {
            if (i % 2 == 0) {
                board[1][i] = "w";
                board[5][i] = "b";
                board[7][i] = "b";
            } else {
                board[0][i] = "w";
                board[2][i] = "w";
                board[6][i] = "b";
            }
        }
    }

    /**
     * Displays the current state of the board to the console.
     */
    private static void displayBoard() {
        // Implement this method to print the board to the console.
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.printf("|%s", board[i][j]);
            }
            System.out.println("|");
        }
        System.out.println("");
    }

    /**
     * Main game loop. Handles player turns and checks for game end conditions.
     */
    private static void startGame() {
        // Implement the game loop, handling player input, turn switching, and win
        // condition checking.
        Scanner input = new Scanner(System.in);
        turn = "b";
        while (input.hasNext()) {
            String player_input = input.nextLine();
            if (player_input.equals("exit")) {
                System.out.println();
                System.exit(0);
            }
            if (player_input.equals("View")) {
                displayBoard();
                continue;
            }
            boolean isValid = processMove(player_input);
            if (isValid == true) {
                if (turn.equals("w")) {
                    turn = "b";
                } else {
                    turn = "w";
                }
            } else {
                System.out.println("Error!\n");
            }
            displayBoard();
            isGameOver();

        }
        System.out.println();
    }

    /**
     * Processes a player's move.
     * 
     * @param move A string representing the player's move (e.g., "C3 to D4").
     * @return true if the move is valid and executed, false otherwise.
     */
    private static boolean processMove(String move) {
        // Implement this method to process the player's move.
        // You should validate the move and execute it if it's valid.
        String[] moves = move.trim().split(" ", 0);
        if (moves.length != 3) {
            return false;
        }
        if (moves[0].length() != 2 || moves[2].length() != 2) {
            return false;
        }
        int col1, col2, row1, row2;
        try {
            col1 = moves[0].charAt(0) -'A';
            col2 = moves[2].charAt(0) - 'A';
            row1 = Integer.parseInt(String.valueOf(moves[0].charAt(1))) - 1;
            row2 = Integer.parseInt(String.valueOf(moves[2].charAt(1))) - 1;
        } catch (Exception e) {
            return false;
        }

        if (col1 > 7 || col1 < 0 || col2 > 7 || col2 < 0 || row1 < 0 || row2 < 0 || row1 > 7 || row2 > 7) {
            return false;
        }
        boolean isValid = isValidMove(row1, col1, row2, col2);
        if (isValid) {
            String p = board[(row1 + row2)/2][(col1 + col2)/2].toLowerCase();
            board[row2][col2] = board[row1][col1];
        
            if (Math.abs(row2 - row1) == 2) {
                if (!board[row1][col1].toLowerCase().equals(p)) {
                    board[(row2 + row1) / 2][(col2 + col1) / 2] = " ";
                }
            }
            board[row1][col1] = " ";
            if (board[row2][col2].equals("b") && row2 == 0) {
                board[row2][col2] = board[row2][col2].toUpperCase();
            }
            if (board[row2][col2].equals("w") && row2 == 7) {
                board[row2][col2] = board[row2][col2].toUpperCase();
            }
            return true;
        }

        return false;
    }

    /**
     * Checks if a move is valid.
     * 
     * @param fromRow the starting row of the move.
     * @param fromCol the starting column of the move.
     * @param toRow   the ending row of the move.
     * @param toCol   the ending column of the move.
     * @return true if the move is legal, false otherwise.
     */
    private static boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol) {
        // Implement this method to check if a move is legal according to the rules of
        // Checkers.
        if (!board[fromRow][fromCol].toLowerCase().equals(turn)) {
            return false;
        }
        if (board[fromRow][fromCol].toLowerCase().equals("w") || board[fromRow][fromCol].toLowerCase().equals("b")) {
            if (board[toRow][toCol].equals(" ")) {
                int distCol, distRow;
                distCol = Math.abs(toCol - fromCol);
                distRow = 0;
                if (board[fromRow][fromCol].equals("w")) {
                    distRow = toRow - fromRow;
                }
                if (board[fromRow][fromCol].equals("b")) {
                    distRow = -(toRow - fromRow);
                }
                if (board[fromRow][fromCol].equals("W") || board[fromRow][fromCol].equals("B")) {
                    distRow = Math.abs(toRow - fromRow);
                }
                if (distRow <= 0) {
                    return false;
                }
                if (distRow == 1 && distCol == 1) {
                    return true;
                }
                if (distRow == 2 && distCol == 2 && (board[(fromRow + toRow)/2][(fromCol + toCol)/2].toLowerCase().equals("w") || board[(fromRow + toRow)/2][(fromCol + toCol)/2].toLowerCase().equals("b"))) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if the game has ended.
     * 
     * The program should terminate if the game has finished.
     */
    private static void isGameOver() {
        // Implement this method to check for win conditions.
        boolean b = false;
        boolean w = false;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j].toLowerCase() == "w") {
                    w = true;
                }
                if (board[i][j].toLowerCase() == "b") {
                    b = true;
                }
            }
        }
        if (b == false || w == false) {
            System.out.println();
            System.exit(0);
        }
        
    }

    /**
     * Main method to run the game.
     * 
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        initialiseBoard();
        displayBoard();
        startGame();
    }
}