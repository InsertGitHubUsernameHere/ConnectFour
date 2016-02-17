/*  
 * Author: Thien Le
 * Program 2 - MyGame
 * CSC230-02 Spring 2016
 */

import java.util.Scanner;

public class MyGame {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        boolean Exception;
        String Loop;
        boolean Repeat;

        C4 myGame = new C4();
        do {
            Repeat = false;
            System.out.println(myGame.getName());
            do {
                myGame.printBoard();

                System.out.println("Choose a column:");
                System.out.print("> Player " + myGame.getTurn() + " turn!\t");

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

                Loop = input.nextLine();
                entry = 0;

                if (Loop.equalsIgnoreCase("y")) {
                    myGame.clearBoard();

                    Repeat = true;


       } else if (Loop.equalsIgnoreCase("n")) {
                    System.out.println("Thank you for playing Connect Four" + ", BYE :D ");
                } else {
                    System.out.println("Please enter Y or N!");
                    entry = 1;
                }

            } while (entry == 1);

        } while (Repeat == true);
    }
}
