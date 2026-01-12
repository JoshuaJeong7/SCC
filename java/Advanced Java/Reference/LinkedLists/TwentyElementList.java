class ElementList {
  public String message;
  public ElementList next;
  public ElementList(String msg) {
    message = msg;
    next = null;
  }
}

public class TwentyElementList {
  public static void addElement(ElementList root, String val) {
     // if (root == null) root = new ElementList(val);
     // else {
          ElementList temp = root;
          while (temp.next != null) {
              temp = temp.next;
          }
          temp.next = new ElementList(val);
      //}
  }
  public static void main(String[] args) {
    String[] messageVals = {"corn", "bag", "apple", "pizza", "mace", "door", "window", "college", "bus", "beautiful", "sad", "angry", "cheese", "games", "sudoku", "mine", "gold", "fracture", "gym", "classroom"};
    ElementList root = new ElementList(messageVals[0]);
    for (int i = 1; i < messageVals.length; i++) {
      addElement(root, messageVals[i]);
    }

    //for testing
    ElementList temp = root;
    while (temp != null) {
      System.out.print(temp.message + " ");
      temp = temp.next;
    }
  }
}


