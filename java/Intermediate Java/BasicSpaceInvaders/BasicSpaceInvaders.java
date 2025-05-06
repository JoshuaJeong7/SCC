import java.util.Scanner;
import java.util.ArrayList;
/**
 * UNIT: ArrayLists and Objects
 * 
 * COMPLETED CLASSES:
 * SpaceUnit.java
 * Invader.java
 * 
 * ASSESSED CLASSES:
 * Shooter.java
 * BasicSpaceInvaders.java
 * Any other classes freely created by the students
 * 
 * ASSESSMENT ON: 
 * -The knowledge and understanding of the concept of inheritance
 * -The ability to manipulate attributes and create methods within a class
 * -The ability to use classes and inherited classes from client classes
 *         that are outside of the target class's hierarchy
 * -The knowledge, usage, and proficiency with using ArrayLists
 * -The knowledge and proficiency with using ArrayList methods such as
 *         isEmpty(), get(), remove(), and add()
 * -The knowledge and ability to create overrided methods
 * 
 * NOT ASSESSED AT ALL:
 * -The knowledge or usage of several library classes, such as javax.swing
 * -The knowledge of how to use loops to create an ongoing game with an unlimited
 *         amount of rounds
 * 
 * OPTIONAL TO ASSESS:
 * -The game quality of the program that is created
 * 
 * ONLY ASSESSED IN ADVANCED VERSION:
 *         NOTE: There is no "advanced" version, the way this program can be
 *         advanced is if the students decide to add new content to their program.
 * -The ability to put inheritance into practice by creating new subclasses
 *         and extending them from superclasses
 * -The ability to create new classes
 * -The ability to create attributes, methods, and constructors from scratch
 * -The proficiency with manipulating methods and attributes in and between classes
 */
public class BasicSpaceInvaders {
    public static void main(String[] args) {
        
        System.out.println("Although this program is called \"Space Invaders\"," +
        " it does not model the original game of Space Invaders at all. \n" +
        " This program models a turn based infinite-round fighting game" +
        " between one Shooter, which represents the player, and an" +
        " increasing army of Invaders. \n Here are some rules to the game: \n" +
        " 1) Both the shooter and the invaders have a certain amount of damage and health. \n" +
        " 2) Each turn, the shooter has an option to directly attack an invader," +
        " or activate a shield charge. \n"
        " 3) If the shooter activates a shield charge, they will take significantly" +
        " less damage from all sources and double the damage of their next attack. \n" +
        " 4) The shooter can stack shield charges an umlimited amount of times, but" +
        " every 5 shield charge stacks, the shooter will lose 20 HP, and deal 1 damage" +
        " less without doubling their damage output. \n" +
        " 5) Upon attacking, the shooter uses up every shield charge," +
        " resetting their damage to its default value and deleting all shield charges. \n" +
        " 6) The shooter can ONLY attack ONE invader at a time. \n" +
        " 7) Upon killing an invader, the shooter instantly heals 30% of their max HP. \n" +
        " 8) At the end of each turn, the invaders will attack the shooter at the same time. \n" +
        " 9) The shooter starts at round 1 with 3 invaders to kill. \n" +
        " 10) When all invaders are dead, the round is considered over, and" +
        " a new round is started." +
        " 11) With every new round, the shooter is restored to full HP, their" +
        " default damage output is increased, and their max HP is increased. \n" +
        " 12) With every new round, all the invaders from the previous round" +
        " are spawned again, including an additional two more invaders." +
        " The max health of each invader is also increased per round. \n" +
        " 13) There are an unlimited number of rounds. \n" + 
        " 14) If the shooter's HP reaches or goes below zero, the game is over. \n" +
        " 15) At the end of each game, the final round is displayed. \n" +
        " 16) If you want to add more functionality to this program to make it" +
        " more then try adding as much code as you can yourself! You can also" +
        " change the rules themselves based on your new code! \n \n GOOD LUCK!! \n \n" );
        
        Shooter shooter = new Shooter();
        
        ArrayList<Invader> invadersLeft = new ArrayList<Invader>();
        for (int i = 0; i < 3; i++)
            invadersLeft.add(new Invader(5, 90));
        
        boolean gameIsRunning = true;
        
        Scanner in = new Scanner(System.in);
        
        int rounds = 1; //The students may add this line of code
        
        //NOTE: This game structure is already provided for the students.
        while (gameIsRunning) {
            if (invadersLeft.isEmpty() ) {
            ///When there are no invaders left, this simulates the start of
            ///a new round. The rounds counter goes up, the shooter's damage and
            ///health are levelled up, the shooter's HP is restored to full,
            /// and two more invaders are spawned than the starting amount from last round,
            /// each invader with slightly higher stats.
            
            //NOTE: Inside this if statement (for when the round ends) is
            //completely empty, and the students must be able to code all
            //the required components inside this if statement.
            //The if-statement itself is already provided.
            System.out.println("ROUND CLEARED! Shooter is upgraded! Full heal!");
            
            rounds++;
            shooter.upgradeHealth(20);
            shooter.upgradeDamage(rounds);
                for (int i = 0; i < rounds * 2; i++) {
                    invadersLeft.add(new Invader(5, 90 + (rounds * 10)));
                    
                }
                for (int i = 10; i < rounds; i++)
                    invadersLeft.add(new PoisonInvader(4, rounds * 10));
            }
            
            ///Everything else inside this game loop is already completed
            ///for the students.
            System.out.print("Round " + rounds + " \t");
            System.out.println("Invaders left: " + invadersLeft.size());
            System.out.println("Current invader's HP: " + invadersLeft.get(0).healthLeft);
            System.out.println("Damage: " + shooter.damage);
            System.out.println("Health: " + shooter.healthLeft + "/" + shooter.maxHealth);
            System.out.println("Shield stacks: " + shooter.shieldCount + " % " + 5);
            
            
            
            ///Shooter's turn
            System.out.println("What do you want to do? (enter number)");
            int shooterChoice = 0;
                
            while (shooterChoice < 1 || shooterChoice > 2) {
                System.out.println("1) Attack the next invader");
                System.out.println("2) Stack a shield");
                shooterChoice = in.nextInt();
            }
            if (shooterChoice == 1)
                shooter.attack(invadersLeft.get(0));
            else
                shooter.block();
                
            if (invadersLeft.get(0).healthLeft <= 0)
                invadersLeft.remove(0);
                
            ///Invader's turn
            for (Invader invader : invadersLeft)
                invader.attack(shooter);
                
            if (shooter.healthLeft <= 0)
                gameIsRunning = false;
        }
        System.out.println("FINAL ROUND REACHED: Round " + rounds);
    }
}
