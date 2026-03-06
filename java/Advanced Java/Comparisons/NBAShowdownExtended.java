//NOTE: If you are copying this into Programiz, move this class definition to the bottom of the file!
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

public class NBAShowdownExtended {

}

class freeThrowVersus extends Comparator<NBAPlayer> {
    // Write a compare() method that does the following:
    // - Find and return the difference between both players’ free throw count. (first - second)
    public int compare(NBAPlayer first, NBAPlayer second) {
        //Finish your code here!

        
        return 0;
    }
}

class winsVersus extends Comparator<NBAPlayer> {
    // Write a compare() method that does the following:
    // - Find and return the difference between both players’ games won. (first - second)
    public int compare(NBAPlayer first, NBAPlayer second) {
        //Finish your code here!

        
        return 0;
    }
}

//Write your own Comparator<NBAPlayer> class to compare the NBA Players by a different metric!
