import java.util.Scanner;
import java.util.ArrayList;
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
        
        //Optional: Keep track of what round it is!
        
        //NOTE: This game structure is already provided for the students.
        while (gameIsRunning) {
            if (invadersLeft.isEmpty() ) {
            ///When there are no invaders left, this simulates the start of
            ///a new round. The rounds counter goes up, the shooter's damage and
            ///health are levelled up, the shooter's HP is restored to full,
            /// and two more invaders are spawned than the starting amount from last round,
            /// each invader with slightly higher stats.
            }
            
            //You may change the display of each turn if you would like to.
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
                //How do you make the shooter attack the invader?
            else
                //How do you make the shooter block?
                
            //How do you check if the FIRST invader in the list of invadersLeft
            //ran out of HP? How do you remove it from the list of invadersLeft
            //once the invader runs out of HP?
                
            ///Invader's turn
            for (Invader invader : invadersLeft)
                invader.attack(shooter);
            
            ///End the game if the shooter's health is zero
            if (shooter.healthLeft <= 0)
                gameIsRunning = false;
        }
        //Print some "game over" message
    }
}