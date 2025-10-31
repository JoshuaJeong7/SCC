import java.util.HashSet;
import java.util.HashMap;
import java.util.Scanner;

public class AssignedMethods {
	
	private static Scanner in = new Scanner(System.in);
	
    /*
     * In this method, you are going to code the following:
     * 
     * - Create an empty HashSet (NOTE: SET, NOT A MAP) of integers.
     * - Add 40 unique numbers randomly generated between
     *   low and high (inclusive) to the HashSet.
     *            - To ensure the number is unique, continuously
     *              generate random numbers UNTIL the number you generate
     *              is no longer in the Set.
     */
    public static HashSet<Integer> randomUniqueNumbers(int n, int low, int high) {
        return null;
    }
    
    /*
     * In this method, you will prompt the user to guess EACH crime in the list.
     * 
     * You have been provided a little bit of starter code for the loop to ask
     * the crimes and the user input for their guess of a listed crime.
     * 
     * The logic of this method is as follows:
     * - The user inputs one of the crimes they think is inside the crime list.
     *   Note: Although the text file separates crimes by hyphen, the code
     * 		   removes that hyphen, so all inputs will use a space instead!
     * 
     * 		   Ex: The user will enter "property destruction", as opposed
     * 			   to "property-destruction"
     * 
     * - The program checks if that guessed crime is actually in the crime list.
     *   Hint: How do you check if a string is contained inside a map?
     * 		   (This same method allows the user to guess ANY crime, 
     * 			without needing to follow an order!)
     * 
     * - If the user correctly guesses a crime in the map, REMOVE THAT CRIME
     *   from the map.
     * - (Optional) You may print a result to the screen for whether the user guessed
     *   a crime actually committed by their client or if the user's guess is wrong.
     * 
     * You DO NOT need to code up the post-guess logic of how much health
     * the U.S. loses, or determine how the game ends. I have already coded
     * that for you, and you do not have to do anything more for that stage.
     * All you need to code in this method is the actual logic described above.
     */
    public static void guessCrimes(HashMap<String, Integer> crimesList) {
		System.out.println("Agent, now it is time for you to guess the crime of your client.");
		int size = crimesList.size();
		for (int i = 1; i <= size; i++) {
			System.out.println("Crime " + i + ": State a crime that your client has committed.");
			String guess = in.nextLine();
			
			//Finish the logic of the code here
			
		}
	}
	
	/**
	From this point onward, you have to code all six methods for the type of actions
	you can do to gain information out of the client.
	* 
	* In order of easiest to hardest, here is my recommendation of what order
	* you should complete these methods:
	* - #5: totalSeverity5
	* - #1: classificationEach1
	* - #2: fiveLetters2
	* - #6: instantDismantle6
	* - #3: guessSeverity3
	* - #4: twoWords4
	*/
	
	/*
	 * classificationEach1
	 * We recommend that this be the 2nd method you code.
	 * This method goes through each crime in the crimesList.
	 * !!!!!!!!!THE METHOD DOES NOT PRINT THE ACTUAL NUMBER OF SEVERITY!!!!!!!!!!!!!
	 * 
	 * The method prints the CLASSIFICATION label for severity, for each individual crime.
	 * The key for severity CLASSIFICATION goes as follows:
	 * • < 100: Minor
	 * • 100 - 999: Severe
	 * • 1,000 - 9,999: Grand
	 * • 10,000 - 99,999: Massacre
	 * • 100,000 - 999,999: Warfare
	 * • 1,000,000+ : CATASTROPHIC
	 * 
	 * Your job is to:
	 * 
	 *  - Travel through each crime element inside the crimesList map
	 * 
	 *  - Send the true severity level through a switch or if-else block for each crime
	 * 
	 *  - !!!!DO NOT JUST PRINT THE SEVERITY NUMBER, but instead CHECK which 
	 *    classification that the current crime falls under (Minor, Severe, Grand, Massacre, Warfare, CATASTROPHIC)
	 * 
	 *  - Print THE CLASSIFICATION label for each crime
	 * 
	 * 
	 * 		• Tip: Here is some basic code that shows how you can determine
	 * 		  RANGES of a number using an if-else block:
	 * 		
	 * 		if (num < 3) { ... }        This encompasses the range -∞ to 3.
	 * 		else if (num < 10) { ... }  This encompasses the range 4 to 9.
	 * 		else if (num < 545) { ... } This encompasses the range 10 to 544.
	 * 		else { ... }                This encompasses the range 545 to ∞.
	 * 
	 * 		• IT IS VERY IMPORTANT that you write ELSE IF instead of IF for
	 * 		  all subsequent conditions! Otherwise, the whole logistics of ranges break.
	 *  
	 */
	public static void classificationEach1(HashMap<String, Integer> crimesList) {

		//Delete these print statements once you have completed the method.
		System.out.println("If you are seeing this message, method 1 is incomplete!");
		System.out.println("Go to AssignedMethods.java and complete the classificationEach1 method!");
		
		//Finish your code here


        
		System.out.println("PRESS ENTER TO CONTINUE");
		in.nextLine();
	}
	
