public class TastyMethodReview {
    //You do not need to do anything in main.
    public static void main(String[] args) {
        String[] foodItems = {"pizza", "hamburger", "pasta", "cheese"}; //Feel free to change this array to any amount of values you want to see!
        
        System.out.println("Before makeTasty: ");
        printArray(foodItems);

        makeTasty(foodItems);
        System.out.println("After makeTasty: ");
        printArray(foodItems);
    }

    //YOU WILL BE CODING THIS METHOD
    public void makeTasty(String[] foodItems) {
        //Write the code for your method
    }

    //You do not need to do anything to this method. It is provided for utility.
    public void printArray(String[] arr) {
        System.out.print("[ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }
}
