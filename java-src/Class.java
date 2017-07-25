import java.util.ArrayList;
public class Class extends Course {
	//Class information
	String name;
	int id;
	School school;
	Teacher teacher;
	String room;
	int period;
	int num;
	Student[] students;
	boolean percentage;
	boolean weighted;
	ArrayList<LearningTarget> targets;
	int index = 0;
	
	//returns class name as a string
	public String toString() {
		return "Class: " + name;
	}
	public Class(int number, int idid, String nn,int p, boolean pe, boolean we) {
		weighted = we;
		percentage = pe;
		period = p;
		num = number;
		name = nn;
		id = idid;
		students = new Student[num];
		targets = new ArrayList<LearningTarget>();
		//teacher.classes[period-1] = this;
		System.out.println(this.toString() + ". Period: " + period + ". ID: " + id + ". ");
	}
	//changes student's grade on a certain assignment
	public void addGrade(int id, int grade, String name) {
		for(int i=0;i<targets.size();i++) {
			for(int j=0;j<targets.get(i).assignments.size();j++) {
				Assignment as = targets.get(i).assignments.get(j);
				if(name.equals(as.name)) {
					for(int k=0;k<as.num;k++) {
						if(id == students[k].id) {
							as.grades[k] = grade;
							students[k].classgrade(period - 1);
							//students[k].update();
							System.out.println(students[k].fname + "'s grade is now: " + grade + " in " + name);
							break;
						}
					}
					break;
				}
			}
		}
	}
	//add an assignment to a target
	public void addAssignment(Assignment as, int target) {
		System.out.println("New Assignment: " + as.name + " added to Target: " + targets.get(target).name);
		targets.get(target).assignments.add(as);
	}
	//adding a learning target
	public void addTarget(LearningTarget ta) {
		System.out.println("New Learning Target: " + ta.name);
		targets.add(ta);
	}
	//adding a student to class
	public void addStudent(Student st) {
		students[index] = st;
		st.schedule[period-1] = this;
		st.index[period-1] = index;
		index++;
		System.out.println(st.fname + " " + st.lname + " added to Class: " + name);
	}
	//Lists all students and grades
	public void list() {
		System.out.println(this.toString());
		for(int i=0;i<index;i++) {
			Student c = students[i];
			System.out.println(c.fname + " " + c.lname + " has a " + c.classgrade(period-1) + " in this class.");
		}
	}
	//Adds absent student
	public void addAbsence(int id, int m, int d, int y, boolean e) {
		for(int i=0;i<index;i++) {
			if(students[i].id == id) {
				students[i].addAbsence(m, d, y, period, e);
			}
		}
	}
}
