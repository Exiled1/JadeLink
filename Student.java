public class Student {
	int id;
	String password;
	int grade;
	String fname, lname;
	Class[] schedule;
	int[] index;
	School school;
	public Student() {
		schedule = new Class[8];
		index = new int[8];
	}
	public double classgrade(int classnum) {
		double grade=0;
		Class temp = schedule[classnum];
		for(int i=0;i<temp.targets.size();i++) {
			grade+=temp.targets.get(i).grades[index[classnum]];
		}
		grade/=temp.targets.size();
		return grade;
	}
}