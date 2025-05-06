//References
public class IntroToReferences1 {

	/// Have you ever wondered what exactly a 'class' or an 'object' is?
	/// This lesson should hopefully help give you a better understanding
	/// towards answering that question.
	
	
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
		  IntroToReferences1 r = new IntroToReferences1(); //This line is used to avoid issues
										//with calling non-static methods
										//from a static method.
		  
		  ///As you progress in this lesson, feel free to comment out tests
		  ///that you do not need anymore.
		  
		  //methodPass
		  System.out.println("{TEST FOR METHOD PASS}");
		  
		  ///--------------------FOCUS ON THIS CODE---------------------
		  
		  int x = 5;
		  r.methodPass(x); ///THIS LINE PRINTS "a = 10"
		  System.out.println("x = " + x); ///THIS LINE PRINTS "x = 5"
		  
		  ///--------------------FOCUS ON THIS CODE---------------------
		  
		  System.out.println("\n\n");
		  
		  
		 //passByValueTests
		 System.out.println("{PASS BY VALUE TESTS}");
		 r.passByValueTests();
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
	   * +——————————————+                 ___________      
       * |   methodPass |                / house 3bC \    
       * +——————————————+                +———————————+    
       * |    a  (3bc)  |                |  a = 5   <------+
       * +——————————————+                +———————————+     |
       *                                                   |
       * +——————————————+                 ___________      |
       * |  main        |                / house f59 \     |
       * +——————————————+                +———————————+     |
       * |  x   (f59)   |                |  x = 5   -------+    
       * +——————————————+                +———————————+
	   * 
	   * x and a live in completely different "houses". Therefore, they
	   * are completely different variables themselves, so do not treat them
	   * like they are the same variable! Instead, a is a different variable
	   * that happens to have the same value as x does, but is still different
	   * from x regardless.
	   * So in methodPass(), when a is incremented by 5, the diagram looks like this:
	   * 
	   * +——————————————+                 ___________      
       * |  methodPass  |                / house 3bC \    
       * +——————————————+                +———————————+    
       * |     a + 5    |                |  a = 10   | 
       * +——————————————+                +———————————+     
       *                                                  
       * +——————————————+                 ___________     
       * |  main        |                / house f59 \     
       * +——————————————+                +———————————+     
       * |     x        |                |  x = 5    |
       * +——————————————+                +———————————+
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
			ans = 0; //Type your answer here
			System.out.println(ans);
			
			///2. What is the value of a?
			ans = 0; //Type your answer here
			System.out.println(ans);
			
			///3. What is the value of B?
			banana(B);
			boolean ansBool = false;//Type your answer here
			System.out.println(ansBool);
			
			///4. What is the value of b?
			banana(B);
			ansBool = false; //Type your answer here
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
			//printCorrectValueAnswers(); //Uncomment this when you're ready to see the answers
			System.out.println("\n");
		}
	 
	 
		// Only look at this method once you have honestly typed an answer
		// for the questions above!
		public void printCorrectValueAnswers() {
			
			
			
			
			
			//    v         v       Answers below         v         v
			
			
			
			
			
			
			
			
			
			
			
			
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
		
}
