import java.util.Scanner;
import java.util.HashMap;
private class AssignedMethods {
	//Because this class is now private, that means that we can no longer
	//create objects/variables of this class.
	//The only thing we can do now is call static methods from this class,
	//i.e. AssignedMethods.addPokemon();
	
	
	public String addPokemon(HashMap<String, Pokemon> playerPokemon) {
		Scanner opt = new Scanner(System.in);
		int count = 0;
		
		String selectedPokemon = ""; //Represents the name, or the "key",
			// of the current selected pokemon in the map.
			
			//YOU WILL HAVE TO RETURN THIS VALUE
		
		while (count < 6) {
			System.out.println("Enter the next pokemon you would like to add.");
			System.out.println("(NOTE: If you are ONLY able to pick Squirtle, then your code is unfinished!)");
			
			String newPokemon = opt.nextLine();
		}
		
		//Finish your code here
		
		
		return selectedPokemon;
	}
	
	public void switchOptions(HashMap<String, Pokemon> playerPokemon) {
		Scanner opt = new Scanner(System.in);
		boolean hasSwitched = false;
		System.out.println("Which pokemon would you like to switch to?");
		
		
		
	}
	
	public void itemOptions(HashMap<String, int> playerItems) {
		
	}
}
