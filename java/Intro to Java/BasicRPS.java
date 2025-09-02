import java.util.Scanner;
public class BasicRPS {
    public static void main(String[] args) {
        System.out.println("This is just Rock Paper Scissors. Let's play!");
        Scanner in = new Scanner(System.in);

        //Code the game of Rock-Paper-Scissors! I'll start you off.
        char p1Guess = 0;
        while (p1Guess != 'r' && p1Guess != 'p' && p1Guess != 's') {
            //Get the user input for what the player guesses
            //Here's a hint:
            
            in.next().charAt(0); //This is how you store the input for the next CHARACTER
        }
        


        //Now code player 2 giving their guess? (You can do it through input or Math.random())


        //Finally, check for which player won.
    }
}