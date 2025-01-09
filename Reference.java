//References
public class Reference {

	/// Have you ever wondered what exactly a 'class' or an 'object' is?
	/// This lesson should hopefully help give you a better understanding
	/// towards answering that question.
	/// Fun Fact: Arrays are considered classes, and are therefore passed
	/// by reference. More on that later.
	
	
	/**
	 * Before we talk about classes, let's talk about an important topic:
	 * passing variables through parameters.
	 * When you pass primitive variables through parameters, such as ints or
	 * floats, you might think that the variable is just transported from
	 * one method to another, such as in the following:
	 */ 
	 
	 public void methodPass(int a) {
		  a += 5;
		  System.out.println("a = " + a);
	 }
	 
	 /**
	  * Assuming that the variable is transported directly between two methods,
	  * then logically, in the following main method, the variable x should
	  * be changed from 5 to 10:
	  */ 
	  public static void main(String[] args) {
		  Reference r = new Reference(); //This line is used to avoid issues
										//with calling non-static methods
										//from a static method.
		  
		  ///As you progress in this lesson, feel free to comment out tests
		  ///that you do not need anymore.
		  
		  //methodPass()
		  System.out.println("{TEST FOR METHOD PASS}");
		  
		  ///--------------------FOCUS ON THIS CODE---------------------
		  int x = 5;
		  r.methodPass(x);
		  System.out.println("x = " + x);
		  ///--------------------FOCUS ON THIS CODE---------------------
		  
		  System.out.println("\n\n");
		  
		  
		 //passByValueTests()
		 System.out.println("{PASS BY VALUE TESTS}");
		 r.passByValueTests();
		 System.out.println("\n\n");
		 
		 //classPassTester()
		 System.out.println("{CLASS PASS EXAMPLE}");
		 r.classPassTester();
		 System.out.println("\n\n");
	  }
	  
	  /**
	   * However, if you run the program right now, you'll see that x does
	   * not print 10, but still 5, meaning that x has not been changed by
	   * methodPass() when it hypothetically should have. Then what's happened
	   * here?
	   */
	   
	  /**
	   * The answer is a concept called PASS BY VALUE. In Java, when any
	   * variable is passed into a method as a parameter, the computer
	   * copies the value of the variable and stores it in a completely new
	   * varaible. In other words, the variable passed as a parameter and
	   * the variable in the main function are two completely separate
	   * variables.
	   * For simplicity, this can be represented by the following:
	   * +——————————————+				 ___________	  
	   * |	methodPass	|				/ house 3bC \    
	   * +——————————————+				+———————————+    
	   * |	a	(3bc)	|               |  a = 5  <------+
	   * +——————————————+               +———————————+	 |
	   * 												 |
	   * +——————————————+				 ___________	 |
	   * |  main        |			    / house f59 \	 |
	   * +——————————————+				+———————————+	 |
	   * |  x   (f59)   |				|  x = 5  -------+    
	   * +——————————————+				+———————————+
	   * 
	   * x and a live in completely different "houses". Therefore, they
	   * are completely different variables themselves, so do not treat them
	   * like they are the same variable! Instead, a is a different variable
	   * that happens to have the same value as x does, but is still different
	   * from x regardless.
	   * So in methodPass(), when a is incremented by 5, the diagram looks like this:
	   * 
	   * +——————————————+				 ___________	  
	   * |	methodPass	|				/ house 3bC \    
	   * +——————————————+				+———————————+    
	   * |		a + 5	|               |  a = 10   | 
	   * +——————————————+               +———————————+	 
	   * 												 
	   * +——————————————+				 ___________	 
	   * |  main        |			    / house f59 \	 
	   * +——————————————+				+———————————+	 
	   * |     x        |				|  x = 5    |
	   * +——————————————+				+———————————+
	   * 
	   * Notice that a has been incremented, but not x. This is because a
	   * is treated as a completely unrelated to x, so when one variable is
	   * incremented, it holds no change on the other variable.
	   * Pass by value applies to any primitive data type, including Strings.
	   */
	   
