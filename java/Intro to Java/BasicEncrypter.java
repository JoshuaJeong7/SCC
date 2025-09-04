//import java.util.Scanner;
/**
 * UNIT: Encryption
 * 
 * ASSESSMENT ON: 
 * -Encryption (the knowledge of ASCII)
 * -Ability to utilize loops 
 * -Ability to use the substring function with Strings
 */
public class BasicEncrypter {
    public static void main(String[] args) {
        System.out.println("Enter your 5-letter word to encrypt:");
        String input = in.next();
        
        encryptAndPrint(input);
        
        System.out.println();
    }
    
    /**
     * NOTE TO STUDENTS: This is the method where you need to finish
     * the encryption code!
     * If you do not know what encryption is, it is basically shifting
     * the letters of a character 2 letters down the alphabet.
     * Ex: A -> C; E -> G; Z -> B; X -> A (In the last two cases, we wrapped back to A)
     * Non-letters (numbers, symbols, etc.) will not be shifted at all.
     */
    public static void encryptAndPrint(String word) {
        System.out.println("Before encryption: " + word);
        String newWord = "";
        for (int i = 0; i < word.length; i++) {
            char currLetter = newWord.charAt(i);

            //FINISH THE ENCRYPTION HERE
        }
        System.out.print("After encryption: " + newWord);
    }
}
