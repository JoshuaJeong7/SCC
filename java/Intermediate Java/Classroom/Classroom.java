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
        
        String[] testQuestions = new String[size];
        int[] testAnswers = new int[size];
        //The two arrays above refer to the questions and answers on the test itself.
        
        int[] studentGrades = new int[students.length];
        //This array refers to the grades acquired by each student
        //based on the answer sheet on the test.
          
          
        /** 
         * 2: Create the Scanner.
         */ 
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
        studentGrades[0] = students[0].takeTest(testQuestions, testAnswers, averageGrade, true);
        for (int i = 1; i < currentSize; i++)
            studentGrades[i] = students[i].takeTest(testQuestions, testAnswers, averageGrade, false);
        
        
        /** 
         * 5: Print the grades that each student got on the test, and print
         *         which students have passed or not passed based on if their
         *         test grade meets the passing grade.
         *             VERY IMPORTANT!!!!! THE ARRAY'S SIZE DOES NOT REPRESENT
         *             ALL STUDENTS, AS SOME SLOTS FOR STUDENTS ARE EMPTY!!!!!
         */
        System.out.println("\n TEST RESULTS");
        for (int i = 0; i < currentSize; i++) {
            System.out.println(students[i].name + " has received a grade of " + studentGrades[i] + " on this test!");
            if (studentGrades[i] >= passingGrade)
                System.out.println("They pass this test! \n");
            else
                System.out.println("Unfortunately, they have not passed this test. \n");
        }
        
        
        /** 
         * 6: Calculate and print the average test score on this test.
         */
        int totalGradeAdder = 0;
        for (int i = 0; i < currentSize; i++)
            totalGradeAdder += studentGrades[i];
            
        System.out.println("AVERAGE GRADE ON THIS TEST: " + (totalGradeAdder / currentSize) );
        
        
        /** 7: Change the CLASS ATTRIBUTE of the average class grade to this
         *         most recent test's average class grade.
         * 
         *     VERY IMPORTANT!!!!! THE ARRAY'S SIZE DOES NOT REPRESENT
         *     ALL STUDENTS, AS SOME SLOTS FOR STUDENTS ARE EMPTY!!!!!
         */
        averageGrade = (totalGradeAdder / currentSize);
        
    }
    
    public void addStudent(String name) {
        students[currentSize] = new Student(name);
        currentSize++;
    }
    
    public void addStudent(String name, int totalTestScore, int numTests) {
        students[currentSize] = new Student(name, totalTestScore, numTests);
        currentSize++;
    }
    
    public void removeStudent(String name) {
        boolean foundStudent = false;
        int i;
        for (i = 0; i < students.length; i++) {
            if (students[i] != null &&
                students[i].name.equals(name)) {
                    
            students[i] = null;
            System.out.println("Successfully removed student from classroom");
            foundStudent = true;
            }
            if (foundStudent) break;
                
        }
        if (!foundStudent)
            System.out.println("Unable to find student with name " + name);
        else {
            
            for (int j = i; j < currentSize; j++) {
                students[j] = students[currentSize - 1];
            }
            currentSize -= 1;
        }
    }
}
