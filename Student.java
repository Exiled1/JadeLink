public class Student {
	int id;
	String password;
	int grade;
	String fname, lname;
	Class[] schedule;
	int[] index;
	School school;
	double[] grades;
	String[] letters;
	public Student() {
		schedule = new Class[8];
		index = new int[8];
		grades = new double[8];
		letters = new String[8];
	}
	public void update() {
		for(int i=0;i<8;i++) {
			if(schedule[i].percentage) {
				if(grades[i] >= 90) letters[i] = "A";
				else if(grades[i] >= 80) letters[i] = "B";
				else if(grades[i] >= 70) letters[i] = "C";
				else if(grades[i] >= 60) letters[i] = "D";
				else letters[i] = "F";
			} else {
				if(grades[i] >= 3.4) letters[i] = "A";
				else if(grades[i] >= 2.8) letters[i] = "B";
				else if(grades[i] >= 2.2) letters[i] = "C";
				else if(grades[i] >= 1.6) letters[i] = "D";
				else letters[i] = "F";
			}
		}
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