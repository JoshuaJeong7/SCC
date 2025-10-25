/*
 * idea:
 * we are going to make something with maps that involves literally swapping the keys
 * how:we add in some new key with the same value as an old key, then remove that old key
 * 

  how to make it fun:
  make it like a spy mission, where you have to find certain dangerous words
  (like nuclear or bombs) and dismantle them with harmless garbage
  (in that case its more like a mission to remove keys than to replace them)

  Key:
  10+: Minor
  100+: Serious
  1,000+: Grand
  10,000+: Massacre
  100,000+: Warfare
  1,000,000+: CATASTROPHIC
 */
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class DefuseAgent {
    final int FILE_LENGTH = 33;
    public Scanner returnScanner() {
        String fileName = "dangerwords.txt";
        File file = new File(fileName);
        Scanner in = null;
        try {
            in = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.err.println("Error: File " + fileName + " not found");
        }

        return in;
    }
    public static void main(String[] args) {
        DefuseAgent main = new DefuseAgent();

        Scanner in = main.returnScanner();
        main.printOccurences(in);

        HashMap<String, Integer> crimesList = main.generateCrimes();

        Scanner input = new Scanner(System.in);
        String msg = "" +
                     "" +
                     "";
    }

    
    public HashMap<String, Integer> generateCrimes() {
        return assignCrimes(AssignedMethods.randomUniqueNumbers(6, 1, FILE_LENGTH));
    }

    public HashMap<String, Integer> assignCrimes(HashSet<Integer> selectedNumbers) {

        //NOTE: This is a very wasteful and expensive programming practice
        //but it is the simplest thing to do for now
        Scanner in = returnScanner();

        HashMap<String, Integer> crimesList = new HashMap<String, Integer>();
        int count = 0;
        while (in.hasNext()) {
            count++;
            if (selectedNumbers.contains(count)) {
                crimesList.put(in.next(), in.nextInt());
            }
            in.nextLine();
        }
        in.close();
        return crimesList;
    }
    public void printOccurences(Scanner in) {
        HashMap<String, Integer> occurences = new HashMap<String, Integer>();
        occurences.put("Minor", 0);
        occurences.put("Serious", 0);
        occurences.put("Grand", 0);
        occurences.put("Massacre", 0);
        occurences.put("Warfare", 0);
        occurences.put("CATASTROPHIC", 0);
        while (in.hasNext()) {
            in.next();
            int freq = in.nextInt();
            in.nextLine();
            if (freq < 100) {
                occurences.put("Minor", occurences.get("Minor") + 1);
            }
            else if (freq < 1000) {
                occurences.put("Serious", occurences.get("Serious") + 1);
            }
            else if (freq < 10000) {
                occurences.put("Grand", occurences.get("Grand") + 1);
            }
            else if (freq < 100000) {
                occurences.put("Massacre", occurences.get("Massacre") + 1);
            }
            else if (freq < 1000000) {
                occurences.put("Warfare", occurences.get("Warfare") + 1);
            }
            else {
                occurences.put("CATASTROPHIC", occurences.get("CATASTROPHIC") + 1);
            }
        }
        in.close();
        System.out.println(occurences);
    }

    public void printIntro() {
        String msg1 = "You are an undercover agent who just learned about a potential " +
                      "foreign threat who entered the U.S. You track them down and " + 
                      "interrogate them personally in a room. You do have just a few " +
                      "resources to force your client to confess a limited amount of info. " +
                      "You KNOW for a fact that your client has committed crimes. Your goal" +
                      "is to prevent catastrophe from hitting the U.S! \n\n";

        String msg2 = "The U.S. has a health number based on how \"healthy\" the U.S. is " +
                      "(i.e. how is it's economy, how healthy/alive are citizens, " +
                      "how happy are they, how stable is the government, is this country " +
                      "weak or vulnerable to collapse, etc.). \n" +
                      "Your client has committed 6 of these crimes, and you need to be a " +
                      "detective and figure out + dispatch of each crime. For every crime " +
                      "that you find out from your client, they will be punished for the crime. " +
                      "For every crime that you DON'T figure out from your client, the U.S. will " +
                      "\"take damage\" and lose health. \n" +
                      "Based on how well you did your job, you will receive an end rating " +
                      "which determines how well you did at decoding your client's crimes.\n\n";

        String msg3 = "Here are all of the things you can do to question your client:\n" +
                      "\t- Ask the client for the severity of all 6 crimes (Minor = 10+, " +
                      "Serious = 100+, Grand = 1,000+, Massacre = 10,000+, Warfare = 100,000+, " +
                      "CATASTROPHIC = 1,000,000+)\n\n" +

                      "\t- Guess three letters contained somewhere in the client's crime list, " +
                      "and they will tell you whether the letter do or do not exist FOR EACH crime\n\n" +

                      "\t- Guess a number for the severity of the crime, and for ALL 6 CRIMES they " +
                      "will tell you whether that number is WAY too low, too low, too high, WAY too high, " +
                      "or exactly accurate\n\n" +

                      "\t- DEMAND a word contained in ONE of the client's crimes, and they will " +
                      "randomly pick one word out of their crimes list to share\n\n" +

                      "\t- ";
    }
}
