import java.util.Scanner;
public class ZombieTrain {
	
	/// +----------------------+   LINKED LISTS   +----------------------+
	TrainCar moduleStart;
	int size;
	
	/// +----------------------+   WINNING THE GAME   +----------------------+
	private int deadCars;
	private int savedCars;
	private boolean gameIsRunning;
	
	
	
	/// +-----------------+   POWER LEVELS AND RESOURCES  +------------------+
	private int gunPower;
	private int vaccinePower;
	private int resources;
	private int resourcePower;
	
	
	
	/// +----------------------+   MISC OPTIONS   +----------------------+
	private int bankMoney;
	
	public ZombieTrain() {
		this(7);
	}
	
	public ZombieTrain(int trainLength) {
		moduleStart = null;
		for (int i = 0; i < trainLength; i++) {
			addCar();
		}
		
		
		deadCars = 0; //The amount of cars where there are no humans left
		savedCars = 0; //The amount of cars where there are no zombies left
		gameIsRunning = true;
		
		
		gunPower = 1;
		vaccinePower = 0;
		resources = 10;
		resourcePower = 0;
		
		
		bankMoney = 0;
	}
	
	public void zombieAttack() {
		TrainCar tempCar = moduleStart; //WE DO NOT WANT TO CHANGE THE
		//MEMORY ADDRESS (or "house") moduleStart IS REFERRING TO, 
		//so we will use tempCar instead.
		
		for (int i = 0; i < 7; i++) {
			
			//For each zombie attack, the amount of zombie power determines
			//how many humans are converted into zombies.
			if (tempCar.accessible) {
				
					int livesLost = Math.min(tempCar.humans, tempCar.zombiePower);
					//The amount of lives lost will never exceed the total number
					//of humans.
					tempCar.humans -= livesLost;
					tempCar.zombies += livesLost;
					tempCar.zombiePower = tempCar.zombies; //Zombie power gets stronger with each round.

				
				
				//On the offchance that there are no more humans left in this car,
				//reset them to zero and count that car as dead.
				if (tempCar.humans <= 0) {
					tempCar.humans = 0;
					tempCar.accessible = false;
				}
		}
			
			
			//Repeat this process on the next car.
			tempCar = tempCar.next;
			
		}
	}
	
	public static void main(String[] args) {
		
		ZombieTrain zt = new ZombieTrain();
		zt.welcomeInformation();
		zt.runGame();
		
		
		//System.out.println("You will");
		//System.out.println("lose resources the more the people dislike you, such as by killing humans");
		//System.out.println("or failing to spark a rebellion within a train car.\n");
	}
	
	
	
	
	
	
	public void runGame() {
		int day = 1;
		
		while (gameIsRunning) {
			printTrain();
			
			//check for game ending conditions
			if (resources < 0) {
				System.out.println("You lost! You ran out of money to operate.");
				gameIsRunning = false;
				break;
			}
			if (deadCars == 7) {
				System.out.println("You lost! The zombies overran the train.");
				gameIsRunning = false;
				break;
			}
			else if (savedCars == 7) {
				System.out.print("You win! Your brilliance has guided the ");
				System.out.println("passengers to their survival.");
				gameIsRunning = true;
				break;
			}
			
			System.out.println("\n\nDAY " + day);
			
			askOptions();
			
			//This is what happens at the end of each day
			day++;
			bankMoney += bankMoney * 0.3;
			resources += resourcePower;
			
			//Every OTHER day, zombies will attack.
			if (day % 2 == 1)
				zombieAttack();
			
			//Every fifth day, a zombie will simply enter each train, so don't think
			//your saved cars are truly safe forever!
			if (day % 5 == 0) {
				///  This is the basic code for transversing an entire list.
				TrainCar currentCar = moduleStart;
				while (currentCar != null) {
					currentCar.zombies += 1;
					
					currentCar = currentCar.next;
				}
			}
			
			
			//Finally, we will calculate how many cars are dead and how many
			//are saved.
			calculateDeadAndSaved();
		}
	}
	
