public class Student {
	int id;
	String password;
	int grade;
	String fname, lname;
	Course[] schedule;
	School school;
	public Student() {
		schedule = new Course[8];
	}
}