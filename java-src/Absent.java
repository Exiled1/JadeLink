public class Absent {
	int month;
	int year;
	int day;
	int period;
	boolean excused;
	
	public Absent(int month, int day, int year, int period, boolean excused) {
		this.month = month;
		this.day = day;
		this.year = year;
		this.period = period;
		this.excused = excused;
	}
}
