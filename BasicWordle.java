import java.util.Scanner;
/**
 * UNIT: Methods and Arrays (Intro/Intermediate Java)
 * 
 * ASSESSMENT ON: 
 * -Ability to create and use methods with parameters to manipulate data into
 *         printing the correct output
 * -Knowledge and proficiency with changing values of arrays and the ability
 *         to access the content inside each array element for printing or expressions
 * -Ability to use loops in conjunction with arrays in order to access and
 *         modify each element of the array
 * -Knowledge and proficiency with nested loops in order to process every letter
 *         of all strings inside of an array
 * -Knowledge of NullPointerExceptions and the understanding that an object array
 *         automatically initializes all elements to null, and therefore must all
 *         be instantiated to an empty object before being used
 * -Knowledge of using loops and Scanner in conjunction in order to create
 *        a game with input and results of that input for a limited number of turns
 * -Knowledge and proficiency with the String methods, such as indexOf(),
 *         equals(), and substring()
 * 
 */
 
public class BasicWordle {
    public static void main(String[] args) {
        
        System.out.println("This program simulates a basic version of \"Wordle\". \n" +
        " In Wordle, you have 6 guesses to guess a 5-letter word. \n After every guess," +
        " each of the 5 guessed LETTERS will be individually highlighted different colors. \n" +
        " If a letter is yellow, then that letter exists within the correct word. \n" +
        " If a letter is dark gray, then that letter does not exist within the correct word. \n" +
        " If a letter is green, then not only does that letter exist within the correct word," +
        " the letter is also in the exact same position as the letter in the correct word. \n" +
        " The game is won if every letter is green, so you correctly guessed the word. \n" +
        " If after 6 guesses you do not guess the correct word, the game is lost with " +
        " the correct word displayed. \b Here are some differences between this program" +
        " and the original Wordle to follow when coding this program: \n" +
        " 1) There is a bar of 5 dots (\"•••••\") which represents the GREEN letters. \n" +
        " 2) Next to these dots are listed all YELLOW letters (\"•••••  edf\"). \n" +
        " 3) Unlike the original Wordle, you are allowed to type letter combinations" +
        " that do NOT create a real word. \n" +
        " 4) Green and yellow letters may overlap. (\"•e••e  ete\"). \n" +
        " 5) Unlike Wordle, multiple letters may be yellow according to the guess," +
        " even if the correct word only contains that letter once. \n" +
        " 6) All 6 guess columns must be displayed at all times. Example: \n" +
        "•••e•  edf\n••t••  at\n•a•en  taen\neaten  eaten\n•••••\n•••••\n" +
        " 7) There will be two players: A word creator and a word guesser.\n" +
        " The word creator makes the word to guess, and the word guesser will" +
        " play the game of Wordle to guess the word creator's correct word. \n" +
        " 8) To make this game simple, type everything in lowercase ONLY. \n Good luck! \n");
        
        
        String[] guesses; //FINISH INITIALIZING THE ARRAY!
        
        
        for (int i = 0; i < guesses.length; i++)
            guesses[i] = new String("     ");
        
        Scanner in = new Scanner(System.in);
        System.out.println("WORD CREATOR: What is the correct word that must be guessed?");
        String word = "";
        while (word.length() != 5) {
            System.out.println("Enter a 5-letter word to be guessed.");
            word = in.nextLine();
        }
        ///NOTE TO STUDENTS: PAY ATTENTION TO THIS VARIABLE!! IT IS THE CORRECT
        ///GUESS THAT YOU SHOULD CONSTANTLY BE CHECKING FOR IF THE USER'S RESPONSE
        ///MATCHES THIS VARIABLE!!
        
        System.out.println("\n \n \n \n \n +---------------------+ \n \n \n \n");
        
        System.out.println("WORD GUESSER:");
        
        System.out.println("\n \n \n \n \n +---------------------+ \n \n \n \n");
        
        
        //From here on out, the students see nothing, they must code the entire
        //game by themselves
        printAllGuesses(guesses, word);
        
        for (int i = 0; i < guesses.length; i++) {
            System.out.println("Guess " + (i + 1) + "/" + guesses.length);
         //PROMPT THE USER TO GUESS A WORD
         //If the user enters an invalid word, keep asking them until they enter a valid word
         //Type your code below:
            
            printAllGuesses(guesses, word);
            System.out.println();
            
            //Check if the user guessed the word
          //Type your code below:

         
        }
        
        System.out.println("GAME OVER - The letter was " + word);
    }
    
    /**
     * 
     */
    public static void printAllGuesses(String[] guesses, String correctWord) {

        //NOTE: When the students receive the code, this is all they will receive
        //inside the method:
        for (int i = 0; i < guesses.length; i++) {
            //Print all green letters
            for (int a = 0; a < 5; a++) {
                System.out.print("•");
            }
        
            System.out.print("  ");
        
            //Print all yellow letters
            for (int a = 0; a < 5; a++) {
        
            }
        }
    }

}
