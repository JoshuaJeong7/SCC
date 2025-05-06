import java.util.Scanner;

/**
 * PART OF THE PokemonBattle.java PROGRAM
 * 
 * Methods to complete:
 * -Add at least two methods that can be used as an option when this pokemon fights.
 * 
 * Attributes to complete:
 * -Attributes are completely optional, but add any attributes that you find
 *         necessary to add based on if you need the code in your methods.
 */
public class Squirtle extends Pokemon {
    /**
     * Type as much code as you need to finish the class. 
     * Add or remove new methods and attributes whenever you need to.
     */
     
    public int tailWhipDuration;
    
    public Squirtle() {
        super("Squirtle", 0.8, 96, 33);
        tailWhipDuration = 0;
    }
    
    public void fight(Pokemon other) {
        //NOTE: The red comments are ALL that the students will see upon first
        //        receiving the program.
        
        //Scanner moveInput = new Scanner(System.in);
        
        //System.out.println("Which move will you attack with, Squirtle? (enter number)");
        //System.out.println("1) [move name]");
        
        Scanner moveInput = new Scanner(System.in);
        
        System.out.println("Which move will you attack with, Squirtle? (enter number)");
        System.out.println("1) Tackle");
        System.out.println("2) Tail Whip");
        
        int chosenMove = moveInput.nextInt();
        
        //if (chosenMove == 1)
        //    moveName(other):
        
        if (chosenMove == 1)
            tackle(other);
        else if (chosenMove == 2)
            tailWhip(other);
    }
    
    public void moveName(Pokemon other) {
        //This method is just an example of a move that your Pokemon may have.
        //Rename this method to your actual move name, and add the code that
        //your move needs to properly work!
        //Repeat this process for three other unique moves for this Pokemon.
    }
    
    ///NOTE: The following code below are SAMPLE moves. You do NOT have to use them
    public void tackle(Pokemon other) {
        System.out.println(name + " used Tackle!");
        int randomChance = 0;
        while (randomChance <= 30) {
            randomChance = (int)(Math.random() * 100) + 1;
            
            int damageDealt = (int)(10 * power);
            other.getHit(damageDealt);
        }
    }
    
    public void tailWhip(Pokemon other) {
        System.out.println(name + " used Tail Whip!");
        System.out.println(other.name + " has their defense lowered for 4 turns!");
        tailWhipDuration = 4;
        other.defense -= 20;
    }
    
    
    public void updateTurn(Pokemon other) {
        super.updateTurn(other);
        if (tailWhipDuration > 0) {
            tailWhipDuration--;
            if (tailWhipDuration == 0) {
                other.defense += 20;
                System.out.println(other.name + " has its defense restored!");
            }
        }
        
    }
    
    
    
}
