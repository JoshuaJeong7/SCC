import java.util.Scanner;
public class Classroom {
    /**
     * This class has all attributes and constructors fully complete.
     * You must finish the reamining methods that are not complete.
     */
    
    Student[] students;    //An array that stores SPACES for students.
                        //NOTE: NOT ALL SPACES HAVE A STUDENT! SOME SPACES ARE EMPTY!
                        //All spaces are empty when the program is created.
                        
    int currentSize;    //The amount of spaces in the array that are FILLED with students.
    
    int averageGrade;    //The average grade among every student that is currently
                        //enrolled inside this classroom.
    
    public Classroom() {
        this(30, 80); //this() makes a call to the constructor with the 
                                //matching parameters. So what we've done in this
                                //code is call the constructor below:
                            
            //public Classroom(capacity = 30, averageClassPercent = 80)
    }
    
    public Classroom(int capacity, int averageClassPercent) {
        students = new Student[capacity];
        currentSize = 0;
        averageGrade = averageClassPercent;
    }
    
    public void assignTest(int size, int passingGrade) {
        /**
         * INSTRUCTIONS FOR WRITING THIS METHOD:
         */
         
        /**
         * 1: Create three new arrays. Two of these arrays have a size of the
         *         "size" parameter and represent each question on the test,
         *         and that question's answer represented by an INTEGER. The 
         *         third array has a size equal to the size of the "students" array 
         *         and represents the grade of each student for this test.
         */
        System.out.println("CREATING NEW TEST WITH " + size + " QUESTIONS");
        
        //Add your code here
          
          
        /** 
         * 2: Create the Scanner.
         */ 
        //This code is very short and is already provided for you.
        Scanner input = new Scanner(System.in);
        
        
        /** 
         * 3: Use a for loop that iterates through each question on the test.
         *         Inside this loop, ask for what the question states, and what
         *         each answer is. NOTE THAT EVERY QUESTION IS MULTIPLE CHOICE!
         *         This means that for EVERY question, you must provide an answer
         *         for each number, THEN provide the number for the CORRECT number.
         *         Obtain the question and answers from the user input, then
         *         store each question and answer into the corresponding index of
         *         the questions array and answers array.
         */
        //This code is provided for you.
        for (int i = 0; i < size; i++) {
            System.out.println("Enter the question for question " + (i + 1) + ":");
            testQuestions[i] = input.nextLine();
            
            for (int j = 1; j <= 4; j++) {
                System.out.println("Enter an answer OPTION for question " + (i + 1) + ", Choice " + j + ":");
                testQuestions[i] += " \n Choice " + j + ": " + input.nextLine();
            }
            
            while (testAnswers[i] < 1 || testAnswers[i] > 4) {
                System.out.println("Enter the answer for question + "+ (i + 1) + 
                    "(enter a number for 1, 2, 3, or 4):");
                testAnswers[i] = input.nextInt();
                input.nextLine();
            }
            
        }
        
        
        /** 
         * 4: Create another for loop that iterates through each STUDENT
         *         in the classroom.
         *             VERY IMPORTANT!!!!! THE ARRAY'S SIZE DOES NOT REPRESENT
         *             ALL STUDENTS, AS SOME SLOTS FOR STUDENTS ARE EMPTY!!!!!
         *         This for loop will make each of them take
         *         the test, as seen in the Student class's method. 
         * 
         *         You may choose how many students automate the test and how 
         *         many students manually take the test. However, it is highly 
         *         recommended that ONLY ONE student manually takes the test, 
         *         and every other student will automate the test. 
         * 
         *         You can control who manually and automatically takes the test 
         *         by passing in either a true(manual) or false(automatic) 
         *         boolean variable into the takeTest method, 
         *         as described in the Student class.
         */ 
        //Add your code here
        
        
        /** 
         * 5: Print the grades that each student got on the test, and print
         *         which students have passed or not passed based on if their
         *         test grade meets the passing grade.
         *             VERY IMPORTANT!!!!! THE ARRAY'S SIZE DOES NOT REPRESENT
         *             ALL STUDENTS, AS SOME SLOTS FOR STUDENTS ARE EMPTY!!!!!
         * Hint: There is already an attribute that represents the effective
         * size of the array!
         */
        System.out.println("\n TEST RESULTS");
        //Loop through each student and assess their grade
        
        
        /** 
         * 6: Calculate and print the average test score on this test.
         */
        //Find and print the average test score
        
        
        /** 7: Change the CLASS ATTRIBUTE of the average class grade to this
         *         most recent test's average class grade.
         * 
         *     VERY IMPORTANT!!!!! THE ARRAY'S SIZE DOES NOT REPRESENT
         *     ALL STUDENTS, AS SOME SLOTS FOR STUDENTS ARE EMPTY!!!!!
         */
        //Change the average class grade
        
    }
    
    public void addStudent(String name) {
        //Add a student to the array of all students
        ///HINT: There is a crucial integer associated
        ///with the array of students that you need to update!
    }
    
    public void addStudent(String name, int totalTestScore, int numTests) {
        //Add a student to the array of all students
        ///HINT: There is a crucial integer associated
        ///with the array of students that you need to update!
    }
    
    public void removeStudent(String name) {
        boolean foundStudent = false;
        int i;
        //Loop through each student to find the student with their matching name
        
        if (!foundStudent)
            System.out.println("Unable to find student with name " + name);
        else {
            //Remove the student from the array
            ///HINT: If you just remove the student as is, the array will have a gap.
            ///Example: (The third student is removed from the array)
            /**
             * +—————+—————+—————+—————+—————+—————+—————+
             * | Bob |Henry|     | Joe | Mark| Will|Susan|
             * +—————+—————+—————+—————+—————+—————+—————+
             */
            ///How do you shift all of the other students to fill this 'gap'?
            ///HINT 2: Are you forgetting to update a certain attribute?
        }
    }
}
