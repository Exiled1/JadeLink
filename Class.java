import java.util.ArrayList;
public class Class extends Course {
	School school;
	Teacher teacher;
	String room;
	int num;
	Student[] students;
	boolean percentage;
	ArrayList<LearningTarget> targets;
	public Class() {
		num = 40;
		students = new Student[num];
		targets = new ArrayList<LearningTarget>();
	}
}
