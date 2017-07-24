public class Class extends Course {
	School school;
	Teacher teacher;
	String room;
	int num;
	Student[] students;
	public Class() {
		num = 40;
		students = new Student[num];
	}
}
