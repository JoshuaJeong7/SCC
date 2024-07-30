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
        //Return the average grade of the student
        //Hint: The formula to find an average in math is:
        //		(Total sum of all numbers) / (The AMOUNT of numbers)
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
        
        if (isManual) {
            Scanner in = new Scanner(System.in);
            //Simulate taking a real given test by loooping through each question.
            //Update the amount of points the student gains with each question.
            ///NOTE: If the student gets an answer wrong, nothing happens. They
            ///do not gain points, but they should not lose any either.
        }
        else {
			//Automates taking a test
            for (int i = 0; i < questions.length; i++) {
                int correctChance = 101; //How do you make the chance randomized?
                
                //NOTE: If the class grade is higher, it will be EASIER to
                //randomly gain a point correctly.
                if (correctChance <= classGrade)
                    pointsGained++;
            }
        }
        
        //Change the return value to its correct value!
        return 0;
    }
}
