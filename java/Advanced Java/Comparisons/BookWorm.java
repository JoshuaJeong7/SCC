//There are five imports you must implement:
//	1: Comparator
//	2: Collections
//	3: ArrayList
//	4: Arrays
//	5: List
import ___ 
	
//NOTE: If you are copying this into Programiz, move all class definitions to the bottom of the file!
//Then your class errors should be fixed!

class Book implements ?COMPLETE_THIS? { 
	//NOTE: THIS TIME ALL FIELD VARIABLES ARE PRIVATE!
	//THIS MEANS THAT IN YOUR COMPARATOR CLASS, YOU CANNOT DIRECTLY ACCESS a.name - b.name!
	//To access these variables, you MUST use the getter methods. (a.getName() - b.getName())
	private String title;
	private String author;
	private String genre;
	private int pageCount;
	//If you want, feel free to add other field variables, like publish date!
	public Book(String titleIn, String authorIn, String genreIn, int pageCountIn) {
		title = titleIn;
		author = authorIn;
		genre = genreIn;
		pageCount = pageCountIn;
		System.out.println("As a reminder, all field variables are PRIVATE! Use getter methods to access field variables!");
	}
	//ALL GETTER METHODS
	public String getTitle() { return title; }	public String getAuthor() { return author; }
	public String getGenre() { return genre; }	public int getPageCount() { return pageCount; }
	
	//ALL SETTER METHODS (You will likely not need them, but they are here just in case you do!)
	public void setTitle(String title) { title = titleIn; }
	public void setAuthor(String authorIn) { author = authorIn; }
	public void setGenre(String genreIn) { genre = genreIn; }
	public void setPageCount(int pageCountIn) { pageCount = pageCountIn; }

	//toString method (if you don't like the printing format, change it to what you want!)
	public String toString() {
		return "[" + title + " by " + author + " | Genre = " + genre + "; Page Count = " pageCount + "]\n";
	}
}

public class BookWorm {
	public static void main(String[] args) {
		Book a = new Book("Percy Jackson and the Lightning Thief", "Rick Riordan", "Fantasy", 375);
		Book b = new Book("Dog Man", "Dav Pilkey", "Children's Graphic Novel", 240);
		Book c = new Book("Programming Abstractions in C++", "Eric S. Roberts", "Textbook", 943);
		Book d = new Book("The Giver", "Lois Lowry", "Dystopian Science Fiction", 208);
		System.out.println("Add more books if you want to! Make sure to add them into the ArrayList's creation definition!");
		ArrayList<Book> bookList = new ArrayList<Book>(Arrays.asList(a, b, c, d));

		System.out.println("Array List Without Sorting: \n" + bookList);
		
		System.out.println("Delete this print statement and replace it with a line that uses Collections.sort!");
		System.out.println("Array List Sorted By Genre (alphabetical): \n" + bookList);

		System.out.println("REMEMBER TO CREATE YOUR Comparator<Book> CLASS!!!!");
		System.out.println("Delete this print statement and replace it with a line that uses Collections.sort!");
		System.out.println("Array List Sorted By Page Count (ascending order): \n" + bookList);
	}
}
