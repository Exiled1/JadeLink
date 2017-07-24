import java.util.ArrayList;
public class Class extends Course {
	School school;
	Teacher teacher;
	String room;
	int period;
	int num;
	Student[] students;
	boolean percentage;
	ArrayList<LearningTarget> targets;
	int index = 0;
	public Class(int number) {
		num = number;
		students = new Student[num];
		targets = new ArrayList<LearningTarget>();
	}
	public void addStudent(Student st) {
		students[index] = st;
		st.index[period-1] = index;
		index++;
	}
}
