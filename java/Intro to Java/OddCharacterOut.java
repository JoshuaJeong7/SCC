import java.util.Scanner;
/**
 * UNIT: Using if statements
 * 
 * ASSESSMENT ON: 
 * -Ability to adapt flexibly to new situations with the Scanner class by
 * taking in a char as the user input
 * -Ability to use if statements to check the winning condition
 * -Ability to use the indexOf function with Strings
 * 
 * NOT ASSESSED AT ALL:
 * -Ability to generally create and set up the Scanner class
 * -The usage of methods
 * -The knowledge of ASCII and its relationship with char values
 * -While loops
 * -Creating the generated random line itself (involves loops, booleans, if statements, Math.random)
 * 
 */
public class OddCharacterOut {
	public static void main(String[] args) {
		
		///NOTE TO STUDENTS: These are the instructions for the program
		System.out.println("\n \n This program will print one line that stores a wide" +
		" variety of random characters and symbols. \n (NOTE: Depending on the size" +
		" of the window, this \"one line\" will actually appear as multiple lines.) \n" +
		" Depending on the input of your choice, your job is to find which index" +
		" one specific character is located inside of that line of characters. \n");
		
		System.out.println("RULES: \n Your chosen character will only appear once. \n \n" +
		" -You can only enter valid characters (characters that appear when typed in general). \n" +
		" For example: Space CAN BE TYPED, letters and numbers can be typed, but delete cannot be typed. \n \n" +
		" -Only symbols with easy access on the keyboard can be typed. \n" +
		" GOOD EXAMPLES (ALLOWED): $, %, ^, & (They can all be easily found on a regular keyboard) \n" +
		" BAD EXAMPLES (PROHIBITED): , ±, œ, ☺ (not universally available for easy access) \n \n" +
		" -The first character is index 0, the second character is index 1, and so on. \n \n" + 
		" -If the line of characters extends past one line on your window (that is," +
		" multiple lines appear on your window), the next index will be the first character" + 
		" on the very next line. \n \n" + 
		" -Be careful when using space as your character, as it is possible " +
		" for space to be the last character in the line and thus become invisible." +
		" \n \n Good luck! \n");

		Scanner reader = new Scanner(System.in);
		System.out.println("\nSAMPLE GAME DEMO (If you're confused on rules, look at this game example!");
		System.out.println("THE GENERATED LINE: \n");
		System.out.println("3%ignr4t9T$h");
		System.out.println("In which index is the character \'g\' found?");
		System.out.println("[user input: 3]");
		System.out.println("Congratulations! You found the index!!!");
		System.out.println("\n PRESS ENTER IF YOU HAVE READ AND UNDERSTOOD THE RULES OF THIS GAME");
		reader.nextLine();
		
		
		System.out.println(">>>>> CREATING THE GAME <<<<<");
		System.out.println("Choose the character that you want the player of the game to find: ");
		///NOTE TO STUDENTS: The variable that represents the input MUST be a char data type.
		char input = reader.nextLine().charAt(0); //THE STUDENTS code this line in
		
		System.out.println("How long do you want your line of characters to be?");
		int length = reader.nextInt();

		System.out.println(">>>>> PLAYING THE GAME <<<<<");
		System.out.println(" \n \n THE GENERATED LINE: \n");
		///NOTE TO STUDENTS: PAY ATTENTION TO THIS STRING VARIABLE!! IT STORES THE LINE OF CHARACTERS!!
		String randomLine = generateRandomLine(input, length);
		System.out.println(randomLine);

		
		///STUDENTS: YOU WILL CODE THE REST OF THE GAME STARTING FROM THIS POINT!
		// Here are some pointers to help you get started:
		//	- "the character" that the player is finding is stored in the variable 'input'.
		//	- Read the rules outlined in the above print statements to determine 
		//	  when the player wins and when the player loses.

		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * NOTE TO STUDENTS: You do not have to worry about this code. All
	 * this function does is generate the line of random characters. You may try to
	 * understand it if you want, but it is not necessary to edit 
	 * this function in any other way.
	 */
	public static String generateRandomLine(char targetChar, int length) {
		String currentLine = "";
		boolean insertedChar = false;
		char newChar = 0;
		for (int i = 0; i < length; i++) {
			newChar = (char)((int)(Math.random() * 95) + 32);
			
			while (insertedChar && newChar == targetChar) 
				newChar = (char)((int)(Math.random() * 95) + 32);
			
			if (newChar == targetChar) insertedChar = true;
			
			currentLine += "" + newChar;
		}
		
		
		if (currentLine.indexOf("" + targetChar) <= -1) {
			
			int randomIndex = (int)(Math.random() * currentLine.length());
			
			if (randomIndex > 0) {
				currentLine = currentLine.substring(0, randomIndex - 1) +
						targetChar + currentLine.substring(randomIndex + 1);
			}
			else
				currentLine = targetChar + currentLine.substring(1);
		}
		
		return currentLine;
	}
}
