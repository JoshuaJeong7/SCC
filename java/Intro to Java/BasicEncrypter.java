//import java.util.Scanner;
/**
 * UNIT: Scanner (and Strings)
 * 
 * ASSESSMENT ON: 
 * -Ability to use Scanner class
 * -Ability to use the substring function with Strings
 * 
 * NOT ASSESSED AT ALL:
 * -The encryption itself (i.e. the knowledge of ASCII and char values)
 * -The usage of methods
 * -If statements
 */
public class BasicEncrypter {
    public static void main(String[] args) {
        //Everything commented out is the intended solution that the students must code.
        
        //Scanner in = new Scanner(System.in);
        
        System.out.println("This program takes in a string and encrypts it," +
            " or shifts all letters two positions down the alphabet. \n" + 
            "For example, \'A\' will become \'C\', \'D\' will become \'F\', " +
            " and so on. \n At the end of the alphabet, \'X\' becomes \'A\' and " +
            " \'Z\' becomes \'B\'. \n Non-letters (numbers, symbols, etc.)" +
            " will not be shifted at all. \n \n");
        System.out.println("Enter your 5-letter word to encrypt:");
        //String input = in.next();
        
        String letter1 = //input.substring(0, 1); 
        String letter2 = //input.substring(1, 2); 
        String letter3 = //input.substring(2, 3); 
        String letter4 = //input.substring(3, 4); 
        String letter5 = //input.substring(4); 
        
        System.out.println("The encrypted word:");
        encryptLetterAndPrint(letter1);
        encryptLetterAndPrint(letter2);
        encryptLetterAndPrint(letter3);
        encryptLetterAndPrint(letter4);
        encryptLetterAndPrint(letter5);
        
        System.out.println();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * NOTE TO STUDENTS: You do not have to worry about this code. All
     * this function does is do the encryption of ONE letter. You may try to
     * understand it if you want, but it is not necessary to edit 
     * this function in any other way.
     */
    public static void encryptLetterAndPrint(String word) {
        char letter = word.charAt(0);
        
        if (letter >= 'A' && letter <= 'Z' || letter >= 'a' && letter <= 'z') {
            letter += 2;
            if ((letter >'Z' && letter < 'a') || (letter > 'Z' && letter < 'a' || letter > 'z'))
                letter -= 26;
        }
        System.out.print(letter);
    }
}
