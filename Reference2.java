//References
public class Reference2 {

	/// Have you ever wondered what exactly a 'class' or an 'object' is?
	/// This lesson should hopefully help give you a better understanding
	/// towards answering that question.
	/// Fun Fact: Arrays are considered classes, and are therefore passed
	/// by reference. More on that later.

	  public static void main(String[] args) {
		  Reference2 r = new Reference2(); //This line is used to avoid issues
										//with calling non-static methods
										//from a static method.

		 //classPassTester
		 System.out.println("{CLASS PASS EXAMPLE}");
		 r.classPassTester();
		 System.out.println("\n\n");
		 
		 //passByReferenceTests
		 System.out.println("{PASS BY REFERENCE TESTS}");
		 r.passByReferenceTest();
		 System.out.println("\n\n");
	  }
	  
	
	/*
	 * The data type of a CLASS or OBJECT is unique from any other primitive data type, such
	 * as an int or a float.
	 * 
	 * With integers or floats, you're able to change what specific
	 * value is stored inside a variable holding that value, but at the end
	 * of the day the data type will never change its properties as
	 * a number, as seen below.
	 */ 
	 
	 public void primitiveExample() {
		 int x = 0; //creating integers
		 x = 5; //I changed x to store a DIFFERENT integer
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
		   
		   for (int i = 0; i < 18; i++) {
			   //calls class2.change() 18 times
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
			
			
			
			
			///--------------------FOCUS ON THIS CODE---------------------
			
			System.out.print(" What class 1 copy prints: ");
			classSwap(class1); ///PRINTS 351
			System.out.print(" What class 1 original prints: ");
			System.out.println(class1.age); ///PRINTS 351
			
			System.out.println();
			
			System.out.print(" What class 2 copy prints: ");
			classSwap(class2); ///PRINTS 2106
			System.out.print(" What class 2 original prints: ");
			System.out.println(class2.age); ///PRINTS 2106
			
			///--------------------FOCUS ON THIS CODE---------------------
			
			
			
			
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
         * |classSwap                         |              ___________            
         * +——————————————————————————————————+             / house Aaf \
         * | 133312                           |             +———————————+    
         * |                                  |             |  133312   | 
         * +——————————————————————————————————+             |names:     |
         *                                                  |class1     |
         * +——————————————————————————————————+             |classy     |
         * |classPassTester                   |             +———————————+    
         * +——————————————————————————————————+
         * | 133312                           |
         * |                                  |  
         * +——————————————————————————————————+
         * 
         * 
         * +——————————————————————————————————+      
         * |classSwap                         |              ___________            
         * +——————————————————————————————————+             / house bfg \
         * | 886644                           |             +———————————+    
         * |                                  |             |  886644   | 
         * +——————————————————————————————————+             |names:     |
         *                                                  |class2     |
         * +——————————————————————————————————+             |classy     |
         * |classPassTester                   |             +———————————+    
         * +——————————————————————————————————+
         * | 886644                           |
         * |                                  |  
         * +——————————————————————————————————+
         * 
	     * In this new house example, there are two distinct "houses": Aaf,
	     * which holds class1, and bfg, which holds class2. So far so good.
	     * 
	     * In reality, these names of "class1" and "class2" are arbitrary;
	     * the real representation of these objects are the memory addresses associated
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
		  
		///Yes, you are allowed to nest a class inside of a class.
		///This is only done out of necessity for completing the exercise.
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
			  
			public void ready() {
				day += 1;
			}
		}
		  
		public void halloween(Holiday a) {
			for (int i = 0; i < 3; i++) {
				a.ready();
			}
		}
		public void christmas(Holiday b) {
			for (int i = 0; i < 8; i++) {
				b.ready();
			}
			b.day = 4;
		}
		public void thanksgiving(Holiday c, Holiday d) {
			for (int i = 0; i < 5; i++) {
				c.day += d.day;
				d.ready();
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
				f.ready();
			}
		}
		public void newyears(Holiday g) {
			for (int i = 0; i < 2; i++) {
				g.ready();
			}
			for (int i = 0; i < 2; i++) {
				g.applause();
			}
			for (int i = 0; i < 2; i++) {
				g.ready();
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
			System.out.println("Answer A: "/* + [Type your answer here] */);
			
			///2. What is the day of a?
			System.out.println("Answer a: "/* + [Type your answer here] */);
			
			///3. What is the day of B?
			christmas(B);
			System.out.println("Answer B: "/* + [Type your answer here] */);
			
			///4. What is the day of b?
			System.out.println("Answer b: "/* + [Type your answer here] */);
			
			///5. What is the day of C?
			thanksgiving(C, D);
			System.out.println("Answer C: "/* + [Type your answer here] */);
			
			///6. What is the day of c?
			System.out.println("Answer c: "/* + [Type your answer here] */);
			
			///7. What is the day of D?
			System.out.println("Answer D: "/* + [Type your answer here] */);
			
			///8. What is the day of d?
			System.out.println("Answer d: "/* + [Type your answer here] */);
			
			///9. How many "Yay"s are there for E?
			valentines(E);
			System.out.println("Answer E: "/* + [Type your answer here] */);
			
			///10. How many "Yay"s are there for e?
			System.out.println("Answer e: "/* + [Type your answer here] */);
			
			///11. What is the day of F?
			easter(F);
			System.out.println("Answer F: "/* + [Type your answer here] */);
			
			///12. What is the day of f?
			System.out.println("Answer f: "/* + [Type your answer here] */);
			
			///13. How many "Yay"s are there for G?
			newyears(G);
			System.out.println("Answer G: "/* + [Type your answer here] */);
			
			///14. How many "Yay"s are there for g?
			System.out.println("Answer g: "/* + [Type your answer here] */);
			
			//When you're ready, run the program again!
			
			System.out.println();
			//printCorrectReferenceAnswers(); //Uncomment this when you're ready to see the answers
			System.out.println("\n");
		}
		
		// Only look at this method once you have honestly typed an answer
		// for the questions above!
		public void printCorrectReferenceAnswers() {
						
			
			
			
			
			//    v         v       Answers below         v         v
			
			
			
			
			
			
			
			
			
			
			
			
			System.out.println();
			System.out.println(">>>CORRECT ANSWERS");
			System.out.println("1: A = 23; Check all the lines in the code BEFORE the halloween() method is executed!");
			System.out.println("2: a = 23");
			System.out.println("3: B = 4");
			System.out.println("4: b = 4");
			System.out.println("5: C = 14");
			System.out.println("6: c = 14");
			System.out.println("7: D = 5");
			System.out.println("8: d = 5");
			System.out.println("9: E = \"\"");
			System.out.println("10: e = \"\"");
			System.out.println("11: F = 15; At the start of the easter() method, the parameter f is changed to refer to a new object.\n This means that the memory address that was linked between F and f is terminated! (NOTE: More accurately, the connection has been severed,)\n BECAUSE f no longer refers to the same object as F, this method has now become PASS BY VALUE. The changes of f is no longer mirrored to the value of F.\n");
			System.out.println("12: f = 10; Read the above explanation");
			System.out.println("13: G = \"YayYayYayYayYayYayYayYayYayYayYayYay (12 \'Yay\'s)\"");
			System.out.println("14: G = \"YayYayYayYayYayYayYayYayYayYayYayYay (12 \'Yay\'s)\"");
		}
}
