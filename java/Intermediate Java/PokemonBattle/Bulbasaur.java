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
public class Bulbasaur extends Pokemon {
    /**
     * Type as much code as you need to finish the class. 
     * Add or remove new methods and attributes whenever you need to.
     */
    
    public Bulbasaur() {
        super("Bulbasaur", 1, 120, 0);
    }
    
    public void fight(Pokemon other) {

        Scanner moveInput = new Scanner(System.in);
        
        System.out.println("Which move will you attack with, Bulbasaur? (enter number)");
        System.out.println("1) Tackle");
        System.out.println("2) Life Drain");
        System.out.println("Add more moves in the code!");
        
        int chosenMove = moveInput.nextInt();
        
        //if (chosenMove == 1)
        //    moveName(other):
        
        if (chosenMove == 1)
            tackle(other);
        else if (chosenMove == 2)
            lifeDrain(other);
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
    
    public void lifeDrain(Pokemon other) {
        //DRAINS 8 health from the other Pokemon. In other words,
        //the other Pokemon takes 8 damage, while THIS Bulbasaur heals 8 hp.
        System.out.println(name + " used Life Drain!");
        other.getHit(8);
        heal(8);
    }
    
    
}
