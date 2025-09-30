import java.util.Scanner;

/**
 * UNIT: Loops
 * 
 * ASSESSMENT ON: 
 * -Ability to adapt flexibly to new situations with the Scanner class by
 * only using user input to confirm a decision instead of asking for a specific
 * value to input into a variable
 * -Ability to use loops to continue to loop the game
 * -Working knowledge of booleans to keep the loop active until you finish the race
 * -Versatility with the program by keeping track of each player's     
 * with an integer
 * 
 * NOT ASSESSED AT ALL:
 * -Ability to generally create and set up the Scanner class
 * -The usage of methods
 * 
 * ONLY ASSESSED IN ADVANCED VERSION:
 * -Ability to keep track of several players' current position (i.e. their number
 * of steps taken)
 * -Proficiency and flexibility with using Math.random() to perform various
 * functions or enhancing the complexity of the possible values that Math.random()
 * can return [NOTE: This means randomly selecting events and making a roll
 * of 7 let you roll the die again but with 1 more step travelled for EACH value]
 */
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
        input.nextLine();
        ///NOTE TO STUDENTS: PAY ATTENTION TO THIS INT VARIABLE!! IT STORES THE MAXIMUM STEPS TO WIN THE RACE!!
    
        ///NOTE TO STUDENTS: 1 is subtracted from the race length because
        ///the first tile is considered at position 0, not position 1.
        
        boolean gameIsRunning = true;
        int numTurns  = 0;
        
        ///NOTE TO STUDENTS: If you're up for a challenge, try to make it so that
        ///    these steps will never repeat each other! (OPTIONAL; DIFFICULT)
        int backwardsStep1 = (int)(Math.random() * raceLength);
        int backwardsStep2 = (int)(Math.random() * raceLength);
        int backwardsStep3 = (int)(Math.random() * raceLength);
        int backwardsStep4 = (int)(Math.random() * raceLength);
        int backwardsStep5 = (int)(Math.random() * raceLength);
        
        int yourSteps = 0;
        
        System.out.println("POSITION OF THE FINISH LINE: " + raceLength);
        ///VERY IMPORTANT!!!! START BY WRITING THE LOOP ITSELF!!!!
        while (gameIsRunning) {
                
                System.out.println(" \n \n ");
                /**
                 * CRITERIA OF WHAT TO DO IN ONE TURN:
                 * 1) Prompt the user to roll the die
                 * 2) Roll the die itself and store it in an int value
                 * 3) Determine if the user needs to roll again
                 * 4) Determine which step the player is on, and end the game
                 *          if they are at or past the finish line, or make them travel
                 *         backwards by 4 steps if they land on a backwards tile
                 * 5) Print the results of the player's     
                 */
                
                
                /// 1) Prompt the user to roll the die
                /// Your solution code must:
                ///    - Prompt the user to roll the die
                ///    - The user enters anything they want as their input, but the very act
                ///      of pressing the 'enter' key should be registered by the program before
                ///      any of the following code should be executed.
                ///    - (If you're confused by the second point, just take in the next line as
                ///      user input and don't do anything else with that variable!)
                /**+----------------------------------------------------------------+ **/
                /** ###    ----    ####  CODE THIS PART YOURSELF  ####    ----    ### **/
                /** ###    ----    ####  CODE THIS PART YOURSELF  ####    ----    ### **/
                /** ###    ----    ####  CODE THIS PART YOURSELF  ####    ----    ### **/
                /** ###    ----    ####  CODE THIS PART YOURSELF  ####    ----    ### **/
                /** ###    ----    ####  CODE THIS PART YOURSELF  ####    ----    ### **/
                /** ###    ----    ####  CODE THIS PART YOURSELF  ####    ----    ### **/
                /**+----------------------------------------------------------------+ **/
                
                /// 2) Roll the die itself and store it in an int value
                int dieRoll = (int)(Math.random() * 7) + 1;
                System.out.println("RESULT OF DICE:");
                System.out.println("+-------+");
                System.out.println("|       |");
                System.out.println("|   " + dieRoll + "   |");
                System.out.println("|       |");
                System.out.println("+-------+");
        
                /// 3) Determine if the user needs to roll again
                /// The solution code must:
                ///    - Figure out whether the user's dieRoll is 7 (the number that means
                ///      they have to roll again)
                ///    - Roll the die again, and figure out if that new number is 7 again or not
                ///    - Use a loop to basically keep rolling the die until it reaches a valid number!
                //Tip: You need to still ask for the user input when rolling again
                /**+----------------------------------------------------------------+ **/
                /** ###    ----    ####  CODE THIS PART YOURSELF  ####    ----    ### **/
                /** ###    ----    ####  CODE THIS PART YOURSELF  ####    ----    ### **/
                /** ###    ----    ####  CODE THIS PART YOURSELF  ####    ----    ### **/
                /** ###    ----    ####  CODE THIS PART YOURSELF  ####    ----    ### **/
                /** ###    ----    ####  CODE THIS PART YOURSELF  ####    ----    ### **/
                /** ###    ----    ####  CODE THIS PART YOURSELF  ####    ----    ### **/
                /**+----------------------------------------------------------------+ **/

            
                ///4) Determine which step the player is on, and end the game
                ///     if they are at or past the finish line, or make them travel
                ///     backwards by 4 steps if they land on a backwards tile
                yourSteps += dieRoll;
                
                if (yourSteps >= raceLength) {
                    ///If the player reaches or passes the finish line
                    //FINISH MISSING CODE (ONE line needed to END the game)
                    
                    /**+----------------------------------------------------------------+ **/
                    /** ###    ----    ####  CODE THIS PART YOURSELF  ####    ----    ### **/
                    /** ###    ----    ####  CODE THIS PART YOURSELF  ####    ----    ### **/
                    /** ###    ----    ####  CODE THIS PART YOURSELF  ####    ----    ### **/
                    /** ###    ----    ####  CODE THIS PART YOURSELF  ####    ----    ### **/
                    /** ###    ----    ####  CODE THIS PART YOURSELF  ####    ----    ### **/
                    /** ###    ----    ####  CODE THIS PART YOURSELF  ####    ----    ### **/
                    /**+----------------------------------------------------------------+ **/
                }
                else if (yourSteps == backwardsStep1) {
                    //If the player lands on a backwards tile, send them 4 tiles backwards
                    yourSteps -= 4;
                    System.out.println("Landed on a backwards tile! Moving backwards");
                }
            
                //REPEAT THE PROCESS ABOVE FOR ALL FIVE BACKWARDS STEPS
                // If you're not sure what that means, in the previous else-if statement
                // we just checked if the current steps the user is at (yourSteps) is at the
                // same location as the FIRST backwards tile (backwardsStep1). You must do
                // this same exact check for ALL 5 backward tiles (backwardsStep2, backwardsStep3,
                // backwardsStep4, and backwardsStep5)!
                
                /**+----------------------------------------------------------------+ **/
                /** ###    ----    ####  CODE THIS PART YOURSELF  ####    ----    ### **/
                /** ###    ----    ####  CODE THIS PART YOURSELF  ####    ----    ### **/
                /** ###    ----    ####  CODE THIS PART YOURSELF  ####    ----    ### **/
                /** ###    ----    ####  CODE THIS PART YOURSELF  ####    ----    ### **/
                /** ###    ----    ####  CODE THIS PART YOURSELF  ####    ----    ### **/
                /** ###    ----    ####  CODE THIS PART YOURSELF  ####    ----    ### **/
                /**+----------------------------------------------------------------+ **/
                    
                System.out.println("Press enter to continue");
                input.nextLine();
            
                /// 5) Print the results of the player's turn and update the amount of turns
                /// The solution MAY (recommended):
                ///    - Print a continuous line that represents each tile of the entire race
                ///      track with a symbol. Some sample symbols are below:
                ///      "-": Regular race tile
                ///      "@": Location of the player
                ///      "X": Location of a backwards tile
                /**+----------------------------------------------------------------+ **/
                /** ###    ----    ####  CODE THIS PART YOURSELF  ####    ----    ### **/
                /** ###    ----    ####  CODE THIS PART YOURSELF  ####    ----    ### **/
                /** ###    ----    ####  CODE THIS PART YOURSELF  ####    ----    ### **/
                /** ###    ----    ####  CODE THIS PART YOURSELF  ####    ----    ### **/
                /** ###    ----    ####  CODE THIS PART YOURSELF  ####    ----    ### **/
                /** ###    ----    ####  CODE THIS PART YOURSELF  ####    ----    ### **/
                /**+----------------------------------------------------------------+ **/
                
            
            
        }
            
            
        System.out.println("You finished the race in " + numTurns  + " steps!");
    
    
    }
    
}

