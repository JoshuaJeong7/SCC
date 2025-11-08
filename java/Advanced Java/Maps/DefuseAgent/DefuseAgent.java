import java.util.Scanner;
import java.util.HashSet;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * @author Joshua Jeong
 * @since Created Friday, October 24th, 2025
 * @since Last modified Friday, October 31st, 2025
 */
public class DefuseAgent {
	
    final int FILE_LENGTH = 34;
    
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
    
    public void printAllCrimes() {
		
		//NOTE: This is a very wasteful and expensive programming practice
        //but it is the simplest thing to do for now
        
        Scanner filer = returnScanner();
        while (filer.hasNext()) {
			String name = filer.next();
			int severity = filer.nextInt();
			String classification = "";
			if (severity < 100) classification = "Minor";
			else if (severity < 1000) classification = "Severe";
			else if (severity < 10000) classification = "Grand";
			else if (severity < 100000) classification = "Massacre";
			else if (severity < 1000000) classification = "Warfare";
			else classification = "CATASTROPHIC";
			System.out.printf("Crime: %-27s Severity: %-10d (%s)%n", name, severity, classification);
			filer.nextLine();
		}
		Scanner confirm = new Scanner(System.in);
		System.out.println("\nPRESS ENTER TO CONTINUE");
		confirm.nextLine();
		filer.close();
	}
	
