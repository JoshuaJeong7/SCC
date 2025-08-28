public class ReferenceListIntro3 {
	public static void main(String[] args) { //This line is used to avoid issues
										//with calling non-static methods
										//from a static method.
		ReferenceListIntro3 r = new ReferenceListIntro3();
		
		System.out.println("\n\n—————————————————————————\nVIRAL MEME!!!\n—————————————————————————\n\n");
		r.viralMeme();
		System.out.println("\n\n—————————————————————————\nCONGA LINE!!!\n—————————————————————————\n\n");
		r.congaLine();
		System.out.println("\n\n");
	}
	/*

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
     * where the memory address 886644 is passed into classSwap, sharing the
     * exact same reference to the exact same object as the object in main.
     * 
     * We can do some pretty interesting things using this knowledge. 
     * 			For example, we can pass the same memory address through 
     * several different methods and make a change to the class every time, 
     * 			so that the class at the end of all of the methods 
     * will look very different from where it started. 
     * 
     * 
     * If you're confused, this can be visually represented as:
     * 
     *  			  ___________            
     *               / house bfg \
     *               +———————————+    
     *               |  886644   |    int myPopularity = 0;
     *               |     |     |
     *               +—————|—————+
     *					   |
     *            /--------/  
     * +————————— | ———————+
     * |twitter	  |        |
     * +————————— v ———————+
     * |      886644 -----VIRAL MEME!!!-----\
     * | myPopularity += 1;|                |
     * +———————————————————+     +————————— | ———————+
     * 							 |youtube   |        |
     *                           +————————— v ———————+
     *             /------------------- 886644       |
     * +————————— | ———————+     | myPopularity += 5;|
     * |instagram |        |     +———————————————————+
     * +————————— v ———————+
     * |      886644 -----VIRAL MEME!!!-----\
     * | myPopularity -= 7;|                |
     * +———————————————————+     +————————— | ———————+
     * 							 |reddit    |        |
     *                           +————————— v ———————+
     *             /------------------- 886644       |
     * +————————— | ———————+     | myPopularity *= 4;|
     * |facebook  |        |     +———————————————————+
     * +————————— v ———————+
     * |      886644 -----VIRAL MEME!!!-----\
     * | myPopularity %= 3;|                |
     * +———————————————————+     +————————— | —————————+
     * 							 |discord   |          |
     *                           +————————— v —————————+
     *             /------------------- 886644         |
     *            |              | myPopularity -= 300;|
     *            |              +—————————————————————+
     *            |
     *            |
     * +————————— | —————————————————————+         
     * |tiktok	  |                      |         
     * +————————— v —————————————————————+
     * |      886644                     |
     * | myPopularity = myPopularity ^ 2;|                   
     * +—————————————————————————————————+                          
     */          
     
     ///Basically, this means that 886644, the viral meme posted, is shared
     ///across every one of these social media platforms, which affects 
     ///the meme's ultimate popularity.
     ///This is what VIRAL MEME looks like in code! 
     
     //Note: Because this is standard coding practice, field variables are now
     //ALWAYS private from this point forward. To access these field variables,
     //you must use getPopularity() and setPopularity().
     class Bfg {
		 private int myPopularity;
		 public Bfg() {
			 myPopularity = 0;
		 }
		 public int getPopularity() {
			 return myPopularity;
		 }
		 public void setPopularity(int newPopularity) {
			 myPopularity = newPopularity;
		 }
	 }
     
     public void viralMeme() {
		 Bfg theMeme = new Bfg();
		 System.out.println("myPopularity = " + theMeme.getPopularity());
		 twitter(theMeme);
		 System.out.println("myPopularity = " + theMeme.getPopularity());
		 
		 
	 }
	 
	 public void twitter(Bfg myClass) {
		 System.out.println("VIRAL MEME 1");
		 myClass.setPopularity(
								myClass.getPopularity() + 1
																);
				//this is how you LEGALLY code myPopularity += 1;
		 youtube(myClass);
	 }
	 
	 public void youtube(Bfg myClass) {
		 System.out.println("VIRAL MEME 2");
		 myClass.setPopularity(
								myClass.getPopularity() + 5
																);
				//this is how you LEGALLY code myPopularity += 5;
		 instagram(myClass);
	 }
	 
	 public void instagram(Bfg myClass) {
		 System.out.println("VIRAL MEME 3");
		 myClass.setPopularity(
								myClass.getPopularity() - 7
																);
				//this is how you LEGALLY code myPopularity -= 7;
		 reddit(myClass);
	 }
	 
	 public void reddit(Bfg myClass) {
		 System.out.println("VIRAL MEME 4");
		 myClass.setPopularity(
								myClass.getPopularity() * 4
																);
				//this is how you LEGALLY code myPopularity *= 4;
		 facebook(myClass);
	 }
	 
	 public void facebook(Bfg myClass) {
		 System.out.println("VIRAL MEME 5");
		 myClass.setPopularity(
								myClass.getPopularity() % 3
																);
				//this is how you LEGALLY code myPopularity %= 3;
		 discord(myClass);
	 }
	 
	 public void discord(Bfg myClass) {
		 System.out.println("VIRAL MEME 6");
		 myClass.setPopularity(
								myClass.getPopularity() - 300
																);
				//this is how you LEGALLY code myPopularity -= 300;
		 tiktok(myClass);
	 }
	 
	 public void tiktok(Bfg myClass) {
		 System.out.println("VIRAL MEME 7");
		 myClass.setPopularity(
					(int)(Math.pow(myClass.getPopularity(), 2))
																);
		//this is how you LEGALLY code myPopularity = Math.pow(myPopularity, 2);
	     System.out.println("VIRAL MEME done!");
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	/*
	 * That's cool! Unfortunately though, this isn't something you'll expect
	 * to do a lot. Typically you're only passing one memory address, or "house",
	 * through 2-3 methods at a time, OR through recursion, which is another topic.
	 * 
	 * However, there IS a related (and cool) thing we can do with classes.
	 * Say that we have the following class:
	 */
	 
	public class AThing {
	 	int myNum;
	 	AThing next;
	 	public AThing() {
	 		myNum = 0;
	 		next = null;
	 	}
	 	public AThing(int newNum) {
	 		myNum = newNum;
	 		next = null;
	 	}
	 
	 	public void nextThing(int num) {
	 		next = new AThing(num);
	 	}
	}
	
	 
	 /* 
	 * This looks all handy-dandy, but notice that inside the class AThing,
	 * we have a field variable that is literally itself. Doesn't this look strange?
	 * Wouldn't this cause an error because the class is defining itself?
	 * 
	 * NO.
	 * 
	 * This is actually a very powerful tool about references! Whenever you
	 * say the keyword 'new', the program creates an entirely new house.
	 * For example, here is our house for AThing if we write the following code:
	 * 
	 * AThing thing3bb = new AThing();
	 * 
	 *  		      _______________            
     *               / house 3bb     \
     *               +———————————————+    
     *               |  182798       |   
     *               | myNum = 0     |
     *               |next = null    |
     *               +———————————————+
     * 
     *  Now, notice that "next" is null. Let's say we wanted to set next
     * equal to something. In order to do that, we must write the following:
     * 
     * 
     * 
     * 
     *     thing3bb.nextThing(20);
     * 
     * This is the equivalent to:
     * 
     *     thing3bb.next = new AThing(20);
     * 
     * 
     * 
     * What would that look like? Well, I'll show you:
     * 
     *                _______________            
     *               / house 3bb     \
     *               +———————————————+    
     *               |  182798       |         
     *               | myNum = 0     |         >>>>  PAY ATTENTION  <<<<
     *               |next = 652137  |  <---- here is the new AThing we made
     *               +———————————————+
     * 
     * Okay, but what does "652137" even mean?
     * Well, this is the memory address of a NEW OBJECT, that is still part
     * of the class AThing. 
     * In other words, this is 652137: a new house.
     * 
     *                _______________            
     *               / house sdn     \
     *               +———————————————+    
     *               |  652137       |   
     *               | myNum = 20    |
     *               |next = null    |
     *               +———————————————+
     * 
     * 
     * If you have keen eyes, then you can recognize that house sdn has the
     * same memory address as the value of next. What does that mean?
     * This is what that visually means:
     * 
     *                _______________            
     *               / house 3bb     \
     *               +———————————————+    
     *               |  182798       |   
     *               | myNum = 0     |
     *               |next = 652137 ----------\
     *               +———————————————+        |
     *                                        |
     *                _______________         |      
     *               / house sdn     \        |
     *               +———————————————+        |
     *               |  652137 <--------------/
     *               | myNum = 20    |
     *               |next = null    |
     *               +———————————————+
     * 
     * 
     * 
     * This is pretty exciting! We just found a way to link one house to
     * a completely different house! In other words, JUST by having the
     * memory address for 182798, we have access to a completely new object
     * thanks to our "next" field variable.
     * 
     * In simple terms, this means that just by having access to house 3bb,
     * we already have access to house sdn!
     * 
     * 
     * Now if we reapply this procedure over and over again, do you know
     * what we get?
     * 
     *                _______________            
     *               / house 3bb     \
     *               +———————————————+    
     *               |  182798       |   
     *               | myNum = 0     |
     *               |next = 652137 ----------\
     *               +———————————————+        |
     *                                        |
     *                                        |
     *                                 CONGA LINE!!!
     *                                        |
     *                _______________         |      
     *               / house sdn     \        |
     *               +———————————————+        |
     *               |  652137 <--------------/
     *               | myNum = 20    |
     *               |next = 293574 ----------\
     *               +———————————————+        |
     *                                        |
     *                                        |
     *                                 CONGA LINE!!!
     *                                        |
     *                _______________         |      
     *               / house v3g     \        |
     *               +———————————————+        |
     *               |  293574 <--------------/
     *               | myNum = -3    |
     *               |next = 873619 ----------\
     *               +———————————————+        |
     *                                        |
     *                                        |
     *                                 CONGA LINE!!!
     *                                        |
     *                _______________         |      
     *               / house b93     \        |
     *               +———————————————+        |
     *               |  873619 <--------------/
     *               | myNum = 100   |
     *               |next = 303482 ----------\
     *               +———————————————+        |
     *                                        |
     *                                        |
     *                                 CONGA LINE!!!
     *                                        |
     *                _______________         |      
     *               / house gv9     \        |
     *               +———————————————+        |
     *               |  303482 <--------------/
     *               | myNum = 9399  |
     *               |next = 594348 ----------\
     *               +———————————————+        |
     *                                        |
     *                                        |
     *                                 CONGA LINE!!!
     *                                        |
     *                _______________         |      
     *               / house 39t     \        |
     *               +———————————————+        |
     *               |  594348 <--------------/
     *               | myNum = -20   |
     *               |next = null    |
     *               +———————————————+
     * 
     * 
     * 
     * 
     * This process, where an object links to another object of the same class
     * repeatedly, creates a structure called a LINKED LIST.
     * 
     * 
     * 
     * You may be asking:
     * 
     * 
     * 
     * 
     * 
     * 
     *             "How does that even make sense? How is this class like...
     *         storing multiple versions of itself? Isn't that a class-ception?"
     * 
     * 
     * 
     * 
     * 
     * 
     *     Kinda. Think about a suburban neighborhood. Every house in one
     * line looks exactly the same and has the same layout, but different
     * people live inside of them and decorate the house with different things.
     * 
     * In order words, everything is the same TYPE of house, but it is NOT
     * THE SAME HOUSE. Every house is still different, even though it's made
     * of the same materials.
     * 
     * 
     * Similarly, the class gives each object (or memory address) the same
     * structure in code, however each object is a completely separate entity,
     * unrelated to each other. 
     * (Although, they ARE related to each other, because the 'next' field
     * variable points directly to the next object!)
     * 
     * 
	 */
	
	
	/* To prove the conga line works, here's a line of code that does everything
	 * described above with the linked list / conga line!
	 */
	public void congaLine() {
		AThing thing3bb = new AThing();
		
		thing3bb.next = new AThing(20); //house sdn
		thing3bb.next.next = new AThing(-3); //house v3g
		thing3bb.next.next.next = new AThing(100); //house b93
		thing3bb.next.next.next.next = new AThing(9399); //house gv9
		thing3bb.next.next.next.next.next = new AThing(-20); //house 39t
		
		// Just to make things fun, we will preview the code for how to "travel" through
		// a linked list!
		// Don't worry about not understanding, we will explain later in the slides!
		
		AThing currentThing = thing3bb;
		while (currentThing != null) {
			System.out.println("CONGA LINE!!!");
			System.out.println(currentThing.myNum);
			
			currentThing = currentThing.next;
		}
	}
	
   /**
	 * 
	 * 
	 * Wanna get some practice with linked lists? Try creating a linked list
	 * of your own!
	 * 
	 * 
	 * Below is the sample class given to set up a linked list:
	 * 
	 */
	 
	class myLinkedList {
		public int num;
		public myLinkedList next;
		
		public myLinkedList() {
			this(0);
		}
		public myLinkedList(int myNum) {
			num = myNum;
			next = null;
		}
		//To change num later, just use [object name].num = ###;
		
		//To change next later, just use [object name].next = new myLinkedList(###);
	} 
	
	/*
	 * We know that it is bad coding practice to make field variables public,
	 * but for the sake of simplicity of this exercise we will do just that.
	 * 
	 * 
	 * Your tasks for what to do with this linked list are below!
	 */
	 
	 
	 /**
	  *  TASK 1:
	  *  Create a linked list with the following linked elements:
	  * 
	  *  1 -> 4 -> 2 -> 3
	  */
	  
	 public void createList() {
		 //Type your code here
	 }
	 
	 /**
	  *  TASK 2:
	  *  Modify an EXISTING linked list so that the 3rd element is always -1.
	  * (You may assume that the list will ALWAYS be at least 3 elements long.)
	  *
	  *  Example
	  *  Original: 1 -> 4 -> 2 -> 3
	  *  New: 1 -> 4 - > -1 -> 3
	  */
	 
	 public void modifyList(myLinkedList testList) {
		 //Type your code here
	 }
	 
	 /**
	  *  TASK 3 (EXTRA CHALLENGE):
	  *  Traverse through an existing linked list to print all values stored
	  *  in that list, in order.
	  */
	 
	 public void printList(myLinkedList testList) {
		 //Type your code here
	 }
}
