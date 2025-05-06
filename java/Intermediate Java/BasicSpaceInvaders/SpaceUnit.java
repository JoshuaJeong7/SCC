/**
 * PART OF THE BasicSpaceInvaders.java PROGRAM
 * 
 * -FULLY COMPLETED CLASS
 */
public class SpaceUnit {
    /**
     * NOTE TO STUDENTS: This class is fully completed, but use it as a
     * reference for how you should code your other classes in this program!
     * This class also provides every tool you should know if you choose
     * to extend from this class.
     */

    public int damage;
    public int maxHealth;
    public int healthLeft;
    
    public SpaceUnit() {
        this(1, 100); //this() makes a call to the constructor with the 
                                //matching parameters. So what we've done in this
                                //code is call the constructor below:
                            
            //public SpaceUnit(startDmg = 1, startLives = 100)
    }
    
    public SpaceUnit(int startDmg, int startLives) {
        
        damage = startDmg;
        
        maxHealth = startLives;
        healthLeft = maxHealth;
    }
    
    public void attack(SpaceUnit other) {
        other.getHit(damage);
    }
    public void getHit(int hpLost) {
        healthLeft -= hpLost;
    }
    public void heal(int healAmt) {
        healthLeft += healAmt;
        if (healthLeft > maxHealth)
            healthLeft = maxHealth;
    }
    
    public void upgradeDamage(int level) {
        damage += level;
    }
    public void upgradeHealth(int level) {
        maxHealth += level;
        healthLeft = maxHealth; //Fully heals the unit and increases their max health
    }
}
