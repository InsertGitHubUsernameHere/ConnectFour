/*  
 * Author: Thien Le
 * Program 2 - MyGame
 * CSC230-02 Spring 2016
 */

import java.util.Scanner;

public class MyGame {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        boolean Exception; //argument for the do while loop
        String answer;
        boolean Repeat; //argument for the do while loop

        C4 myGame = new C4();
        //Do while loop that loop the whole game until Repeat is true.
        do {
            Repeat = false;
            System.out.println(myGame.getName());
            //Nest do while loop to print the game/collect user's input/catch exception
            do {
                myGame.printBoard();

                System.out.println("Choose a column:");
                if (myGame.getTurn() == 'R') {
                    System.out.println(">Player One(R) turn!");
                } else if(myGame.getTurn() == 'Y'){
                    System.out.print("> Player Two(Y) turn!\t");
                }
                //Guard for column is full and number not in ranged of 0-6
                do {
                    try {
                        Exception = false;
                        myGame.playPiece(input.nextInt());
                        myGame.nextTurn();
                    } catch (ArrayIndexOutOfBoundsException c) {
                        Exception = true;
                        System.out.print("Please insert a valid number! ");
                        
                    }

                } while (Exception == true);
                //Repeat as long as the board is not full and there is no winner
            } while (myGame.isFull() == false && myGame.isWinner() == false); 

            myGame.printBoard();

            myGame.nextTurn();
            //Display The winner and the amount of tries in total to win the game
            myGame.winner();

            int entry;

            input.nextLine();
            //Allow users to be able to repeator end the game
            do {
                System.out.print("Would you like to play again?(Y/N): ");

                answer = input.nextLine();
                entry = 0;

                if (answer.equalsIgnoreCase("y")) {
                    myGame.clearBoard();

                    Repeat = true;

                } else if (answer.equalsIgnoreCase("n")) {
                    System.out.println("\n.*•.¸¸¸.•*Thank you for playing Connect Four!¨*•.¸¸¸.•*.\n" + 
                                                 "\t\t\tGood Bye!");
                } else {
                    System.out.println("Please enter Y or N!");
                    entry = 1;
                }

            } while (entry == 1);

        } while (Repeat == true); 
    }
}
