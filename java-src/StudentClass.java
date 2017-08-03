import java.util.ArrayList;
public class StudentClass {//extends Course {
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
	public StudentClass(int number, int idid, String nn,int p, boolean pe, boolean we) {
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
	
	//remove student from class
	//also has to remove the student's grades
	public void removeStudent(int id) {
		boolean lol = false;
		for(int i=0;i<index;i++) {
			if(students[i].id==id) {
				lol = true;
				students[i].schedule[period-1] = null;
				students[i].index[period-1] = -1;
				System.out.println(students[i].fname + " " + students[i].lname + " was removed from " +this.name + ". ");
			} else if(lol) {
				students[i-1] = students[i];
				for(int j=0;j<targets.size();j++) {
					for(int k=0;k<targets.get(j).assignments.size();k++) {
						targets.get(j).assignments.get(k).grades[i-1] = targets.get(j).assignments.get(k).grades[i];
					}
				}
			}
		}
		students[index-1] = null;
		for(int j=0;j<targets.size();j++) {
			for(int k=0;k<targets.get(j).assignments.size();k++) {
				targets.get(j).assignments.get(k).grades[index-1] = 0;
			}
		}
		index--;
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
	//Sorts students in alphabetical order by last name
	public void sort() {
		for(int i=0;i<index;i++) {
			for(int j=0;j<i;j++) {
				if(students[j].lname.compareTo(students[i].lname) > 0) {
					Student swap = students[j];
					students[j] = students[i];
					students[i] = swap;
					
					for(int k=0;k<targets.size();k++) {
						for(int l=0;l<targets.get(k).assignments.size();l++) {
							double swapp = targets.get(k).assignments.get(l).grades[j];
							targets.get(k).assignments.get(l).grades[j] = targets.get(k).assignments.get(l).grades[i];
							targets.get(k).assignments.get(l).grades[i] = swapp;
						}
						double swapp = targets.get(k).grades[j];
						targets.get(k).grades[j]=targets.get(k).grades[i];
						targets.get(k).grades[i] = swapp;
					}
				}/* else if(students[j].lname.compareTo(students[i].lname) < 0) {
				} else {
					if(students[j].fname.compareTo(students[i].fname) > 0) {
						Student swap = students[j];
						students[j] = students[i];
						students[i] = swap;
						for(int k=0;k<targets.size();k++) {
							for(int l=0;l<targets.get(k).assignments.size();l++) {
								double swapp = targets.get(k).assignments.get(l).grades[j];
								targets.get(k).assignments.get(l).grades[j] = targets.get(k).assignments.get(l).grades[i];
								targets.get(k).assignments.get(l).grades[i] = swapp;
							}
							double swapp = targets.get(k).grades[j];
							targets.get(k).grades[j]=targets.get(k).grades[i];
							targets.get(k).grades[i] = swapp;
						}
					}
				}*/
			}
		}
		for(int i=0;i<targets.size();i++) {
			targets.get(i).average();
		}
		for(int i=0;i<index;i++) {
			students[i].index[period-1] = i;
		}
		System.out.println(this.name + " was sorted. ");
	}
}
