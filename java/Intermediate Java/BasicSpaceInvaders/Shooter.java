/**
 * PART OF THE PokemonBattle.java PROGRAM
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
        
        //Note: This method is empty. The students must finish or add to the code.
        shieldCount++;
        if (shieldCount % 5 != 0)
            damage *= 2;
        else {
            damage -= 1;
            healthLeft -= 20;
        }
    }
    
    public void getHit(int hpLost) {
        ///Take damage normally unless the shooter is blocking (has a shield charge),
        ///then take 1/5 of the normal damage.
        
        //Note: This method is empty. The students must finish or add to the code.
        if (shieldCount > 0)                         
            hpLost /= 5;
        
        healthLeft -= hpLost;
    }
    
    public void attack(SpaceUnit other) {
        ///Deal your current amount of damage to the other unit. If the shooter
        ///currently has shield charges, then use up every shield charge,
        ///that is, reduce the damage to its default value and set the amount
        ///of shield charges to zero.
        ///Additionally, if the other unit's health reaches or goes below zero,
        ///heal this shooter for 30% of its maximum health.
        
        ///NOTE TO STUDENTS: If you're up for the challenge, try to add unique
        ///attributes to attacking! (Example: Random chance to land a critical
        ///hit, which deals 5x damage for ONE turn only)
        ///(OPTIONAL; MAY BE DIFFICULT)
        
        //Note: This method is empty. The students must finish or add to the code.
        int randomChance = (int)(Math.random() * 101);
        if (randomChance <= 15) {
            damage *= 5; //Shooters have a 15% chance to land a critical hit,
                            //making their attacks deal 5x damage
            System.out.println("Shooter just landed a [CRITICAL HIT]! 5x damage! Dealt " + damage + " damage!");
            System.out.println("Heal 10% of the damage dealt! Healed " + (damage / 10) + " HP!");
            other.getHit(damage);
            heal(damage / 10);
            damage /= 5;
        }
        other.getHit(damage);
        if (shieldCount > 0) {
            //Used up ALL shield charges to release the enhanced damage
            
            damage = minDamage;
            shieldCount = 0;
        }
        
        
        if (other.healthLeft <= 0) {
            heal(maxHealth / 3);
        }

    }
    
    ///This method is complete.
    public void upgradeDamage(int level) {
        super.upgradeDamage(level);
        minDamage += level;
    }
}
    
