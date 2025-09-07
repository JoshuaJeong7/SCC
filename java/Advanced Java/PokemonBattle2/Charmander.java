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
public class Charmander extends FirePokemon {
    /**
     * Type as much code as you need to finish the class. 
     * Add or remove new methods and attributes whenever you need to.
     */
     
    public int emberDuration;
    
    public Charmander() {
        super("Charmander", 1.4, 80, 10);
        burnDamage = 5;
        emberDuration = 0;
    }
    
    public void fight(Pokemon other) {
        //NOTE: The red comments are ALL that the students will see upon first
        //        receiving the program.
        
        //Scanner moveInput = new Scanner(System.in);
        
        //System.out.println("Which move will you attack with, Squirtle? (enter number)");
        //System.out.println("1) [move name]");
        
        Scanner moveInput = new Scanner(System.in);
        
        System.out.println("Which move will you attack with, Charmander? (enter number)");
        System.out.println("1) Tackle");
        System.out.println("2) Ember");
        
        
        int chosenMove = moveInput.nextInt();
        
        //if (chosenMove == 1)
        //    moveName(other):
        
        if (chosenMove == 1)
            tackle(other);
        else if (chosenMove == 2)
            ember(other);
    }
    
    public void moveName(Pokemon other) {
        //This method is just an example of a move that your Pokemon may have.
        //Rename this method to your actual move name, and add the code that
        //your move needs to properly work!
        //Repeat this process for three other unique moves for this Pokemon.
    }
    
    //The following code below is a SAMPLE solution, NOT necessarily the INTENDED one
    public void tackle(Pokemon other) {
        System.out.println(name + " used Tackle!");
        int randomChance = 0;
        while (randomChance <= 30) {
            randomChance = (int)(Math.random() * 100) + 1;
            
            int damageDealt = (int)(10 * power);
            other.getHit(damageDealt);
        }
    }
    
    public void ember(Pokemon other) {
        //This is just to show that we are using the generic implementation
        //of ember() from the FirePokemon class.
        //Feel free to completely replace this method with your own code
        //for implementation!
        
       super.ember(other);
       emberDuration = super.burnDuration;
    }

    public void updateTurn(Pokemon other) {
        super.updateTurn(other);
        if (emberDuration > 0) {
            emberDuration--;
            other.getHit(burnDamage);
            
            if (emberDuration == 0)
                System.out.println(other.name + " has its burn effect worn off!");
        }
        
    }
}