	public void askOptions() {		
		Scanner in = new Scanner(System.in);
		System.out.println("Resources: " + resources);
		System.out.println("Vaccine power: " + vaccinePower);
		System.out.println("DEAD CARS = " + deadCars);
		System.out.println("SAVED CARS = " + savedCars);
		System.out.println("Current Bank Money = " + bankMoney);
		System.out.println("PRESS ENTER TO CONTINUE");
		in.nextLine();
		int option = 0;
		
		
		do {
			System.out.println("\nWhat do you want to do?");
			System.out.println("1: Attack options");
			System.out.println("2: Vaccine options");
			System.out.println("3: Economy options");
			System.out.println("4: Desperation options");
			option = in.nextInt();
			in.nextLine(); //Clears the buffer (consumes the extra "enter" key left behind)
			
			
			if (option == 1) {
				fightOptions(in);
			}
			else if (option == 2) {
				vaccineOptions(in);
			}
			
			else if (option == 3) {
				economyOptions(in);
			}
			else if (option == 4) {
				desperationOptions(in);
			}
			else {
				System.out.println("Enter a valid number between 1-4.");
			}
		} while (option < 1 || option > 4);
	}
	

	/**
	 * 
	 * 
	 * 
	 * 
	 *               FIGHT OPTIONS
	 * 
	 * 
	 * 
	 * 
	 * 
	 */ 
	public void fightOptions(Scanner in) {
		
		System.out.println("The best anti-zombie defense is to fight.");
		String printedMsg = "What would you like to do? (DP: " + gunPower + ")\n";
		printedMsg += "1: (see #2. for price) Fire: Shoot at the current zombies in the train (kills " + (gunPower * gunPower) + " zombies)\n";
		printedMsg += "2: (variable price) Upgrade: Upgrade your gun (boosts all stats)";
		int option = getNumericOption(in, printedMsg, 1, 2);
		
		if (option == 1 && confirmChoice(in, (gunPower - 1) * 4)) { 
			fire(in);
		}
		else if (option == 2) {
			upgrade(in);
		}
	}

	public void fire(Scanner in) {
		TrainCar selectedCar = selectCar(false);
		int zombiesKilled = Math.min(selectedCar.zombies, gunPower * gunPower);
		//The amount of zombies killed (never exceeds the total amount of zombies.
		selectedCar.zombies -= zombiesKilled;
		selectedCar.dead += zombiesKilled;
			
		if (selectedCar.zombies <= 0) {
			selectedCar.zombies = 0;
			selectedCar.accessible = false;
		}
	}
	public void upgrade(Scanner in) {
		String levelMsg = "Level 1: Starting level; kills 1 zombie, $0 to shoot\n";
		levelMsg += "Level 2: 10 RESOURCES; kills 4 zombies, $4 to shoot\n";
		levelMsg += "Level 3: 15 RESOURCES; kills 9 zombies, $8 to shoot\n";
		levelMsg += "Level 4: 20 RESOURCES; kills 16 zombies, $12 to shoot\n";
		levelMsg += "Level 5: 25 RESOURCES; kills 25 zombies, $16 to shoot\n";
		levelMsg += "Level 6: 30 RESOURCES; kills 36 zombies, $20 to shoot\n";
		levelMsg += "Level 7: 35 RESOURCES; kills 49 zombies, $24 to shoot\n";
		levelMsg += "Level 8: 40 RESOURCES; kills 64 zombies, $28 to shoot\n";
		levelMsg += "Level 9: 45 RESOURCES; kills 81 zombies; $32 to shoot\n";
		levelMsg += "Level 10: 50 RESOURCES; kills 100 zombies; $36 to shoot\n";
		levelMsg += "Choose a level to upgrade your gun to.\n";
		levelMsg += "CURRENT LEVEL: " + gunPower;
		int levelChoice = -1;
		do {
			levelChoice = getNumericOption(in, levelMsg, 1, 10);
			if (levelChoice <= gunPower) {
				System.out.println("You already have this level!");
				System.out.println("PRESS ENTER TO TRY AGAIN");
				in.nextLine();
			}
		} while (levelChoice <= gunPower);
		
		if (confirmChoice(in, levelChoice * 5))
			gunPower = levelChoice;
	}
	
