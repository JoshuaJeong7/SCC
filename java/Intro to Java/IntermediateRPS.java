import java.util.Scanner;
public class IntermediateRPS {
    public static void main(String[] args) {
        System.out.println("This is just Rock Paper Scissors. Let's play!");
        Scanner in = new Scanner(System.in);

        //Code the game of Rock-Paper-Scissors! I'll start you off.
        boolean gameIsRunning = true;

        System.out.println("NOTE: THE BIGGEST DIFFERENCE BETWEEN THIS VERSION AND THE BASIC" +
                            " VERSION IS THAT YOU HAVE THE OPTION TO CONTINUALLY KEEP" +
                            " PLAYING UNTIL THE USER DECIDES TO QUIT!");
        while (gameIsRunning) {
            char p1Guess = 0;
            while (p1Guess != 'r' && p1Guess != 'p' && p1Guess != 's') {
                //Get the user input for what the player guesses
                //Here's a hint:
                
                in.next().charAt(0); //This is how you store the input for the next CHARACTER
            }
            


            //Now code player 2 giving their guess? (You can do it through input or Math.random())


            //Check for which player won.

            
            // !!!!           IMPORTANT             !!!!

            //Finally, we will ask the user if they want to play again or not. If they do, then
            //continue the loop. If not, then we shall end the loop.
        }
    }
}