	   /*
	    * Want some practice with pass by value? Here are some more methods
	    * that will make changes in operations. Your job is to trace what the
	    * values of each variable and determine what is printed in
	    * passByValueTests().
	    */
	    public void grape(int a) {
			a+=1;
		}
		
		public void banana(boolean b) {
			b = !b;
		}
		
		public int apple(int c) {
			return c + 40;
		}
		
		public int orange(int d) {
			d *= 2;
			return 58;
		}
	    
	    public void kiwi(int e, int f) {
			f += e;
		}
		
		public void passByValueTests() {
			int A = 40;
			boolean B = false;
			int C = 20;
			int D = 30;
			int E = 17;
			int F = 50;
			
			int ans = 0;
			System.out.println(">>>USER GUESSES");
			
			///1. What is the value of A?
			grape(A);
			ans = //Type your answer here
			System.out.println(ans);
			
			///2. What is the value of a?
			ans = //Type your answer here
			System.out.println(ans);
			
			///3. What is the value of B?
			banana(B);
			boolean ansBool = //Type your answer here
			System.out.println(ansBool);
			
			///4. What is the value of b?
			banana(B);
			boolean ansBool = //Type your answer here
			System.out.println(ansBool);
			
			///5. What is the value of C?
			C = apple(C);
			ans = 0; //Type your answer here
			System.out.println(ans);
			
			///6. What is the value of c?
			ans = 0; //Type your answer here
			System.out.println(ans);
			
			///7. What is the value of D?
			D = orange(D);
			ans = 0; //Type your answer here
			System.out.println(ans);
			
			///8. What is the value of d?
			ans = 0; //Type your answer here
			System.out.println(ans);
			
			///9. What is the value of E?
			kiwi(E, F);
			ans = 0; //Type your answer here
			System.out.println(ans);
			
			///10. What is the value of e?
			ans = 0; //Type your answer here
			System.out.println(ans);
			
			///11. What is the value of F?
			ans = 0; //Type your answer here
			System.out.println(ans);
			
			///12. What is the value of f?
			ans = 0; //Type your answer here
			System.out.println(ans);
			
			//When you're ready, run the program again!
			
			System.out.println();
			//printCorrectValueAnswers(); Uncomment this when you're ready to see the answers
			System.out.println("\n");
		}
	 
	 
		// Only look at this method once you have honestly typed an answer
		// for the rest of the questions!
		public void printCorrectValueAnswers() {
			System.out.println(">>>CORRECT ANSWERS");
			System.out.println("1: A = 40");
			System.out.println("2: a = 41");
			System.out.println("3: B = false");
			System.out.println("4: b = true");
			System.out.println("5: C = 41; In this case, the return value is not what changes C, but it is the fact that C is directly set to the return value in passByValueTests()");
			System.out.println("6: c = 40; The method returns c + 40, but NEVER does it add one to c as a variable");
			System.out.println("7: D = 58");
			System.out.println("8: d = 60");
			System.out.println("9: E = 17");
			System.out.println("10: e = 17");
			System.out.println("11: F = 50");
			System.out.println("12: f = 67");
		}
		
		
		
	/*
	 * The data type of a class is unique from any other primitive data type, such
	 * as an int or a float.
	 * 
	 * With integers or floats, you're able to change what specific
	 * value is stored inside a variable holding that value, but at the end
	 * of the day the data type will never change its properties as
	 * a number, as seen below.
	 */ 
	 
	 public void primitiveExample() {
		 int x = 0; //creating integers
		 x = 5; //I changed x to store a different INTEGER
	 }
	 /*
	  * Even though I changed x to a different number, it is still just that:
	  * a number. I can't change x to have any new number properties,
	  * such as representing a graph function, an imaginary number,
	  * a degree, or anything else.
	  */
	  
	  /*
	   * Classes, however, are different. Properties about them can rapidly
	   * change, such as the values stored into them, or whatever status they
	   * might hold. An example is shown in this next class:
	   */
	   
	   ///Yes, you are allowed to nest a class inside of a class.
	   ///This is only done out of necessity for completing the exercise.
	   class ChangingClass {
			public int age;
			private String message;
			private int[] storage;
			
