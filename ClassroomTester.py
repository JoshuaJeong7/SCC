import random

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
    def __init__(self, name_in):
        self.name = name_in
        self.cumulative_score = 0
        self.total_tests_taken = total_tests
    def __init__(self, name_in, total_score=0, total_tests=0):
        self.name = name_in
        self.cumulative_score = total_score
        self.total_tests_taken = total_tests

    def return_average_grade(self):
        #Return the average grade of the student
        #Hint: The formula to find an average in math is:
        #		(Total sum of all numbers) / (The AMOUNT of numbers)

    def take_test(self, questions, correct_answers, class_grade, is_manual):
        points_gained = 0
        
        if is_manual:
            #Simulate taking a real given test by loooping through each question.
            #Update the amount of points the student gains with each question.
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
        print(f"CREATING NEW TEST WITH {size} QUESTIONS")
        
        test_questions = [""] * size
        test_answers = [0] * size
        
        for i in range(size):
            test_questions[i] = input(f"Enter the question for question {i + 1}: ")
            for j in range(1, 5):
                answer = input(f"Enter an answer OPTION for question {i + 1}, Choice {j}: ")
                test_questions[i] += f" \n Choice {j}: {answer}"
            while test_answers[i] < 1 or test_answers[i] > 4:
                test_answers[i] = int(input(f"Enter the answer for question {i + 1} (enter a number for 1, 2, 3, or 4): "))
        
        print("\nTEST RESULTS")
        for student in self.students:
            if student is not None:
                grade = student.take_test(test_questions, test_answers, self.average_grade, False)
                print(f"{student.name} scored {grade} and {'passed' if grade >= passing_grade else 'did not pass'}.")

        # Calculate and print the average test score
        # Update the average class grade
        # This part is left for implementation

    def add_student(self, name, total_test_score=0, num_tests=0):
        self.students.add(Student(name, total_test_score, num_tests))

    def remove_student(self, name):
        found_student = False
        for student in self.students:
            if student is not None and student.name == name:
                found_student = True
                students.remove(student)
                break
        
        if not found_student:
            print("Unable to find student with name ", name)


print("Imagine you are a teacher in a classroom. This program models the classroom environment, "
          "including keeping track of the number of students in the classroom, their grades, and assigning "
          "tests to change the grades of each student. This classroom is created with a default average class "
          "grade and starts with no students inside the classroom. Across the program, you can choose to add new "
          "students or remove underperforming students from the classroom. The primary feature of this program is "
          "the ability to create Multiple Choice tests for every student to fill out. One of these students will "
          "fill the test out manually, while the rest of the students fill it out automatically. At the end of the "
          "test, the overall grade average for that test will be printed. Have fun!")

classroom = Classroom()
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


