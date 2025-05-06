///PART OF THE BasicSpaceInvaders.java PROGRAM
///EXAMPLE SUBCLASS (not in the code by default)
public class PoisonInvader extends Invader {
    
    public PoisonInvader() {
        super(5, 90);
    }
    public PoisonInvader(int startDmg, int startHP) {
        super(startDmg, startHP);
    }
    
    public void attack(SpaceUnit other) {
        super.attack(other);
        
        int randomChance = (int)(Math.random() * 101);
        if (randomChance <= 1) {
            other.getHit(damage);
            System.out.println("Poison Invader used Toxin! Shooter's attack permanently halfed!");
            other.damage /= 2; //Invaders have a 1% chance to permanently
                                //half the damage of their opponent
        }
        if (other.damage == 0)
            other.damage = 1;
        
    }
}