	/*
	 * fiveLetters2
	 * We recommend that this be the 3rd method you code.
	 * This method will ask the user for five letters that they would like to guess
	 * for EVERY crime in the crimes list.
	 * Using those five letters, the method will loop through each crime in the
	 * list and check EACH letter to see if it exists in the list.
	 * 
	 * Some starter code has been provided, so that user input is received FOR you.
	 * However, you will have to complete the rest of the code's logic.
	 * Hints have been provided to you within the method.
	 */
	public static void fiveLetters2(HashMap<String, Integer> crimesList) {
		String theGuess = "";
		while (!DefuseAgent.isFiveLetters(theGuess)) {
			System.out.println("Enter five letters that you would like to guess.");
			theGuess = in.nextLine();
		}
		
		//This following code line is the biggest hint for how to implement this method.
		//This is a String array, with each element being a letter.
		// Ex: If the user input is 'goieb', letters = ["g", "o", "i", "e", "b"]
		//
		
		String[] letters = theGuess.split("");
		
		//Delete these print statements once you have completed the method.
		System.out.println("If you are seeing this message, method 2 is incomplete!");
		System.out.println("Go to AssignedMethods.java and complete the fiveLetters2 method!");
		
		//You know that for ALL listed crimes, you have to check EACH letter
		//to see if that letter is contained in the word.
		// Ex: If the crimes are burgulary, murder, robbery, heist, and nuke,
		// and the guessed letters are 'u', 'y', 'b', 'g' and 'n',
		// then the following result should print something like this:
		///
		///	Letter Guess Results
		///	Crime 1: uybg_
		///	Crime 2: u____
		///	Crime 3: _yb__
		///	Crime 4: _____
		/// Crime 5: u___n
		///
		//Therefore, we need one loop that processes each crime in the crimeList.
		//Then we need another loop INSIDE our crimes loop, so that we can process
		//each letter of the String array!
		
		//Finish your code here


        
		System.out.println("PRESS ENTER TO CONTINUE");
		in.nextLine();
	}
	
	/*
	 * guessSeverity3
	 * We recommend that this be the 5th method you code.
	 * 
	 * Note: Starter code for receiving user input has already been provided to you.
	 * Your task now is to finish the logic of the code.
	 */
	public static void guessSeverity3(HashMap<String, Integer> crimesList) {
		//Delete these print statements once you have completed the method.
		System.out.println("If you are seeing this message, method 3 is incomplete!");
		System.out.println("Go to AssignedMethods.java and complete the guessSeverity3 method!");

        //Finish your code here
        
		
		
		System.out.println("PRESS ENTER TO CONTINUE");
		in.nextLine();
		
		
		
	}
	
	/*
	 * twoWords4
	 * We recommend that this be the LAST method you code.
	 * 
	 * maybe you should provide input for them
	 */
	public static void twoWords4(HashMap<String, Integer> crimesList) {
		//Delete these print statements once you have completed the method.
		System.out.println("If you are seeing this message, method 4 is incomplete!");
		System.out.println("Go to AssignedMethods.java and complete the twoWords4 method!");
		
		//Finish your code here
		
        
		
		System.out.println("PRESS ENTER TO CONTINUE");
		in.nextLine();
	}
	
	/*
	 * totalSeverity5
	 * We recommend that this be the 1st method you code.
	 * This method adds up the total severity of all crimes in the crimesList map
	 * and prints the result of all the severities added together.
	 * Your job is to:
	 *  - Have some sum variable to add all the severities into
	 *  - Go through each element of the map and addd every value (severity)
	 *    to the sum variable
	 * 
	 * 
	 *  
	 */
	public static void totalSeverity5(HashMap<String, Integer> crimesList) {
		
		//Delete these print statements once you have completed the method.
		System.out.println("If you are seeing this message, method 5 is incomplete!");
		System.out.println("Go to AssignedMethods.java and complete the totalSeverity5 method!");
		
		
		//Finish your code here

        
		System.out.println("PRESS ENTER TO CONTINUE");
		in.nextLine();
	}
	
	/*
	 * instantDismantle6
	 * We recommend that this be the 4th method you code.
	 * This method randomly picks ONE crime in the crimesList map and removes
	 * that crime completely from the list.
	 * Your job is to:
	 *  - Randomly pick ONE crime out of the crimes list (i.e. out of the Strings)
	 *  - Remove that one crime from the crime list
	 * 
	 * 		• Tip: Because the map uses Strings, you have to store each crime as a
	 * 		 String into a separate INDEXED data structure (like an array).
	 * 
	 * 		• You have to use an INDEXED data structure because otherwise, how
	 * 			will you reasonably acquire a random KEY from your map?
	 * 
	 * 		• Using that indexed data structure, you can randomly pick one
	 * 		 out of all possible indices, get the String key at that index,
	 * 		 and delete that key-value pair from the crimesList map.
	 * 
	 * 
	 *  
	 */
	 
	public static void instantDismantle6(HashMap<String, Integer> crimesList) {
		
		//Delete these print statements once you have completed the method.
		System.out.println("If you are seeing this message, method 6 is incomplete!");
		System.out.println("Go to AssignedMethods.java and complete the instantDismantle6 method!");
		
		
		//Finish your code here
		

        
		System.out.println("PRESS ENTER TO CONTINUE");
		in.nextLine();
	}
}
