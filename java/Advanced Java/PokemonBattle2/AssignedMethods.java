import java.util.Scanner;
import java.util.HashMap;
public class AssignedMethods {
	
	
	/**
	 * This is the only method completed for you. The rest you must code on
	 * your own.
	 * 
	 */
	public static Pokemon addPokemon(HashMap<String, Pokemon> playerPokemon) {
		Scanner opt = new Scanner(System.in);
		int count = 0;
		
		Pokemon selectedPokemon = null; //Represents the value
			// of the current selected pokemon in the map.
		
		while (count < 6) {
			System.out.println("Enter the next pokemon you would like to add. (" + (count + 1) + " / 6)");
			
			String newPokemon = opt.nextLine();
			try {
				selectedPokemon = returnCopyOf(newPokemon);
			}
			catch (ClassNotFoundException e) {
				System.err.println("Invalid pokemon; Does not exist in this program");
				continue;
			}
			playerPokemon.put(newPokemon, selectedPokemon);
			count++;
		}
		
		selectedPokemon = null;
		do {
			System.out.println("Which pokemon would you like to start with? (Write out the name)");
			String firstChoice = opt.nextLine();
			if (playerPokemon.containsKey(firstChoice)) {
				selectedPokemon = playerPokemon.get(firstChoice);
			}
			else {
				System.out.println("Invalid pokemon name");
			}
		} while (selectedPokemon == null);
		return selectedPokemon;
	}

	/*
		In this method, you are switching which Pokemon is currently active, just like in real Pokemon.

		NOTE: If the Pokemon you want to switch to has already fainted (i.e. for the Pokemon value inside
				the map, that corresponding Pokemon object has a HP less than or equal to 0),
				then you will be prevented from switching to that pokemon.
	*/
	public static void switchOptions(HashMap<String, Pokemon> playerPokemon) {
		Scanner opt = new Scanner(System.in);
		boolean hasSwitched = false;
		System.out.println("Which pokemon would you like to switch to?");
		
		//FINISH YOUR CODE HERE
		
	}

	/*
		In this method, you pick na item that you want to use on the current Pokemon.
		First, select the item you want to use.
		Then, check if there are enough items left in stock (i.e. if the integer value associated
				with that item is greater than 0).
		Finally, if it is, do the desired task of that specific item (i.e. a Heal Potion will heal
				your current pokemon.)
	*/
	public static void itemsOptions(HashMap<String, Integer> playerItems) {
		//FINISH YOUR CODE HERE
	}

	/*
		Good news and bad news!
		Good news: This method is super easy! If you create a new Pokemon, just add that
		           new Pokemon to this method in the exact way that I do it and this is complete!
		Bad news: You have to update this method every time you make a new Pokemon, and there's
		           no easy way to do it all at once.
	*/
	private static Pokemon returnCopyOf(String pokemon) throws ClassNotFoundException {
		Pokemon returnedPokemon;
		switch (pokemon) {
			case "Bulbasaur":
				returnedPokemon = new Bulbasaur();
			break;
			
			case "Squirtle":
				returnedPokemon = new Squirtle();
			break;
			
			case "Charmander":
				returnedPokemon = new Charmander();
			break;
			
			default:
				throw new ClassNotFoundException("ERROR: No Valid Pokemon Entered!");
		}
		return returnedPokemon;
	}
}
