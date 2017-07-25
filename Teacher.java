public class Teacher {
	String fname, lname;
	String password;
	Class [] classes;
	School school;
	public Teacher(String f, String l, School s, String pw) {
		classes = new Class[8];
		fname = f;
		lname = l;
		school = s;
		password = pw;
	}
}