	/**
	 * 
	 * 
	 * 
	 * 
	 *               VACCINE OPTIONS
	 * 
	 * 
	 * 
	 * 
	 * 
	 */ 
	public void vaccineOptions(Scanner in) {
		System.out.println("Stopping the outbreak is your best chance to win.");
		String printedMsg = "What would you like to do?\n";
		printedMsg += " 1: ($M5) Lab Research - Work on your vaccine research (Current power: " + vaccinePower + ")\n";
		printedMsg += "2: ($0) Vaccinate Humans - Vaccinates 1 human per vaccine power used up\n";
		printedMsg += "3: ($10) Convert Zombies - Convert ZOMBIES into humans Converts 1 zombie per FOUR vaccine power used into a human\n";
		
		int option = getNumericOption(in, printedMsg, 1, 3);
		
		if (option == 1) {
			labResearch(in);
		}
		else if (option == 2 && confirmChoice(in, 0)) {
			vaccinateHumans(in);
		}
		else if (option == 3 && confirmChoice(in, 10)) {
			convertZombies(in);
		}
	}
	
	public void labResearch(Scanner in) {
		System.out.println("You will need to spend 5 resources for every 10 vaccine research.");
		System.out.println("Ex: 10 vaccine = $5, 40 vaccine = $20 etc.");
		System.out.println("NOTE: You will be SCAMMED for trying to get Vaccine Power that aren't multiples of 2!");
		System.out.println("Please enter the vaccine power you want in multiples of 2!\n");
			
		String printedMsg = "Choose how much vaccine power you want to buy (no max limit)";
		int vaccineBought = getNumericOption(in, printedMsg, 0, Integer.MAX_VALUE);
		
		int cost = vaccineBought / 2;
			
		if (confirmChoice(in, cost);
		vaccinePower += vaccineBought;
		System.out.println("Your vaccine progress has become stronger!");
		System.out.println("Current vaccine power: " + vaccinePower);
		System.out.println("PRESS ENTER TO CONTINUE");
		in.nextLine();
	}
	
	public void vaccinateHumans(Scanner in) {
		TrainCar selectedCar = selectCar(false);
		String printedMsg = "Enter how many humans you want to vaccinate (0-" + selectedCar.humans +"):";
		int humansConverted = -1;
		do {
			int humansConverted = getNumericOption(in, printedMsg, 0, selectedCar.humans);
			if (humansConverted > vaccinePower) {
				System.out.println("Not enough vaccine power (" + vaccinePower + ") to treat humans (" + humansConverted + ")!");
			}
		} while (humansConverted > vaccinePower);
			
		vaccinePower -= humansConverted;
		selectedCar.humans -= humansConverted;
		selectedCar.immune += humansConverted;
	}
	public void convertZombies(Scanner in) { 
		TrainCar selectedCar = selectCar(true);
		String printedMsg = "Enter how many zombies you want to convert (0-" + selectedCar.zombies + "):";
		int zombiesConverted = -1;
		do {
			int zombiesConverted = getNumericOption(in, printedMsg, 0, selectedCar.zombies);
			if (zombiesConverted > vaccinePower * 4) {
				System.out.println("Not enough vaccine power (" + vaccinePower+ ") to convert zombies (" + zombiesConverted + ")!");
			}
		} while (zombiesConverted > vaccinePower * 4);
			
		vaccinePower -= zombiesConverted * 4;
		selectedCar.zombies -= zombiesConverted;
		selectedCar.immune += zombiesConverted;
	}
	
	/**
	 * 
	 * 
	 * 
	 * 
	 *               ECONOMY OPTIONS
	 * 
	 * 
	 * 
	 * 
	 * 
	 */ 
	public void economyOptions(Scanner in) {
		
		System.out.println("Money fuels everything.");
		String printedMsg = "What would you like to do?\n";
		printedMsg += "1: ($" + resourcePower + ") Stronger Business - Increase money output (Current gain per round: " + resourcePower + ")\n";
		printedMsg += "2: (-$60 to $100) Stock Gambling - Gamble on the stock market\n";
		printedMsg += "3: ($10) Bank Deposit - Deposit selected money into bank (30% interest)\n";
		printedMsg += "4: ($0) Bank Withdraw - Withdraw selected money from bank";
		
		int option = getNumericOption(in, printedMsg, 1, 4);
		
		
		if (option == 1 && confirmChoice(in, resourcePower)) {
			strongerBusiness(in);
		}
		else if (option == 2) {
			stockGamble(in);
		}
		
		else if (option == 3 || option == 4) {
			System.out.println("\nThe bank has a very powerful interest rate at 30%.");
			System.out.println("Current bank storage: " + bankMoney);
			
			
			
				
				
			if (option == 3 && confirmChoice(in, 10)) {
				bankDeposit(in);
			}
			else if (option == 4 && confirmChoice(in, 0)) {
				bankWithdraw(in);
			}
		}
	}
	
	public void strongerBusiness(Scanner in) {
		if (resourcePower == 0) {
			System.out.println("Resource power started at 2!");
			resourcePower = 2;
		}
		else {
			System.out.println("Resource power doubled!");
			resourcePower *= 2;
		}
		System.out.println("Current gain per round: " + resourcePower);
		System.out.println("PRESS ENTER TO CONTINUE");
		in.nextLine();
	}
	
	public void stockGamble(Scanner in) {
		System.out.println("You can WIN up to 100 resources OR LOSE up to 60 resources.");
		System.out.println("Do you like to gamble?");
		if (confirmChoice(in, 0)) {
			int winOrLose = (int)(Math.random() * 161 - 60);
				
			//This game can be very unbalanced if you could actually earn 100 resources in one turn, so
			//the chances of getting a big win or a big loss are further weighted to only happen 25% of the time.
			//The other 75% of the time, your earnings/losses are cut into fourths.
			int bigWinChance = (int)(Math.random() * 4);
			if (bigWinChance != 0) {
				winOrLose /= 4;
			}
				
			if (winOrLose > 0) {
				System.out.println("YOU WON " + winOrLose + " RESOURCES!!!");
			}
			else {
				System.out.println("YOU LOST " + (-winOrLose) + " RESOURCES");
			}
			
			System.out.println("PRESS ENTER TO CONTINUE");
			in.nextLine();
			resources += winOrLose;
				
		}
	}
	public void bankDeposit(Scanner in) {
		//This gets the user input for how much money to deposit
		int deposit = -1;
		while (deposit <= 0 || deposit > resources) {
			System.out.println("Enter the amount of resources you want to deposit. (YOU HAVE " + resources + " RESOURCES)");
			deposit = in.nextInt();
			in.nextLine();
					
			if (deposit <= 0 || deposit > resources) {
				System.out.println("Please enter a nonzero number within your budget range!");
			}
		}
				
		//This puts money from the resources into the bank
		bankMoney += deposit;
		resources -= deposit;
	}
	
	public void bankWithdraw(Scanner in) {
		//This gets the user input for how much money to withdraw
		int withdraw = -1;
		while (withdraw <= 0 || withdraw > resources) {
			System.out.println("Enter the amount of resources you want to withdraw. (YOU HAVE $" + bankMoney + " STORED)");
			withdraw = in.nextInt();
			in.nextLine();
					
			if (withdraw <= 0 || withdraw > resources) {
				System.out.println("Please enter a nonzero number within your bank's storage!");
			}
		}
				
		//This puts money from the resources into the bank
		bankMoney += withdraw;
		resources -= withdraw;
	}
	
	/**
	 * 
	 * 
	 * 
	 * 
	 *               DESPERATION OPTIONS
	 * 
	 * 
	 * 
	 * 
	 * 
	 */ 
	public void desperationOptions(Scanner in) {
		int option = 0;
		System.out.println("\nDesperate times calls for desperate measures.");
		String printedMsg = "What ability would you like to use?\n";
		printedMsg += "1: ($100) Sterilization Nuke - Annihlate all cars except one. Better to handle one problem than seven at a time.\n";
		printedMsg += "2: ($40) Arise - A selected number of dead humans are converted into vaccinated humans. Requires LOTS of vaccine research.\n";
		printedMsg += "3: [NOT CODED; ADVANCED] Transcend Space - For 3 days, any one action you do affects every car.";
		printedMsg += "4: [NOT CODED; ADVANCED] Time Stop - Days stop moving forward for 3 turns.";
		option = getNumericOption(in, printedMsg, 1, 2);
		
		
		if (option == 1 && confirmChoice(in, 100)) {
			sterilizationNuke(in);
		}
		if (option == 2 && confirmChoice(in, 40)) {
			arise(in);
		}
		else if (option == 3 || option == 4) {
			System.out.println("Sorry, this function has not been coded yet. Try adding this functionality into the code yourself!");
			System.out.println("Here's 10 resources as compensation.");
			resources += 10;
		}
	}
	
	public void sterilizationNuke(Scanner in) {
		System.out.println("Here is the current condition of all cars.\nChoose wisely which car you want to operate on. [PRESS ENTER TO CONTINUE]");
		in.nextLine();
		printTrain();
		System.out.println("\nChoose a car to be saved. (numbers 1-7)->");
		int saved = in.nextInt();
		 
		TrainCar carToBeSaved = getCar(saved - 1);
		 
		TrainCar tempCar = moduleStart;
		while (tempCar != null) {
			if (tempCar != carToBeSaved) {
				tempCar.humans = 0;
				tempCar.zombies = 0;
				tempCar.dead = 200;
				tempCar.accessible = false;
			}
			tempCar = tempCar.next;
		}
		 
		 
		System.out.println("EVERY CAR EXCEPT CAR " + saved + " HAS BEEN DEMOLISHED");
	}
	 
	public void arise(Scanner in) {
		System.out.println("The conversion rate is as follows:");
		String printedMsg = "20 vaccine research is SACRIFICED for every human you want to revive and vaccinate.\n";
		printedMsg += "Current vaccine research: " + vaccinePower + "\n";
		printedMsg += "How many DEAD humans do you want to revive into vaccinated humans? (0-200)";
		int reviveNum = getNumericOption(in, printedMsg, 0, 200);
		
		System.out.println("Vaccine research required to sacrifice: " + reviveNum * 20);
		
		
		//Note: We have to re-code the systems from confirmChoice() because
		//we are no longer "buying" this item with resources, but with vaccine power.
		String result = "";
		do {
			System.out.println("Are you sure you want to continue? (Y/N)");
			result = in.nextLine();
			if (!result.equalsIgnoreCase("y") && !result.equalsIgnoreCase("n")) {
				System.out.println("Please enter a response that is either Y or N.");
			}
		} while (!result.equalsIgnoreCase("y") && !result.equalsIgnoreCase("n"));
		
		if (result.equalsIgnoreCase("n") || vaccinePower < reviveNum * 20) {
			System.out.println("You are declined of this offer because either you stated no or you don't have enough vaccine power (" + vaccinePower + " RESEARCH).");
			System.out.println("PRESS ENTER TO CONTINUE");
			in.nextLine();
		}
		else {
			TrainCar carToOperate = selectCar(true);
			carToOperate.dead -= reviveNum;
			carToOperate.immune += reviveNum;
			vaccinePower -= reviveNum * 20;
		}
	}
	public void transcendSpace() {
		//Try to write code for Transcend Space!
	}
	 
	 
	 
	/**
	 * 
	 * 
	 * 
	 * 
	 *               GENERAL MISC TASKS
	 * 
	 * 
	 * 
	 * 
	 * 
	 */ 
	public int getNumericOption(Scanner in, String message, int low, int high) {
		int option = low - 1;
		do {
			System.out.println(message);
			option = in.nextInt();
			in.nextLine(); //Clears buffer (gets rid of that extra "enter" in the scanner)
			if (option < low || option > high) {
				System.out.println("Please enter a valid number (" + low + " - " + high + ")");
			}
		} while (option < low || option > high);
		
		return option;
	}
	
	
	
	public boolean confirmChoice(Scanner in, int cost) {
		String result = "";
		
		System.out.println("Cost for this move: " + cost + " RESOURCES");
		do {
			System.out.println("Are you sure you want to continue? (Y/N)");
			result = in.nextLine();
			if (!result.equalsIgnoreCase("y") && !result.equalsIgnoreCase("n")) {
				System.out.println("Please enter a response that is either Y or N.");
			}
		} while (!result.equalsIgnoreCase("y") && !result.equalsIgnoreCase("n"));
		
		
		if (result.equalsIgnoreCase("y") && resources >= cost) {
			resources -= cost;
			return true;
		}
		else {
			System.out.println("You are declined of this offer because either you stated no or you don't have enough resources (" + resources + " RESOURCES).");
			System.out.println("PRESS ENTER TO CONTINUE");
			in.nextLine();
		}
		return false;
	}
	
	
	
	public TrainCar selectCar(boolean canAccessDeadCars) {
		Scanner s = new Scanner(System.in);
		System.out.println("First, pick a train car to operate within.");
		if (canAccessDeadCars) {
			System.out.println("FOR THIS SPECIFIC MOVE, YOU ARE ALLOWED TO ACCESS BOTH" + 
			 " DEAD AND SAVED CARS!");
		}
		System.out.println("[PRESS ENTER TO CONTINUE]");
		s.nextLine();
			
		TrainCar selectedCar = null;
		do {	
			printTrain();
			
			
			
			int carNum = -1;
			while (carNum < 1 || carNum > size) {
				System.out.println("\nWhich train car would you like to travel to?");
				carNum = s.nextInt();
				s.nextLine(); //Clears the buffer
				
				if (carNum < 0 || carNum >= size) {
					System.out.println("Please pick a valid number between 1 and " + size);
				}
			}
			
			
			
			selectedCar = getCar(carNum - 1); //indexes start at 0
			
			if (!canAccessDeadCars && !selectedCar.accessible) {
				System.out.println("Error: This train car is not accessible because it is either dead or saved.");
				System.out.println("PRESS ENTER TO TRY AGAIN");
				s.nextLine();
			}
		} while (!selectedCar.accessible);
				
		return selectedCar; 
		
	}
	
	
	public void calculateDeadAndSaved() {
		TrainCar currentCar = moduleStart;
		deadCars = 0;
		savedCars = 0;
		while (currentCar != null) {
			if (currentCar.humans == 0) {
				deadCars++;
			}
			if (currentCar.zombies == 0) {
				savedCars++;
			}
			currentCar = currentCar.next;
		}
	}
	
	/**
	 * 
	 * 
	 * 
	 * 
	 *               PRINTING THE ENTIRE TRAIN
	 * 
	 * 
	 * 
	 * 
	 * 
	 */ 
	 public void printTrain() {
		 TrainCar tempCar = moduleStart;
		 int carNumber = 1;
		 while (tempCar != null) {
			 System.out.println("      -+-      ");
			 System.out.println("      (|)      ");
			 System.out.println("+—————————————+");
			 System.out.println("| TrainCar  " + carNumber + " |");
			 System.out.println("|             |");
			 System.out.printf("| humans: %3d |\n", (tempCar.humans + tempCar.immune));
			 System.out.printf("|zombies: %3d |\n", tempCar.zombies);
			 System.out.printf("| dead:  %3d  |\n", tempCar.dead);	 
			 System.out.println("+—————————————+");
			 System.out.println("      (|)      ");
			 
			 
			 
			 tempCar = tempCar.next; //Move to the next TrainCar.
			 carNumber++;
		 }
	 }
	 
	 
	/**
	 * 
	 * 
	 * 
	 * 
	 *               ADDING AND GETTING NODES WITHIN THE TRAIN
	 * 
	 * 
	 * 
	 * 
	 * 
	 */ 
	public void addCar() {
		
		//If there are no existing train cars, set the root node equal to 
		//a new train car. Otherwise, set the 'next' node of the LAST
		//train car to yet another new train car.
		if (moduleStart == null) {
			moduleStart = new TrainCar();
		}
		else {
			TrainCar lastCar = getCar(size - 1);
			lastCar.next = new TrainCar();
		}
		
		//Update size to reflect our changes
		size++;
	}
	
	public TrainCar getCar(int index) throws IndexOutOfBoundsException {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException("Error: Train car out of bounds with index " + index + " for length " + size);
		}
		
		
		TrainCar tempCar = moduleStart;
		for (int i = 0; i < index; i++) {
			tempCar = tempCar.next;
		}
		return tempCar;
	}
	