    public static void main(String[] args) {
        DefuseAgent main = new DefuseAgent();
		main.printIntro();
		
        //main.printOccurences();

        HashMap<String, Integer> crimesList = main.generateCrimes();
        System.out.println("Agent, your client has arrived.");

        main.interrogateCrimes(crimesList);
        AssignedMethods.guessCrimes(crimesList);
        main.printResults(crimesList);
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
                crimesList.put(removeHyphen(in.next()), in.nextInt());
            }
            in.nextLine();
        }
        in.close();
        return crimesList;
    }
    public String removeHyphen(String str) {
		String newStr = "";
		String[] temp = str.split("-");
		for (String i : temp)
			newStr += i + " ";
			
		String finalStr = newStr.substring(0, newStr.length() - 1);
		return finalStr;
	}
    
    public void interrogateCrimes(HashMap<String, Integer> crimesList) {
		Scanner input = new Scanner(System.in);
		
		int userChoice = -1;
		int questionsLeft = 3;
		
		while (questionsLeft > 0) {
			userChoice = -1;
			while (userChoice < 0 || userChoice > 6) {
				
				System.out.println("Number of questions available: " + questionsLeft);
				System.out.println("How would you like to interrogate your client?");
				System.out.println("1: Ask the severity CLASSIFICATION of all their crimes");
				System.out.println("2: Guess five letters contained in each crime");
				System.out.println("3: Guess a number for the severity of each crimes");
				System.out.println("4: Demand two word contained anywhere in their crimes list");
				System.out.println("5: Demand the total severity level of all their crimes combined");
				System.out.println("6: Instantly confess and dismantle one crime");
				System.out.println("0 (help): Get a list of all possible crimes in this game");
				userChoice = input.nextInt();
				input.nextLine();
			}
			
			switch (userChoice) {
				case 1:
					AssignedMethods.classificationEach1(crimesList);
				break;
				case 2:
					AssignedMethods.fiveLetters2(crimesList);
				break;
				case 3:
					AssignedMethods.guessSeverity3(crimesList);
				break;
				case 4:
					AssignedMethods.twoWords4(crimesList);
				break;
				case 5:
					AssignedMethods.totalSeverity5(crimesList);
				break;
				case 6:
					AssignedMethods.instantDismantle6(crimesList);
				break;
				case 0:
					printAllCrimes();
					questionsLeft++;
				break;
				default:
					continue;
			}
			questionsLeft--;
		}
	}
    
    public void printResults(HashMap<String, Integer> crimesList) {
		
		int usHealth = 1000000;
		
		//How well you did as an agent is based on a 5-star system.
		//The determination for earning stars is basically how many dismantles you had.
		int stars = 0;
		
		System.out.println("Here is the total damage the U.S. has suffered for");
		System.out.println("undismantled crimes, if any.");
		System.out.println("U.S. Starting Health: " + usHealth + "\n");
		
		if (crimesList.isEmpty()) {
			System.out.println("All crimes have been dismantled!");
		}
		else {
			System.out.println("|| DAMAGE SUFFERED ||\n");
			for (String crime : crimesList.keySet()) {
				System.out.println("Crime: " + crime);
				System.out.println("Damage suffered: " + crimesList.get(crime));
				usHealth -= crimesList.get(crime);
				System.out.println("U.S. Health left: " + usHealth + "\n");
			}
		}
		System.out.println("Final U.S. Health: " + usHealth);
		
		//If the user did correctly dismantled 0-1 crimes, they get 1 star.
		if (crimesList.size() == 5)
			stars = 1;
		else if (crimesList.size() == 4 || crimesList.size() == 3) //Dismantled 2-3 crimes
			stars = 2;
		else if (crimesList.size() == 2) //Dismantled 4 crimes
			stars = 3;
		else if (crimesList.size() == 1) //Dismantled 5 crimes
			stars = 4;
		else if (crimesList.size() == 0) //Dismantled all 6 crimes
			stars = 5;
			
		//Regardless of guesses, if the U.S. has "died", then you get 0 stars and lose.
		if (usHealth <= 0) {
			stars = 0;
			System.out.println("YOU FAILED TO SAVE THE U.S.");
		}
		System.out.println("Final star count: " + stars);
	}
	
	/**
	 * Utility method; Prints the occurrences of ranked labels of severity
	 * within the full list of possible crimes
	 * @param in	The file scanner
	 */
    public void printOccurences() {
		//NOTE: This is a very wasteful and expensive programming practice
        //but it is the simplest thing to do for now
		Scanner in = returnScanner();
		
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
	
    public static boolean isFiveLetters(String testStr) {
		if (testStr == null || testStr.length() != 5) return false;
		
		for (char i : testStr.toCharArray()) {
			if (!Character.isLetter(i) && i != ' ')
				return false;
		}
		return true;
	}

    public void printIntro() {
        String msg1 = "You are an undercover agent who just learned about a potential\n" +
                      "foreign threat who entered the U.S. You track them down and\n" + 
                      "interrogate them personally in a room. You do have just a few\n" +
                      "resources to force your client to confess a limited amount of info.\n" +
                      "You KNOW for a fact that your client has committed 6 crimes. Your goal\n" +
                      "is to prevent catastrophe from hitting the U.S! \n\n";

        String msg2 = "The U.S. has a health number based on how \"healthy\" the U.S. is\n" +
                      "(i.e. how is it's economy, how healthy/alive are citizens,\n" +
                      "how happy are they, how stable is the government, is this country\n" +
                      "weak or vulnerable to collapse, etc.).\n" +
                      "Your client has committed 6 of these crimes, and you need to be a\n" +
                      "detective and figure out and dispatch of each crime.\n" +
                      "Each of your client's crimes has a \"severity\", which basically means\n" +
                      "how much \"damage\" that specific crime does.\n" +
                      "For every crime that you find out from your client, these crimes will be\ndismantled.\n" +
                      "For every crime that you DON'T figure out from your client, the U.S. will\n" +
                      "\"take damage\" based on the severity of your client's crime.\n" +
                      "Based on how well you did your job, you will receive an end rating\n" +
                      "which determines how well you did at decoding your client's crimes.\n\n";

        String msg3 = "Here are all of the things you can do to question your client.\n" +
					  "Note that you can only ask THREE questions, so choose wisely!\n\n" +
					  
                      " - Ask the client for the severity CLASSIFICATION of all 6 crimes\n(Minor = 10+,\n" +
                      "Serious = 100+, Grand = 1,000+, Massacre = 10,000+, Warfare = 100,000+,\n" +
                      "CATASTROPHIC = 1,000,000+)\n\n" +

                      " - Guess five letters contained somewhere in the client's crime list,\n" +
                      "and they will tell you whether each letter does or does not exist FOR EACH crime\n\n" +

                      " - Guess a number for the severity of the crime, and for ALL 6 CRIMES they\n" +
                      "will tell you whether that number is WAY too low, too low, too high, WAY too high,\n" +
                      "or exactly accurate\n\n" +

                      " - DEMAND two words contained in ANY of the client's crimes, and they will\n" +
                      "randomly pick two words out of their crimes list to share\n\n" +

                      " - DEMAND the client return the total severity of all of their crimes combined\n\n" +
                      
                      " - Instantly figure out and dismantle ONE of their crimes for free\n";
                      
         
         String msg4 = "Once you have asked your three questions, you must make a guess on all 6 (or 5) crimes. \n" +
					   "Good Luck!";
						
         
         Scanner user = new Scanner(System.in);
         System.out.println(msg1);
         System.out.println("TYPE \"skip\" TO SKIP INTRO; ANYTHING ELSE TO CONTINUE");
         String userInput = user.nextLine();
         if (userInput.equals("skip")) return;
         
         System.out.println(msg2);
         System.out.println("TYPE \"skip\" TO SKIP INTRO; ANYTHING ELSE TO CONTINUE");
         userInput = user.nextLine();
         if (userInput.equals("skip")) return;
         
         System.out.println(msg3);
         System.out.println("TYPE \"skip\" TO SKIP INTRO; ANYTHING ELSE TO CONTINUE");
         userInput = user.nextLine();
         if (userInput.equals("skip")) return;
         
         System.out.println(msg4);
         System.out.println("PRESS ENTER TO CONTINUE");
         user.nextLine();
    }
}