			public void change() {
				age += 17;
				message = message + "Potato";
				storage[age % 1000] += 100;
			}
			
			public int addAge() {
				for (int i = 0; i < storage.length; i++) {
					age += storage[i];
				}
				return age;
			}
			
			public ChangingClass() {
				age = 0;
				message = "Hi";
				storage = new int[1000];
			}
		}

	   public ChangingClass class1Example() {
		   ///IMPORTANT: SEE ABOVE FOR ChangingClass
		   ChangingClass class1 = new ChangingClass();
		     
		   for (int i = 0; i < 3; i++) {
			   class1.change();
		   }
		    
		   return class1;
	   }
	   
	   public ChangingClass class2Example() {
		   ChangingClass class2 = new ChangingClass();
		   
		   for (int i = 0; i < (int)(Math.random() * 20 + 5); i++) {
			   //calls class2.change() a random amount of times between 5-24
			   class2.change();
		   }
		   
		   return class2;
	   }
	   
	   
		/* Things look weird, but nothing broke so far, right?
		 * All we did was create two classes, and call the method in one
		 * three times, and the method in another a random amount of times.
		 * 
		 * What happens, then, if we pass these classes into a method
		 * to perform operations, such as the one below?
		 */
		public void classSwap(ChangingClass classy) {
			int newAge = classy.addAge();
			System.out.println(classy.age);
			
		}
	   
	   /*
	    * From what we learned previously about primitive data types, it
	    * would seem logical that the computer make a copy of
	    * the class, say for example class1, and whatever data is only changed
	    * in classy is not reflected in class1. Let's test that in the method below.
	    */
	    public void classPassTester() {
			ChangingClass class1 = class1Example();
			ChangingClass class2 = class2Example();
			
			System.out.print(" What class 1 copy prints: ");
			classSwap(class1);
			System.out.print(" What class 1 original prints: ");
			System.out.println(class1.age);
			
			System.out.println();
			
			System.out.print(" What class 2 copy prints: ");
			classSwap(class2);
			System.out.print(" What class 2 original prints: ");
			System.out.println(class2.age);
			
			System.out.println();
		}
		
		/*
		 * As you can see, the "copy" of the object and the original object
		 * both return the exact same value, even though the operation has
		 * been performed on only the copy.
		 * 
		 * This tells us that even though we are in different methods and
		 * we did different operations to different variables,
		 * the copy of the object and the original object somehow
		 * refer to the exact same thing. How is that possible?
		 */
		 
		/*
		 * The answer is because of a concept that is the opposite of
		 * pass by value: PASS BY REFERENCE. In pass by reference, when
		 * a variable is passed into a method as a parameter, the computer
		 * will refer to that exact same variable, as if you truly were just
		 * using the original variable all along. This means that if you
		 * make any change in the "copy", the change WILL be reflected in
		 * the original variable. 
		 * Let's demonstrate pass by reference using the house example again.
		 * 
		 * +——————————————————————————————————+	  
	     * |classSwap	                      |			     ___________		    
	     * +——————————————————————————————————+				/ house Aaf \
	     * | 133312                           |				+———————————+    
	     * |								  |             |  133312   | 
	     * +——————————————————————————————————+ 			|names:     |
	     * 													|class1     |
	     * +——————————————————————————————————+ 			|classy     |
	     * |classPassTester	                  |			    +———————————+	
	     * +——————————————————————————————————+
	     * | 133312                           |
	     * |								  |  
	     * +——————————————————————————————————+
	     * 
	     * 
	     * +——————————————————————————————————+	  
	     * |classSwap	                      |			     ___________		    
	     * +——————————————————————————————————+				/ house bfg \
	     * | 886644                           |				+———————————+    
	     * |								  |             |  886644   | 
	     * +——————————————————————————————————+ 			|names:     |
	     * 													|class2     |
	     * +——————————————————————————————————+ 			|classy     |
	     * |classPassTester	                  |			    +———————————+	
	     * +——————————————————————————————————+
	     * | 886644                           |
	     * |								  |  
	     * +——————————————————————————————————+
	     * 
	     * In this new house example, there are two distinct "houses": Aaf,
	     * which holds class1, and bfg, which holds class2. So far so good.
	     * 
	     * In reality, these names of "class1" and "class2" are arbitrary;
	     * the real representation of these objects are the numbers associated
	     * with them: 133312 for "class1" and 886644 for "class2".
	     * 
	     * When an object from classPassTester is passed into classSwap,
	     * what's really passed between methods is the memory address,
	     * such as 133312. Since the memory address is the same across
	     * both methods, they refer to the exact same object. In classSwap,
	     * this object is called "classy", while in classPassTester, the object
	     * is called "class1". This means that changing the object in 
	     * classSwap WILL change the object in classPassTester, 
	     * because they share the same object.
		 */ 
		 
