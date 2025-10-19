import java.util.ArrayList;
public class College {
	private String name;
	private double admitRate;
	private int satAvg;
	private ArrayList<String> popularPrograms;
	private String applicationDeadline;
	public College(String nameIn, double admit, int sat, ArrayList<String> programs, String deadline) {
		name = nameIn;
		admitRate = admit;
		satAvg = sat;
		popularPrograms = programs;
		applicationDeadline = deadline;
	}
	
	public String toString() {
		String msg = "";
		
		msg += "University: " + name + "\n";
		msg += "Admission rate: " + (admitRate * 100) + "%\n";
		msg += "Average SAT Score: " + satAvg + "\n";
		msg += "Number of programs offered: " + popularPrograms + "\n";
		msg += "Application deadline: " + applicationDeadline + "\n";
		return msg;
	}
	

}
