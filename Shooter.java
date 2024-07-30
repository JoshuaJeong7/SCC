/*
 * PART OF THE BasicSpaceInvaders.java PROGRAM
 * 
 * Methods to complete:
 * -block()
 * -getHit()
 * -attack(SpaceUnit other)
 * -Any other methods the students may want to optionally add
 * 
 * Attributes to complete:
 * -Attributes are completely optional, but add any attributes that you find
 *         necessary to add based on if you need the code in your methods.
 */
public class Shooter extends SpaceUnit {
    /**
     * NOTE TO STUDENTS: The methods that you are required to create are
     * already created, but there is no code inside of them. Type as much code as you
     * need to finish the class. Add new methods and attributes whenever you need to.
     */
    public int shieldCount;
    public int minDamage; ///The minimum possible damage that the shooter can deal.
                          ///NOTE: minDamage also represents THE DEFAULT DAMAGE VALUE
    
    public Shooter() {
        super(1, 100);
        shieldCount = 0;
        minDamage = damage;
    }
    
    public void block() {
        ///When the shooter blocks, increase their shield count by 1.
        ///Every five shield counts, remove 20 hp and subtract damage by 1,
        ///but otherwise simply multiply damage by 2.
    }
    
    public void getHit(int hpLost) {
        ///Take damage normally unless the shooter is blocking (has a shield charge),
        ///then take 1/5 of the normal damage.
    }
    
    public void attack(SpaceUnit other) {
        ///Deal your current amount of damage to the other unit. If the shooter
        ///currently has shield charges, then use up every shield charge,
        ///that is, reduce the damage to its default value and set the amount
        ///of shield charges to zero.
        ///Additionally, if the other unit's health reaches or goes below zero,
        ///heal this shooter for 30% of its maximum health.
        
        //NOTE TO STUDENTS: If you're up for the challenge, try to add unique
        //attributes to attacking! (Example: Random chance to land a critical
        //hit, which deals 5x damage for ONE turn only)
        //(OPTIONAL; MAY BE DIFFICULT)
    }
    
    ///This method is complete.
    public void upgradeDamage(int level) {
        super.upgradeDamage(level);
        minDamage += level;
    }
}
    
