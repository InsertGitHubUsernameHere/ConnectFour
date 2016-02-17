
import java.util.Arrays;
/*
 * Author: Thien Le
 * Program 1 - MyString
 * CSC230-02 Spring 2016
 */

//Subclass
public class C4 extends Game {

    private final int COLS = 7; //Field for the COLS    
    private final int ROWS = 6; //FIeld for the ROWS
    private final char[][] board = new char[ROWS][COLS]; //char 2d Arrays

    //This is the constructor for the Connect Four class
    public C4() {
        super(" !!Welcome to Connect Four!!", 2);
        for (int row = 0; row < ROWS; row++) {
            Arrays.fill(board[row], ' ');
        }
    } //end of constructor
    //This method will fill the whole board with blank space

    public void clearBoard() {
        for (int row = 0; row < ROWS; row++) {
            Arrays.fill(board[row], ' ');
        }
    }

    //return the row and col of the arrays

    public int getPiece(int row, int col) {
        return this.board[row][col];

    }

    //method that returns the int value of the current player

    public int getTurn() {
        return super.currentTurn();

    }

    //Method return false if the col is not full

    public boolean isColFull(int col) {
        for (int rowFul = 0; rowFul < ROWS; rowFul++) {
            if (board[rowFul][col] == ' ') {
                return false;
            }

        }
        return true;
    }

    //Algorithm for 4 consecutive inputs that are alike in a diagonal fashion.

    private boolean isDiagWinner() {
        {
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 4; c++) {

                    // Check from bottom left to upper right.
                    if (board[5 - r][6 - c] != ' ' && board[5 - r][6 - c] == board[4 - r][5 - c]) {
                        if (board[4 - r][5 - c] == board[3 - r][4 - c]) {
                            if (board[3 - r][4 - c] == board[2 - r][3 - c]) {
                                return true;
                            }
                        }
                    }
                    //Check bottom right to upper left.
                    if (board[5 - r][0 + c] != ' ' && board[5 - r][0 + c] == board[4 - r][1 + c]) {
                        if (board[4 - r][1 + c] == board[3 - r][2 + c]) {
                            if (board[3 - r][2 + c] == board[2 - r][3 + c]) {
                                return true;
                            }
                        }
                    }
                }
            }
            return false;
        }
    }

    public boolean isFull() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (board[row][col] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
//Algorithm for 4 consecutive inputs that are alike in a horizontal fashion.

    private boolean isHorizWinner() {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < 4; c++) {
                if (board[r][c] != ' ' && board[r][c] == board[r][c + 1]) {
                    if (board[r][c + 1] == board[r][c + 2]) {
                        if (board[r][c + 2] == board[r][c + 3]) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

//Algorithm for 4 consecutive inputs that are alike in a vertical fashion.
    private boolean isVertWinner() {
        for (int c = 0; c < COLS; c++) {
            for (int r = 0; r < 3; r++) {
                if (board[r][c] != ' ' && board[r][c] == board[r + 1][c]) {
                    if (board[r + 1][c] == board[r + 2][c]) {
                        if (board[r + 2][c] == board[r + 3][c]) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }
//Return the winner if one of the algorithm methods retrun true.

    public boolean isWinner() {
        if (isVertWinner() == true) {
            return isVertWinner();
        }
        if (isDiagWinner() == true) {
            return isDiagWinner();
        }
        if (isHorizWinner() == true) {
            return isHorizWinner();
        }
        return false;
    }

    //Alternating between player.

    public void nextTurn() {
        super.next();
    }

    //Print out the piece correspond to the user's input.

    public void playPiece(int col) {
        //If the col selected is empty print out that char
        if (board[5][col] == ' ') {
            board[5][col] = (char) getTurn();
            //If not print the one above that, then stop the loop
        } else {
            for (int i = 0; i < ROWS; i++) {
                if (board[i][col] != ' ') {
                    board[i - 1][col] = (char) getTurn();
                    break;
                }
            }
        }

    }
//Print out and display the board for the connect 4 game

    public void printBoard() {
        System.out.println("==0===1===2===3===4===5===6==");
        for (int row = 0; row < board.length; ++row) {
            System.out.print("| ");
            for (int col = 0; col < board[row].length; ++col) {
                System.out.print(board[row][col] + " | ");
            }

            System.out.println();
        } //Print the bottom of the board
        for (int row = 0; row < 29; row++) {
            System.out.print("=");

        }
        System.out.println(" ");
    }

}
