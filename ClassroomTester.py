import random

print("Imagine you are a teacher in a classroom. This program models the classroom environment, "
          "including keeping track of the number of students in the classroom, their grades, and assigning "
          "tests to change the grades of each student. This classroom is created with a default average class "
          "grade and starts with no students inside the classroom. Across the program, you can choose to add new "
          "students or remove underperforming students from the classroom. The primary feature of this program is "
          "the ability to create Multiple Choice tests for every student to fill out. One of these students will "
          "fill the test out manually, while the rest of the students fill it out automatically. At the end of the "
          "test, the overall grade average for that test will be printed. Have fun!")


classroom = Classroom() 
#If the line above is causing errors, then copy from where it says "1111" to where it says "0000",
#and move all lines of code in between those two lines to the second line of the code, below 'import random'.
user_input = 0
while user_input != -1:
    user_input = int(input("What would you like to do with your classroom? (enter number)\n1) Add new student \n2) Remove existing student \n3) Assign a new test \n4) Get the class average \n5) Get the list of all students in the classroom \n(Enter -1 to quit): "))
        
    if user_input == 1:
        name = input("What is the name of this new student? ")
        tests_taken = int(input("How many tests has this student taken? "))
        average_grade = 0
        while average_grade < 1 or average_grade > 100:
            average_grade = int(input("What is this student's grade average? (enter number between 1-100): "))
        total_test_score = tests_taken * average_grade
        classroom.add_student(name, total_test_score, tests_taken)
        
    elif user_input == 2:
        if len(classroom.students) == 0:
            print("No students to remove")
        else:
            target_name = input("What is the name of the student to remove? ")
            classroom.remove_student(target_name)
        
    elif user_input == 3:
        size = int(input("How many questions are on this test? "))
        passing_grade = 0
        while passing_grade < 1 or passing_grade > 100:
            passing_grade = int(input("What is the passing grade on this test? (enter number between 1-100): "))
        classroom.assign_test(size, passing_grade)
        
    elif user_input == 4:
        print(f"Average class grade: {classroom.average_grade}")
        
    elif user_input == 5:
        for student in classroom.students:
            if student is not None:
                print(f"Name: {student.name}\t Grade: {student.return_average_grade()}")




class Student:
    """
      NOTE TO STUDENTS: This class has all attributes and methods completed,
      except for two methods: the returnAverageGrade() method and the
      takeTest() method. Complete both of these methods, and this class
      will be complete.
	ATTRIBUTES OF A STUDENT:
	name: The name of the student
	cumulative_score: The total amount of points this student has received across all tests they've taken
	total_tests_taken: The total number of tests this student has taken
    """
    
    def __init__(self, name_in, total_score=0, total_tests=0):
        self.name = name_in
        self.cumulative_score = total_score
        self.total_tests_taken = total_tests

    def return_average_grade(self):
        #Return the average grade of the student
        #Hint: The formula to find an average in math is:
        #		(Total sum of all numbers) / (The AMOUNT of numbers)



    """
     * Simulates this student taking a test based on the questions and answers
     * provided for the test. If this student is taking the test manually,
     * then each question will be printed, and the user will input each of
     * their answers, and if their answer is correct, this student gains a
     * point on the test. If this student is taking the test automatically, 
     * then they will gain points based on random chance. The probability of
     * this student succeeding is dependant on the average grade of the entire
     * class. This method returns the grade percentage that this student received after
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
    """
    def take_test(self, questions, correct_answers, class_grade, is_manual):
        points_gained = 0
        
        if is_manual:
            #Simulate taking a real given test by looping through each question and asking the user for their answer on each question.
            #Update the amount of points the student gains with each correct answer that the user responds with.
            """
            NOTE: If the student gets an answer wrong, nothing happens. They
            do not gain points, but they should not lose any either.
            """
        else:
            #Automates taking a test
            for i in questions:
                correct_chance = #How do you make the chance randomized?
                
                #NOTE: If the class grade is higher, it will be EASIER to
                #randomly gain a point correctly.
                if correct_chance <= class_grade:
                    points_gained += 1
        
        return #Finish the return value!

""" 1111 """
class Classroom:
    """
      This class has all attributes and constructors fully complete.
     * You must finish the remaining methods that are not complete.
	ATTRIBUTES OF A CLASSROOM:
	students: A list that contains every student inside the classroom
        averageGrade: The class average calculated from the grades of every student
    """
    def __init__(self, capacity=30, average_class_percent=80):
        self.students = [None] * capacity
        self.average_grade = average_class_percent

    def assign_test(self, size, passing_grade):
        
        #INSTRUCTIONS FOR WRITING THIS METHOD:
        
         
        """
         * 1: Create three new lists. Two of these lists have a size of the
         *         "size" parameter and represent each question on the test,
         *         and that question's answer represented by an INTEGER. The 
         *         third list has a size equal to the size of the "students" list 
         *         and represents the grade of each student for this test.
        """
        print(f"CREATING NEW TEST WITH {size} QUESTIONS")
        #Add your lists here
        
        """
         * 2: [COMPLETE] Use a for loop that iterates through each question on the test.
         *         Inside this loop, ask for what the question states, and what
         *         each answer is. NOTE THAT EVERY QUESTION IS MULTIPLE CHOICE!
         *         This means that for EVERY question, you must provide an answer
         *         for each number, THEN provide the number for the CORRECT number.
         *         Obtain the question and answers from the user input, then
         *         store each question and answer into the corresponding index of
         *         the questions list and answers list.
        """
        #This code is provided for you.
        for i in range(0, size):
            questions.append(
                input("Enter the question for question " + str(i + 1) + ":"))
            for j in range(1, 5):
                ansOption = input("Enter an answer OPTION for question " +
                               str(i + 1) + ", Choice" + str(j) + ": ")
                questions[i] += "\n Choice " + str(j) + ": " + str(ansOption)
            answers.append(
                int(
                    input("Enter the correct answer for question " + str(i + 1) +
                          "(enter a number for 1, 2, 3, or 4): ")))
            while answers[i] < 1 or answers[i] > 4:
                answers[i] = int(
                    input("Enter the correct answer for question " + str(i + 1) +
                          "(enter a number for 1, 2, 3, or 4): "))
        
        """
         * 3: Create another for loop that iterates through each STUDENT
         *         in the classroom.
         *             
         *         This for loop will make each of them take
         *         the test, as seen in the Student class's function. 
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
        """
        #Add your code here

        """
         * 4: Print the grades that each student got on the test, and print
         *         which students have passed or not passed based on if their
         *         test grade meets the passing grade.
        """
        print("\nTEST RESULTS")
        #Add your code here for printing each student's grade
        
        # 5: Calculate and print the average test score
        # This part is left for implementation


        # 6: Update the average class grade
        # This part is left for implementation

    def add_student(self, name, total_test_score=0, num_tests=0):
        self.students.add(Student(name, total_test_score, num_tests))

    def remove_student(self, name):
        found_student = False
        for student in self.students:
            if student.name == name:
                found_student = True
                students.remove(student)
                break
        
        if not found_student:
            print("Unable to find student with name ", name)

""" 0000 """
