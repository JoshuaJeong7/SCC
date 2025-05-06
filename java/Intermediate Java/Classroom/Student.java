import java.util.Scanner;
public class Student {
    /**
     * NOTE TO STUDENTS: This class has all attributes and methods completed,
     * except for two methods: the returnAverageGrade() method and the
     * takeTest() method. Complete both of these methods, and this class
     * will be complete.
     */
    public String name;
    public int cumulativeScore;
    public int totalTestsTaken;
    
    public Student(String nameIn) {
        name = nameIn;
        cumulativeScore = -1;
        totalTestsTaken = 0;
    }
    
    public Student(String nameIn, int totalScore, int totalTests) {
        name = nameIn;
        cumulativeScore = totalScore;
        totalTestsTaken = totalTests;
    }
    
    public int returnAverageGrade() {
        //This method is empty; the students need to complete the method
        double gradePercent = (double)cumulativeScore / totalTestsTaken;
        int roundedGrade = (int)( (gradePercent * 2) / 2);
        return roundedGrade;
    }
    
    /**
     * Simulates this student taking a test based on the questions and answers
     * provided for the test. If this student is taking the test manually,
     * then each question will be printed, and the user will input each of
     * their answers, and if their answer is correct, this student gains a
     * point on the test. If this student is taking the test automatically, 
     * then they will gain points based on random chance. The probability of
     * this student succeeding is dependant on the average grade of the entire
     * class. This method returns the grade that this student received after
     * the test is completed, which is calculated depending on the points
     * they gained on the test and the number of questions on the test.
     * @param questions        An array of all the questions on the test
     * @param correctAnswers    An array of the correct answers for each question
     * @param classGrade        The average grade of the entire class
     * @param isManual            A boolean that if true, will take the test
     *                         manually, otherwise will take the test automatically
     * 
     * @return    The grade that this student received on the test once they
     *             have completed taking the test
     */
    public int takeTest(String[] questions, int[] correctAnswers, int classGrade, boolean isManual) {
        int pointsGained = 0;
        //return 0; //<- this is what students see when they first see the method
        
        if (isManual) {
            Scanner in = new Scanner(System.in);
            for (int i = 0; i < questions.length; i++) {
                
                int answerChoice = 0;
                while (answerChoice < 1 || answerChoice > 4) {
                    System.out.println(questions[i]);
                    answerChoice = in.nextInt();
                    in.nextLine();
                }
                if (answerChoice == correctAnswers[i])
                    pointsGained++;
            }
        }
        else {
            for (int i = 0; i < questions.length; i++) {
                int correctChance = (int)(Math.random() * 101);
                if (correctChance <= classGrade)
                    pointsGained++;
            }
        }
        
        double gradeDecimal = (double)pointsGained / questions.length;
        double gradePercent = gradeDecimal * 100;
        int roundedGrade = (int)( (gradePercent * 2) / 2);
        return roundedGrade;
    }
}
