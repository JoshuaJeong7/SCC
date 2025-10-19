import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;
public class CollegeList {
	public static void main(String[] args) {
		HashMap<String, College> collegeList = new HashMap<String, College>();
		
		/**
		 * Using the constructor for College, add the following colleges into
		 * the college list:
		 * 
		 * UC Berkeley
		 * Admission rate: 11%
		 * Avg SAT Score: 0 (Does not take SAT)
		 * Popular Programs: CS and Support, Social Sciences, Engineering, Biomed, Interdisciplinary
		 * Application Deadline: November 30th
		 * 
		 * 
		 * Cornell University
		 * Admission rate: 8%
		 * Avg SAT Score: 1520
		 * Popular Programs: CS and Support, Business, Engineering, Agriculture, Biomed
		 * Application Deadline: January 2nd
		 * 
		 * Purdue University
		 * Admission rate: 50%
		 * Avg SAT Score: 1300
		 * Popular Programs: Engineering, Business, CS and Support, Tech Engineering, Biomed
		 * Application Deadline: January 15th
		 * 
		 * 
		 * De Anza Community College
		 * Admission rate: 100%
		 * Avg SAT Score: 0 (Does not take SAT)
		 * Popular Programs: Business, Social Sciences, Interdisciplinary, Liberal Arts, Mechanics and Repair
		 * Application Deadline: June 1
		 * 
		 */
		 
		 // Here is some starter code to show you how to add an element to
		 // the college list!
		 
		 //This is just a shortcut to create an ArrayList with preexisting elements inside of it.
		 //You can skip this implementation and just create an empty ArrayList and add your elements individually to the list!
		 /*
		 String[] stanfordArray = {"CS and Support", "Social Sciences", "Engineering", "Interdisciplinary", "Math and Stats"};
		 ArrayList<String> stanfordPrograms = new ArrayList<String>(Arrays.asList(stanfordArray));
		 */
		 
		 ArrayList<String> stanfordPrograms = new ArrayList<String>();
		 stanfordPrograms.add("CS and Support");
		 stanfordPrograms.add("Social Sciences");
		 stanfordPrograms.add("Engineering");
		 stanfordPrograms.add("Interdisciplinary");
		 stanfordPrograms.add("Math and Stats");
		 
		 collegeList.put("Stanford", new College("Stanford", 0.04, 1560, stanfordPrograms, "January 5th"));
		 
		 
		 //Add UC Berkeley here
		 
		 
		 //Add Cornell University here
		 
		 
		 //Add Purdue University here
		 
		 
		 //Add De Anza College here
	}
}
