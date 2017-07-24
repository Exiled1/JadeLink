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
		teacher.classes[period-1] = this;
	}
	public void addGrade(int id, int grade, String name) {
		for(int i=0;i<targets.size();i++) {
			for(int j=0;j<targets.get(i).assignments.size();j++) {
				Assignment as = targets.get(i).assignments.get(j);
				if(name.equals(as.name)) {
					for(int k=0;k<as.num;k++) {
						if(id == students[k].id) {
							as.grades[k] = grade;
							students[k].classgrade(period - 1);
							students[k].update();
						}
					}
					break;
				}
			}
		}
	}
	public void addAssignment(Assignment as, int target) {
		targets.get(target).assignments.add(as);
	}
	public void addTarget(LearningTarget ta) {
		targets.add(ta);
	}
	public void addStudent(Student st) {
		students[index] = st;
		st.schedule[period-1] = this;
		st.index[period-1] = index;
		index++;
	}
}
