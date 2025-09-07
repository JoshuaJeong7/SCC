import java.util.Scanner;
import java.util.HashMap;
public class AssignedMethods {
	
	
	/**
	 * This is the only method completed for you. The rest you must code on
	 * your own.
	 * 
	 */
	public String addPokemon(HashMap<String, Pokemon> playerPokemon) {
		Scanner opt = new Scanner(System.in);
		int count = 0;
		
		String selectedPokemon = ""; //Represents the name, or the "key",
			// of the current selected pokemon in the map.
		
		while (count < 6) {
			System.out.println("Enter the next pokemon you would like to add.");
			
			String newPokemon = opt.nextLine();
			selectedPokemon = newPokemon;
			playerPokemon.put(newPokemon, returnCopyOf(newPokemon));
		}
		
		
		return selectedPokemon;
	}
	
	public void switchOptions(HashMap<String, Pokemon> playerPokemon) {
		Scanner opt = new Scanner(System.in);
		boolean hasSwitched = false;
		System.out.println("Which pokemon would you like to switch to?");
		
		
		
	}
	
	public void itemOptions(HashMap<String, Integer> playerItems) {
		
	}
	
	public Pokemon returnCopyOf(String pokemon) throws ClassNotFoundException {
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
