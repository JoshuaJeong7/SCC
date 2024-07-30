import java.util.Scanner;
public class BasicDiceRace {
    public static void main(String[] args) {
        System.out.println("This program will create a functioning race." +
        "  \n You must cross a certain amount of steps in order to reach the goal and" +
        " finish the race. \n You will  roll a 7-sided die (singular form" +
        " for \"dice\"), and whatever number you roll is the number of steps" +
        " you will travel towards the goal. \n The exception is if you roll the" +
        " 7th number, in which case you will not move any steps and will roll" +
        " the die again. \n The goal is to travel a certain amount of steps " + 
        " forward, but there are up to 5 steps across the race that will make" +
        " you travel backwards by 4 steps instead, so watch out! \n");
        
        System.out.println(" \n +---------------------------+ \n");
        
        

        /**
         * At this step, you must finish the rest of the game by yourself.
         * Here are some helpful tips to follow:
         * 
         * -YOU MUST START BY WRITING THE LOOP ITSELF!!!!
         *         The code that has already been typed represents ONE turn,
         *         not a LOOP of turns.
         * 
         * -Don't forget to print an end message for after the game ends!
         *         Optionally, print how many turns it took to win the race.
         */
         
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of steps required to finish the race:");
        
        int raceLength = input.nextInt() - 1; 
        input.nextLine(); //THE STUDENTS code this line in
        ///NOTE TO STUDENTS: PAY ATTENTION TO THIS INT VARIABLE!! IT STORES THE MAXIMUM STEPS TO WIN THE RACE!!
    
        ///NOTE TO STUDENTS: 1 is subtracted from the race length because
        ///the first tile is considered at position 0, not position 1.
        
        boolean gameIsRunning = true;
        int numTurns = 0;
        
        ///NOTE TO STUDENTS: If you're up for a challenge, try to make it so that
        ///    these steps will never repeat each other! (OPTIONAL; DIFFICULT)
        int backwardsStep1 = (int)(Math.random() * raceLength);
        int backwardsStep2 = (int)(Math.random() * raceLength);
        int backwardsStep3 = (int)(Math.random() * raceLength);
        int backwardsStep4 = (int)(Math.random() * raceLength);
        int backwardsStep5 = (int)(Math.random() * raceLength);
        
        int yourSteps = 0;
        
        System.out.println("POSITION OF THE FINISH LINE: " + raceLength);
        
        while (gameIsRunning) {
                
                System.out.println(" \n \n ");
                /**
                 * CRITERIA OF WHAT TO DO IN ONE     :
                 * 1) Prompt the user to roll the die
                 * 2) Roll the die itself and store it in an int value
                 * 3) Determine if the user needs to roll again
                 * 4) Determine which step the player is on, and end the game
                 *          if they are at or past the finish line, or make them travel
                 *         backwards by 4 steps if they land on a backwards tile
                 * 5) Print the results of the player's     
                 */
                
                
                /// 1) Prompt the user to roll the die
                // TYPE YOUR CODE HERE
                
                /// 2) Roll the die itself and store it in an int value
                int dieRoll = (int)(Math.random() * 7) + 1;
                System.out.println("RESULT OF DICE:");
                System.out.println("+-------+");
                System.out.println("|       |");
                System.out.println("|   " + dieRoll + "   |");
                System.out.println("|       |");
                System.out.println("+-------+");
        
                /// 3) Determine if the user needs to roll again
                //TYPE YOUR CODE HERE    Note 1: You can combine steps 3) and 2)
                //Note 2: You need to still ask for the user input when rolling again
                
                ///4) Determine which step the player is on, and end the game
                ///     if they are at or past the finish line, or make them travel
                ///     backwards by 4 steps if they land on a backwards tile
                yourSteps += dieRoll;
                
                if (yourSteps >= raceLength) { ///If the player reaches or passes the finish line
                    //FINISH MISSING CODE (ONE line needed to END the game)
                }
                else if (yourSteps == backwardsStep1) {
                    yourSteps -= 4;
                    System.out.println("Landed on a backwards tile! Moving backwards");
                }
                //REPEAT THE STEPS FOR ALL FIVE BACKWARDS STEPS
                
                /// 5) Print the results of the player's     
                // TYPE YOUR CODE HERE
        }
            
            
        System.out.println("You finished the race in " + numTurns + " steps!");
    
    
    }
    
}

