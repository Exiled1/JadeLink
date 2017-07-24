public class Student {
	int id;
	String password;
	int grade;
	String fname, lname;
	Class[] schedule;
	School school;
	public Student() {
		schedule = new Class[8];
	}
}