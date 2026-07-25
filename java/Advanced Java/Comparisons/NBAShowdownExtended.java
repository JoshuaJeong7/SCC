//NOTE: If you are copying this into Programiz, move all class definitions to the bottom of the file!
//Then your class errors should be fixed!
class NBAPlayer {
    int freeThrows;
    int gamesWon;
    int totalScore;
    public NBAPlayer(int f, int g, int s) {
        freeThrows = f;
        gamesWon = g;
        totalScore = s;
    }
}

class FreeThrowVersus extends Comparator<NBAPlayer> {
    // Write a compare() method that does the following:
    // - Find and return the difference between both players’ FREE THROW COUNT. (first - second)
    public int compare(NBAPlayer first, NBAPlayer second) {
        //Finish your code here!

        
        return 0;
    }
}

class WinsVersus extends Comparator<NBAPlayer> {
    // Write a compare() method that does the following:
    // - Find and return the difference between both players’ GAMES WON. (first - second)
    public int compare(NBAPlayer first, NBAPlayer second) {
        //Finish your code here!

        
        return 0;
    }
}

//Write your own Comparator<NBAPlayer> class to compare the NBA Players by a different metric!
class yourOwnChoice extends Comparator<NBAPlayer> {
    //Rename this class name to "___Versus", where ___ is replaced with your metric of comparison.
    
    //Write the compare(first, second) method over here! Copy the format of your previous two Comparator classes!
    // - Find and return the difference between both players' [CUSTOM STATISTIC]. (first - second)
}

public class NBAShowdownExtended {
    public static void main(String[] args) {
        NBAPlayer stephenCurry = new NBAPlayer( (int)(Math.random() * 50 + 150), (int)(Math.random() * 20 + 80, (int)(Math.random() * 150 + 300) );
        NBAPlayer lebronJames = new NBAPlayer( (int)(Math.random() * 50 + 150), (int)(Math.random() * 20 + 80, (int)(Math.random() * 150 + 300) );

        FreeThrowVersus freeThrow = new FreeThrowVersus()
        WinsVersus win = new WinsVersus()

        System.out.println("If you are getting an error message at this point, you need to rename \'yourOwnChoice\' to the name you chose for your third class!");
        yourOwnChoice custom = new yourOwnChoice()

        freeThrowResult = freeThrow.compare(stephenCurry, lebronJames)
        if (freeThrowResult < 0) { System.out.println("Stephen Curry has more free throws!"); }
        else if (freeThrowResult > 0) { System.out.println("Lebron James has more free throws!"); }
        else { System.out.println("Both players have the same amount of free throws!"); }

        winsResult = wins.compare(stephenCurry, lebronJames)
        if (winsResult < 0) { System.out.println("Stephen Curry has more game wins!"); }
        else if (winsResult > 0) { System.out.println("Lebron James has more game wins!"); }
        else { System.out.println("Both players have the same amount of game wins!"); }

        customResult = custom.compare(stephenCurry, lebronJames)
        if (customResult < 0) { System.out.println("Update this print message to compare your custom statistic!"); }
        else if (freeThrowResult > 0) { System.out.println("Update this print message to compare your custom statistic!"); }
        else { System.out.println("Update this print message to compare your custom statistic!"); }
    }
}
