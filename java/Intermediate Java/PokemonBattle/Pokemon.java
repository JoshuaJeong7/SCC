/**
 * PART OF THE PokemonBattle.java PROGRAM
 * 
 * -FULLY COMPLETED CLASS
 */
public class Pokemon {
    /**
     * NOTE TO STUDENTS: This class is fully completed, but use it as a
     * reference for how you should code your other classes in this program!
     * This class also provides every tool you should know if you choose
     * to extend from this class.
     */
    
    public int turns; //This variable is never used in this default class,
                      //but it can be very useful for if you choose to add
                      //certain functionality, like status effects, to the program!
                      //It should mostly be used in subclasses.
     
    //EXTRA CHALLENGE: Make these attributes private instead of public!
    //NOTE: You will need to create new methods to use these variables outside
    //        of the class.
    
    public String name;                //Name of the Pokemon
    
    public double power;            //A percentage that is multiplied to all damage dealt.
    
    public int maxHealth;            //The maximum possible health of a Pokemon.
    
    public int healthLeft;            //The amount of health left for a Pokemon.
    
    public int defense;                //Subtracts the amount of incoming damage taken
                                    //        depending on the max health.
                                    //        NOTE: Defense should be LESS than
                                    //        the maximum hp.
                                    //        NOTE 2: If defense is negative,
                                    //        this Pokemon will take EXTRA damage.
                                    //        See getHit() for more details
    
    
    public Pokemon() {
        this("None", 1.0, 100, 0); //this() makes a call to the constructor with the 
                                //matching parameters. So what we've done in this
                                //code is call the constructor below:
                            
            //public Pokemon(nameIn = "None", startPower = 1.0, startLives = 100, startDefense = 0)
    }
    
    public Pokemon(String nameIn, double startPower, int startLives, int startDefense) {
        turns = 0;
        
        name = nameIn;
        
        power = startPower;
        
        maxHealth = startLives;
        healthLeft = maxHealth;
        
        defense = startDefense;
    }
    
    public void fight(Pokemon other) {
        other.getHit((int)(15 * power));
    }
    public void getHit(int hpLost) {
        double defensePercentage = (maxHealth - defense) / ((double) maxHealth);
        
        hpLost *= defensePercentage;
        healthLeft -= hpLost;
        System.out.println(hpLost + " damage dealt to " + name + "!");
        System.out.println(name + " now has " + healthLeft + "/" + maxHealth + " HP");
    }
    
    public void heal(int hpAmt) {
        healthLeft += hpAmt;
        if (healthLeft > maxHealth)
            healthLeft = maxHealth;
            
        System.out.println("Healed " + name + " for " + hpAmt + " HP!");
        System.out.println(name + " now has " + healthLeft + "/" + maxHealth + " HP");
    }
    
    
    public void updateTurn(Pokemon other) {
        turns++;
    }
    
}
