//NOTE: If you are copying this into Programiz, move this class definition to the bottom of the file!
//Then your class errors should be fixed!
class NBAPlayer implements Comparable<NBAPlayer> {
    int freeThrows;
    int gamesWon;
    int totalScore;
    public NBAPlayer(int f, int g, int s) {
        freeThrows = f;
        gamesWon = g;
        totalScore = s;
    }

    // Within the NBAPlayer class, write a compareTo() method that does the following:
    // - Find the difference both players’ free throw count. Whoever has more free throws earns a point.
    // - Find the difference both players’ games won. Whoever has more games won earns a point.
    // - Find the difference both players’ total scores. Whoever has more total scores earns a point.
    // - Find the difference in both players’ points across these three categories. Whoever has more points is the better NBA player!
    public int compareTo(NBAPlayer other) {
        //Finish your code here!

        
        return 0;
    }
}

public class NBAShowdown {
    public static void main(String[] args) {
        NBAPlayer stephenCurry = new NBAPlayer( (int)(Math.random() * 50 + 150), (int)(Math.random() * 20 + 80, (int)(Math.random() * 150 + 300) );
        NBAPlayer lebronJames = new NBAPlayer( (int)(Math.random() * 50 + 150), (int)(Math.random() * 20 + 80, (int)(Math.random() * 150 + 300) );

        if (stephenCurry.compareTo(lebronJames) > 0)
            System.out.println("Stephen Curry is the better NBA Player!");
        else if (stephenCurry.copmareTo(lebronJames) < 0)
            System.out.println("Lebron James is the better NBA Player!");
        else
            System.out.println("Both Curry and Lebron are equally good!");
    }
}