		 /*
		  * Here's some more practice with pass by reference! Like before,
		  * trace the values of each variable/object and figure out what
		  * is printed by the program at the end.
		  */
		  
		//Yes, you are allowed to nest a class inside of a class.
		//This is only done out of necessity for completing the exercise.
		class Holiday {
			public int day;
			public String cheer;
		  
			public Holiday() {
				day = 0;
				cheer = "";
			}
			  
			public void applause() {
				for (int i = 0; i < day; i++) {
					cheer += "Yay";
				}
			}
			  
			public void wait() {
				day += 1;
			}
		}
		  
		public void halloween(Holiday a) {
			for (int i = 0; i < 3; i++) {
				a.wait();
			}
		}
		public void christmas(Holiday b) {
			for (int i = 0; i < 8; i++) {
				a.wait();
			}
			a.day = 4;
		}
		public void thanksgiving(Holiday c, Holiday d) {
			for (int i = 0; i < 5; i++) {
				c.day += d.day();
				d.wait();
			}
		}
		public Holiday valentines(Holiday e) {
			for (int i = 0; i <= 2; i++) {
				e.applause();
			}
			return e;
		}
		public void easter(Holiday f) {
			f = new Holiday();
			for (int i = 0; i < 10; i++) {
				f.wait();
			}
		}
		public void newyears(Holiday g) {
			for (int i = 0; i < 2; i++) {
				g.wait();
			}
			for (int i = 0; i < 2; i++) {
				g.applause();
			}
			for (int i = 0; i < 2; i++) {
				g.wait();
			}
			for (int i = 0; i < 2; i++) {
				g.applause();
			}
		}
		
		public void passByReferenceTest() {
			Holiday A = new Holiday();
			Holiday B = new Holiday();
			Holiday C = B;
			Holiday D = new Holiday();
			Holiday E = new Holiday();
			Holiday F = new Holiday();
			Holiday G = new Holiday();
			
			A.day = 20;
			C.day = 7;
			F.day = 15;
			
			System.out.println(">>>USER GUESSES");
			
			///1. What is the day of A?
			halloween(A);
			System.out.println(/* Type your answer here */);
			
			///2. What is the day of a?
			System.out.println(/* Type your answer here */);
			
			///3. What is the day of B?
			christmas(B);
			System.out.println(/* Type your answer here */);
			
			///4. What is the day of b?
			System.out.println(/* Type your answer here */);
			
			///5. What is the day of C?
			thanksgiving(C, D);
			System.out.println(/* Type your answer here */);
			
			///6. What is the day of c?
			System.out.println(/* Type your answer here */);
			
			///7. What is the day of D?
			System.out.println(/* Type your answer here */);
			
			///8. What is the day of d?
			System.out.println(/* Type your answer here */);
			
			///9. How many "Yay"s are there for E?
			valentines(E);
			System.out.println(/* Type your answer here */);
			
			///10. How many "Yay"s are there for e?
			System.out.println(/* Type your answer here */);
			
			///11. What is the day of F?
			easter(F);
			System.out.println(/* Type your answer here */);
			
			///12. What is the day of f?
			System.out.println(ans);
			
			///11. How many "Yay"s are there for G?
			newyears(G);
			System.out.println(/* Type your answer here */);
			
			///12. How many "Yay"s are there for g?
			System.out.println(/* Type your answer here */);
			
			//When you're ready, run the program again!
			
			System.out.println();
			
			System.out.println("\n");
		}
}
