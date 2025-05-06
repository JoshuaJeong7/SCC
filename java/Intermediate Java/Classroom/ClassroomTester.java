import java.util.Scanner;
/**
 * UNIT: Objects and Classes
 * 
 * COMPLETED CLASSES:
 * ClassroomTester.java
 * 
 * ASSESSED CLASSES:
 * Classroom.java
 * Student.java
 * 
 * ASSESSMENT ON: 
 * -The ability to manipulate attributes and create methods within a class
 * -The knowledge of how to flush the input stream (i.e. nextLine() after nextInt())
 * 
 * NOT ASSESSED AT ALL:
 * -The knowledge or usage of several library classes, such as javax.swing
 * -The knowledge and understanding of the concept of inheritance
 * -The ability to use classes and inherited classes from client classes
 *         that are outside of the target class's hierarchy
 * 
 */
public class ClassroomTester {
    public static void main(String[] args) {
        System.out.println("Imagine you are a teacher in a classroom. This" +
        " program models the classroom environment, \n including keeping track" +
        " of the number of students in the classroom, their grades, and assigning" +
        " tests to change the grades of each student. \n This classroom is " +
        " created with a default average class grade and starts with no students" +
        " inside the classroom. \n Across the program, you can choose to add new " +
        " students or remove underperforming students from the classroom. \n" +
        " The primary feature of this program is the ability to create Multiple Choice tests " +
        " for every student to fill out. One of these students will fill the test " +
        " out manually, while the rest of the students fill it out automatically. \n" +
        " At the end of the test, the overall grade average for that test will be printed." +
        " \n Have fun!");
        
        Scanner in = new Scanner(System.in);
        Classroom classroom = new Classroom();
        int userInput = 0;
        while (userInput != -1) {
            do {
                System.out.println("What would you like to do with your classroom? (enter number)");
                System.out.println("1) Add new student");
                System.out.println("2) Remove existing student");
                System.out.println("3) Assign a new test");
                System.out.println("4) Get the class average");
                System.out.println("5) Get the list of all students in the classroom");
                System.out.println("(Enter -1 to quit)");
                userInput = in.nextInt();
                in.nextLine();
            } while (userInput != -1 && userInput < 1  || userInput > 5);
            
            if (userInput == 1) {
                System.out.println("What is the name of this new student?");
                String name = in.nextLine();
                System.out.println("How many tests has this student taken?");
                int testsTaken = in.nextInt();
                in.nextLine();
                
                int averageGrade = 0;
                while (averageGrade < 1 || averageGrade > 100) {
                    
                System.out.println("What is this student's grade average? " +
                                    "(enter number between 1-100)");
                                    
                    averageGrade = in.nextInt();
                    in.nextLine();
                }
                
                int totalTestScore = testsTaken * averageGrade;
                    
                classroom.addStudent(name, totalTestScore, testsTaken);
            }
            
            else if (userInput == 2) {
                if (classroom.currentSize == 0)
                    System.out.println("No students to remove");
                else {
                    System.out.println("What is the name of this new student?");
                    String targetName = in.nextLine();
                    
                    classroom.removeStudent(targetName);
                }
            }
            
            else if (userInput == 3) {
                System.out.println("How many questions are on this test?");
                int size = in.nextInt();
                in.nextLine();
                
                int passingGrade = 0;
                while (passingGrade < 1 || passingGrade > 100) {
                    
                System.out.println("What is the passing grade on this test? " +
                                    "(enter number between 1-100)");
                                    
                    passingGrade = in.nextInt();
                    in.nextLine();
                }
                
                classroom.assignTest(size, passingGrade);
            }
            
            else if (userInput == 4) {
                System.out.println("Average class grade: " + classroom.averageGrade);
            }
            else if (userInput == 5) {
                for (int i = 0; i < classroom.currentSize; i++) {
                    System.out.println("Name: " + classroom.students[i].name +
                                        "\t Grade: " + classroom.students[i].returnAverageGrade() );
                }
            }
        }
    }
}
