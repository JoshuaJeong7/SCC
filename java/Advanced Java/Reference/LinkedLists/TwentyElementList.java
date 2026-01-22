class ElementList {
  public String message;
  public ElementList next;
  public ElementList(String msg) {
    message = msg;
    next = null;
  }
}

public class TwentyElementList {

  // THIS IS THE METHOD YOU WILL BE CODING
  // Given a linked list, this method will check if the string "gold" exists inside the list.
  // If "gold" does exist, the method returns true. Otherwise, it returns false.
  // Your job is to use a loop (or recursion) to travel fully through the linked list
  // through sequential search, checking each element to see if "gold" exists. Good luck!
  public static boolean isGoldInList(ElementList root) {
    //Finish the code here!
    
    return false;
  }
  
  public static void main(String[] args) {
    String[] messageVals = {"corn", "bag", "apple", "pizza", "mace", "door", "window", "college", "bus", "beautiful", "sad", "angry", "cheese", "games", "sudoku", "mine", "gold", "fracture", "gym", "classroom"};
    
    //The following is one possible way to compactly add several elements into a linked list.
    //You must define the root as having the first value, then create a tempRoot auxillary variable.
    //From the second to the last element, you will add a new ElementList by updating the .next pointer
    //on the auxillary variable, then moving the variable itself into the .next pointer.
    ElementList root = new ElementList(messageVals[0]);
    ElementList tempRoot = root;
    for (int i = 1; i < messageVals.length; i++) {
      tempRoot.next = new ElementList(messageVals[i]);
      tempRoot = tempRoot.next;
    }

    //NOTE: You may be wondering why we need a tempRoot variable in the first place, and why we shouldn't
    //do the exact same loop with the root variable. The answer is, if we change the root variable to
    //be equal to its pointer, then what points back to the first element? Nothing will, so we have effectively
    //lost access to the entire list. We need to maintain at least one variable's reference to the first element,
    //so that we retain access to the list.
    
    //NOTE 2: Yes, changing the .root variable on tempRoot will reflect those same changes to the original root,
    //because of Pass By Reference!
    
  }
}