	/**
	 * 
	 * 
	 * 
	 * 
	 *               WELCOME INFORMATION
	 * 
	 * 
	 * 
	 * 
	 * 
	 */ 
	public void welcomeInformation() {
		Scanner s = new Scanner(System.in);
		System.out.println("    Welcome to ZombieTrain, inspired by games like"); 
		System.out.println("Plague Inc. A terrible virus has broken out in");
		System.out.println("a train of 7 cars, and in each of these 7 cars,");
		System.out.println("one unfortunate soul has been infected and mutilated");
		System.out.println("into a zombie.\n ");
		
		System.out.println("    Your job is to exterminate all zombies in the train.");
		System.out.println("Every other day, the zombie horde will eat and directly convert");
		System.out.println("the train's passengers into zombies, and they will get");
		System.out.println("stronger each day.\n");
		
		System.out.println("PRESS ENTER TO CONTINUE");
		System.out.println("TYPE \"SKIP\" to skip intro");
		String ans = s.nextLine();
		if (ans.equalsIgnoreCase("SKIP"))
			return;
		
		System.out.println("    You have a limited amount of resources to control this");
		System.out.println("outbreak. You can make progress towards the vaccine,");
		System.out.println("kill zombies yourself with a gun, reduce their potency,");
		System.out.println("upgrade your gun, or if you're desperate,");
		System.out.println("use powerful yet extremely costly abilities.\n");
		
		System.out.println("    You can gain resources most effectively by managing your");
		System.out.println("trading economy, which passively earns you lots of resources if");
		System.out.println("sufficiently upgraded.\n");
		System.out.println("PRESS ENTER TO CONTINUE");
		System.out.println("TYPE \"SKIP\" to skip intro");
		ans = s.nextLine();
		if (ans.equalsIgnoreCase("SKIP"))
			return;
		
		System.out.println("Your main hope to win this game is to work on the vaccine research");
		System.out.println("to cure all humans on the train from the zombie plague.");
		System.out.println("You will need to work on vaccine production to gain vaccine power.");
		System.out.println("This vaccine power can be used to vaccinate humans and make them immune");
		System.out.println("to getting attacked by zombies.");
		System.out.println("This vaccine power is also used for directly converting zombies into humans,");
		System.out.println("but at a higher cost. Additionally, converted zombies are NOT vaccinated");
		System.out.println("and must be immunized a second time.");
		System.out.println("Finally, there is a desperation option to convert dead passengers into fully");
		System.out.println("immunized humans, but this option is extremely costly.");
		
		System.out.println("Good luck soldier. We're counting on you for the train\'s");
		System.out.println("survival.\n");
		System.out.println("PRESS ENTER TO CONTINUE");
		s.nextLine();

	}
}
