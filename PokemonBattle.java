import java.util.Scanner;
public class PokemonBattle {
    public static void main(String[] args) {
        
        System.out.println("This program simulates a basic Pokemon battle by" +
        " using objects and inheritance. \n First, two separate players will pick" +
        " their choice of Pokemon between Squirtle, Bulbasaur, and Charmander. \n" +
        " Then, the two Pokemon battle each other until one of them reaches a hp of"+
        " zero, at which point the remaining Pokemon wins. \n This program is not the" +
        " exact same as the original Pokemon, so here are some rules that this program follows. \n \n" +
        " 1) Player 1 will ALWAYS go first, then Player 2 goes next. \n" +
        " 2) A Pokemon turn ONLY consists of FIGHT or HEAL. \n" +
        " 3) ALL Pokemon only have a power, HP, and defense stat. \n" +
        " 4) Each trainer will only have ONE pokemon to fight with. \n" +
        " 5) Type advantages and disadvantages are not considered in this program. \n" +
        " 6) It is implied that Pokemon will not level up at any point of the game. \n" +
        " 7) Pokemon still only have four moves to attack with. \n" +
        " 8) There is no PP meter in this game, meaning you can use moves umlimitedly. \n" +
        " 9) All moves are guaranteed to successfully land. \n" +
        " 10) There are currently only four moves per pokemon. \n" +
        " 11) If you want to add more functionality to this program to make it" +
        " closer to a real Pokemon game, then try adding as much code as you" +
        " can yourself! \n \n GOOD LUCK!! \n \n" 
        );
        
        
        Scanner in = new Scanner(System.in);
        
        //The following is an example model of how you should code each player
        //to pick their desired pokemon. You may alter this model if you want
        //for the second player, or alter this model for both players, such
        //as using an int to choose pokemon instead of String inputs.
        System.out.println("PLAYER 1: Choose your pokemon between Bulbasaur, Charmander, and Squirtle.");
        String player1Choice = in.next();
        
        Pokemon pokemon1;
        if (player1Choice.equalsIgnoreCase("Squirtle"))
            pokemon1 = new Squirtle();
        else if (player1Choice.equalsIgnoreCase("Bulbasaur"))
            pokemon1 = new Bulbasaur();
        else
            pokemon1 = new Charmander();
        
        //Have the second player pick their pokemon of choice
        
        boolean gameIsRunning = true;
        while (gameIsRunning) {
            
            System.out.println("\n \n Turn " + pokemon1.turns);
            
            ///PLAYER 1's TURN
            //The entire structure of player 1's turn is provided for you.
            //You must code the structure for player 2's turn.
            System.out.println("Current pokemon: " + pokemon1.name);
            
            int decision1 = 0;
            while (decision1 < 1 || decision1 > 2) {
                System.out.println("PLAYER 1: What would you like to do? (enter number)");
                System.out.println("1) FIGHT");
                System.out.println("2) HEAL 10 HP");
                decision1 = in.nextInt();
            }
            
            if (decision1 == 1)
                pokemon1.fight(pokemon2);
            else if (decision1 == 2)
                pokemon1.heal(10);
            
            
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
                //Choose whether to fight or heal 10 HP for the current pokemon
            }
            //Update the turn of this current pokemon (code is provided for you)
            pokemon2.updateTurn(pokemon1);
            
            //Check if the opponent pokemon's hp is zero, thus winning the game
            //ALSO check if BOTH pokemon have zero hp, thus resulting in a draw
            
            
            //Enter a new line for cleaner formatting
            System.out.println();
        }
    }
}