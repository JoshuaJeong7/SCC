import java.util.HashMap;
import java.util.Scanner;
public class PokemonBattle2 {
	private static HashMap<String, Pokemon> player1Pokemon;
	private static HashMap<String, Pokemon> player2Pokemon;
	
	private static HashMap<String, Integer> player1Items;
	private static HashMap<String, Integer> player2Items;
	
	public PokemonBattle2() {
		player1Pokemon = new HashMap<String, Pokemon>();
		player2Pokemon = new HashMap<String, Pokemon>();
		
		player1Items = new HashMap<String, Integer>();
		player2Items = new HashMap<String, Integer>();
		
		//instantiating all keys + values into player1Items and player2Items
		
		player1Items.put("Poké Balls", 0);	  player2Items.put("Poké Balls", 0);
		player1Items.put("Great Balls", 0);	  player2Items.put("Great Balls", 0);
		player1Items.put("Heal Potions", 1);	  player2Items.put("Heal Potions", 1);
		player1Items.put("Berries", 5);	  player2Items.put("Berries", 5);
		player1Items.put("Revive Potions", 0);	  player2Items.put("Revive Potions", 0);
		
		
	}
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("\n\nThis program is very similar to PokemonBattle (version 1), ");
		System.out.println("but with a few additions. If you haven't played PokemonBattle, ");
		System.out.println("find and play it in the Intermediate Java section!\n");
		
		System.out.println("The most drastic changes are that both players get access to ");
		System.out.println("fight with multiple Pokemon at once using a map that pairs ");
		System.out.println("the pokemon's name with its actual Pokemon object.\n");
		
		System.out.println("Additionally, both players get access to an items map that ");
		System.out.println("pairs the item itself with the count of how many you have.");
		System.out.println("Have fun with a more accurate Pokemon battle simulator!");
		System.out.println("As always, try to add more to the code yourself!!");
		
		
		System.out.println("Player 1, pick the pokemon you want to add to your team!");
		System.out.println("Press 0 to use the default layout (Squirtle, Charmander, Bulbasaur");
		System.out.println("Press any other key to proceed");
		
		String result = in.next();
		Pokemon pokemon1 = null;
		Pokemon pokemon2 = null;
		if (result.equals("0")) {
			player1Pokemon.put("Squirtle", new Squirtle());
			player1Pokemon.put("Bulbasaur", new Bulbasaur());
			player1Pokemon.put("Charmander", new Charmander());

		}
		else {
			pokemon1 = AssignedMethods.addPokemon(player1Pokemon);
		}
		
		System.out.println("Player 2, pick the pokemon you want to add to your team!");
		System.out.println("Press 0 to use the default layout (Squirtle, Charmander, Bulbasaur");
		System.out.println("Press any other key to proceed");
		
		result = in.next();
		if (result.equals("0")) {
			player2Pokemon.put("Squirtle", new Squirtle());
			player2Pokemon.put("Bulbasaur", new Bulbasaur());
			player2Pokemon.put("Charmander", new Charmander());

		}
		else {
			pokemon2 = AssignedMethods.addPokemon(player2Pokemon);
		}
		
		
		boolean gameIsRunning = true;
		
		while (gameIsRunning) {
			
			 System.out.println("\n \n Turn " + pokemon1.turns);
            
            ///PLAYER 1's TURN
            //The entire structure of player 1's turn is provided for you.
            //You must code the structure for player 2's turn.
            System.out.println("Current pokemon: " + pokemon1.name);
            
            int decision1 = 0;
            while (decision1 < 1 || decision1 > 3) {
                System.out.println("PLAYER 1: What would you like to do? (enter number)");
                System.out.println("1) FIGHT");
                System.out.println("2) SWITCH POKEMON");
                System.out.println("3) ITEMS");
                decision1 = in.nextInt();
            }
            
            if (decision1 == 1)
                pokemon1.fight(pokemon2);
            else if (decision1 == 2)
                AssignedMethods.switchOptions(player1Pokemon);
            else if (decision1 == 3)
				AssignedMethods.itemsOptions(player1Items);
            
            
            //Update the turn of this current pokemon (code is provided for you)
            pokemon1.updateTurn(pokemon2);
            
            //Check if the opponent pokemon's hp is zero, thus winning the game
            if (pokemon2.healthLeft <= 0) {
                System.out.println("Player 2's " + pokemon2.name + " has fainted!");
                System.out.println("Player 1 wins with " + pokemon1.name + "!");
                gameIsRunning = false;
            }
            
            ///PLAYER 2'S TURN
            System.out.println("Current pokemon: " + pokemon2.name);
            
            if (gameIsRunning) {

                int decision2 = 0;
                while (decision2 < 1 || decision2 > 3) {
                    System.out.println("PLAYER 2: What would you like to do? (enter number)");
                    System.out.println("1) FIGHT");
                    System.out.println("2) SWITCH POKEMON");
					System.out.println("3) ITEMS");
                    decision2 = in.nextInt();
                }
                
                if (decision2 == 1)
                    pokemon2.fight(pokemon1);
                else if (decision1 == 2)
					AssignedMethods.switchOptions(player2Pokemon);
				else if (decision1 == 3)
					AssignedMethods.itemsOptions(player2Items);
            }
            //Update the turn of this current pokemon (code is provided for you)
            pokemon2.updateTurn(pokemon1);

            //Check if the opponent pokemon's hp is zero, thus winning the game
            //ALSO check if BOTH pokemon have zero hp, thus resulting in a draw
            ///The students must code the entire if-else block below
            if (playerLost(player1Pokemon) && playerLost(player2Pokemon)) {
                System.out.println("The game is a draw! Neither player won.");
                gameIsRunning = false;
            }
            else if (playerLost(player2Pokemon)) {
                System.out.println("Player 2 wins with " + pokemon2.name + "!");
                gameIsRunning = false;
            }
            else if (playerLost(player1Pokemon)) {
                System.out.println("Player 1 wins with " + pokemon1.name + "!");
                gameIsRunning = false;
            }

			if (pokemon1.healthLeft <= 0) {
				System.out.println("Player 1's " + pokemon1.name + " has fainted!");
				pokemon1 = AssignedMethods.addPokemon(player1Pokemon);
			}
			if (pokemon2.healthLeft <= 0) {
				System.out.println("Player 2's " + pokemon2.name + " has fainted!");
				pokemon2 = AssignedMethods.addPokemon(player2Pokemon);
			}
            //Enter a new line for cleaner formatting
            System.out.println();
        
		}


	}

	public static boolean playerLost(HashMap<String, Pokemon> playerPokemon) {
		for (Pokemon thisPokemon : playerPokemon.values()) {
			if (thisPokemon.healthLeft > 0) {
				return false;
			}
		}
		return true;
	}
}
